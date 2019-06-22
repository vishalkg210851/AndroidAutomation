package tests;
import io.appium.java_client.AppiumDriver;
import org.Appium.AppiumServer;
import org.driver.AndroidDriverClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import java.io.IOException;
//import static org.utils.LoggingManager.logMessage;

public class Base_Class {

    public static AppiumDriver driver;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Parameters({"platformType", "platformName"})
    @BeforeTest
    public void startAppiumServer(String platformType, String platformName) throws IOException {
        if (platformType.equalsIgnoreCase("Android")) {
            killExistingAppiumProcess();
            if (AppiumServer.appium == null || !AppiumServer.appium.isRunning()) {
                AppiumServer.start();
                log.info("Appium server has been started");
            }
        }
    }

    @Parameters({"platformType", "platformName"})
    @AfterTest
    public void stopAppiumServer(String platformType, String platformName) throws IOException {
        if (platformType.equalsIgnoreCase("Android")) {
            if (AppiumServer.appium != null || AppiumServer.appium.isRunning()) {
                AppiumServer.stop();
                log.info("Appium server has been stopped");
            }
        }
    }

    @Parameters({"platformType", "platformName", "model"})
    @BeforeMethod
    public void setupDriver(String platformType, String platformName, String model) throws Exception {
          log.info("finding the platform type");
        if (platformType.equalsIgnoreCase("Android")) {
            log.info("Setting up the Android Driver");
            setupMobileDriver(platformName, model);
        }
    }

    public void setupMobileDriver(String platformName, String model) throws Exception {
        if (platformName.equalsIgnoreCase("Mobile")) {
            driver = new AndroidDriverClass().setupDriver(model);
        }
        log.info(model+"driver has been created for execution");
        //logMessage(model + " driver has been created for execution");
    }

    @AfterMethod
    public void teardownDriver() {
        log.info("Quiting driver");
//        driver.quit();
    }

    public AppiumDriver getDriver() {
        return driver;
    }
    private void killExistingAppiumProcess() throws IOException {
        Runtime.getRuntime().exec("killall node");
    }

}