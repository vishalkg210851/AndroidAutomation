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

public class HomePage extends Helpers {

    AndroidDriver driver;
    private Logger log = LoggerFactory.getLogger(this.getClass());

//    @FindBy(xpath = "//a[@title='Log In'][1]")
//    @AndroidFindBy(id = "login_button")
    private WebElement homepagetab;

    public HomePage(AndroidDriver driver) throws InterruptedException {
        super(driver);
        this.driver = driver;
//        PageFactory.initElements(driver, this);
        log.info("Initializing the \"+this.getClass().getSimpleName()+\" elements");
     //   logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }



}

