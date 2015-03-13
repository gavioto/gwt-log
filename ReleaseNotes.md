
---

# What's brewing in gwt-log `trunk` #
  * ### Other changes ###
    * Stay tuned. More to come.


---

# What's new in `gwt-log-3.3.2.jar` (requires GWT 2.6.1 or newer) #
  * ### Changes in this release ###
    * In `LogMessageFormatterGenerator` replace accidental `com.google.gwt.dev.util.collect.HashSet` with `java.util.HashSet`. Thanks, Roberto Lublinerman!



---

# What's new in `gwt-log-3.3.1.jar` (requires GWT 2.6.1 or newer) #
  * ### Changes in this release ###
    * Java 7, GWT 2.6.1
    * Changes to `RemoteLoggerServlet` initialization parameters: `symbolMaps` no longer supported, in favor of `symbolMapsFileSystem`, `symbolMapsResourcePath` and `symbolMapsResourceUrl` initialization parameters
  * ### New in this release ###
    * `LogRecord` and `WrappedClientThrowable` implement `IsSerializable`, to help certain users avoid `SerializationException` when using remote logging
  * ### Removed in this release ###
    * Removed deprecated `RemoteLoggerServiceImpl`; Use `RemoteLoggerServlet` instead.
    * Removed deprecated `FirebugLogger`; Use `ConsoleLogger` instead.
  * ### Bug Fixes ###
    * [Issue 43](https://code.google.com/p/gwt-log/issues/detail?id=43), Remote logger fails with gwt-2.1.0-M3: `IncompatibleRemoteServiceException`. Thanks A.A.Vasiljev!
    * [Issue 67](https://code.google.com/p/gwt-log/issues/detail?id=67), Serialization error. Thanks barnabas!
    * [Issue 73](https://code.google.com/p/gwt-log/issues/detail?id=73), Remote servlet uses file api instead of `context.getResource()`. Thanks jcompagner!
    * [Issue 18](https://code.google.com/p/gwt-log/issues/detail?id=18), SLF4J server-side support. Thanks, dobesv!


---

# What's new in `gwt-log-3.3.0.jar` (requires GWT 2.6.0 or newer) #
  * ### New in this release ###
    * Support for GWT 2.6.0
  * ### Changes in this release ###
    * Removed support for `ie6`
    * Added support for `ie10`


---

# What's new in `gwt-log-3.2.1.jar` #
  * ### Bug Fixes ###
    * [Issue 70](https://code.google.com/p/gwt-log/issues/detail?id=70), `java.lang.NoClassDefFoundError: com/google/gwt/core/client/GWTBridge` in GWT 2.5 server side code. Thanks brian.tosch and tomfreay!


---

# What's new in `gwt-log-3.2.0.jar` #
  * ### New in this release ###
    * Support for GWT 2.5.0


---

# What's new in `gwt-log-3.1.8.jar` #
  * ### Bug Fixes ###
    * [Issue 44](http://code.google.com/p/gwt-log/issues/detail?id=44), fixed corrupted `DivLogger` triangle image (again). Thanks PhiLho!
  * ### Changes Affecting Maven Users ###
    * [Issue 65](http://code.google.com/p/gwt-log/issues/detail?id=65), mark `gwt-user` pom dependency with `<scope>provided</scope>`, to avoid `gwt-user-*.jar` ending up in `WEB-INF/lib/`. Thanks samskivert!


---

# What's new in `gwt-log-3.1.7.jar` #
  * ### New in this release ###
    * `RemoteLoggerServlet` now logs a warning message if a provided `symbolMaps` directory does not exist. The warning message includes the server's current working directory, in order to assist developers in configuring valid server paths.


---

# What's new in `gwt-log-3.1.6.jar` #
  * ### New in this release ###
    * Releases are now also deployed to Sonatype OSS Maven repository and sync to [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ccom.allen-sauer.gwt.log) with groupId `com.allen-sauer.gwt.log` and artifact `gwt-log`


---

# What's new in `gwt-log-3.1.5.jar` #
  * ### Improvements in this release ###
    * Add category to server side messages when `java.util.logging` is used (which is the default)


---

# What's new in `gwt-log-3.1.4.jar` #
  * ### Bug Fixes ###
    * Fix `DivLogger#setSize()` and `DivLogger#setPixelSize()`. Thanks DavLP!
    * Improve logging in IE: revert console logger; use `$wnd.console` rather than `window.console`, now that [FireBug issue 2914](http://code.google.com/p/fbug/issues/detail?id=2914) has been fixed
  * ### Improvements in this release ###
    * Avoid recomputing message for each logger. Thanks Eugen!


---

# What's new in `gwt-log-3.1.3.jar` #
  * ### Bug Fixes ###
    * Fix caller information when remote logger is used. Thanks cimballi!
    * [Issue 46](http://code.google.com/p/gwt-log/issues/detail?id=46), no longer resize the `DivLogger` when a new message is logged
    * Fix sizing of `DivLogger` when `moveTo()` is called before the first logged message
    * Fix [issue 61](http://code.google.com/p/gwt-log/issues/detail?id=61), logging in IE developer tools
    * Recursively deobfuscate `WrappedClientThrowable` causes
  * ### New in this release ###
    * Finally fixed [issue 3](http://code.google.com/p/gwt-log/issues/detail?id=3): make `DivLogger` closeable. Thanks pby\_fr!
    * [Issue 14](http://code.google.com/p/gwt-log/issues/detail?id=14), by popular demand, `DivLogger` is attached to the bottom of the browser window, instead of being attached to the top left corner, where it is more likely to interfere with your UI.
    * Add ie9 property support, to avoid those annoying warnings.
    * Update your web.xml servlet definitions: `RemoteLoggerServiceImpl` -> `RemoteLoggerServlet`
    * New `RemoteLoggerServlet#shouldReturnDeobfuscatedStackTraceToClient()` method provides a way for subclasses to restrict which clients (users) have access to deobfuscated `JavaScript` stack traces.
    * [Issue 56](http://code.google.com/p/gwt-log/issues/detail?id=56), allow apps to specify multiple symbolMaps directories by using multiple init-param names that start with "symbolMaps"
    * Add cross-domain XHR support to `RemoteLogger` (for all but IE)
    * Removed complexity from `RemoteLogger`. We now simply 1) log to local (client) loggers immediately, 2) send log messages to the server. If the server returns deobfuscated stack traces, we send those deobfuscated stacktraces to other client loggers when we get them, even though they may be delayed, and are essentially duplicates of the earlier obfuscated messages.
    * On Google App Engine, use JDK logging by default, for better log integration
  * ### Other changes in this release ###
    * Java 1.5 -> 1.6
    * GWT 2.2 -> 2.3
    * gwt-log's DEBUG/TRACE levels were mapped to java.util.logging's FINE/FINEST levels; now using CONFIG/FINE instead
    * `DivLogger` no longer overrides `setVisible()`.
    * Comment out servlet declaration in .gwt.xml due to [GWT issue 6377](http://code.google.com/p/google-web-toolkit/issues/detail?id=6377)
    * Suppress annoying warning about failure to deobfuscate `HostedMode` permutation when running in GWT Development Mode. Thanks José Morales!


---

# What's new in `gwt-log-3.1.2.jar` #
  * ### Bug Fixes ###
    * Fix incorrect caller information when `RemoteLogger` is used. Thanks Cimballi!


---

# What's new in `gwt-log-3.1.1.jar` #
  * ### Bug Fixes ###
    * Fix incorrect caller information in log messages. Thanks John White!
  * ### Changes in this release ###
    * `ConsoleLogger` subsumes `FirebugLogger`
  * ### Other changes in this release ###
    * Firebug (tested in 1.7X.0a9) logged stack traces can now be shown in a single message, broken by line feeds
    * Removed old `gecko` deferred binding rules


---

# What's new in `gwt-log-3.1.0.jar` #
  * ### Bug Fixes ###
    * Fix for [issue 53](http://code.google.com/p/gwt-log/issues/detail?id=53), restore logging of chained exceptions, i.e. exceptions with causes. Thanks rileylark!
  * ### New in this release ###
    * Added server side strack trace deobfuscation! To enable this feature, which will turn your cryptic production mode obfuscated stack traces into something a lot more useful:
      1. Enable the `RemoteLogger` in your `.gwt.xml` module file:
```
  <inherits name="com.allen_sauer.gwt.log.gwt-log-RemoteLogger"/>
```
      1. Specify the `symbolMaps` `<init-param>` to the `RemoteLogger` servlet in your `web.xml`:
```
  <servlet>
    <servlet-name>remoteLoggerServiceImpl</servlet-name>
    <servlet-class>com.allen_sauer.gwt.log.server.RemoteLoggerServiceImpl</servlet-class>
    <init-param>
      <param-name>symbolMaps</param-name>
      <!-- This value assume a GWT compile with '-deploy war/WEB-INF/deploy/' -->
      <param-value>WEB-INF/deploy/yourmodulename/symbolMaps/</param-value>
    </init-param>
  </servlet>

  <servlet-mapping>
    <servlet-name>remoteLoggerServiceImpl</servlet-name>
    <url-pattern>/logtest/gwt-log</url-pattern>
  </servlet-mapping>
```
      1. Compile your GWT app with `-deploy war/WEB-INF/deploy/`, which will place generated symbol map files in `war/WEB-INF/deploy/yourmodulename/symbolMaps/`.
      1. Optionally, get complete stack traces across all browsers by turning on emulated stack traces and record line numbers and file names in your `.gwt.xml` module:
```
  <set-property name="compiler.emulatedStack" value="true" />
  <set-configuration-property name="compiler.emulatedStack.recordLineNumbers" value="true" />
  <set-configuration-property name="compiler.emulatedStack.recordFileNames" value="true" />
```
| **Before: without deobfuscation** | **After: with deobfuscation turned on** |
|:----------------------------------|:----------------------------------------|
| `at Unknown.hm(Unknown source)`<br><code>at Unknown.vn(Unknown source)</code><br><code>at Unknown.x6(Unknown source)</code><br><code>at Unknown.uH(Unknown source)</code><br><code>at Unknown.No(Unknown source)</code><br><code>at Unknown.anonymous(Unknown source)</code><br><code>at Unknown.gwtOnLoad(Unknown source)</code> <table><thead><th> <code>at java.lang.Throwable.fillInStackTrace(Throwable.java:71)</code><br><code>at java.lang.RuntimeException.RuntimeException(RuntimeException.java:25)</code><br><code>at logtest.client.Logtest.$onModuleLoad(Logtest.java:43)</code><br><code>at com.google.gwt.lang.EntryMethodHolder.init(com.google.gwt.dev.jjs.JavaToJavaScriptCompiler)</code><br><code>at com.google.gwt.core.client.impl.Impl.entry0(Impl.java:197)</code><br><code>at Unknown.anonymous(Unknown source)</code><br><code>at Unknown.gwtOnLoad(Unknown source)</code> </th></thead><tbody></li></ul></li></ul></li></ul></tbody></table>

<ul><li><h3>Other changes in this release</h3>
<ul><li>Changes for <a href='http://code.google.com/p/gwt-log/issues/detail?id=51'>issue 51</a>, use <code>throwable.toString()</code> instead of replicating <code>toString()</code> logic in gwt-log, so that exceptions with custom <code>toString()</code> implementations are logged as expected. Thanks terciofilho!</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-3.0.4.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Fix for <a href='http://code.google.com/p/gwt-log/issues/detail?id=42'>issue 42</a>, precision specifier breaks padding. Thanks cimballi.cimballi!<br>
</li><li>Fix for <a href='http://code.google.com/p/gwt-log/issues/detail?id=44'>issue 44</a>, <code>DivLogger</code> bottom-right corner image is corrupted. Thanks polushin!</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-3.0.3.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Fix for <a href='http://code.google.com/p/gwt-log/issues/detail?id=32'>issue 32</a>, <code>ConsoleLogger.isSupported()</code> returns <code>false</code> for Internet Explorer 8. Thanks hernidez!<br>
</li><li>Restore missing stack traces from log messages sent to the server via <code>RemoteLogger</code>. We inadvertently lost them in <a href='https://code.google.com/p/gwt-log/source/detail?r=436'>r436</a> (gwt-log 3.0.1) when <code>LogRecord</code>s were introduced. Thanks ebatzdor!<br>
</li></ul></li><li><h3>New Features</h3>
<ul><li>Add Logging of <code>X-Forwarded-For</code> headers for <code>RemoteLogger</code> as suggested in <a href='http://code.google.com/p/gwt-log/issues/detail?id=31'>issue 31</a>. Thanks kmj7777!<br>
</li></ul></li><li><h3>Other Changes</h3>
<ul><li>Removing legacy <code>com.allen_sauer.gwt.log.gwt-log</code> module in favor of log level specific modules, e.g. <code>com.allen_sauer.gwt.log.gwt-log-DEBUG</code>, <code>com.allen_sauer.gwt.log.gwt-log-WARN</code>, etc.<br>
</li><li>Change Dev Mode stack trace element determination function from the brittle fixed depth implementation to a more robust search past <code>com.allen_sauer.gwt.log.{client|shared}</code>
</li><li>Address <a href='http://code.google.com/p/gwt-log/issues/detail?id=26'>issue 26</a>, Extract <code>RemoteLogger</code> to separate gwt module. Thanks konstantin.v.pavlov!<br>
</li></ul><blockquote><code>RemoteLogger</code> is now activated by inheriting a module:<br>
<pre><code>  &lt;inherits name="com.allen_sauer.gwt.log.gwt-log-RemoteLogger" /&gt;<br>
</code></pre>
rather than setting a property as had be the case up till now:<br>
<pre><code>  &lt;set-property name="log_RemoteLogger" value="ENABLED" /&gt;<br>
</code></pre>
This change means that users who don't need <code>RemoteLogger</code> will no longer have to see message like these:<br>
<pre><code>[WARN] Module declares a servlet class 'com.allen_sauer.gwt.log.server.RemoteLoggerServiceImpl', but the web.xml has no corresponding declaration; please add the following lines to your web.xml:<br>
&lt;servlet&gt;<br>
  &lt;servlet-name&gt;remoteLoggerServiceImpl&lt;/servlet-name&gt;<br>
  &lt;servlet-class&gt;com.allen_sauer.gwt.log.server.RemoteLoggerServiceImpl&lt;/servlet-class&gt;<br>
&lt;/servlet&gt;<br>
&lt;servlet-mapping&gt;<br>
  &lt;servlet-name&gt;remoteLoggerServiceImpl&lt;/servlet-name&gt;<br>
  &lt;url-pattern&gt;/yourmodule/gwt-log&lt;/url-pattern&gt;<br>
&lt;/servlet-mapping&gt;<br>
</code></pre></blockquote></li></ul>

<hr />
<h1>What's new in <code>gwt-log-3.0.2.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Fix for for <code>%C</code>, <code>%F</code>, <code>%L</code> showing incorrect stack trace element. Thanks chengkarleung!<br>
</li><li>Fix for <code>NullPointerException</code> in <code>ServerLogImplLog4J</code>. Thanks isacssouza!<br>
</li><li>Workaround for <a href='http://code.google.com/p/fbug/issues/detail?id=2914'>Firebug issue 2914</a>, which prevented <code>Log.error()</code> and <code>Log.fatal()</code> calls from reaching the Firebug console. Thanks mcarthum!<br>
</li></ul></li><li><h3>New in this release</h3>
<ul><li>Support precision specifiers for category and class conversion characters, e.g. instead of just <code>%c</code> and <code>%C</code>, <code>%c{5}</code> or <code>%C{2}</code> are now possible. See <a href='http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html'>http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html</a>
</li><li>A javadoc jar is available for <a href='http://code.google.com/p/gwt-log/downloads/list'>download</a>
</li></ul></li><li><h3>Other changes in this release</h3>
<ul><li>No longer forward gwt-log diagnostic messages to the server.<br>
</li></ul></li><li><h3>Changes under the hood</h3>
<ul><li>Moved shared client/server code into a <code>shared</code> Java package<br>
</li><li>Removed the special<code>ClientStackTraceElement</code> Java class now that GWT directly supports serialization of <code>StackTraceElement</code></li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-3.0.1.jar</code></h1>
<ul><li><h3>Visible changes</h3>
<ul><li>Reintroduction of server side implementations such as Log.isDebugEnabled(). Thanks vruiz.jurado!<br>
</li></ul></li><li><h3>Changes under the hood</h3>
<ul><li>Project refactoring and simplification<br>
</li><li>Introduction of new <code>LogRecord</code> class in preparation for new features<br>
</li><li>Improved ant build. Thanks amichail!</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-3.0.0.jar</code></h1>
<ul><li><h3>New features</h3>
<ul><li>Additional pattern specifiers now supported (<code>%C</code>, <code>%F</code>, <code>%L</code> or<code> %M</code> and <code>%l</code>) in Development Mode (Hosted Mode). See <a href='http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html'>http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html</a> to get an idea of how these work. Thanks omsrobert!<br>
</li><li>RemoteLogger sends multiple messages in a single RPC when they are logged within a short period of time<br>
</li><li>RemoteLogger more resilient in the face of client server communication failures<br>
</li><li>RemoteLogger only uses a single network connection at any given time<br>
</li><li>Fix for <a href='http://code.google.com/p/gwt-log/issues/detail?id=22'>issue 22</a> - <code>RemoteLogger</code> now sends messages from a single client to the server in order (although the server does no ordering across multiple clients, so out of order logging is strictly speaking still possible). Thanks terciofilho!<br>
</li><li>Server side logging (via <code>RemoteLogger</code>) is no longer hard coded via <code>setCurrentLogLevel(LOG_LEVEL_DEBUG)</code>. Thanks Bob Cunius!<br>
</li></ul></li><li><h3>General changes in this release</h3>
<ul><li><code>gwt-log.css</code> is now injected via <code>ClientBundle</code>: minification benefits and avoid an extra HTTP roundtrip<br>
</li><li><code>gwt-log.css</code> is no longer injected when logging is turned off<br>
</li></ul></li><li><h3>Other changes in this release</h3>
<ul><li>Build script fix. Thanks Evely!<br>
</li><li>No longer use deprecated <code>PropertyOracle</code> methods which avoid compiler warnings<br>
</li><li>Fix for <a href='http://code.google.com/p/gwt-log/issues/detail?id=10'>issue 10</a> in <a href='https://code.google.com/p/gwt-log/source/detail?r=423'>r423</a> ability to programmatically hide DivLogger. Calling <code>Log.getDivLogger().getWidget().setVisible(false)</code> keeps DivLogger hidden, even when new messages appear. Call <code>Log.getDivLogger().getWidget().setVisible(true)</code> to make DivLogger reappear. Thanks pohl.longsine!<br>
</li><li>Remove workaround for <a href='http://code.google.com/p/google-web-toolkit/issues/detail?id=1934'>GWT issue 1934</a> <code>WindowResizeListener#onWindowResized</code> fires too often in IE</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-2.6.2.jar</code></h1>
<ul><li><h3>General changes in this release</h3>
<ul><li>Support for GWT's new user-agent value <code>ie8</code></li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-2.6.1.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Workaround for <a href='http://code.google.com/p/google-web-toolkit/issues/detail?id=3791'>GWT issue 3791</a> affecting anyone using logging code inside of <code>GWTTestCase</code>. Thanks praveen.kumar.jayaram, dwself, pcniatic, dgantenbein (Dorothy)!</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-2.6.0.jar</code></h1>
<ul><li><h3>New features</h3>
<ul><li>Control the format of your log messages<br>
<pre><code>  &lt;!--<br>
    Inspired by Apache log4j PatternLayout:<br>
    http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html<br>
  --&gt;<br>
  &lt;set-configuration-property name="log_pattern" value="%d [%-5p] %m%n" /&gt;<br>
</code></pre>
</li></ul></li><li><h3>General changes in this release</h3>
<ul><li>Allow logging to work easily on <a href='http://code.google.com/appengine'>Google App Engine</a>
</li><li>Got rid of explicit call outs to <code>ConsoleHandler</code> so that application developers can better control their own log output when using <code>java.util.logging</code> on the server, i.e.<br>
replaced:<br>
<pre><code>    logger = Logger.getLogger("gwt-log");<br>
    logger.setUseParentHandlers(false);<br>
    ConsoleHandler consoleHandler = new ConsoleHandler();<br>
    consoleHandler.setLevel(Level.ALL);<br>
    logger.addHandler(consoleHandler);<br>
</code></pre>
with:<br>
<pre><code>    logger = Logger.getLogger("gwt-log");<br>
</code></pre>
</li><li>Updated code base to use new GWT 1.6 features<br>
<ul><li><code>Listener</code>s -> <code>Handler</code>s<br>
</li><li>Use new <code>war</code> directory structure<br>
</li></ul></li></ul></li><li><h3>Eclipse project related changes</h3>
<ul><li>Update <code>Log</code> Eclipse project to use new Eclipse plugin<br>
</li><li>Merged separate <code>LogClientServerDemo</code> Eclipse project into main <code>Log</code> project<br>
</li><li>Project uses <code>super-src</code> mechanism to pull in client side versions of <code>*.java</code> classes</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-2.5.3.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Prevent extraneous 'null' messages logged by <code>RemoteLogger</code> when no exception is passed. Thanks Thomas Vidal!</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-2.5.2.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Fix broken ant build file causing <code>UnsupportedOperationException: ERROR: GWT.create() is only usable in client code!</code> in server code. Thanks Vicente J. Ruiz Jurado!</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-2.5.1.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Fix for <a href='http://code.google.com/p/gwt-log/issues/detail?id=15'>issue 15</a>, <code>DivLogger</code> failing to auto scroll in Firefox and Mozilla 1.5 (Linux hosted mode). Thanks borice!<br>
</li></ul></li><li><h3>New Functionality</h3>
<ul><li>Add ability to catch exceptions in code called from JSNI <code>setTimeout()</code> or <code>setInterval()</code>. This feature is available in Firefox and IE only. However, Safari and Opera will allow you access to the same information from their native JavaScript (debug) consoles<br>
</li><li>Support for <code>TRACE</code> level logging (in addition to existing levels <code>DEBUG</code>, <code>INFO</code>, <code>WARN</code>, <code>ERROR</code>, <code>FATAL</code>, <code>OFF</code>)<br>
</li><li>New log level specific modules to inherit from so that a default other than <code>OFF</code> can be selected for your application, e.g.<br>
<pre><code>      &lt;inherits name="com.allen_sauer.gwt.log.gwt-log-WARN" /&gt;<br>
</code></pre>
</li></ul></li><li><h3>Other Changes</h3>
<ul><li>Reduced <code>RemoteLogger</code> noise, especially when multiple clients are involved. No longer output the log delimiter message during initialization (for each client). Thanks Rafal!</li></ul></li></ul>

<hr />
<h1>What's new in <code>gwt-log-2.5.0.jar</code></h1>
<ul><li><h3>New Functionality</h3>
<ul><li>New experimental <code>WindowLogger</code> which can be enabled in your application's <code>*.gwt.xml</code> by adding:<br>
<pre><code>  &lt;!--<br>
    Enable experimental WindowLogger, which logs messages to a separate<br>
    popup window. There are currently a couple of restrictions:<br>
<br>
    1. When Firefox is configured to open new Windows as new tabs,<br>
       WindowLogger does not work<br>
    2. In hosted mode, the windows are not automatically closed,<br>
       although you can easily close them manually in the usual way<br>
  --&gt;<br>
  &lt;set-property name="log_WindowLogger" value="ENABLED" /&gt;<br>
<br>
  &lt;!--<br>
    You probably will want to disable the default `DivLogger` as well:<br>
  --&gt;<br>
  &lt;set-property name="log_DivLogger" value="DISABLED" /&gt;<br>
</code></pre></li></ul></li></ul>

<ul><li><h3>General changes in this release</h3>
<ul><li>Wrap/unwrap client thrown exceptions to:<br>
<ol><li>Reduce RPC surface area (reduction in size of compiled code)<br>
</li><li>Prevent RPC errors when non-<code>Serializable</code> exceptions are logged client-side</li></ol></li></ul></li></ul>

<ul><li><h3>Bug Fixes</h3>
<ul><li>gwt-log <a href='http://code.google.com/p/gwt-log/issues/detail?id=13'>issue 13</a>: Logging a null message results in NPE. Thanks rintcius!</li></ul></li></ul>

<ul><li><h3>Other updates</h3>
<ul><li>Javadoc updates<br>
</li><li>Minor updates to online demo, including new log <code>null</code> message button<br>
</li><li>Ant build changes</li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.5.6.jar</code></h1>
<ul><li><h3>New Functionality</h3>
<ul><li>Improved code completion for IDEs</li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.5.5.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Improved <code>DivLogger</code> resizing</li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.5.3.jar</code></h1>
<ul><li><h3>Bug Fixes</h3>
<ul><li>Disable <code>ConsoleLogger</code> when <code>FirebugLogger</code> is available, to prevent duplicate messages for Firebug users<br>
</li><li><a href='http://code.google.com/p/gwt-log/issues/detail?id=9'>issue 9</a> Disabling and re-enabling Firebug causes the <code>FirebugLogger</code> to be removed, rather than begin throwing JavaScript exceptions.</li></ul></li></ul>

<ul><li><h3>New Functionality</h3>
<ul><li><code>DivLogger</code> user interface updates:<br>
<ul><li>Control runtime log level<br>
</li><li>Clear the log (<a href='http://code.google.com/p/gwt-log/issues/detail?id=5'>issue 5</a>)<br>
</li><li>Resize log panel<br>
</li><li>Show 'About' information<br>
</li></ul></li><li>Emit a message when runtime log level is changed, to prevent developers from believing they have eliminated overhead caused by logging<br>
</li><li>Loggers which throw exceptions are now automatically removed; Previously there was a special case for <code>RemoteLogger</code> RPC failures</li></ul></li></ul>

<ul><li><h3>Other Changes</h3>
<ul><li>Javadoc updates<br>
</li><li>Eclipse project changes<br>
</li><li>New internal diagnostic logging method<br>
</li><li>Various internal changes</li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.5.2.jar</code></h1>
<ul><li><h3>New Functionality</h3>
<ul><li>Remote logging, i.e. sending a copy of messages logged on the client to the server, via<br>
<pre><code>  &lt;set-property name="log_RemoteLogger" value="ENABLED" /&gt;<br>
</code></pre>
</li><li>Ability to configure loggers from your module, with these defaults:<br>
<pre><code>  &lt;!-- Enabled by default --&gt;<br>
  &lt;set-property name="log_ConsoleLogger" value="ENABLED" /&gt;<br>
  &lt;set-property name="log_DivLogger" value="ENABLED" /&gt;<br>
  &lt;set-property name="log_FirebugLogger" value="ENABLED" /&gt;<br>
  &lt;set-property name="log_GWTLogger" value="ENABLED" /&gt;<br>
  &lt;set-property name="log_SystemLogger" value="ENABLED" /&gt;<br>
<br>
  &lt;!-- Disabled by default --&gt;<br>
  &lt;set-property name="log_RemoteLogger" value="DISABLED" /&gt;<br>
</code></pre></li></ul></li></ul>

<ul><li><h3>Other Changes</h3>
<ul><li>Removed <code>Log#removeLogger</code> method in favor of deferred binding properties<br>
</li><li>Updated JDK 1.4 <code>gwt-log</code> logger to be configured with a <code>ConsoleHandler</code> at the <code>ALL</code> level as the JDK implementation default is <code>SEVERE</code> and would unexpectedly hide debug/info/warn messages<br>
</li><li>Various minor implementation changes</li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.5.1.jar</code></h1>
<ul><li><h3>New Functionality</h3>
<ul><li>Serializable classes (domain objects, POJOs, etc.) can utilize the same logging code on client and server via inclusion of a single, common, <code>gwt-log</code> jar on both tiers<br>
</li><li>Server side logging automatically detects Apache <a href='http://logging.apache.org/log4j/'>log4j</a>, falling back to <a href='http://java.sun.com/j2se/1.4.2/docs/guide/util/logging/overview.html'>JDK 1.4 logging</a></li></ul></li></ul>

<ul><li><h3>Other Changes</h3>
<ul><li>Removed ability to extend existing log levels for reduced complexity; please file an issue if you absolutely must have this ability<br>
</li><li>Class <code>LoggerSystem</code> renamed to <code>SystemLogger</code> for consistency<br>
</li><li>Public <code>Logger#log</code> changed accessibility to package default<br>
</li><li>Updated project and ant build file</li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.4.5.jar</code></h1>

<ul><li><h3>Bug Fixes</h3>
<ul><li><a href='http://code.google.com/p/gwt-log/issues/detail?id=6'>Issue 6</a> <code>Throwable</code> with <code>null</code> message, e.g. <code>throw new NullPointerException()</code>, would fail to get logged; instead an exception would be logged in the hosted mode tree logger regarding the gwt-log failure. Thanks dwyah!</li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.4.4.jar</code></h1>

<ul><li><h3>Changes in this version</h3>
<ul><li><code>DivLogger</code> text area now resizes itself with the browser window to roughly 80% of the client window width and 20% of the height, but always at least <code>300px</code> x <code>100px</code>. To set an explicit size in your application use something like:<br>
<pre><code>.log-panel .log-scroll-panel {<br>
  width: 800px !important;<br>
  height: 150px !important;<br>
}<br>
</code></pre>
</li><li>Hovering over log messages and stack traces shows a tool tip with the most essential portion of the error message, which should greatly reduce the amount of scrolling required in the log panel<br>
<blockquote><img src='http://gwt-log.googlecode.com/files/2008-01-20-log-panel.png' />
</blockquote></li><li>In the <code>DivLogger</code>, all messages, except for stack traces, wrap, rather than scroll off the right hand side, which again, this should reduce the amount of log panel scrolling<br>
</li><li><code>Logger#removeLogger</code> is now static. Thanks steven.marcus!<br>
</li><li>ant build file, checkstyle and other Eclipse project changes</li></ul></li></ul>





<hr />
<h1>What's new in <code>gwt-log-1.4.3.jar</code></h1>

<ul><li><h3>Changes in this version</h3>
<ul><li>Compile time <code>log_level</code> parameter is now set to a single value (<code>OFF</code>) by default instead of generating all six (<code>DEBUG</code>, <code>INFO</code>, <code>WARN</code>, <code>ERROR</code>, <code>FATAL</code>, <code>OFF</code>) deferred binding combinations.<br>
<ul><li>Additional compile time values can of course be added via <code>extend-property</code>, typically:<br>
<pre><code>          &lt;extend-property name="log_level" values="DEBUG,OFF"/&gt;<br>
</code></pre>
</li><li>The default value may be overridden via <code>set-property</code>, typically:<br>
<pre><code>          &lt;set-property name='log_level' value='DEBUG'/&gt;<br>
</code></pre>
</li><li>See <a href='http://gwt-log.googlecode.com/svn/trunk/Log/src/com/allen_sauer/gwt/log/gwt-log.gwt.xml'>gwt-log.xml</a> for additional documentation on how to control the compile time and runtime log levels of your application.</li></ul></li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.4.1.jar</code></h1>

<ul><li><h3>Changes in this version</h3>
<ul><li>Implemented deferred binding to allow for client and library related logging code to be compiled out by the GWT Compiler dead code elimination when <code>log_level=OFF</code>.<br>
</li><li>Changed module name from <code>com.allen_sauer.gwt.log.Log</code> to <code>com.allen_sauer.gwt.log.gwt-log</code>.<br>
</li><li>Please see the updated <a href='http://code.google.com/p/gwt-log/wiki/GettingStarted'>GettingStarted</a> wiki for additional details.</li></ul></li></ul>




<hr />
<h1>What's new in <code>gwt-log-1.3.1.jar</code></h1>

<ul><li>Release 1.3.1 is not new. It's old :).</li></ul>



<hr />