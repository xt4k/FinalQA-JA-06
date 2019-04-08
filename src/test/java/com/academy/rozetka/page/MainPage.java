package com.academy.rozetka.page;

import com.academy.automation.framework.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage  extends BasePage {

    private final String enterLinkLocator = "body > app-root > div > div:nth-child(2) > div.app-rz-header > header > div > div.header-topline > div.header-topline__user.js-rz-auth > div.header-topline__user-wrapper > p > a";

//    @FindBy(css = "body > app-root > div > div:nth-child(2) > div.app-rz-header > header > div > div.header-topline > div.header-topline__user.js-rz-auth > div.header-topline__user-wrapper > p > a")
    @FindBy(css = enterLinkLocator)
    private WebElement enterLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getEnterLinkText() {
        return enterLink.getText().trim();
    }

    public AuthFormPage clickEnterLink() {
        enterLink.click();
        return new AuthFormPage(driver);
    }

    public MainPage waitUntilLinkTextChanged(String oldMessage){
        waitUntilTextChanged(enterLinkLocator, oldMessage);
        return this;
    }
   }
