package com.mystore.qa.pages;

import com.mystore.qa.base.BasePage;
import com.mystore.qa.util.JavaScriptTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signInLink;

    @FindBy(id = "contact-link")
    WebElement contactLink;

    @FindBy(id = "newsletter-input")
    WebElement newsletterInput;

    @FindBy(name = "submitNewsletter")
    WebElement submitNewsletterBtn;

    @FindBy(xpath = "//h4[contains(text(),'Newsletter')]")
    WebElement newsletterLabel;

    @FindBy(xpath = "//h4[contains(text(), 'Follow us')]")
    WebElement followusLabel;

    @FindBy(xpath = "//li[@class='facebook']")
    WebElement facebookLink;

    @FindBy(xpath = "//li[@class='twitter']")
    WebElement twitterLink;

    @FindBy(xpath = "//li[@class='youtube']")
    WebElement youtubeLink;

    @FindBy(xpath = "//li[@class='google-plus']")
    WebElement googleplusLink;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement logoImg;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle(){
        return driver.getTitle();
    }

    public boolean validateHomePageNewslatterLabel(){
        JavaScriptTestHelper.drawBorder(newsletterLabel, driver);
        return newsletterLabel.isDisplayed();
    }

    public boolean validateHomePageLogo(){
        JavaScriptTestHelper.drawBorder(logoImg, driver);
        return logoImg.isDisplayed();
    }

    public boolean validateHomePageFollowUsLabel(){
        JavaScriptTestHelper.drawBorder(followusLabel, driver);
        return followusLabel.isDisplayed();
    }

    public LoginPage clickOnSignInLink(){
        JavaScriptTestHelper.drawBorder(signInLink, driver);
        signInLink.click();
        return new LoginPage();
    }

    public String validateNewslatterValidSubs(String email){
        newsletterInput.sendKeys(email);
        submitNewsletterBtn.click();
        WebElement msg = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
        JavaScriptTestHelper.drawBorder(msg, driver);
        return msg.getText();
    }
    public String validateNewslatterInvalidSubs(String email){
        newsletterInput.sendKeys(email);
        submitNewsletterBtn.click();
        WebElement msg = driver.findElement(By.xpath("//p[@class='alert alert-danger']"));
        JavaScriptTestHelper.drawBorder(msg, driver);

        return msg.getText();
    }

    public void clickOnFacebookLink(){
        facebookLink.click();
    }

    public void clickOnTwitterLink(){
        twitterLink.click();
    }

    public void clickOnYoutubeLink(){
        youtubeLink.click();
    }

    public void clickOnGooglePlusLink(){
        googleplusLink.click();
    }
}
