package utils;

import STB.STB_functions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static Interface.Dependencies.DOWN_key;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;


public class Helpers {

    private static AppiumDriver driver;
    private static WebDriverWait driverWait;

    /**
     * Initialize the webdriver. Must be called before using any helper methods. *
     */
    public static void init(AppiumDriver webDriver) {
        driver = webDriver;
        int timeoutInSeconds = 60;
        // must wait at least 60 seconds for running on Sauce.
        // waiting for 30 seconds works locally however it fails on Sauce.
        driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
    }


     static  String URL = "https://layout.airtel.tv/tv/layout/v1/page?op=NON_AIRTEL&os=ANDROID&currSeg=ATVPLUS&cl=unknown&refresh=true&pacp=4001&bn=2148&cp=altbalaji%2Cerosnow%2Cfastfilmz%2Choichoi%2Chooq%2Chotstar%2Chungama%2Cmwtv%2Cndtv%2Czee5&dt=STB&recInProg=false&rg=true&lg=hi&ut=PO&pncp=&appId=SDK";
     String pageID = "5b4c82f8abbba8a60dcd384b";
//     static Object[] arr = new String[2];


    /*public static Object[] getPagelayout(String pageID) {

        try {
            Response response = given().relaxedHTTPSValidation().
                    param("pageId", pageID).
                    when().
                    get(URL);
            String stringresponse = response.asString();
            String prettystyring = toPrettyJson(stringresponse);
            int size = response.jsonPath().getList("$").size();
            System.out.println("Dlogs" + size);

            List<Map<String, String>> formatvalue = response.jsonPath().getList("format");
            String title = formatvalue.get(size - 3).get("t");
            System.out.println("Title from API = " +title);
            arr[0] = title;
            arr[1] = String.valueOf(size);

            return arr;
        } catch (Exception e) {
            System.out.println("Exception found: "
                    + e);
        }

        return null;

     }*/

//    -----new code-------

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




