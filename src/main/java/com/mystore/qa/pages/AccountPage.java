package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.util.JavaScriptTestHelper;

public class AccountPage extends BasePage {



    public String validateAccountPageTitle(){
        return JavaScriptTestHelper.getTitleByJS(driver);
    }
}
