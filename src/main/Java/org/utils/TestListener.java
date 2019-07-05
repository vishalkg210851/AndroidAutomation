package org.utils;


import io.appium.java_client.AppiumDriver;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.Base_Class;


public class TestListener extends Base_Class implements ITestListener {


    Logger Log = Logger.getLogger("testinfolog");
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
    }
    public void onTestStart(ITestResult iTestResult) {
        Log.info("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
        Log.info(getTestMethodName(iTestResult) + " test is starting.");

    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");


    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (AppiumDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");

        //Get driver from Base_Class and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
       AppiumDriver driver = ((Base_Class) testClass).getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof AppiumDriver) {
           Log.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }

        //Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
                getScreenshotAs(OutputType.BASE64);


    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}

