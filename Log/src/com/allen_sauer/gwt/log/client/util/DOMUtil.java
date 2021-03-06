/*
 * Copyright 2009 Fred Sauer
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
package com.allen_sauer.gwt.log.client.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;

import com.allen_sauer.gwt.log.client.util.impl.DOMUtilImpl;

/**
 * Provides DOM utility methods.
 */
public class DOMUtil {
  // CHECKSTYLE_JAVADOC_OFF
  private static DOMUtilImpl impl;

  static {
    impl = (DOMUtilImpl) GWT.create(DOMUtilImpl.class);
  }

  /**
   * Adjust line breaks within in the provided title for optimal readability and display length for
   * the current user agent.
   * 
   * @param title the desired raw text
   * @return formatted and escaped text
   */
  public static String adjustTitleLineBreaks(String title) {
    return impl.adjustTitleLineBreaks(title);
  }

  public static void reportFatalAndThrowRuntimeException(String msg) throws RuntimeException {
    msg = "gwt-dnd warning: " + msg;
    Window.alert(msg);
    throw new RuntimeException(msg);
  }

  public static native void windowClear(JavaScriptObject w)
  /*-{
    w.document.body.innerHTML = "";
  }-*/;

  public static native void windowClose(JavaScriptObject window)
  /*-{
    window.close();
  }-*/;

  public static native JavaScriptObject windowOpen(String features)
  /*-{
    var w = $wnd.open("", "_blank", features);
    $wnd.focus();
    return w;
  }-*/;

  public static native String windowReadyState(JavaScriptObject w)
  /*-{
    return w.document.readyState;
  }-*/;

  public static native String windowSetTitle(JavaScriptObject w, String title)
  /*-{
    w.document.title = title;
  }-*/;

  public static native void windowWrapAndAppendHTML(JavaScriptObject w, String html)
      throws JavaScriptException
  /*-{
    var div = w.document.createElement('div');
    div.innerHTML = html;
    w.document.body.appendChild(div);
  }-*/;
}
