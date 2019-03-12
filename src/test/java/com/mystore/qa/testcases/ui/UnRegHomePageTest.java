package com.mystore.qa.testcases.ui;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.UnRegHomePage;
import com.mystore.qa.util.TestUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Random;

public class UnRegHomePageTest extends BasePage {

    private final String TITLE = "My Store";
    private final String LOGIN_TITLE = "Login - My Store";
    private final String VALID_SUB_MSG = "Newsletter : You have successfully subscribed to this newsletter.";
    private final String INVALID_SUB_MSG = "Newsletter : This email address is already registered.";

    private ExtentReports extentReports;
    private ExtentTest extentTest;

    private UnRegHomePage unRegHomePage;


    public UnRegHomePageTest(){
        super();
    }


    @BeforeTest
    public void setExtentReports(){
        extentReports = new ExtentReports(System.getProperty("user.dir") + "/test-output/TestReport.html", true);
        extentReports.addSystemInfo("Host Name", "Ihor Mac");
        extentReports.addSystemInfo("User Name", "Ihor Automation Lab");
        extentReports.addSystemInfo("Environment", "QA");
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        unRegHomePage = new UnRegHomePage();
    }


    @DataProvider
    public Object[] validEmailProvider(){
        Random random = new Random();
        String email = "test" + random.nextInt(TestUtil.RAND_RANGE) + "@test.com";
        logger.info("Generating random email for subscription: " + email);
        return new Object[]{email};
    }


    @Test(priority = HIGH, description = "Verify correct Home Page title")
    public void homePageTitleTest(){
        logger.info(String.format("Starting %s test execution", TestUtil.testName()));
        extentTest = extentReports.startTest(TestUtil.testName());
        String title = unRegHomePage.validateHomePageTitle();

        Assert.assertEquals(title, TITLE);

        logger.info(String.format("Ending %s test execution", TestUtil.testName()));
    }


    @Test(priority = HIGH, description = "Verify that Sign In button returns Login Page")
    public void signInLinkTest(){
        logger.info(String.format("Starting %s test execution", TestUtil.testName()));
        extentTest = extentReports.startTest(TestUtil.testName());
        LoginPage loginPage = unRegHomePage.clickOnSignInLink();

        Assert.assertEquals(loginPage.validateLoginPageTitle(), LOGIN_TITLE);

        logger.info(String.format("Ending %s test execution", TestUtil.testName()));
    }


    @Test(priority = LOW, description = "Verify that Home Page logo is displayed")
    public void homePageLogoTest(){
        logger.info(String.format("Starting %s test execution", TestUtil.testName()));
        extentTest = extentReports.startTest(TestUtil.testName());
        boolean isLogo = unRegHomePage.validateHomePageLogo();

        Assert.assertTrue(isLogo);

        logger.info(String.format("Ending %s test execution", TestUtil.testName()));
    }


//    @Test(priority = MEDIUM, dataProvider = "validEmailProvider", description = "Verify that user can subscribe with valid email")
//    public void homePageValidSubscriptionTest(String email){
//        logger.info(String.format("Starting %s test execution", TestUtil.testName()));
//        extentTest = extentReports.startTest(TestUtil.testName());
//        String msg = unRegHomePage.validateNewslatterValidSubs(email);

//        Assert.assertTrue(msg.contains(VALID_SUB_MSG));
//
//        logger.info(String.format("Ending %s test execution", TestUtil.testName()));
//    }


    @Test(priority = MEDIUM, description = "Verify that user cannot subscribe with email that already exist")
    public void homePageInvalidSubscriptionTest(){
        logger.info(String.format("Starting %s test execution", TestUtil.testName()));
        extentTest = extentReports.startTest(TestUtil.testName());
        String msg = unRegHomePage.validateNewslatterInvalidSubs(prop.getProperty("useremail"));

        Assert.assertTrue(msg.contains(INVALID_SUB_MSG));

        logger.info(String.format("Ending %s test execution", TestUtil.testName()));
    }


    @Test(priority = LOW, description = "Verify that News Letter label is displayed")
    public void homePageNewsletterLabelTest(){
        logger.info(String.format("Starting %s test execution", TestUtil.testName()));
        extentTest = extentReports.startTest(TestUtil.testName());
        boolean isLabel = unRegHomePage.validateHomePageNewslatterLabel();

        Assert.assertTrue(isLabel);

        logger.info(String.format("Ending %s test execution", TestUtil.testName()));
    }


    @Test(priority = LOW, description = "Verify that Follow Us label is displayed")
    public void homePageFollowUsLabelTest(){
        logger.info(String.format("Starting %s test execution", TestUtil.testName()));
        extentTest = extentReports.startTest(TestUtil.testName());
        boolean isLabel = unRegHomePage.validateHomePageFollowUsLabel();

        Assert.assertTrue(isLabel);

        logger.info(String.format("Ending %s test execution", TestUtil.testName()));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        String screenshotPath = null;
        if(result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

            screenshotPath = TestUtil.takeScreenshotTest(driver, result.getName());

            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
//			extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); // for video
        } else if(result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED IS " + result.getName());
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS " + result.getName());
        }
        extentReports.endTest(extentTest);
        driver.quit();
    }


    @AfterTest
    public void endReport(){
        extentReports.flush();
        extentReports.close();
    }
}
