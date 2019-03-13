package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.util.JavaScriptTestHelper;

public class PasswordRecoverPage extends BasePage {

    public String validatePasswordRecoverPageTitle(){
        return JavaScriptTestHelper.getTitleByJS(driver);
    }
}
