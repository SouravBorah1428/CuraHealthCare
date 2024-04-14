package org.cura.pages.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cura.base.BaseClass;
import org.cura.pages.elements.HomePageElements;
import org.cura.utils.WebDriverUtility;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends HomePageElements {
    static final Logger logger = LogManager.getLogger(HomePage.class.getName());
    private WebDriverUtility driverUtility;

    public HomePage() {
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
    }

    public String getPageTitle() {
        logger.info("Getting page title");
        return driverUtility.getPageTitle();
    }

    public void selectFacility() {
        Select select = new Select(facilityDropDown);
        logger.info("Selecting dropdown value from the facility dropdown");
        select.selectByValue("Hongkong CURA Healthcare Center");
    }

    public void checkHospitalReadmission() {
        logger.info("Checking Apply for Hospital Readmission checkbox");
        driverUtility.click(hospitalReadmissionCheckbox);
    }

    public void selectHealthCareProgram() {
        logger.info("Selecting health care program from the radio buttons");
        driverUtility.click(healthCareProgramRadioButtons);
    }

    public void enterVisitDate() {
        logger.info("Entering visit date");
        driverUtility.type(visitDateField, "28/04/2024");
    }

    public void enterComments() {
        logger.info("Enter comments in the comment box");
        driverUtility.type(commentTextArea, "Booking for 28th of April");
    }

    public void bookAppointment() {
        logger.info("Clicking on Book Appointment button");
        driverUtility.click(bookAppointmentBtn);
    }
}
