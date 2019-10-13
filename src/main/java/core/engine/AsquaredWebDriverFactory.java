package core.engine;


import core.properties.PropertyHandlerFactory;
import org.apache.commons.exec.OS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AsquaredWebDriverFactory {

    private static Logger LOGGER = LogManager.getLogger("EngineRunLog");
    private static browser currentBrowser;
    private static Integer timeout;
    private static AsquaredEventFiringWebDriver driver;


    /**
     * Method starting WebDriver.
     * <p>
     * wiki reference for DesiredCapabilities:
     * http://code.google.com/p/selenium/wiki/DesiredCapabilities
     *
     * @return
     */
    public static WebDriver startDriver(String browserName) {
        WebDriver driver = startDriver(browserName, true);
        return driver;
    }

    /**
     * Method starting WebDriver.     *
     *
     * @param deleteCookies param used for decision if delete cookies on not during starting WebDriver
     * @return
     */
    private static WebDriver startDriver(String browserName, boolean deleteCookies) {
        LOGGER.info("driver not initialized, starting:" + getBrowser(browserName));
        switch (getBrowser(browserName)) {
            case GOOGLECHROME:
                prepareChrome();
                break;
            default:
                prepareFirefox();
        }

        LOGGER.info(getBrowserName(browserName) + " started");
        timeout = 30;
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        if (deleteCookies)
            driver.manage().deleteAllCookies();
        return driver;
    }

    /**
     * Returns currently used browser. Browsers supported are Firefox, IE, Chrome
     */
    private static browser getBrowser(String browserName) {
        setBrowser(browserName);
        if (currentBrowser == null) currentBrowser = browser.FIREFOX;
        return currentBrowser;
    }

    /**
     * Sets browser to be used. Default is Firefox, can be IE or CHROME.
     *
     * @param browserName
     */
    public static void setBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("googlechrome")) {
            currentBrowser = browser.GOOGLECHROME;
            return;
        }
        currentBrowser = browser.FIREFOX;
    }

    public static String getBrowserName(String browserName) {
        return getBrowser(browserName).name();
    }


    /**
     * Obtains driver instance and starts it if it is not started.
     *
     * @return
     */
    public static WebDriver getDriver(String browser) {
        return (driver == null) ? startDriver(browser) : driver;
    }

    /**
     * Kills webdriver, sets it to null and closes browser window.
     */
    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            LOGGER.info("Driver killed");
        }
    }

    private enum browser {
        IE, FIREFOX, GOOGLECHROME, SAFARI
    }

    private static void prepareChrome() {
        File driverBinaryFile = null;
        if (OS.isFamilyWindows()) {
            driverBinaryFile = new File("src/test/resources/drivers/chromedriver.exe");
        } else {
            driverBinaryFile = new File("src/test/resources/drivers/chromedriver");
        }
        System.setProperty("webdriver.chrome.driver", driverBinaryFile.getAbsolutePath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        String loadChroPath = PropertyHandlerFactory.get().getPropertyValue("loadChroPath");
        if ((loadChroPath != null) && (loadChroPath.equalsIgnoreCase("true"))) {
            try {
                chromeOptions.addExtensions(new File("src/test/resources/chropath-0.3.4-Crx4Chrome.com.crx"));
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
        driver = new AsquaredEventFiringWebDriver(new ChromeDriver(chromeOptions));
//        PropertyHandler.setDynamicPropertyToDefaultFile("browserName", driver.getCapabilities().getBrowserName());
//        PropertyHandler.setDynamicPropertyToDefaultFile("browserVersion", driver.getCapabilities().getVersion());
    }

    private static void prepareFirefox() {
        // prepare information about firefox profile and it's config
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        // Creating firefox Options instance from our Profile
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(firefoxProfile);

        // Try running legacy version for Firefox version less than 53
        try {
            firefoxOptions.setLegacy(true);
            driver = new AsquaredEventFiringWebDriver(new FirefoxDriver(firefoxOptions));
        } catch (WebDriverException e) {
            // If firefox is >= 53 then use geckodriver and move on.
            System.out.println("Firefox is too new for legacy ");
            firefoxOptions.setLegacy(false);
            // inform where is geckodriver exec
            System.setProperty("webdriver.gecko.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "geckodriver");
            driver = new AsquaredEventFiringWebDriver(new FirefoxDriver(firefoxOptions));
        }
    }

}
