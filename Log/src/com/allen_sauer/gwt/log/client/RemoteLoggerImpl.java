/*
 * Copyright 2010 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.log.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestTimeoutException;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RpcRequestBuilder;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import com.allen_sauer.gwt.log.shared.LogRecord;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Logger which sends output via RPC to the server where it can be logged and aggregated.
 */
public final class RemoteLoggerImpl extends RemoteLogger {
  // CHECKSTYLE_JAVADOC_OFF

  private static class MyRpcRequestBuilder extends RpcRequestBuilder {
    private static final int RPC_TIMEOUT_MILLIS_INITIAL = 500;
    private static final int RPC_TIMEOUT_MILLIS_MAX = 4000;
    private int rpcTimeoutMillis = RPC_TIMEOUT_MILLIS_INITIAL;

    @Override
    protected void doFinish(RequestBuilder rb) {
      super.doFinish(rb);
      rb.setTimeoutMillis(rpcTimeoutMillis);
    }

    boolean maybeIncrementRpcTimeOut() {
      if (rpcTimeoutMillis == RPC_TIMEOUT_MILLIS_MAX) {
        // caller should give up
        return false;
      }

      // exponential back off
      rpcTimeoutMillis = Math.min(RPC_TIMEOUT_MILLIS_MAX, rpcTimeoutMillis * 2);

      // caller should try again
      return true;
    }
  }

  private static final RemoteLoggerConfig config = GWT.create(RemoteLoggerConfig.class);
  private static final int MESSAGE_QUEUEING_DELAY_MILLIS = 50;
  private static final String REMOTE_LOGGER_NAME = "RemoteLogger";
  private final AsyncCallback<ArrayList<LogRecord>> callback;
  private boolean callInProgressOrScheduled = false;
  private Throwable failure;
  private final ArrayList<LogRecord> logMessageList = new ArrayList<LogRecord>();
  private final ArrayList<LogRecord> queuedMessageList = new ArrayList<LogRecord>();
  private final RemoteLoggerServiceAsync service;

  private final Timer timer = new Timer() {
    @Override
    public void run() {
      movePendingMessagesToQueue();
      service.log(queuedMessageList, callback);
    }

    // No need to synchronize on collection since JavaScript is single-threaded
    private void movePendingMessagesToQueue() {
      queuedMessageList.addAll(logMessageList);
      logMessageList.clear();
    }
  };

  public RemoteLoggerImpl() {
    if (!GWT.isClient()) {
      throw new UnsupportedOperationException();
    }
    service = (RemoteLoggerServiceAsync) GWT.create(RemoteLoggerService.class);
    final ServiceDefTarget target = (ServiceDefTarget) service;
    final MyRpcRequestBuilder rpcRequestBuilder = new MyRpcRequestBuilder();
    target.setRpcRequestBuilder(rpcRequestBuilder);
    String serviceEntryPointUrl = config.serviceEntryPointUrl();
    if (serviceEntryPointUrl != null) {
      target.setServiceEntryPoint(serviceEntryPointUrl);
    }

    callback = new AsyncCallback<ArrayList<LogRecord>>() {

      @SuppressWarnings("deprecation")
      public void onFailure(Throwable ex) {

        if (ex instanceof RequestTimeoutException) {
          if (rpcRequestBuilder.maybeIncrementRpcTimeOut()) {
            // RequestTimeoutException: We should try again
            Log.diagnostic(
                REMOTE_LOGGER_NAME + " will reattempt delivery and stack trace deobfuscation of "
                    + (logMessageList.size() + queuedMessageList.size()) + " log messages in "
                    + rpcRequestBuilder.rpcTimeoutMillis + " milliseconds using "
                    + target.getServiceEntryPoint(), null);
            callInProgressOrScheduled = false;
            maybeTriggerRPC();
            return;
          }

          // RequestTimeoutException: We should give up
          Log.diagnostic(
              REMOTE_LOGGER_NAME + " has PERMANENTLY FAILED with "
                  + (logMessageList.size() + queuedMessageList.size())
                  + " log messages undelivered to " + target.getServiceEntryPoint(), null);

          // log queued messages to other loggers before purging
          loggersLogToOthers(queuedMessageList);
          loggersLogToOthers(logMessageList);

          //purge
          logMessageList.clear();
          queuedMessageList.clear();

          failure = ex;
          return;
        }

        // Something other than a RequestTimeoutException
        Log.diagnostic(
            REMOTE_LOGGER_NAME + " has PERMANENTLY FAILED with "
                + (logMessageList.size() + queuedMessageList.size())
                + " log messages undelivered to " + target.getServiceEntryPoint() + " due to "
                + ex.toString(), null);
        callInProgressOrScheduled = false;

        // log queued messages to other loggers before purging
        loggersLogToOthers(queuedMessageList);
        loggersLogToOthers(logMessageList);

        //purge
        logMessageList.clear();
        queuedMessageList.clear();

        failure = ex;
      }

      public void onSuccess(ArrayList<LogRecord> deobfuscatedLogRecords) {
        if (deobfuscatedLogRecords != null) {
          loggersLogToOthers(deobfuscatedLogRecords);
        } else {
          // server did not deobfuscate
          loggersLogToOthers(queuedMessageList);
        }
        queuedMessageList.clear();
        callInProgressOrScheduled = false;
        maybeTriggerRPC();
      }

      private void loggersLogToOthers(ArrayList<LogRecord> logRecords) {
        for (Iterator<LogRecord> iterator = logRecords.iterator(); iterator.hasNext();) {
          LogRecord record = iterator.next();
          RemoteLoggerImpl.super.loggersLog(record);
        }
      }
    };
  }

  @Override
  public void clear() {
  }

  @Override
  public boolean isSupported() {
    return true;
  }

  @Override
  public void log(LogRecord record) {
    if (failure != null) {
      // remote logger has been disabled; just pass on log messages to other loggers
      super.loggersLog(record);
      return;
    }
    if (record.getLevel() == Log.LOG_LEVEL_OFF) {
      // don't forward gwt-log diagnostic messages to the server; just pass on log messages to others
      super.loggersLog(record);
      return;
    }
    logMessageList.add(record);
    maybeTriggerRPC();
  }

  @Override
  public void loggersLog(LogRecord record) {
    log(record);
  }

  @Override
  public void setCurrentLogLevel(int level) {
  }

  private void maybeTriggerRPC() {
    if (failure == null && !callInProgressOrScheduled
        && (!logMessageList.isEmpty() || !queuedMessageList.isEmpty())) {
      callInProgressOrScheduled = true;
      timer.schedule(MESSAGE_QUEUEING_DELAY_MILLIS);
    }
  }
}
