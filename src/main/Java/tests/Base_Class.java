package tests;
import io.appium.java_client.android.AndroidDriver;
import org.driver.AndroidDriverClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import static org.utils.LoggingManager.logMessage;


public class Base_Class {

    AndroidDriver driver;


    @Parameters({"platformType", "platformName", "model"})
    @BeforeMethod
    public void setupDriver(String platformType, String platformName, @Optional String model) throws Exception {
        if (platformType.equalsIgnoreCase("Android")) {
            setupMobileDriver(platformName, model);
        }
    }

    public void setupMobileDriver(String platformName, String model) throws Exception {
        if (platformName.equalsIgnoreCase("Mobile")) {
            driver = new AndroidDriverClass().setupDriver(model);
        }
        logMessage(model + " driver has been created for execution");
    }


    @AfterMethod
    public void teardownDriver() {
        driver.quit();
    }

}