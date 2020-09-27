package com.udacity.java.course1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterText(String text) {
        messageText.sendKeys(text);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
