package tests;
import org.Interface.Dependencies;
import org.apache.log4j.Logger;
import org.pages.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;


public class STB_Automation extends Base_Class {
    Logger log = Logger.getLogger("testinfolog");
    HomePage homePage;

    @Test(priority = 1, description = "Testing HomePage")
    public void TestHomePage() throws IOException {
        homePage = new HomePage(driver);
        //homePage.HomePageTest();
        log.info("Home Page connected");
        new Python_Interpreter();
        Python_Interpreter.main();

    }

    @Test(priority = 2, description = "Home Page Horizontal Scrolling")
    public void TestHomePageHScroll(){
        homePage.test(Dependencies.DOWN_key);
        homePage.test(Dependencies.DOWN_key);
        homePage.HomePageHorizontalScrollTest();

    }

    @Test(priority = 3, description = "Home Page Vertical Scrolling")
    public void TestHomePageVScroll(){
        homePage.HomePageVerticalScrollTest();

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













