package tests;
import io.appium.java_client.android.AndroidDriver;
import org.driver.AndroidDriverClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base_Class {

    AndroidDriver driver;

    @BeforeMethod
    public void setupMobileDriver() throws Exception {
        driver = new AndroidDriverClass().setUp();

    }

    @AfterMethod
    public void teardownDriver() {
        driver.quit();
    }

}