package com.udacity.java.course1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    @FindBy(id = "inputFirstName")
    private WebElement inputFirstName;

    @FindBy(id = "inputLastName")
    private WebElement inputLastName;

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "success-msg")
    private WebElement successMessage;

    @FindBy(id = "login-link")
    private WebElement loginLink;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void inputUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void inputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickLogin() {
        loginLink.click();
    }
}