package com.udacity.java.course1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void inputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLogin() {
        submitButton.click();
    }
}