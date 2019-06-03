package STB_Launcher;

import Interface.Dependencies;
import STB.STB_functions;
import com.gargoylesoftware.htmlunit.html.DomNode;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import org.openqa.selenium.JavascriptExecutor;
import utils.Helpers;


public class STB_Automation extends Base_Class implements Dependencies {
    AndroidDriver driver;
    Process p;
    List<String> arr = new ArrayList<String>();
    STB_functions stb = new STB_functions(driver);
    private boolean Flag = true;
    Boolean horizontal = false;
    Helpers helpers = new Helpers();




    @SuppressWarnings("rawtypes")


    @Test
    public void checkHomePage() {
//         Base_Class baseclass = new Base_Class();
        try {
            Thread.sleep(10000);
            driver = setUp();

            System.out.println("Inside STB");
            String s = driver.currentActivity();
            System.out.println("CUREENT ACTIVITY" +s);
            Thread.sleep(10000);
//            Thread.sleep(5000);
            stb.test(Right_Key);
            Thread.sleep(8000);
            WebElement tabs = driver.findElementById("com.airtel.tv:id/homeTab");

            String tabstring = tabs.getText();
            System.out.println(tabstring);
            System.out.println(tabs.isSelected());
            if (tabs.isSelected()) {
                System.out.println("Home is selected");
//                Thread.sleep(20000);
//                Thread.sleep(10000);
            }
            WebDriverWait wait= new WebDriverWait(driver,90);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.airtel.tv:id/subSectionTitleView")));

                stb.test(DOWN_key);
                stb.test(DOWN_key);
                Thread.sleep(5000);
//                stb.ContentDesc(driver);

//                Thread.sleep(3000);
//                stb.test(DOWN_key);
//                Thread.sleep(10000);
                System.out.println("Down key");
//                stb.ContentDesc(driver);
//                Thread.sleep(5000);




            Thread.sleep(5000);
            stb.scrollVertical(driver);
            Thread.sleep(5000);
            tearDown(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }}

//    public void scrolltoend() throws InterruptedException {
//
//        boolean flag = true;
//        Integer diffcount_horizontal = Integer.MAX_VALUE;
//
//        while (diffcount_horizontal > 0) {
//            Set<String> set_a = new HashSet<String>();
//            try {
//                List<WebElement> Title = driver.findElementsById("com.airtel.tv:id/subSectionTitleView");
//
//                Boolean title_is_displayed = Title.get(0).isDisplayed();
//
//                if (title_is_displayed) {
//                    System.out.println("DLogs " + Title.get(0).getText().toString());
//
//                    List<WebElement> List1 = driver.findElementsById("com.airtel.tv:id/titleView");
//                    int l1 = List1.size();
//                    System.out.println("Movies Present in first set =" + List1.size());
//                    for (int i = 0; i < l1; i++) {
//                        String s1 = List1.get(i).getText();
//                        System.out.println(s1);
//                        set_a.add(s1);
//                        if (flag = true) {
//                            WebElement row = driver.findElementByXPath("//android.widget.RelativeLayout[@index='0']");
//                            if (row.isDisplayed()) {
//                                stb.test(Right_Key);
//                            }
//                            flag = false;
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                stb.test(DOWN_key);
//                stb.test(DOWN_key);
//
//            }
//            Set<String> set_b = new HashSet<String>();
////            List<WebElement> List2 = dr.findElementsById("com.airtel.tv:id/titleView");
//            List<WebElement> List2 = driver.findElementsById("com.airtel.tv:id/titleView");
//            int l2 = List2.size();
//            System.out.println("Movies Present in Second set =" + List2.size());
//            for (int j = 0; j < l2; j++) {
//                String s2 = List2.get(j).getText();
//                set_b.add(s2);
//                System.out.println(s2);
//            }
//            Set<String> diff = new HashSet<String>(set_a);
//            diff.removeAll(set_b);
//            diffcount_horizontal = diff.size();
//            System.out.println("Difference is : " + diff.size());
//            System.out.println(diff);
//            System.out.println("SetA:" + set_a);
//            System.out.println("SetB:" + set_b);
//
//            for (int k = 0; k <= (diffcount_horizontal + set_a.size() + set_b.size()); k++) {
//                stb.test(Right_Key);
//            }
//        }
//        System.out.println("Reached End ! Success");
//
//    }
//
//   /* public void scrollVertical() throws InterruptedException {
//
//        boolean flag = true;
//        String HomepageID = "5b4c82f8abbba8a60dcd384b";
//        Object[] objtomatch = helpers.getPagelayout(HomepageID);
//        String stringtomatch = objtomatch[0].toString();
//        int size = Integer.parseInt(objtomatch[1].toString());
//        System.out.println("str:- " + stringtomatch);
//        System.out.println("str:- " + size);
//        int i = 0;
//
//        while (flag) {

//            WebElement subSectionTitleView = driver.findElementById("com.airtel.tv:id/subSectionTitleView");
//            String title = subSectionTitleView.getText().trim();
//            System.out.println("Last Title:- " + stringtomatch);
//            System.out.println("str:- " + title);
//            System.out.println("str:- " + size);
//
//                if (i<=size){
//                    System.out.println("Last not reached");
//                    System.out.println("SIZE"+i);
//                    scrolltoend();
//                    stb.test(DOWN_key);
//                    ++i;
//                    }
//                else {
//                    scrolltoend();
//                    flag=false;
//                    System.out.println("Reached to end");
//                    break;
//                }
//            }
//       }*/
//    }
//











