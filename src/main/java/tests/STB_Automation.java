package tests;
import org.pages.HomePage;
import org.testng.annotations.Test;

public class STB_Automation extends Base_Class {

    @Test(description = "testing HomePage")
    public void TestHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.scrolltoend();
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













