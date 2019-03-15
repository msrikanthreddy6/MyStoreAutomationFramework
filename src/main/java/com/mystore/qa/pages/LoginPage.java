package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.util.JavaScriptTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailCreateField;

    @FindBy(id = "SubmitCreate")
    WebElement submitCreateBtn;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInputField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordInputField;

    @FindBy(id = "SubmitLogin")
    WebElement submitLoginBtn;

    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    WebElement recoverPassLink;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }


    public RegistrationPage validateRegistration(String email){
        emailCreateField.sendKeys(email);
        JavaScriptTestHelper.drawBorder(emailCreateField, driver);
        JavaScriptTestHelper.clickElementByJS(submitCreateBtn, driver);
        JavaScriptTestHelper.drawBorder(submitCreateBtn, driver);
        return new RegistrationPage();
    }


    public String validateLoginPageTitle(){
        return JavaScriptTestHelper.getTitleByJS(driver);
    }


    public AccountPage validateLogin(String email, String password){
        emailInputField.sendKeys(email);
        JavaScriptTestHelper.drawBorder(emailInputField, driver);
        passwordInputField.sendKeys(password);
        JavaScriptTestHelper.drawBorder(passwordInputField, driver);
        JavaScriptTestHelper.clickElementByJS(submitLoginBtn, driver);
        return new AccountPage();
    }


    public PasswordRecoverPage validatePasswordRecoverLink(){
        JavaScriptTestHelper.drawBorder(recoverPassLink, driver);
        JavaScriptTestHelper.clickElementByJS(recoverPassLink, driver);
        return new PasswordRecoverPage();
    }

    public String validateAuthenificationErrorMsg(){
        return driver.findElement(By.xpath("//div[@class='alert alert-danger']//li")).getText();
    }
}
