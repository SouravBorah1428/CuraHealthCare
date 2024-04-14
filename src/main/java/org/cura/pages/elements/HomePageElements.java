package org.cura.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements {
    @FindBy (xpath = "//select[@id='combo_facility']")
    public WebElement facilityDropDown;

    @FindBy (xpath = "//input[@id='chk_hospotal_readmission']")
    public WebElement hospitalReadmissionCheckbox;

    @FindBy (xpath = "//label[@class='radio-inline'][1]//input")
    public WebElement healthCareProgramRadioButtons;

    @FindBy (xpath = "//input[@id='txt_visit_date']")
    public WebElement visitDateField;

    @FindBy (xpath = "//textarea[@id='txt_comment']")
    public WebElement commentTextArea;

    @FindBy (xpath = "//button[@id='btn-book-appointment']")
    public WebElement bookAppointmentBtn;
}
