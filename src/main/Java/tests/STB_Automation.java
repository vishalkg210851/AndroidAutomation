package tests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.Interface.Dependencies;
import org.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import tests.Python_Interpreter;

public class STB_Automation extends Base_Class {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    HomePage homePage;

    @Test(priority = 1, description = "Testing HomePage")
    public void TestHomePage() {
        homePage = new HomePage(driver);
        homePage.HomePageTest();
        log.info("Home Page connected");
        //new Python_Interpreter();
    }

    @Test(priority = 2, description = "Home Page Scrolling")
    public void TestHomePageScroll(){
        homePage.HomePageScrollTest();


    }
}






































//    STB_functions stb = new STB_functions(driver);
//
//    @SuppressWarnings("rawtypes")
//    @Test
//    public void checkHomePage() {
////         Base_Class baseclass = new Base_Class();
//        try {
//            Thread.sleep(10000);
//            driver = setUp();
//
//            System.out.println("Inside com.java.org.STB");
//            String s = driver.currentActivity();
//            System.out.println("CUREENT ACTIVITY" +s);
//            Thread.sleep(10000);
////            Thread.sleep(5000);
//            stb.test(Right_Key);
//            WebElement tabs = driver.findElementById("com.airtel.tv:id/homeTab");
//
//            if (tabs.isSelected()) {
//                System.out.println("Home is selected");
//            }
//            WebDriverWait wait= new WebDriverWait(driver,90);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.airtel.tv:id/subSectionTitleView")));













