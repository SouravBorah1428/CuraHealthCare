package org.cura.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cura.pages.functions.LandingPage;
import org.cura.utils.PropUtils;
import org.cura.utils.TestConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    static final Logger logger = LogManager.getLogger(LandingPage.class.getName());
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
        driver.manage().window().maximize();
        logger.info("Deleting the browser cookies");
        driver.manage().deleteAllCookies();
        logger.info("Adding implicit wait");
        driver.manage().timeouts().implicitlyWait(TestConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        logger.info("Adding page load timeout");
        driver.manage().timeouts().pageLoadTimeout(TestConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    private static void openBaseUrl() {
        logger.info("Opening the website url");
        driver.get(baseUrl);
    }

    private static WebDriver openChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        try {
            logger.info("Opening chrome browser in a docker image");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        return driver;
    }

    private static WebDriver openChromeWebDriverManager() {
        logger.info("Opening Chrome browser locally");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static void closeBrowser() {
        try {
            driver.close();
        } catch (Exception e) {
            driver.quit();
        }
    }
}
