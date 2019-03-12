package com.mystore.qa.util;


import java.io.IOException;

import com.mystore.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class WebEventListener extends BasePage implements WebDriverEventListener {

    public void beforeAlertAccept(WebDriver driver) {
        logger.info("Trying to accept the Alert");

    }


    public void afterAlertAccept(WebDriver driver) {
        logger.info("Alert is accepted");

    }


    public void afterAlertDismiss(WebDriver driver) {
        logger.info("Alert is dismissed");

    }


    public void beforeAlertDismiss(WebDriver driver) {
        logger.info("Trying to dismiss the Alert");

    }


    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info("Before navigating to: '" + url + "'");

    }


    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info("Navigated to:'" + url + "'");
    }


    public void beforeNavigateBack(WebDriver driver) {
        logger.info("Navigating back to previous page");
    }


    public void afterNavigateBack(WebDriver driver) {
        logger.info("Navigated back to previous page");
    }


    public void beforeNavigateForward(WebDriver driver) {
        logger.info("Navigating forward to next page");
    }


    public void afterNavigateForward(WebDriver driver) {
        logger.info("Navigated forward to next page");
    }


    public void beforeNavigateRefresh(WebDriver driver) {
        logger.info("Trying to refresh");
    }


    public void afterNavigateRefresh(WebDriver driver) {
        logger.info("Application is refreshed");
    }


    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Trying to find Element By : " + by.toString());
    }


    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Found Element By : " + by.toString());
    }


    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Trying to click on: " + element.toString());
    }


    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("Clicked on: " + element.toString());
    }


    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        logger.info("Value of the:" + element.toString() + " before any changes made");
    }


    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        logger.info("Element value changed to: " + element.toString());
    }


    public void beforeScript(String script, WebDriver driver) {
        logger.info("Trying to execute script: " + script);
    }


    public void afterScript(String script, WebDriver driver) {
        logger.info("Script is executed: " + script);
    }


    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        logger.info("Trying to switch to the window: " + windowName);
    }


    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        logger.info("Switched to the window: " + windowName);
    }


    public void onException(Throwable throwable, WebDriver driver) {
        logger.error("Exception occurred: " + throwable);
        try {
            TestUtil.takeScreenshotIfExceptionOccurred();
        }catch(IOException exc) {
            exc.printStackTrace();
        }
    }


    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        logger.info("Trying to get screenshot: " + target.toString());
    }


    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        logger.info("Screenshot is done: " + target.toString() + " " + screenshot.toString());
    }


    public void beforeGetText(WebElement element, WebDriver driver) {
        logger.info("Trying to get a text: " + element.toString());
    }


    public void afterGetText(WebElement element, WebDriver driver, String text) {
        logger.info("Text for: " + element.toString() + " : " + text);
    }

}
