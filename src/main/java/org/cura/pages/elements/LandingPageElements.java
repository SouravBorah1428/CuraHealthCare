package org.cura.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPageElements {
    @FindBy (xpath = "//a[@id='btn-make-appointment']")
    public WebElement makeAppointmentBtn;

    @FindBy (xpath = "//a[@id='menu-toggle']")
    public WebElement cogMenuBtn;

    @FindBy (xpath = "//*[@id='sidebar-wrapper']/ul/li[2]/a")
    public WebElement homeBtnLink;

    @FindBy (xpath = "//*[@id='sidebar-wrapper']/ul/li[3]/a")
    public WebElement loginBtnLink;
}
