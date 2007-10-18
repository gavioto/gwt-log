/*
 * Copyright 2007 Fred Sauer
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

import com.google.gwt.core.client.GWT;

public class SystemLogger extends AbstractLogger {
  public boolean isSupported() {
    return !GWT.isScript();
  }

  public void log(int logLevel, String message) {
    if (logLevel >= Log.LOG_LEVEL_ERROR) {
      System.err.println(message);
    } else {
      System.out.println(message);
    }
  }
}
