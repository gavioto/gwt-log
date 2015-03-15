
---

# What's brewing in gwt-log `trunk` #
  * **Other changes**
    * Stay tuned. More to come.


---

# What's new in `gwt-log-3.3.2.jar` (requires GWT 2.6.1 or newer) #
  * **Changes in this release**
    * In `LogMessageFormatterGenerator` replace accidental `com.google.gwt.dev.util.collect.HashSet` with `java.util.HashSet`. Thanks, Roberto Lublinerman!



---

# What's new in `gwt-log-3.3.1.jar` (requires GWT 2.6.1 or newer) #
  * **Changes in this release**
    * Java 7, GWT 2.6.1
    * Changes to `RemoteLoggerServlet` initialization parameters: `symbolMaps` no longer supported, in favor of `symbolMapsFileSystem`, `symbolMapsResourcePath` and `symbolMapsResourceUrl` initialization parameters
  * **New in this release**
    * `LogRecord` and `WrappedClientThrowable` implement `IsSerializable`, to help certain users avoid `SerializationException` when using remote logging
  * **Removed in this release**
    * Removed deprecated `RemoteLoggerServiceImpl`; Use `RemoteLoggerServlet` instead.
    * Removed deprecated `FirebugLogger`; Use `ConsoleLogger` instead.
  * **Bug Fixes**
    * [Issue 43](https://github.com/fredsa/gwt-log/issues/43), Remote logger fails with gwt-2.1.0-M3: `IncompatibleRemoteServiceException`. Thanks A.A.Vasiljev!
    * [Issue 67](https://github.com/fredsa/gwt-log/issues/67), Serialization error. Thanks barnabas!
    * [Issue 73](https://github.com/fredsa/gwt-log/issues/73), Remote servlet uses file api instead of `context.getResource()`. Thanks jcompagner!
    * [Issue 18](https://github.com/fredsa/gwt-log/issues/18), SLF4J server-side support. Thanks, dobesv!


---

# What's new in `gwt-log-3.3.0.jar` (requires GWT 2.6.0 or newer) #
  * **New in this release**
    * Support for GWT 2.6.0
  * **Changes in this release**
    * Removed support for `ie6`
    * Added support for `ie10`


---

# What's new in `gwt-log-3.2.1.jar` #
  * **Bug Fixes**
    * [Issue 70](https://github.com/fredsa/gwt-log/issues/70), `java.lang.NoClassDefFoundError: com/google/gwt/core/client/GWTBridge` in GWT 2.5 server side code. Thanks brian.tosch and tomfreay!


---

# What's new in `gwt-log-3.2.0.jar` #
  * **New in this release**
    * Support for GWT 2.5.0


---

# What's new in `gwt-log-3.1.8.jar` #
  * **Bug Fixes**
    * [Issue 44](https://github.com/fredsa/gwt-log/issues/44), fixed corrupted `DivLogger` triangle image (again). Thanks PhiLho!
  * **Changes Affecting Maven Users**
    * [Issue 65](https://github.com/fredsa/gwt-log/issues/65), mark `gwt-user` pom dependency with `<scope>provided</scope>`, to avoid `gwt-user-*.jar` ending up in `WEB-INF/lib/`. Thanks samskivert!


---

# What's new in `gwt-log-3.1.7.jar` #
  * **New in this release**
    * `RemoteLoggerServlet` now logs a warning message if a provided `symbolMaps` directory does not exist. The warning message includes the server's current working directory, in order to assist developers in configuring valid server paths.


---

# What's new in `gwt-log-3.1.6.jar` #
  * **New in this release**
    * Releases are now also deployed to Sonatype OSS Maven repository and sync to [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ccom.allen-sauer.gwt.log) with groupId `com.allen-sauer.gwt.log` and artifact `gwt-log`


---

# What's new in `gwt-log-3.1.5.jar` #
  * **Improvements in this release**
    * Add category to server side messages when `java.util.logging` is used (which is the default)


---

# What's new in `gwt-log-3.1.4.jar` #
  * **Bug Fixes**
    * Fix `DivLogger#setSize()` and `DivLogger#setPixelSize()`. Thanks DavLP!
    * Improve logging in IE: revert console logger; use `$wnd.console` rather than `window.console`, now that [FireBug issue 2914](http://code.google.com/p/fbug/issues/detail?id=2914) has been fixed
  * **Improvements in this release**
    * Avoid recomputing message for each logger. Thanks Eugen!


---

# What's new in `gwt-log-3.1.3.jar` #
  * **Bug Fixes**
    * Fix caller information when remote logger is used. Thanks cimballi!
    * [Issue 46](https://github.com/fredsa/gwt-log/issues/46), no longer resize the `DivLogger` when a new message is logged
    * Fix sizing of `DivLogger` when `moveTo()` is called before the first logged message
    * Fix [issue 61](https://github.com/fredsa/gwt-log/issues/61), logging in IE developer tools
    * Recursively deobfuscate `WrappedClientThrowable` causes
  * **New in this release**
    * Finally fixed [issue 3](https://github.com/fredsa/gwt-log/issues/3): make `DivLogger` closeable. Thanks pby\_fr!
    * [Issue 14](https://github.com/fredsa/gwt-log/issues/14), by popular demand, `DivLogger` is attached to the bottom of the browser window, instead of being attached to the top left corner, where it is more likely to interfere with your UI.
    * Add ie9 property support, to avoid those annoying warnings.
    * Update your web.xml servlet definitions: `RemoteLoggerServiceImpl` -> `RemoteLoggerServlet`
    * New `RemoteLoggerServlet#shouldReturnDeobfuscatedStackTraceToClient()` method provides a way for subclasses to restrict which clients (users) have access to deobfuscated `JavaScript` stack traces.
    * [Issue 56](https://github.com/fredsa/gwt-log/issues/56), allow apps to specify multiple symbolMaps directories by using multiple init-param names that start with "symbolMaps"
    * Add cross-domain XHR support to `RemoteLogger` (for all but IE)
    * Removed complexity from `RemoteLogger`. We now simply 1) log to local (client) loggers immediately, 2) send log messages to the server. If the server returns deobfuscated stack traces, we send those deobfuscated stacktraces to other client loggers when we get them, even though they may be delayed, and are essentially duplicates of the earlier obfuscated messages.
    * On Google App Engine, use JDK logging by default, for better log integration
  * **Other changes in this release**
    * Java 1.5 -> 1.6
    * GWT 2.2 -> 2.3
    * gwt-log's DEBUG/TRACE levels were mapped to java.util.logging's FINE/FINEST levels; now using CONFIG/FINE instead
    * `DivLogger` no longer overrides `setVisible()`.
    * Comment out servlet declaration in .gwt.xml due to [GWT issue 6377](http://code.google.com/p/google-web-toolkit/issues/detail?id=6377)
    * Suppress annoying warning about failure to deobfuscate `HostedMode` permutation when running in GWT Development Mode. Thanks José Morales!


---

# What's new in `gwt-log-3.1.2.jar` #
  * **Bug Fixes**
    * Fix incorrect caller information when `RemoteLogger` is used. Thanks Cimballi!


---

# What's new in `gwt-log-3.1.1.jar` #
  * **Bug Fixes**
    * Fix incorrect caller information in log messages. Thanks John White!
  * **Changes in this release**
    * `ConsoleLogger` subsumes `FirebugLogger`
  * **Other changes in this release**
    * Firebug (tested in 1.7X.0a9) logged stack traces can now be shown in a single message, broken by line feeds
    * Removed old `gecko` deferred binding rules


---

# What's new in `gwt-log-3.1.0.jar` #
  * **Bug Fixes**
    * Fix for [issue 53](https://github.com/fredsa/gwt-log/issues/53), restore logging of chained exceptions, i.e. exceptions with causes. Thanks rileylark!
  * **New in this release**
    * Added server side strack trace deobfuscation! To enable this feature, which will turn your cryptic production mode obfuscated stack traces into something a lot more useful:
      1. Enable the `RemoteLogger` in your `.gwt.xml` module file:

        ```XML
        <inherits name="com.allen_sauer.gwt.log.gwt-log-RemoteLogger"/>
        ```

      1. Specify the `symbolMaps` `<init-param>` to the `RemoteLogger` servlet in your `web.xml`:

        ```XML
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

        ```XML
        <set-property name="compiler.emulatedStack" value="true" />
        <set-configuration-property name="compiler.emulatedStack.recordLineNumbers" value="true" />
        <set-configuration-property name="compiler.emulatedStack.recordFileNames" value="true" />
        ```

        Before, without deobfuscation:

        ```Java
        at Unknown.hm(Unknown source)
        at Unknown.vn(Unknown source)
        at Unknown.x6(Unknown source)
        at Unknown.uH(Unknown source)
        at Unknown.No(Unknown source)
        at Unknown.anonymous(Unknown source)
        at Unknown.gwtOnLoad(Unknown source)
        ```

        After, with deobfuscation turned on:

        ```Java
        at java.lang.Throwable.fillInStackTrace(Throwable.java:71)
        at java.lang.RuntimeException.RuntimeException(RuntimeException.java:25)
        at logtest.client.Logtest.$onModuleLoad(Logtest.java:43)
        at com.google.gwt.lang.EntryMethodHolder.init(com.google.gwt.dev.jjs.JavaToJavaScriptCompiler)
        at com.google.gwt.core.client.impl.Impl.entry0(Impl.java:197)
        at Unknown.anonymous(Unknown source)
        at Unknown.gwtOnLoad(Unknown source)
        ```

  * **Other changes in this release**
    * Changes for [issue 51](https://github.com/fredsa/gwt-log/issues/51), use `throwable.toString()` instead of replicating `toString()` logic in gwt-log, so that exceptions with custom `toString()` implementations are logged as expected. Thanks terciofilho!

----
# What's new in `gwt-log-3.0.4.jar` #
  * **Bug Fixes**
    * Fix for [issue 42](https://github.com/fredsa/gwt-log/issues/42), precision specifier breaks padding. Thanks cimballi.cimballi!
    * Fix for [issue 44](https://github.com/fredsa/gwt-log/issues/44), `DivLogger` bottom-right corner image is corrupted. Thanks polushin!

----
# What's new in `gwt-log-3.0.3.jar` #
  * **Bug Fixes**
    * Fix for [issue 32](https://github.com/fredsa/gwt-log/issues/32), `ConsoleLogger.isSupported()` returns `false` for Internet Explorer 8. Thanks hernidez!
    * Restore missing stack traces from log messages sent to the server via `RemoteLogger`. We inadvertently lost them in r436 (gwt-log 3.0.1) when `LogRecord`s were introduced. Thanks ebatzdor!
  * **New Features**
    * Add Logging of `X-Forwarded-For` headers for `RemoteLogger` as suggested in [issue 31](https://github.com/fredsa/gwt-log/issues/31). Thanks kmj7777!
  * **Other Changes**
    * Removing legacy `com.allen_sauer.gwt.log.gwt-log` module in favor of log level specific modules, e.g. `com.allen_sauer.gwt.log.gwt-log-DEBUG`, `com.allen_sauer.gwt.log.gwt-log-WARN`, etc.
    * Change Dev Mode stack trace element determination function from the brittle fixed depth implementation to a more robust search past `com.allen_sauer.gwt.log.{client|shared}`
    * Address [issue 26](https://github.com/fredsa/gwt-log/issues/26), Extract `RemoteLogger` to separate gwt module. Thanks konstantin.v.pavlov!
    `RemoteLogger` is now activated by inheriting a module:

        ```XML
        <inherits name="com.allen_sauer.gwt.log.gwt-log-RemoteLogger" />
        ```

        rather than setting a property as had be the case up till now:

        ```XML
        <set-property name="log_RemoteLogger" value="ENABLED" />
        ```

        This change means that users who don't need `RemoteLogger` will no longer have to see message like these:

        ```
        [WARN] Module declares a servlet class 'com.allen_sauer.gwt.log.server.RemoteLoggerServiceImpl', but the web.xml has no corresponding declaration; please add the following lines to your web.xml:
        <servlet>
          <servlet-name>remoteLoggerServiceImpl</servlet-name>
          <servlet-class>com.allen_sauer.gwt.log.server.RemoteLoggerServiceImpl</servlet-class>
        </servlet>
        <servlet-mapping>
          <servlet-name>remoteLoggerServiceImpl</servlet-name>
          <url-pattern>/yourmodule/gwt-log</url-pattern>
        </servlet-mapping>
        ```


----
# What's new in `gwt-log-3.0.2.jar` #
  * **Bug Fixes**
    * Fix for for `%C`, `%F`, `%L` showing incorrect stack trace element. Thanks chengkarleung!
    * Fix for `NullPointerException` in `ServerLogImplLog4J`. Thanks isacssouza!
    * Workaround for [Firebug issue 2914](http://code.google.com/p/fbug/issues/detail?id=2914), which prevented `Log.error()` and `Log.fatal()` calls from reaching the Firebug console. Thanks mcarthum!
  * **New in this release**
    * Support precision specifiers for category and class conversion characters, e.g. instead of just `%c` and `%C`, `%c{5}` or `%C{2}` are now possible. See http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
    * A javadoc jar is available for [download](https://github.com/fredsa/gwt-log/blob/wiki/Downloads.md)
  * **Other changes in this release**
    * No longer forward gwt-log diagnostic messages to the server.
  * **Changes under the hood**
    * Moved shared client/server code into a `shared` Java package
    * Removed the special`ClientStackTraceElement` Java class now that GWT directly supports serialization of `StackTraceElement`

----
# What's new in `gwt-log-3.0.1.jar` #
  * **Visible changes**
    * Reintroduction of server side implementations such as Log.isDebugEnabled(). Thanks vruiz.jurado!
  * **Changes under the hood**
    * Project refactoring and simplification
    * Introduction of new `LogRecord` class in preparation for new features
    * Improved ant build. Thanks amichail!

----
# What's new in `gwt-log-3.0.0.jar` #
  * **New features**
    * Additional pattern specifiers now supported (`%C`, `%F`, `%L` or` %M` and `%l`) in Development Mode (Hosted Mode). See http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html to get an idea of how these work. Thanks omsrobert!
    * !RemoteLogger sends multiple messages in a single RPC when they are logged within a short period of time
    * !RemoteLogger more resilient in the face of client server communication failures
    * !RemoteLogger only uses a single network connection at any given time
    * Fix for [issue 22](https://github.com/fredsa/gwt-log/issues/22) - `RemoteLogger` now sends messages from a single client to the server in order (although the server does no ordering across multiple clients, so out of order logging is strictly speaking still possible). Thanks terciofilho!
    * Server side logging (via `RemoteLogger`) is no longer hard coded via `setCurrentLogLevel(LOG_LEVEL_DEBUG)`. Thanks Bob Cunius!
  * **General changes in this release**
      * `gwt-log.css` is now injected via `ClientBundle`: minification benefits and avoid an extra HTTP roundtrip
      * `gwt-log.css` is no longer injected when logging is turned off
  * **Other changes in this release**
    * Build script fix. Thanks Evely!
    * No longer use deprecated `PropertyOracle` methods which avoid compiler warnings
    * Fix for [issue 10](https://github.com/fredsa/gwt-log/issues/10) in r423 ability to programmatically hide !DivLogger. Calling `Log.getDivLogger().getWidget().setVisible(false)` keeps !DivLogger hidden, even when new messages appear. Call `Log.getDivLogger().getWidget().setVisible(true)` to make !DivLogger reappear. Thanks pohl.longsine!
    * Remove workaround for [GWT issue 1934](http://code.google.com/p/google-web-toolkit/issues/detail?id=1934) `WindowResizeListener#onWindowResized` fires too often in IE

----
# What's new in `gwt-log-2.6.2.jar` #
  * **General changes in this release**
    * Support for GWT's new user-agent value `ie8`

----
# What's new in `gwt-log-2.6.1.jar` #
  * **Bug Fixes**
    * Workaround for [GWT issue 3791](http://code.google.com/p/google-web-toolkit/issues/detail?id=3791) affecting anyone using logging code inside of `GWTTestCase`. Thanks praveen.kumar.jayaram, dwself, pcniatic, dgantenbein (Dorothy)!

----
# What's new in `gwt-log-2.6.0.jar` #
  * **New features**
    * Control the format of your log messages

        ```XML
        <!--
          Inspired by Apache log4j PatternLayout:
          http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
        -->
        <set-configuration-property name="log_pattern" value="%d [%-5p] %m%n" />
        ```

  * **General changes in this release**
    * Allow logging to work easily on [Google App Engine](https://cloud.google.com/appengine)
    * Got rid of explicit call outs to `ConsoleHandler` so that application developers can better control their own log output when using `java.util.logging` on the server, i.e.
replaced:

        ```Java
        logger = Logger.getLogger("gwt-log");
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        ```

        with:

        ```Java
        logger = Logger.getLogger("gwt-log");
        ```

    * Updated code base to use new GWT 1.6 features
      * `Listener`s -> `Handler`s
      * Use new `war` directory structure
  * **Eclipse project related changes**
    * Update `Log` Eclipse project to use new Eclipse plugin
    * Merged separate `LogClientServerDemo` Eclipse project into main `Log` project
    * Project uses `super-src` mechanism to pull in client side versions of `*.java` classes

----
# What's new in `gwt-log-2.5.3.jar` #
  * **Bug Fixes**
    * Prevent extraneous 'null' messages logged by `RemoteLogger` when no exception is passed. Thanks Thomas Vidal!

----
# What's new in `gwt-log-2.5.2.jar` #
  * **Bug Fixes**
    * Fix broken ant build file causing `UnsupportedOperationException: ERROR: GWT.create() is only usable in client code!` in server code. Thanks Vicente J. Ruiz Jurado!

----
# What's new in `gwt-log-2.5.1.jar` #
  * **Bug Fixes**
    * Fix for [issue 15](https://github.com/fredsa/gwt-log/issues/15), `DivLogger` failing to auto scroll in Firefox and Mozilla 1.5 (Linux hosted mode). Thanks borice!
  * **New Functionality**
    * Add ability to catch exceptions in code called from JSNI `setTimeout()` or `setInterval()`. This feature is available in Firefox and IE only. However, Safari and Opera will allow you access to the same information from their native !JavaScript (debug) consoles
    * Support for `TRACE` level logging (in addition to existing levels `DEBUG`, `INFO`, `WARN`, `ERROR`, `FATAL`, `OFF`)
    * New log level specific modules to inherit from so that a default other than `OFF` can be selected for your application, e.g.

        ```XML
        <inherits name="com.allen_sauer.gwt.log.gwt-log-WARN" />
        ```

  * **Other Changes**
    * Reduced `RemoteLogger` noise, especially when multiple clients are involved. No longer output the log delimiter message during initialization (for each client). Thanks Rafal!

----
# What's new in `gwt-log-2.5.0.jar` #
  * **New Functionality**
    * New experimental `WindowLogger` which can be enabled in your application's `*.gwt.xml` by adding:

        ```XML
        <!--
          Enable experimental WindowLogger, which logs messages to a separate
          popup window. There are currently a couple of restrictions:

          1. When Firefox is configured to open new Windows as new tabs,
             WindowLogger does not work
          2. In hosted mode, the windows are not automatically closed,
             although you can easily close them manually in the usual way
        -->
        <set-property name="log_WindowLogger" value="ENABLED" />

        <!--
          You probably will want to disable the default `DivLogger` as well:
        -->
        <set-property name="log_DivLogger" value="DISABLED" />
        ```


  * **General changes in this release**
    * Wrap/unwrap client thrown exceptions to:
      # Reduce RPC surface area (reduction in size of compiled code)
      # Prevent RPC errors when non-`Serializable` exceptions are logged client-side

  * **Bug Fixes**
    * gwt-log [issue 13](https://github.com/fredsa/gwt-log/issues/13): Logging a null message results in NPE. Thanks rintcius!

  * **Other updates**
    * Javadoc updates
    * Minor updates to online demo, including new log `null` message button
    * Ant build changes




----
# What's new in `gwt-log-1.5.6.jar` #
  * **New Functionality**
    * Improved code completion for IDEs




----
# What's new in `gwt-log-1.5.5.jar` #
  * **Bug Fixes**
    * Improved `DivLogger` resizing




----
# What's new in `gwt-log-1.5.3.jar` #
  * **Bug Fixes**
    * Disable `ConsoleLogger` when `FirebugLogger` is available, to prevent duplicate messages for Firebug users
    * [issue 9](https://github.com/fredsa/gwt-log/issues/9) Disabling and re-enabling Firebug causes the `FirebugLogger` to be removed, rather than begin throwing !JavaScript exceptions.

  * **New Functionality**
    * `DivLogger` user interface updates:
      * Control runtime log level
      * Clear the log ([issue 5](https://github.com/fredsa/gwt-log/issues/5))
      * Resize log panel
      * Show 'About' information
    * Emit a message when runtime log level is changed, to prevent developers from believing they have eliminated overhead caused by logging
    * Loggers which throw exceptions are now automatically removed; Previously there was a special case for `RemoteLogger` RPC failures

  * **Other Changes**
    * Javadoc updates
    * Eclipse project changes
    * New internal diagnostic logging method
    * Various internal changes




----
# What's new in `gwt-log-1.5.2.jar` #
  * **New Functionality**
    * Remote logging, i.e. sending a copy of messages logged on the client to the server, via

        ```XML
        <set-property name="log_RemoteLogger" value="ENABLED" />
        ```

    * Ability to configure loggers from your module, with these defaults:

        ```XML
        <!-- Enabled by default -->
        <set-property name="log_ConsoleLogger" value="ENABLED" />
        <set-property name="log_DivLogger" value="ENABLED" />
        <set-property name="log_FirebugLogger" value="ENABLED" />
        <set-property name="log_GWTLogger" value="ENABLED" />
        <set-property name="log_SystemLogger" value="ENABLED" />

        <!-- Disabled by default -->
        <set-property name="log_RemoteLogger" value="DISABLED" />
        ```


  * **Other Changes**
    * Removed `Log#removeLogger` method in favor of deferred binding properties
    * Updated JDK 1.4 `gwt-log` logger to be configured with a `ConsoleHandler` at the `ALL` level as the JDK implementation default is `SEVERE` and would unexpectedly hide debug/info/warn messages
    * Various minor implementation changes




----
# What's new in `gwt-log-1.5.1.jar` #
  * **New Functionality**
    * Serializable classes (domain objects, POJOs, etc.) can utilize the same logging code on client and server via inclusion of a single, common, `gwt-log` jar on both tiers
    * Server side logging automatically detects Apache [log4j](http://logging.apache.org/log4j/), falling back to [JDK 1.4 logging](http://java.sun.com/j2se/1.4.2/docs/guide/util/logging/overview.html)

  * **Other Changes**
    * Removed ability to extend existing log levels for reduced complexity; please file an issue if you absolutely must have this ability
    * Class `LoggerSystem` renamed to `SystemLogger` for consistency
    * Public `Logger#log` changed accessibility to package default
    * Updated project and ant build file




----
# What's new in `gwt-log-1.4.5.jar` #

  * **Bug Fixes**
    * [Issue 6](https://github.com/fredsa/gwt-log/issues/6) `Throwable` with `null` message, e.g. `throw new NullPointerException()`, would fail to get logged; instead an exception would be logged in the hosted mode tree logger regarding the gwt-log failure. Thanks dwyah!




----
# What's new in `gwt-log-1.4.4.jar` #

  * **Changes in this version**
    * `DivLogger` text area now resizes itself with the browser window to roughly 80% of the client window width and 20% of the height, but always at least `300px` x `100px`. To set an explicit size in your application use something like:

        ```CSS
        .log-panel .log-scroll-panel {
          width: 800px !important;
          height: 150px !important;
        }
        ```

    * Hovering over log messages and stack traces shows a tool tip with the most essential portion of the error message, which should greatly reduce the amount of scrolling required in the log panel:

      ![http://gwt-log.googlecode.com/files/2008-01-20-log-panel.png](http://gwt-log.googlecode.com/files/2008-01-20-log-panel.png)

    * In the `DivLogger`, all messages, except for stack traces, wrap, rather than scroll off the right hand side, which again, this should reduce the amount of log panel scrolling
    * `Logger#removeLogger` is now static. Thanks steven.marcus!
    * ant build file, checkstyle and other Eclipse project changes





----
# What's new in `gwt-log-1.4.3.jar` #

  * **Changes in this version**
    * Compile time `log_level` parameter is now set to a single value (`OFF`) by default instead of generating all six (`DEBUG`, `INFO`, `WARN`, `ERROR`, `FATAL`, `OFF`) deferred binding combinations.
      * Additional compile time values can of course be added via `extend-property`, typically:

        ```XML
        <extend-property name="log_level" values="DEBUG,OFF"/>
        ```

      * The default value may be overridden via `set-property`, typically:

        ```XML
        <set-property name='log_level' value='DEBUG'/>
        ```

      * See [gwt-log.gwt.xml](https://github.com/fredsa/gwt-log/tree/master/Log/src/com/allen_sauer/gwt/log/gwt-log.gwt.xml) for additional documentation on how to control the compile time and runtime log levels of your application.




----
# What's new in `gwt-log-1.4.1.jar` #

  * **Changes in this version**
    * Implemented deferred binding to allow for client and library related logging code to be compiled out by the GWT Compiler dead code elimination when `log_level=OFF`.
    * Changed module name from `com.allen_sauer.gwt.log.Log` to `com.allen_sauer.gwt.log.gwt-log`.
    * Please see the updated [GettingStarted](https://github.com/fredsa/gwt-log/blob/wiki/GettingStarted.md) wiki for additional details.




----
# What's new in `gwt-log-1.3.1.jar` #

  * Release 1.3.1 is not new. It's old :).



----
