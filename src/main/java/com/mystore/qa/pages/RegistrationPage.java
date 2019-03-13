package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.util.JavaScriptTestHelper;

public class RegistrationPage extends BasePage {

    public String validateRegistrationPageTitle(){
        return JavaScriptTestHelper.getTitleByJS(driver);
    }
}
