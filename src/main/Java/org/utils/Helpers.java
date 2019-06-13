package org.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.Interface.Dependencies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.restassured.response.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static io.restassured.RestAssured.given;


public class Helpers implements Dependencies
    {
        public AndroidDriver driver;
        static  String URL = "https://layout.airtel.tv/tv/layout/v1/page?" +
                "op=NON_AIRTEL&os=ANDROID&currSeg=ATVPLUS&cl=unknown&" +
                "refresh=true&pacp=4001&bn=2148&cp=altbalaji%2Cerosnow%2Cfastfilmz%2Choichoi%2Chooq%2Chotstar%2Chun" +
                "gama%2Cmwtv%2Cndtv%2Czee5&dt=com.java.org.ST" +
                "B&recInProg=false&rg=true&lg=hi&ut=PO&pncp=&appId=SDK";
        String pageID = "5b4c82f8abbba8a60dcd384b";

    public Helpers(AndroidDriver driver){
        this.driver = driver;
    }


    private void test(String key) {
        try {
            Runtime.getRuntime().exec(key);}
            catch (Exception e)
        { e.printStackTrace(); } }
    @Step
    public void scrollVertical(){

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
                    scrolltoend();
                    test(DOWN_key);
                    System.out.println("Down key pressed");
                } else{
                    flag = false;
                    scrolltoend();
                    break;
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            } } }

    @Step
    public void scrolltoend() {
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
                        } } }
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
            } }
        System.out.println("Reached End ! Success"); }

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

    public static String getPagelayout(String pageID) {
        String title = "";

        try {
            Response response = given().relaxedHTTPSValidation().
                    param("pageId", pageID).
                    when().
                    get(URL);
            String stringresponse = response.asString();
            String prettystyring = toPrettyJson(stringresponse);
            int size = response.jsonPath().getList("$").size();
            System.out.println("Dlogs:- " + size);

            List<Map<String, String>> formatvalue = response.jsonPath().getList("format");
            title = formatvalue.get(size - 3).get("t");
            System.out.println("Title from API = " + title);
        } catch (Exception e) {
            System.out.println("Exception found: "
                    + e);
        }
        return title;
    }
        public static String toPrettyJson(String uglyJSONString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }

    public static String toJsonString(Object obj) {
        return new Gson().toJson(obj);
    }

    }




