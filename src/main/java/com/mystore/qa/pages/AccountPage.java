package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.util.JavaScriptTestHelper;

public class RegHomePage extends BasePage {



    public String validateRegHomePageTitle(){
        return JavaScriptTestHelper.getTitleByJS(driver);
    }
}
