package org.cura.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cura.pages.functions.LandingPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
 This class contains the common utility methods related to the driver
 */
public class WebDriverUtility {
    static final Logger logger = LogManager.getLogger(LandingPage.class.getName());

    private static WebDriver driver;
    private static Actions actions;
    private static JavascriptExecutor javascriptExecutor;

    public WebDriverUtility(WebDriver driver) {
        WebDriverUtility.driver = driver;
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    // Method to return the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Method to click on a webelement using different approaches
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e1) {
            try {
                javascriptExecutor.executeScript("arguments[0].click();", element);
            } catch (Exception e2) {
                try {
                    int x = element.getLocation().getX();
                    int y = element.getLocation().getY();
                    actions.moveToElement(element, x, y).click().build().perform();
                } catch (Exception e3) {
                    e3.getMessage();
                }
            }
        }
    }

    // Method to type in a webelement field
    public static void type(WebElement element, String text) {
        element.sendKeys();
    }

    // Method to clear the webelement field data
    public static void clearField(WebElement element) {
        element.clear();
    }

    // Method to scroll down the page
    public static void scrollDown() {
        javascriptExecutor.executeScript("window.scrollBy(0, " + TestConstants.SCROLL_UP + ");", "");
    }

    // Method to scroll up the page
    public static void scrollUp() {
        javascriptExecutor.executeScript("window.scrollBy(0, " + TestConstants.SCROLL_DOWN + ");", "");
    }
}