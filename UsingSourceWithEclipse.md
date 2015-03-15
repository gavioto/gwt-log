# Prerequisites #
  1. Get the latest [Eclipse IDE for Java EE Developers](http://www.eclipse.org/downloads/) release supported by the [Google Plugin for Eclipse](https://developers.google.com/eclipse).
  1. Install the [Google Plugin for Eclipse](https://developers.google.com/eclipse)
  1. Use the Google Plugin for Eclipse to download the GWT SDK for you by following the appropriate [instructions](https://developers.google.com/eclipse/docs/getting_started.html).
  1. Install [EGit](http://www.eclipse.org/egit/download/) for Eclipse

# Checking out gwt-log using EGit #
  1. Checkout the code
    1. **File > Import > Git > Projects from Git > Clone...**
    1. Set the URI to `https://github.com/fredsa/gwt-log` which will give you the source code for the gwt-log library, the source code for the demo (examples), the getting-started launch configuration and the Eclipse project. Click **Next**.
    1. Specify the `master` branch. Click **Next**.
    1. Optionally, consider setting the **Directory** to `/path/to/your/workspace/gwt-log`, so that your imported project working tree is checked out inside the git clone.
    1. Click **Finish**. Then select the `gwt-log` clone you just created. Click **Next**.
    1. Select the `Log` folder. Click **Finish**.
  1. If you have the Checkstyle plugin, right-click on the `Log` project, select **Properties > Checkstyle**, uncheck **Checkstyle active for this project**, click **OK**.
  1. Navigate to the Eclipse **Problems** view. Right click on one of the SDK Jar errors and select **Quick Fix**. Choose the default fix. Repeat the Quick Fix for the remaining SDK Jar error. The project should now build correctly.

# Building a distribution #
  1. Change to the `Log` directory
  1. Build the code using Apache Ant by typing `ant`
  1. Provide values for the prompted filenames and directory names

# Project Layout #

|  **Directory** | **Description** |
|:---------------|:----------------|
| `src/`       | Library source code. |
| `demo/`      | Log demo as seen [here](http://allen-sauer.com/com.allen_sauer.gwt.log.demo.LogDemo/LogDemo.html). |
| `getting-started/`   | The sample application from the [GettingStarted wiki](https://github.com/fredsa/gwt-log/blob/wiki/GettingStarted.md). |
| `test/`      | Skeleton launch configuration for quick testing. |
| `build/`     | ant build output |
| `war/`       | Web resrouces |
| `eclipse/`   | Eclipse based resources |
