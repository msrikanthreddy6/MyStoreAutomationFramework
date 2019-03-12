package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
}
