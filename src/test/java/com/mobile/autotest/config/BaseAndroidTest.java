/*
 * package com.mobile.autotest.config;
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.io.IOException; import java.io.InputStream; import java.util.Properties;
 * 
 * import org.openqa.selenium.remote.DesiredCapabilities;
 * 
 * import cucumber.api.java.After; import cucumber.api.java.Before; import
 * io.appium.java_client.android.AndroidDriver; import
 * io.appium.java_client.android.AndroidElement; import
 * io.appium.java_client.remote.AndroidMobileCapabilityType; import
 * io.appium.java_client.remote.AutomationName; import
 * io.appium.java_client.remote.MobileCapabilityType; import
 * io.appium.java_client.service.local.AppiumDriverLocalService; import
 * io.appium.java_client.service.local.
 * AppiumServerHasNotBeenStartedLocallyException;
 * 
 * public class BaseAndroidTest {
 * 
 * public static final String APP_ID = "io.appium.android.apis"; private static
 * AppiumDriverLocalService service; protected static
 * AndroidDriver<AndroidElement> driver; private final String CONFIG_FILE_PATH =
 * "src\\test\\resources\\testData\\config.properties"; protected static
 * Properties configProp;
 * 
 * 
 * Start Appium Server Programmatically before each scenario
 * 
 * @Before public void startServer() {
 * 
 * service = AppiumDriverLocalService.buildDefaultService(); service.start();
 * 
 * if (service == null || !service.isRunning()) { throw new
 * AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!"
 * ); } // Load Config Property File loadTestData();
 * 
 * File appDir = new File(configProp.getProperty("app.path")); File app = new
 * File(appDir, configProp.getProperty("apk.file")); DesiredCapabilities
 * capabilities = new DesiredCapabilities();
 * capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
 * AutomationName.ANDROID_UIAUTOMATOR2);
 * capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
 * configProp.getProperty("device.name"));
 * capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
 * capabilities.setCapability("eventTimings", true);
 * 
 * capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
 * configProp.getProperty("app.package"));
 * capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
 * configProp.getProperty("app.activity"));
 * 
 * // System.out.println("service.getUrl() >>>>>>>>>>>>" + service.getUrl());
 * 
 * driver = new AndroidDriver<>(service.getUrl(), capabilities); }
 * 
 * 
 * Stop Appium Server Programmatically before each scenario
 * 
 * @After public static void afterClass() { if (driver != null) { driver.quit();
 * } if (service != null) { service.stop(); } }
 * 
 * public AndroidDriver getDriver() { return driver; }
 * 
 * public AppiumDriverLocalService getService() { return service; }
 * 
 * public void loadTestData() { try (InputStream input = new
 * FileInputStream(CONFIG_FILE_PATH)) { configProp = new Properties(); // load a
 * properties file configProp.load(input);
 * System.out.println("configProp.getProperty(\"app.path\") :" +
 * configProp.getProperty("app.path")); } catch (IOException ex) {
 * ex.printStackTrace(); } }
 * 
 * public Properties getProperties() { return configProp; }
 * 
 * }
 */