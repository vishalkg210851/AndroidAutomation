package org.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.Helpers;

import java.util.List;

public class HomePage extends Helpers {

    AppiumDriver driver;

    @AndroidFindBy(id = "com.airtel.tv:id/railTitleID")
    public WebElement RailTitle;

    @AndroidFindBy(id = "com.airtel.tv:id/cardEpisode")
    public List<WebElement> CardList;

    @AndroidFindBy(id = "com.airtel.tv:id/tv_error_title")
    public WebElement CardTitle;

    public HomePage(AppiumDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String HomePageTest(){
        return RailTitle.getText();
    }


    public void HomePageVerticalScrollTest(){ scrollVertical(RailTitle);
    }

    public void HomePageHorizontalScrollTest(){ scrolltoend(CardList, CardTitle);}


    }


