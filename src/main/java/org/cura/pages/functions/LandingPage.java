package org.cura.pages.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cura.base.BaseClass;
import org.cura.pages.elements.LandingPageElements;
import org.cura.utils.WebDriverUtility;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage extends LandingPageElements {
    static final Logger logger = LogManager.getLogger(LandingPage.class.getName());
    private WebDriverUtility driverUtility;

    public LandingPage() {
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
    }

    public String getPageTitle() {
        logger.info("Getting page title");
        return driverUtility.getPageTitle();
    }

    public void makeAppointment() {
        logger.info("Clicking on Make Appointment button");
        driverUtility.click(makeAppointmentBtn);
    }

    public void clickHomeButton() {
        logger.info("Clicking on Home Button from cog menu");
        driverUtility.click(cogMenuBtn);
        driverUtility.click(homeBtnLink);
    }

    public void clickLoginButton() {
        logger.info("Clicking on Login Button from cog menu");
        driverUtility.click(cogMenuBtn);
        driverUtility.click(loginBtnLink);
    }
}
