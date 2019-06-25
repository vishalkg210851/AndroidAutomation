package org.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.Helpers;

public class HomePage extends Helpers {

    AppiumDriver driver;

    @AndroidFindBy(id = "tv.airtel.smartstick:id/row_header")
    public WebElement RailTitle;

    public HomePage(AppiumDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String HomePageTest(){
        return RailTitle.getText();
    }


    public void HomePageScrollTest(){ scrollVertical(RailTitle);
    }

    }


