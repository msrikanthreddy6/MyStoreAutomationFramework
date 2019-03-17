package com.mystore.qa.testcases.ui;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.AccountPage;
import com.mystore.qa.pages.HomePage;

import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class LoginPageTest extends BasePage {

    private static final String TITLE = "Login - My Store";
    private static final String HOME_PAGE_TITLE = "My account - My Store";
    private static final String EMAIL_AUTH_ERROR_MSG = "Authentication failed.";
    private static final String EMPTY_EMAIL_AUTH_ERROR_MSG = "An email address required.";
    private static final String EMPTY_PASS_AUTH_ERROR_MSG = "Password is required.";


    private HomePage homePage;
    private LoginPage loginPage;

    public LoginPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = homePage.clickOnSignInLink();
    }


    @Test(priority = HIGH, description = "Verify correct Login Page title")
    public void loginPageTitleTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        String title = loginPage.validateLoginPageTitle();

        assertions.assertEquals(title, TITLE);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @Test(priority = HIGH, description = "Verify login with valid email and password")
    public void loginWithValidCredentialsTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        AccountPage accountPage = loginPage.validateLogin(prop.getProperty("useremail"), prop.getProperty("userpassword"));

        assertions.assertEquals(accountPage.validateAccountPageTitle(), HOME_PAGE_TITLE);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }

    @Test(priority = HIGH, description = "Verify login with invalid email")
    public void loginWithInalidEmailTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        loginPage.validateLogin(prop.getProperty("invalidemail"), prop.getProperty("userpassword"));
        String msg;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(msg = loginPage.validateAuthenificationErrorMsg());
        softAssert.assertEquals(msg, EMAIL_AUTH_ERROR_MSG);
        softAssert.assertAll();

        logger.info(String.format("Ending %s test execution", test.getName()));
    }

    @Test(priority = HIGH, description = "Verify login with empty email field")
    public void loginWithEmptyEmailFieldTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        loginPage.validateLogin("", prop.getProperty("userpassword"));
        String msg;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(msg = loginPage.validateAuthenificationErrorMsg());
        softAssert.assertEquals(msg, EMPTY_EMAIL_AUTH_ERROR_MSG);
        softAssert.assertAll();

        logger.info(String.format("Ending %s test execution", test.getName()));
    }

    @Test(priority = HIGH, description = "Verify login with empty password field")
    public void loginWithEmptyPasswordFieldTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        loginPage.validateLogin(prop.getProperty("useremail"), "");
        String msg;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(msg = loginPage.validateAuthenificationErrorMsg());
        softAssert.assertEquals(msg, EMPTY_PASS_AUTH_ERROR_MSG);
        softAssert.assertAll();

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        driver.quit();
    }


}
