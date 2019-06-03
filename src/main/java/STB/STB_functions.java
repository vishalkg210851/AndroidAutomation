package STB;

import Interface.Dependencies;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.debugger.cdbg.BaseClass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Helpers;

import org.openqa.selenium.support.ui.ExpectedConditions;



public class STB_functions implements Dependencies {

    WebDriver driver ;
    boolean flag = true;
    Integer diffcount = Integer.MAX_VALUE;



   /* @FindBy(id = "com.airtel.tv:id/homeTab")
    WebElement Home;

    @FindBy(id = "'com.airtel.tv:id/add_banner_img_view'|com.airtel.tv:id/bannerImage")
    WebElement banner;

    @FindBy(id = "com.airtel.tv:id/subSectionTitleView")
    WebElement subSectionTitle;

    public STB_functions(WebDriver driver) throws InterruptedException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }*/


        public STB_functions(AndroidDriver driver){

            this.driver = driver;
        }

        public void test(String key) {
            try {
                Runtime.getRuntime().exec(key);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


  /*  public void scrollVertical(AndroidDriver driver) throws InterruptedException {

        boolean flag = true;
        String  HomepageID = "5b4c82f8abbba8a60dcd384b";
        Object[] objtomatch = Helpers.getPagelayout(HomepageID);
        String stringtomatch = objtomatch[0].toString();
        int size = Integer.parseInt(objtomatch[1].toString());
        System.out.println("str:- " + stringtomatch);
        System.out.println("str:- " + size);
        int i = 0;

        while (flag) {

            WebElement subSectionTitleView = driver.findElementById("com.airtel.tv:id/subSectionTitleView");
            String title = subSectionTitleView.getText().trim();
            System.out.println("Last Title:- " + stringtomatch);
            System.out.println(+i+ ".Current Title:- " + title);
            System.out.println("index:- " + size);

//            if (i<=size){
            if(!title.contentEquals(stringtomatch)){
                System.out.println("Last not reached");
                System.out.println("SIZE"+i);
                scrolltoend(driver);
                test(DOWN_key);
                ++i;
            }
            else {
                scrolltoend(driver);
                flag=false;
                System.out.println("Reached to end");
                break;
            }
        }
    }*/
//    ---------------new code-------------
    public void scrollVertical(AndroidDriver driver) throws InterruptedException {

        boolean flag = true;
        String HomepageID = "5b4c82f8abbba8a60dcd384b";
        String title = Helpers.getPagelayout(HomepageID);
        System.out.println("Last Title:- " + title);
        int counter = 1;


        while (flag) {
            try {

            WebDriverWait wait=new WebDriverWait(driver,90);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.airtel.tv:id/subSectionTitleView")));
            WebElement subSectionTitleView = driver.findElementById("com.airtel.tv:id/subSectionTitleView");
            String str = subSectionTitleView.getText().trim();
            System.out.println("Current Title"   +str);
            System.out.println("Last Title"   +title);

            if (!str.contentEquals(title)) {
                    scrolltoend(driver);
                    test(DOWN_key);
                    System.out.println("Down key pressed");
                } else{
                    flag = false;
                    scrolltoend(driver);
                    break;
                }

            }
        catch(Exception e) {
            e.printStackTrace();
        }
        }


        }


    public void scrolltoend(AndroidDriver driver) throws InterruptedException {

        boolean flag = true;
        Integer diffcount_horizontal = Integer.MAX_VALUE;

        while (diffcount_horizontal > 0) {
            Set<String> set_a = new HashSet<String>();
            try {
                List<WebElement> Title = driver.findElementsById("com.airtel.tv:id/subSectionTitleView");

                Boolean title_is_displayed = Title.get(0).isDisplayed();

                if (title_is_displayed) {
                    System.out.println("DLogs " + Title.get(0).getText().toString());

                    List<WebElement> List1 = driver.findElementsById("com.airtel.tv:id/titleView");
                    int l1 = List1.size();
                    System.out.println("Movies Present in first set =" + List1.size());
                    for (int i = 0; i < l1; i++) {
                        String s1 = List1.get(i).getText();
                        System.out.println(s1);
                        set_a.add(s1);
                        if (flag = true) {
                            WebElement row = driver.findElementByXPath("//android.widget.RelativeLayout[@index='0']");
                            if (row.isDisplayed()) {
                                test(Right_Key);
                            }
                            flag = false;
                        }
                    }
                }
            } catch (Exception e) {
                test(DOWN_key);
               test(DOWN_key);

            }
            Set<String> set_b = new HashSet<String>();
            List<WebElement> List2 = driver.findElementsById("com.airtel.tv:id/titleView");
            int l2 = List2.size();
            System.out.println("Movies Present in Second set =" + List2.size());
            for (int j = 0; j < l2; j++) {
                String s2 = List2.get(j).getText();
                set_b.add(s2);
                System.out.println(s2);
            }
            Set<String> diff = new HashSet<String>(set_a);
            diff.removeAll(set_b);
            diffcount_horizontal = diff.size();
            System.out.println("Difference is : " + diff.size());
            System.out.println(diff);
            System.out.println("SetA:" + set_a);
            System.out.println("SetB:" + set_b);

            for (int k = 0; k <= (diffcount_horizontal + set_a.size() + set_b.size()); k++) {
                test(Right_Key);
                set_a.clear();
                set_b.clear();
            }
        }
        System.out.println("Reached End ! Success");

    }


    public void ContentDesc(AndroidDriver driver) throws InterruptedException {

        try {
            Thread.sleep(5000);
            WebElement ContentClick = driver.findElementById("com.airtel.tv:id/titleView");
            ContentClick.getText();
            ContentClick.click();
            Thread.sleep(5000);
            WebDriverWait wait_desc=new WebDriverWait(driver,90);
            wait_desc.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.airtel.tv:id/tvDescription")));
            WebElement Movie_Title = driver.findElementByXPath("//android.widget.TextView[@index='0']");
            if(Movie_Title.isDisplayed()){
                Movie_Title.getText();
                System.out.println("Displayed Movie Title:-" + Movie_Title);
            }
            Thread.sleep(5000);
            test(Back);
            Thread.sleep(5000);
            test(Up_Key);
        } catch (Exception e) {
            e.printStackTrace();
            test(Back);
        }
    }
}