/*
 * Copyright 2008 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.log.client;

/**
 * Logger which sends output via <a href="http://www.getfirebug.com/">Firebug</a>
 * or <a href="http://www.getfirebug.com/lite.html">Firebug Lite</a>
 * via <code>$wnd.console.debug()</code>,
 * <code>$wnd.console.info()</code>, <code>$wnd.console.warn()</code>
 * and <code>$wnd.console.error()</code> if <code>$wnd.console.firebug</code>
 * is defined.
 */
public final class FirebugLogger extends AbstractLogger {
  // CHECKSTYLE_JAVADOC_OFF

  public native boolean isSupported()
  /*-{
    return !!($wnd.console && $wnd.console.firebug);
  }-*/;

  @Override
  native void log(int logLevel, String message)
  /*-{
    if (logLevel >= @com.allen_sauer.gwt.log.client.Log::LOG_LEVEL_ERROR) {
      $wnd.console.error(message);
    } else if (logLevel >= @com.allen_sauer.gwt.log.client.Log::LOG_LEVEL_WARN) {
      $wnd.console.warn(message);
    } else if (logLevel >= @com.allen_sauer.gwt.log.client.Log::LOG_LEVEL_INFO) {
      $wnd.console.info(message);
    } else {
      $wnd.console.debug(message);
    }
  }-*/;
}
