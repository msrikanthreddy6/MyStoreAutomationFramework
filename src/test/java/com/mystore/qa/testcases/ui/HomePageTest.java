package com.mystore.qa.testcases.ui;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.util.TestUtil;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Random;

public class HomePageTest extends BasePage {

    private static final String TITLE = "My Store";
    private static final String LOGIN_TITLE = "Login - My Store";
    private static final String VALID_SUB_MSG = "Newsletter : You have successfully subscribed to this newsletter.";
    private static final String INVALID_SUB_MSG = "Newsletter : This email address is already registered.";

    private HomePage homePage;

    public HomePageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
    }


    @DataProvider
    public Object[] validEmailProvider(){
        Random random = new Random();
        String email = "test" + random.nextInt(TestUtil.RAND_RANGE) + "@test.com";
        logger.info("Generating random email for subscription: " + email);
        return new Object[]{email};
    }


    @Test(priority = HIGH, description = "Verify correct Home Page title")
    public void homePageTitleTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        String title = homePage.validateHomePageTitle();

        Assert.assertEquals(title, TITLE);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @Test(priority = HIGH, description = "Verify that Sign In button returns Login Page")
    public void signInLinkTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        LoginPage loginPage = homePage.clickOnSignInLink();

        Assert.assertEquals(loginPage.validateLoginPageTitle(), LOGIN_TITLE);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @Test(priority = LOW, description = "Verify that Home Page logo is displayed")
    public void homePageLogoTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        boolean isLogo = homePage.validateHomePageLogo();

        Assert.assertTrue(isLogo);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @Test(priority = MEDIUM, dataProvider = "validEmailProvider", description = "Verify that user can subscribe with valid email")
    public void homePageValidSubscriptionTest(String email, Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        String msg = homePage.validateNewslatterValidSubs(email);

        Assert.assertTrue(msg.contains(VALID_SUB_MSG));

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @Test(priority = MEDIUM, description = "Verify that user cannot subscribe with email that already exist")
    public void homePageInvalidSubscriptionTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        String msg = homePage.validateNewslatterInvalidSubs(prop.getProperty("useremail"));

        Assert.assertTrue(msg.contains(INVALID_SUB_MSG));

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @Test(priority = LOW, description = "Verify that News Letter label is displayed")
    public void homePageNewsletterLabelTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        boolean isLabel = homePage.validateHomePageNewslatterLabel();

        Assert.assertTrue(isLabel);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @Test(priority = LOW, description = "Verify that Follow Us label is displayed")
    public void homePageFollowUsLabelTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        boolean isLabel = homePage.validateHomePageFollowUsLabel();

        Assert.assertTrue(isLabel);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        driver.quit();
    }


}
