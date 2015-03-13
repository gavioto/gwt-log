# Table of Contents #


# GWT Compatibility #

Please make sure your you GWT and gwt-log versions are compatible.

| **If you are using GWT version...** | **Then use gwt-log version...** |
|:------------------------------------|:--------------------------------|
| [GWT 2.6.1](http://code.google.com/p/google-web-toolkit/downloads/list) or newer | [gwt-log-3.3.2.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.6.0](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.3.0.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.5.0](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.2.1.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.4.0](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.1.8.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.3.0](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.1.3.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.2.0](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.1.2.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.1.1](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.0.4.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.1.0](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.0.4.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.0.4](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.0.4.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 2.0.0](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-3.0.1.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.7.0](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-2.6.2.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.6.4](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-2.6.2.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.5.3](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-2.5.2.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.5.2](http://code.google.com/p/google-web-toolkit/downloads/list) | [gwt-log-2.5.2.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.5.1](http://code.google.com/p/google-web-toolkit/downloads/list) (1.5 RC2) | [gwt-log-2.5.2.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.5.0](http://code.google.com/p/google-web-toolkit/downloads/list) (1.5 RC1) | [gwt-log-2.5.2.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.4.62](http://code.google.com/p/google-web-toolkit/downloads/list) (1.4 update 2) | [gwt-log-1.5.6.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.4.61](http://code.google.com/p/google-web-toolkit/downloads/list) (1.4 update) | [gwt-log-1.5.6.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |
| [GWT 1.4.60](http://code.google.com/p/google-web-toolkit/downloads/list) (1.4) | [gwt-log-1.5.6.jar](https://code.google.com/p/gwt-log/wiki/Downloads) |


# Working examples #
Try the [logging demo](http://allen-sauer.com/com.allen_sauer.gwt.log.demo.LogDemo/LogDemo.html):
> [![](http://gwt-log.googlecode.com/files/2008-10-28-log-panel-click-here.png)](http://allen-sauer.com/com.allen_sauer.gwt.log.demo.LogDemo/LogDemo.html)


# Adding gwt-log to an (Eclipse) GWT Project #

  1. Download the latest [gwt-log-&lt;version&gt;.jar](https://code.google.com/p/gwt-log/wiki/Downloads) and place it in a convenient location.
    * Note for Maven users: Releases are also available in [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ccom.allen-sauer.gwt.log) with groupId `com.allen-sauer.gwt.log` and artifact `gwt-log`.
  1. Create a GWT Eclipse project as instructed here: http://code.google.com/webtoolkit/usingeclipse.html#creating
  1. Add the gwt-log jar to your project via one of these two methods:
    * Right-click on the project node in the Package Explorer and select 'Build Path > Add External Archives...'. Then, specify the location of the `gwt-log-<version>.jar` file.
    * Copy the `gwt-log-<version>.jar` file into your project's `war/WEB-INF/lib` directory. Then, in the Project Explorer view, right click the jar file and select 'Build Path > Add to Build Path'
  1. Make sure the GWT compiler can find the gwt-log source code. Modify your `*.gwt.xml` module to include one of the following, depending on your needs:
```
  <!-- For production, most teams prefer to set the default log level to `OFF` -->
  <inherits name="com.allen_sauer.gwt.log.gwt-log-OFF" />

  <!-- For development, a default of `DEBUG` is recommended -->
  <inherits name="com.allen_sauer.gwt.log.gwt-log-DEBUG" />

  <!-- To compile at `DEBUG`, `WARN` and `OFF` log levels (with a 3x compile time cost) -->
  <inherits name="com.allen_sauer.gwt.log.gwt-log-OFF" />
  <extend-property name="log_level" values="DEBUG,WARN"/>

  <!-- 
     Default to `OFF`, but allow selection of a specific log level,
     say `INFO`, via the `log_level` URL parameter:
     http[s]://hostame:port/yourmodule/Yourmodule.html?log_level=INFO
  -->
  <inherits name="com.allen_sauer.gwt.log.gwt-log-OFF" />
  <extend-property name="log_level" values="INFO"/>

  <!-- 
     Compile both `DEBUG` and `ERROR` log levels, with level
     selection via a `gwt:property` meta tag in your HTML page:
       <head>
         <title>....</title>
         <meta name="gwt:property" content="log_level=DEBUG">
       </head>
  -->
  <inherits name="com.allen_sauer.gwt.log.gwt-log-ERROR" />
  <extend-property name="log_level" values="DEBUG"/>
```
  1. (Optional) if you want to play with the demo (examples), you'll need to grab those from the [Subversion trunk demo directory](http://gwt-log.googlecode.com/svn/trunk/DragDrop/demo/) as there is no jar file for the demos (i.e. the `com.allen_sauer.gwt.log.demo` package). See the [Using Source with Eclipse](http://code.google.com/p/gwt-log/wiki/UsingSourceWithEclipse) wiki for more details.



# An Introductory Example #
  1. Use this code in your `EntryPoint` class:
```
package com.mycompany.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

import com.allen_sauer.gwt.log.client.Log;

/**
 * Illustrative example.
 */
public class MyApplication implements EntryPoint {
  /**
   * This field gets compiled out when <code>log_level=OFF</code>, or any <code>log_level</code>
   * higher than <code>DEBUG</code>.
   */
  private long startTimeMillis;

  /**
   * Note, we defer all application initialization code to {@link #onModuleLoad2()} so that the
   * UncaughtExceptionHandler can catch any unexpected exceptions.
   */
  @Override
  public void onModuleLoad() {
    /*
     * Install an UncaughtExceptionHandler which will produce <code>FATAL</code> log messages
     */
    Log.setUncaughtExceptionHandler();

    // use deferred command to catch initialization exceptions in onModuleLoad2
    Scheduler.get().scheduleDeferred(new ScheduledCommand() {
      @Override
      public void execute() {
        onModuleLoad2();
      }
    });
  }

  /**
   * Deferred initialization method, used by {@link #onModuleLoad()}.
   */
  private void onModuleLoad2() {
    /*
     * Use a <code>if (Log.isDebugEnabled()) {...}</code> guard to ensure that
     * <code>System.currentTimeMillis()</code> is compiled out when <code>log_level=OFF</code>, or
     * any <code>log_level</code> higher than <code>DEBUG</code>.
     */
    if (Log.isDebugEnabled()) {
      startTimeMillis = System.currentTimeMillis();
    }

    /*
     * No guards necessary. Code will be compiled out when <code>log_level=OFF</code>
     */
    Log.debug("This is a 'DEBUG' test message");
    Log.info("This is a 'INFO' test message");
    Log.warn("This is a 'WARN' test message");
    Log.error("This is a 'ERROR' test message");
    Log.fatal("This is a 'FATAL' test message");

    Log.fatal("This is what an exception might look like", new RuntimeException("2 + 2 = 5"));

    Log.debug("foo.bar.baz", "Using logging categories", (Exception) null);

    /*
     * Again, we need a guard here, otherwise <code>log_level=OFF</code> would still produce the
     * following useless JavaScript: <pre> var durationSeconds, endTimeMillis; endTimeMillis =
     * currentTimeMillis_0(); durationSeconds = (endTimeMillis - this$static.startTimeMillis) /
     * 1000.0; </pre>
     */
    if (Log.isDebugEnabled()) {
      long endTimeMillis = System.currentTimeMillis();
      float durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
      Log.debug("Duration: " + durationSeconds + " seconds");
    }
  }
}
```



# Other things you might want to do #

## Dynamically adjust the runtime log level ##
```
  Log.setCurrentLogLevel(Log.LOG_LEVEL_...);
```

## Get the floating `DivLogger` out of your way ##
Disable the `DivLogger`:
```
  <set-property name="log_DivLogger" value="DISABLED" />
```
Or place it at a fixed location in your appliation:
```
  Widget divLogger = Log.getLogger(DivLogger.class).getWidget();
  someWidgetOfYours.add(divLogger);
```

## Enable the remote logging option (disabled by default) ##
Enabling the remote logging option sends copies of all client log messages to the server where it can be written to a file. This is particularly useful for mobile development.
Modify your module file:
```
  <!-- In gwt-log-3.0.3 or later -->
  <inherits name="com.allen_sauer.gwt.log.gwt-log-RemoteLogger" />

  <!-- In gwt-log-3.0.2 or earlier releases only, use this instead -->
  <set-property name="log_RemoteLogger" value="ENABLED" />
```
To deploy the `RemoteLogger` to your own web server:
  * Compile your application with `-deploy war/WEB-INF/deploy/`, so that the GWT compiler produces symbol maps, which gwt-log can use for deobfuscation of stack traces
  * Include the remote logger servlet in your `web.xml` deployment descriptor:
```
<servlet>

  <servlet-name>gwt-log-remote-logger-servlet</servlet-name>
  <servlet-class>com.allen_sauer.gwt.log.server.RemoteLoggerServlet</servlet-class>

  <!--
     These symbol maps parameters specify the server location where the GWT
     compiler symbol maps are stored, which is used for stack trace deobfuscation:

     - 'symbolMapsFileSystem' uses StackTraceDeobfuscator#fromFileSystem(String)
     - 'symbolMapsResourcePath' uses StackTraceDeobfuscator#fromResource(String)
     - "symbolMapsResourceUrl' uses StackTraceDeobfuscator#fromResource(String)
  -->
  <init-param>
    <!-- This value assumes a GWT compile with '-deploy war/WEB-INF/deploy/' -->
    <param-name>symbolMapsFileSystem</param-name>
    <!--
       Modify the param-value based on your server environment. Some web servers
       use your `war` directory as the 'current working dir', while other
       vendors will do something different. You may use trial and error. Specify the
       relative path you think should work, then check the server log after forwarding
       the first client log message to the server. If the directory cannot be found,
       gwt-log will report the full path which it tried.
     -->
    <param-value>WEB-INF/deploy/your-module-name/symbolMaps/</param-value>
  </init-param>

  <!--
     Additional or alternate locations may be specified via additional parameters
     which also begin with one of the symbol maps prefixes ('symbolMapsFileSystem',
     'symbolMapsResourcePath' or 'symbolMapsResourceUrl'). This may be useful
     if you deploy to multiple server environments which use different locations or
     have a different notion of what the 'current working directory' is.
  -->
  <init-param>
    <param-name>symbolMapsFileSystem_2</param-name>
    <param-value>some/alternate/path/to/try/your-module-name/symbolMaps/</param-value>
  </init-param>

  <!-- Optionally enable CORS (http://www.w3.org/TR/cors/) -->
  <!--
  <init-param>
    <param-name>Access-Control-Allow-Origin</param-name>
    <param-value>http://your-applications-origin</param-value>
  </init-param> 
  -->
</servlet>

<servlet-mapping>
  <servlet-name>gwt-log-remote-logger-servlet</servlet-name>
  <url-pattern>/your-module-name/gwt-log</url-pattern>
</servlet-mapping>
```
  * Don't forget to include `gwt-log-x.x.x.jar` in the server classpath, which usually means dropping the jar file into `war/WEB-INF/lib/`. In Eclipse, also right click on the jar and select `Build Path -> Add to Build Path`.
  * If you're using `java.util.logging` (the default), you can [configure Java Logging](http://java.sun.com/j2se/1.4.2/docs/guide/util/logging/overview.html#2.2).
    * The default JDK logging level is `INFO`, i.e. in `java.util.logging` terms, `FINEST`, `FINER`, `FINE`, `CONFIG` are ignored and only `INFO`, `WARNING`, `SEVERE` are logged. See `JDK_HOME/jre/lib/logging.properties`.
    * The default JDK logging level can be set in your `logging.properties` file:
```
# Set the default for all loggers to log everything
.level = ALL
```
  * If you prefer to use `log4j, you may also optionally drop a `log4j` jar file on the server side classpath (again, usually `war/WEB-INF/lib/`), in which case gwt-log will use log4j logging instead of `java.util.logging` based logging
    * The default log4j logging level is `DEBUG`, i.e. `TRACE` messages are ignored while `DEBUG`, `INFO`, `WARN`, `ERROR`, `FATAL` are logged. This can be controlled via `log4j.xml` or `log4j.properties`.
    * Note: on Google App Engine, log4j uses JDK logging, even when a log4j jar is present on the server classpath. This provides for better integration with the App Engine admin console.

## Turn on the experimental `WindowLogger` ##
The experimental `WindowLogger` (disabled by default), can log messages to a separate window, so that logging does not affect the DOM in your application.
```
  <!--
    Enable experimental WindowLogger, which logs messages to a separate
    popup window. There are currently a couple of restrictions:

    1. When Firefox is configured to open new Windows as new tabs,
        WindowLogger does not work
    2. In GWT Development Mode, the windows are not automatically closed,
        although you can easily close them manually in the usual way
  -->
  <set-property name="log_WindowLogger" value="ENABLED" />

  <!--
    You'll probably want to disable the default `DivLogger` as well:
  -->
  <set-property name="log_DivLogger" value="DISABLED" />
```

## Control which loggers are active ##
```
  <!-- Loggers Enabled by default -->
  <set-property name="log_ConsoleLogger" value="ENABLED" />
  <set-property name="log_DivLogger" value="ENABLED" />
  <set-property name="log_GWTLogger" value="ENABLED" />
  <set-property name="log_SystemLogger" value="ENABLED" />
  
  <!-- Loggers Disabled by default -->
  <set-property name="log_WindowLogger" value="DISABLED" />

  <!-- In gwt-log-3.0.3 or later, enable RemoteLogger with -->
  <inherits name="com.allen_sauer.gwt.log.gwt-log-RemoteLogger" />
```


## Control the format of your log messages ##

### Client side log messages ###
In your `.gwt.xml` specify a `log_pattern`:
```
  <!--
    Inspired by Apache log4j PatternLayout:
    http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
  -->
  <set-configuration-property name="log_pattern" value="(%F:%L) %d [%-5p] %m%n" />
```

### Server side log messages ###
In your `log4j.xml` specify a `ConversionPattern`. Two special values are provided:

| **`ConversionPattern` parameter** | **Description** |
|:----------------------------------|:----------------|
| `%X{remoteAddr}` | The IP address of the client logging the request |
| `%X{X-Forwarded-For}` | The non-standard [X-Forwarded-For](http://en.wikipedia.org/wiki/X-Forwarded-For) HTTP header used by some proxies |

For example:
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

  <appender name="CONSOLE" class="org.apache.log4j.ConsoleAppender">
    <param name="Target" value="System.out" />
    <param name="Threshold" value="DEBUG" />
    <layout class="org.apache.log4j.PatternLayout">
      <param name="ConversionPattern"
             value="%d{ISO8601} [%-5p][%c{1}][%X{remoteAddr} %X{X-Forwarded-For} %X{logSequence}] %m%n" />
    </layout>
  </appender>

  <root>
    <priority value="trace" />
    <appender-ref ref="CONSOLE" />
  </root>

</log4j:configuration>
```

## Adjust the `z-index` of the `DivLogger` panel ##
  * Review the [gwt-log.css](http://code.google.com/p/gwt-log/source/browse/trunk/Log/src/com/allen_sauer/gwt/log/client/impl/gwt-log.css) file to see the CSS which is injected into your application by gwt-log.
  * Override the `z-index` (using `!important` if necessary) by adding a new rule to your application's CSS:
```
  .log-panel {
    z-index: 2000;
  }
```
or:
```
  .log-panel {
    z-index: 2000 !important;
  }
```

## Override the default URL which the `RemoteLogger` connects to ##
The default `RemoteLogger` URL can be set via the `log_url` property:
```
  <set-configuration-property name="log_url" value="/my-custom-servlet-url" />
```
Don't forget to make a corresponding change to your `web.xml`.

## Configuring multiple `.gwt.xml` module files ##
Advanced projects may have more than one `.gwt.xml` module files which inherit from each other.

An initial module file may wish to set logging `OFF` by default:
```
  <inherits name="com.allen_sauer.gwt.log.gwt-log-OFF" />
```
A later module file may wish to override this and enable say `DEBUG` logging:
```
   <extend-property name="log_level" values="DEBUG"/>
   <set-property name="log_level" value="DEBUG"/>
```

## Setup an `UncaughtExceptionHandler` ##
Setting up an `UncaughtExceptionHandler` is as easy as calling `Log.setUncaughtExceptionHandler()` before you do anything else in your module.
```
  @Override
  public void onModuleLoad() {
    /*
     * Install an UncaughtExceptionHandler which will produce <code>FATAL</code> log messages
     */
    Log.setUncaughtExceptionHandler();

    // use deferred command to catch initialization exceptions in onModuleLoad2
    Scheduler.get().scheduleDeferred(new ScheduledCommand() {
      @Override
      public void execute() {
        onModuleLoad2();
      }
    });
  }

  private void onModuleLoad2() {
    // Your client code goes here
  }
```
Note that we use a deferred command and void any initialization code during our `EntryPoint` class loading or construction. This ensures that we really catch everything in Production Mode. In Chrome, Firefox and IE this will even catch exceptions thrown from JSNI via `setTimeout()` or `setInterval()` functions.

## Use logging categories ##
### Using categories from your code ###
The default logging category for all log messages is `gwt-log` (and _not_, say, `com.allen_sauer.gwt.log.gwt-log`).

Use the three argument logging methods to override the default logging category:
```
  Log.debug("com.foo.myproject.mycategory", "2 + 2 = 5, for large values of two", exception);
```
### Client side category logging ###
Include a category specifier `%c` in your `log_pattern`:
```
  <set-configuration-property name="log_pattern" value="[%c] (%F:%L) %d [%-5p] %m%n" />
```
#### Server side category logging, when using `java.util.logging` (which is the default) ####
You'll need to modify the default `java.util.logging.Formatter`:
```
package myapp.server;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {

  private Formatter formatter = new Formatter() {
    @Override
    public String format(LogRecord record) {
      return "(" + record.getLoggerName() + ") " + super.formatMessage(record);
    }
  };

  @Override
  public void contextDestroyed(ServletContextEvent evt) {
    // do nothing
  }

  @Override
  public void contextInitialized(ServletContextEvent evt) {
    Logger rootLogger = Logger.getLogger("");

    // crude replacement of existing formatters
    for (Handler handler : rootLogger.getHandlers()) {
      handler.setFormatter(formatter);
    }
  }
}
```
Modify your `WEB-INF/web.xml` to ensure your changes are installed when your application starts:
```
  <listener>
    <listener-class>logcat.server.MyContextListener</listener-class>
  </listener>
```
### Server side category logging, when using log4j ###
Use the standard log4j methods to configure a
[PatternLayout](http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html). This commonly done via a `log4j.properties` or `log4j.xml` file.


# Get more our of gwt-log #
  1. Add logging to your serializable domain objects, POJOs, etc. for both client and server side logging
  1. In development you likely want to use `-style PRETTY` rather than the default `-style OBFUSCATED` in order to get better Production Mode stack trace methods.
  1. When developing, you may wish to turn on enhanced Production Mode stack traces. Note this adds overhead to the resulting JavaScript so you generally don't want to leave this on for production. Then again, if you're debugging a production issue, you might need to anyway :)
```
  <set-property name="compiler.emulatedStack" value="true" />
  <set-configuration-property name="compiler.emulatedStack.recordLineNumbers" value="true"/>
  <set-configuration-property name="compiler.emulatedStack.recordFileNames" value="true"/>
```
  1. Use gwt-log seamlessly on [Google App Engine](http://code.google.com/appengine)
    * Modify your `logging.properties` file:
```
  .level = FINEST
```
| ![http://gwt-log.googlecode.com/files/2009-04-15-gwt-log-RemoteLogger-App-Engine.png](http://gwt-log.googlecode.com/files/2009-04-15-gwt-log-RemoteLogger-App-Engine.png) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|