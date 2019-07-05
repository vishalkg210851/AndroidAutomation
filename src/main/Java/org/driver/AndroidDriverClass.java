package org.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.config.deviceconfig;
import org.config.AndroidDeviceModel;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverClass extends deviceconfig{

    private static AppiumDriver driver;
    Logger log = Logger.getLogger("testinfolog");

    public AppiumDriver setupDriver(String model) throws IOException {
        log.info("Inside AndroidDriver Class");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        log.info("Dlogs: " + model);
            AndroidDeviceModel device = readAndroidDeviceConfig().getAndroidDevice();
            capabilities.setCapability(MobileCapabilityType.VERSION, device.getPlatformVersion());
            capabilities.setCapability("deviceName",device.getDeviceName());
            capabilities.setCapability("platformName", device.getPlatformName());
            capabilities.setCapability("appPackage",device.getPackageName());
            capabilities.setCapability("version",device.getPlatformVersion());
            capabilities.setCapability("noReset","true");
            capabilities.setCapability("appActivity",device.getActivity());
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;
    }
}