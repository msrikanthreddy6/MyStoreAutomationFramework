package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;

public class TShirtsPage extends BasePage {


    public String validateAccountPageTitle(){
        return driver.getTitle();
    }

}
