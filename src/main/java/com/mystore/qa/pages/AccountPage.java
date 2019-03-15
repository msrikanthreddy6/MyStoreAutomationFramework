package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.util.JavaScriptTestHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {


    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenLink;

    @FindBy(xpath = "//a[@title='T-shirts']")
    WebElement tshirtsLink;


    public AccountPage(){
        PageFactory.initElements(driver, this);
    }


    public TShirtsPage validateClickOnTshirtsLink(){
        Actions action = new Actions(driver);
        action.moveToElement(womenLink).build().perform();
        tshirtsLink.click();
        return new TShirtsPage();
    }

    public String validateAccountPageTitle(){
        return JavaScriptTestHelper.getTitleByJS(driver);
    }
}
