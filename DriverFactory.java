package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigReader;
import java.net.URI;

public final class DriverFactory {
    private static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();

    public static void initDriver() throws Exception {
        String platform = ConfigReader.get("platform").toLowerCase();
        String app = ConfigReader.get("appPath");
        String device = ConfigReader.get("deviceName");
        String server = ConfigReader.get("serverUrl");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platform.equals("ios") ? "iOS" : "Android");
        caps.setCapability("appium:deviceName", device);
        caps.setCapability("appium:app", app);
        caps.setCapability("appium:newCommandTimeout", 120);

        if (platform.equals("ios")) {
            caps.setCapability("appium:automationName", "XCUITest");
            DRIVER.set(new IOSDriver(URI.create(server).toURL(), caps));
        } else {
            caps.setCapability("appium:automationName", "UiAutomator2");
            DRIVER.set(new AndroidDriver(URI.create(server).toURL(), caps));
        }
    }

    public static AppiumDriver getDriver() { return DRIVER.get(); }

    public static void quitDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
