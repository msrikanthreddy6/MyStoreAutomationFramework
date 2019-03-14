package com.mystore.qa.testcases.ui;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.UnRegHomePage;

import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class LoginPageTest extends BasePage {

    private static String TITLE = "Login - My Store";

    private UnRegHomePage unRegHomePage;
    private LoginPage loginPage;

    public LoginPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        unRegHomePage = new UnRegHomePage();
        loginPage = unRegHomePage.clickOnSignInLink();
    }


    @Test(priority = HIGH, description = "Verify correct Home Page title")
    public void loginPageTitleTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));
        String title = loginPage.validateLoginPageTitle();

        Assert.assertEquals(title, TITLE);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        driver.quit();
    }


}
