package org.cura.pages.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cura.base.BaseClass;
import org.cura.pages.elements.LoginPageElements;
import org.cura.utils.WebDriverUtility;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginPageElements {
    static final Logger logger = LogManager.getLogger(LoginPage.class);
    private WebDriverUtility driverUtility;

    public LoginPage() {
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
    }

    public String getPageTitle() {
        logger.info("Getting the page title");
        return driverUtility.getPageTitle();
    }

    public void enterUsername() {
        logger.info("Entering username in the username field");
        driverUtility.type(usernameField, "John Doe");
    }

    public void enterPassword() {
        logger.info("Entering password in the password field");
        driverUtility.type(passwordField, "ThisIsNotAPassword");
    }

    public void clickLogin() {
        logger.info("Clicking on login button");
        driverUtility.click(loginBtn);
    }
}
