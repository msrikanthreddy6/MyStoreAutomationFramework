package com.mystore.qa.util;

import com.mystore.qa.base.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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

    public static String userEmailGenerator(){
        Random random = new Random();
        String existingEmail = "";
        String email = "autotest" + random.nextInt(RAND_RANGE) + "@test.com";

        File file = new File("src/main/java/com/mystore/qa/config/skippedEmails.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            do{
                existingEmail = br.readLine();
                if(existingEmail != null && email.equals(existingEmail)){
                    email = random.nextInt(RAND_RANGE) + email;
                }
            }while (existingEmail != null);

        }catch (IOException exc){
            logger.error(exc.getMessage());
        }

        try(OutputStream os = new FileOutputStream(file, true);){
            String newSkippedEmail = email + "\n";
            os.write(newSkippedEmail.getBytes(), 0, newSkippedEmail.length());
        }catch (IOException exc){
            logger.error(exc.getMessage());
        }

        logger.info("Generating random email for subscription: " + email);
        return email;
    }

}
