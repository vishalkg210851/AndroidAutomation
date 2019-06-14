package tests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class STB_Automation extends Base_Class {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test(priority =0, description = "Testing HomePage")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description:Scroll till the end of the page")
    public void TestHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        log.info("Calling the function to scroll till the end");
        homePage.HomePageScroll();
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













