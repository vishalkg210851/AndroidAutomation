package org.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.config.deviceconfig;
import org.config.AndroidDeviceModel;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverClass extends deviceconfig{

    AndroidDriver driver;

    public AndroidDriver setupDriver(String model) throws Exception {
        System.out.println("Inside Before Class");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        AndroidDeviceModel device = readAndroidDeviceConfig().getAndroidDeviceByName(model);

        capabilities.setCapability(MobileCapabilityType.VERSION, device.getPlatformVersion());
        capabilities.setCapability("deviceName",device.getDeviceName());
        capabilities.setCapability("platformName", device.getPlatformName());
        capabilities.setCapability("appPackage",device.getPackageName());
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("appActivity",device.getActivity());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }


}
