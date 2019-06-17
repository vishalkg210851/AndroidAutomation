package org.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.utils.Helpers;
//import static org.utils.LoggingManager.logMessage;

import java.util.List;
import java.util.concurrent.ExecutionException;

//import static org.utils.LoggingManager.logMessage;

public class HomePage extends Helpers {

    AndroidDriver driver;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @AndroidFindBy(id = "com.airtel.tv:id/subSectionTitleView")
    private List<WebElement> HomePageTitleList;

    @AndroidFindBy(id = "com.airtel.tv:id/titleView")
    private List<WebElement> HomePageRailList;

    public HomePage(AndroidDriver driver) throws InterruptedException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void HomePageScroll(){
        try{
        scrolltoend(HomePageTitleList, HomePageRailList);}catch (Exception e){
            System.out.println("Element not found");
        }

    }


}

