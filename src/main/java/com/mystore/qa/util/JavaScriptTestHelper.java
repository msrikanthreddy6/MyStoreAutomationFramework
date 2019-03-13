package com.mystore.qa.util;

import com.mystore.qa.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptTestHelper extends BasePage {

    // selecting date

    public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value', '" + dateValue + "');" , element);
    }

    // highlight element

    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(100);
        }
        catch(InterruptedException exc) {
            exc.printStackTrace();
        }
    }

    // draw a border of an element

    public static void drawBorder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    // generate Alerts

    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('" + message + "')");
    }

    // click on element

    public static void clickElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
    }

    // browser refreshing

    public static void refreshBrowserByJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("history.go(0)");
    }

    // get title

    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript("return document.title").toString();
    }

    // get innerText

    public static String getInnerText(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript("return document.documentElement.innerText;").toString();
    }

    // scrolling to the down

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // scrolling to the element

    public static void scrollingToView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
