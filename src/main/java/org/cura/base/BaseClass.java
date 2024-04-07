package org.cura.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cura.pages.functions.HomePage;
import org.cura.utils.PropUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    static final Logger logger = LogManager.getLogger(HomePage.class.getName());
    public static WebDriver driver;
    private static String browser;
    private static String baseUrl;
    public PropUtils propUtils;

    public BaseClass() {
        propUtils = new PropUtils();
        browser = propUtils.getProperty("browser");
        baseUrl = propUtils.getProperty("baseUrl");
    }

    public static void initialisation() {
        openBrowser();
    }

    private static WebDriver openBrowser() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = openChromeBrowser();
            setDriverProperties();
            openBaseUrl();
        } else {
            logger.error("Browsers other than chrome are not supported yet");
        }
        return null;
    }

    private static void setDriverProperties() {
        logger.info("Maximizing the browser window");
    }

    private static void openBaseUrl() {

    }

    private static WebDriver openChromeBrowser() {

    }

    private static WebDriver openChromeWebDriverManager() {

    }

    public static void closeBrowser() {

    }
}
