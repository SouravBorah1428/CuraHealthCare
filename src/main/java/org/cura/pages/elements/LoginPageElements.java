package org.cura.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements {
    @FindBy (xpath = "//input[@id='txt-username']")
    public WebElement usernameField;

    @FindBy (xpath = "//input[@id='txt-password']")
    public WebElement passwordField;

    @FindBy (xpath = "//button[@id='btn-login']")
    public WebElement loginBtn;
}
