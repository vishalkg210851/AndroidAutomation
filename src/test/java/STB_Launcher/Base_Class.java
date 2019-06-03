package STB_Launcher;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import utils.Helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Base_Class {

//    AndroidDriver dr;
    AndroidDriver driver;

    protected HomePage home;

    /**
     * wait wraps utils.Helpers.wait *
     */
//    public static WebElement wait(By locator) {
//        return Helpers.wait(locator);
//    }

    /**
     * Keep the same date prefix to identify job sets. *
     */
    private static final Date date = new Date();


    /**
     * Run before each test *
     */

    public AndroidDriver setUp() throws Exception {
        System.out.println("Inside Before Class");
        home = new HomePage();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
        capabilities.setCapability("deviceName", "STB");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.airtel.tv");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("appActivity", "com.airtel.tv.MainActivity");
        connecttodevice();
//        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        Helpers.init(dr);
//        return dr;
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Helpers.init(driver);
        return driver;
    }

    public void connecttodevice()throws IOException {
        String ip = "192.168.105.30:5555";
        Runtime rt = Runtime.getRuntime();
//        Process proc1 = rt.exec("adb disconnect");
        Process proc2 = rt.exec("adb connect "+ip);
        Process proc3 = rt.exec("adb devices");
        InputStream is = proc3.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if(line.contains("device")){

                System.out.println("Device connected");
            }
            else{
                tearDown(driver);
            }
        }
    }


    public void tearDown(AndroidDriver driver) {
            System.out.println("Inside After Class");
            if (driver != null) driver.quit();
    }
}