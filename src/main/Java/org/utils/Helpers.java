package org.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.Interface.Dependencies;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class Helpers implements Dependencies {
    public AppiumDriver driver;
    Logger log = Logger.getLogger("testinfolog");
    static String URL = "https://layout.airtel.tv/tv/layout/v1/page?op=NON_AIRTEL&os=ANDROID&currSeg=ATVPLUS&cl=unknown&refresh=true&pacp=4001&bn=2148&cp=altbalaji%2Cerosnow%2Cfastfilmz%2Choichoi%2Chooq%2Chotstar%2Chungama%2Cmwtv%2Cndtv%2Czee5&dt=STICK&recInProg=false&rg=true&lg=hi&ut=PO&pncp=&appId=XTREME";
    Boolean ReachedEnd = false;
    String temp = "";

    public Helpers(AppiumDriver driver) {
        this.driver = driver;
    }


    public void test(String key) {
        try {
            Runtime.getRuntime().exec(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollVertical(WebElement LastTitle) {
        boolean flag = true;
        String HomepageID = "5bd05a82e4b0800562a32335";
        String title;
        try {
            title = Helpers.getPagelayout(HomepageID);
            log.info("Last Title:- " + title);

            while (flag) {
                try {
                    Thread.sleep(3000);
                    WebDriverWait wait = new WebDriverWait(driver, 30);
                    wait.until(ExpectedConditions.visibilityOf(LastTitle));
                    String str = LastTitle.getText().trim();
                    log.info("Current Title DLogs" + str);
                    if (!str.contentEquals(title)) {
                        test(DOWN_key);
                        System.out.println("Down key pressed");
                    } else {
                        flag = false;
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            log.info(e);
        }
    }


    public void scrolltoend(List<WebElement> cardList, WebElement cardtitle) {
        ReachedEnd = false;
        while (!ReachedEnd) {
            try {
                swipecards(cardList, cardtitle);
                test(Right_Key); }

            catch (Exception e) {
                e.printStackTrace(); } }}


    private void swipecards(List<WebElement> args, WebElement arg) throws InterruptedException {
        String name;
        int list_size=args.size();
       log.info("size of list is:-" +list_size);
        for(int j=0;j<=list_size;j++) {
            test(Right_Key);
            Thread.sleep(2000);
        }
        name = arg.getText();
       log.info("name1 is =" + name);
        if (name.equals(temp)){
            ReachedEnd = true;
            test(Right_Key);
        }
        else temp = name;
    }


    public void ContentDesc(AppiumDriver driver) throws InterruptedException {

        try {
            Thread.sleep(5000);
            WebElement ContentClick = driver.findElementById("com.airtel.tv:id/titleView");
            ContentClick.getText();
            ContentClick.click();
            Thread.sleep(5000);
            WebDriverWait wait_desc = new WebDriverWait(driver, 90);
            //wait_desc.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.airtel.tv:id/tvDescription")));
            WebElement Movie_Title = driver.findElementByXPath("//android.widget.TextView[@index='0']");
            if (Movie_Title.isDisplayed()) {
                Movie_Title.getText();
                log.info("Displayed Movie Title:-" + Movie_Title);
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
            List<String> jsonresponse = response.jsonPath().getList("$");
            int size = jsonresponse.size();
            System.out.println("Dlogs:- " + size);
            List<Map<String, String>> formatvalue = response.jsonPath().getList("format");
            title = formatvalue.get(size - 1).get("t");
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

    public void Vscroll(String str) {
        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.support.v7.widget.RecyclerView\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \""+str+"\")"));
        element.click();

    }

    public void Vscroll_new(String str) {
        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(new UiSelector().descriptionContains(\""+ str+ "\"));"));
        element.click();
    }


        public void Hscroll() {
            WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(                                                                                                                                                                                                                                                                                               				"new UiScrollable(new UiSelector().className(\"android.widget.LinearLayout\"))." +
                                        "setAsHorizontalList().scrollIntoView("
                				+ "new UiSelector().descriptionContains(\"Continue Watching\"))"));
            log.info(element.getAttribute("id"));
    }

}
        

