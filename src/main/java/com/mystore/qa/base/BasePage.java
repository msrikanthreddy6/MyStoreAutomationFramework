package com.mystore.qa.base;

import com.mystore.qa.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage implements TestPriority, Browsers {

    private static final String configFilePath = "src/main/java/com/mystore/qa/config/config.properties";

    public static WebDriver driver;
    public static Properties prop;
    private static EventFiringWebDriver e_driver;
    private static WebEventListener eventListener;

    public static final Logger logger = Log.getLogData(Log.class.getName());
    public static final CustomAssertion assertions = new CustomAssertion();

    public BasePage(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream(configFilePath);
            prop.load(ip);
        } catch (FileNotFoundException exc){
            exc.printStackTrace();
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty(TestUtil.BROWSER);

        if(browserName.equals(CHROME)){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserName.equals(FIREFOX)){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(browserName.equals(SAFARI)){
            driver = new SafariDriver();
        } else if(browserName.equals(IE)){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if(browserName.equals(EDGE)){
            WebDriverManager.edgedriver();
            driver = new EdgeDriver();
        } else {
            logger.error("No such browser: " + browserName);
            return;
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(TestUtil.SCRIPT_TIMEOUT, TimeUnit.SECONDS);

        driver.get(prop.getProperty(TestUtil.URL));
    }


}
