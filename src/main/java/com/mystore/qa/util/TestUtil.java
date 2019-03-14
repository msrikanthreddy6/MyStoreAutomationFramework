package com.mystore.qa.util;

import com.mystore.qa.base.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil extends BasePage {

    public static final String BROWSER = "browser";
    public static final String URL = "url";

    public static final int PAGELOAD_TIMEOUT = 20;
    public static final int IMPLICIT_WAIT = 10;
    public static final int SCRIPT_TIMEOUT = 10;

    public static final int RAND_RANGE = 1000;


    public static void takeScreenshotIfExceptionOccurred() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }


    public static String takeScreenshotTest(WebDriver driver, String scrshotName) throws IOException{
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String currentDir = System.getProperty("user.dir") + "/screenshots/" + dateName + scrshotName + ".png";

        FileUtils.copyFile(srcFile, new File(currentDir));
        return currentDir;
    }


}
