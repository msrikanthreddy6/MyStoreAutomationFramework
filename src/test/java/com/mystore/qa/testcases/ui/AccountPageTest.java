package com.mystore.qa.testcases.ui;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.pages.AccountPage;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.TShirtsPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AccountPageTest extends BasePage {

    private static final String TITLE = "My account - My Store";
    private static final String TSHIRT_PAGE_TITLE = "T-shirts - My Store";


    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private TShirtsPage tShirtsPage;


    public AccountPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = homePage.clickOnSignInLink();
        accountPage = loginPage.validateLogin(prop.getProperty("useremail"), prop.getProperty("userpassword"));
    }


    @Test(priority = HIGH, description = "Verify account page title")
    public void accountPageTitleTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));

        String title = accountPage.validateAccountPageTitle();
        assertions.assertEquals(title, TITLE);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }

    @Test(priority = MEDIUM, description = "Verify click on t-shirts link")
    public void tshirtsLinkTest(Method test){
        logger.info(String.format("Starting %s test execution", test.getName()));

        tShirtsPage = accountPage.validateClickOnTshirtsLink();
        String title = tShirtsPage.validateAccountPageTitle();
        assertions.assertEquals(title, TSHIRT_PAGE_TITLE);

        logger.info(String.format("Ending %s test execution", test.getName()));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
