package tests;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import org.driver.AndroidDriverClass;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;
//import static org.utils.LoggingManager.logMessage;


public class Base_Class {

    public AndroidDriver driver;
    private Logger log = LoggerFactory.getLogger(this.getClass());

//    @BeforeSuite
//    public void browse() throws IOException, InterruptedException
//    {
//        Runtime.getRuntime().exec("cmd /c start C:\\appiumstart.sh");
//        Thread.sleep(7000L);
//    }

    @Parameters({"platformType", "platformName", "model"})
    @BeforeMethod
    public void setupDriver(String platformType, String platformName, @Optional String model) throws Exception {
          log.info("finding the platform type");
        if (platformType.equalsIgnoreCase("Android")) {
            log.info("Setting up the Android Driver");
            setupMobileDriver(platformName, model);
        }
    }

    public void setupMobileDriver(String platformName, String model) throws Exception {
        if (platformName.equalsIgnoreCase("Mobile")) {
            log.info("Setting up the Mobile Driver");
            driver = new AndroidDriverClass().setupDriver(model);
        }
        log.info(model+"driver has been created for execution");
        //logMessage(model + " driver has been created for execution");
    }


    @AfterMethod
    public void teardownDriver() {
        driver.quit();
    }

    public AndroidDriver getDriver() {
        return driver;

}
}