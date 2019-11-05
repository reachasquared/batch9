package asquared;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCssSelector extends global {
    @Test
    public void cssSelector() {
        logger.info("Step1: Go to http://newtours.demoaut.com/");
        driver.get(baseUrl);

        // Verify page title is "Welcome: Mercury Tours"
        logger.info("Step 2: Verify page title is \"Welcome: Mercury Tours\"");
        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        // Verify Home link exist
        logger.info("Step 3:Verify Home link exist");
        assertTrue(driver.findElement(By.cssSelector("a[href^=\"mercurywelcome.php\"]")).isDisplayed());


        // Verify Logo exist
        logger.info("Step 4:Verify Logo image exist");
        assertTrue(driver.findElement(By.cssSelector("img[src^=\"/images/nav/logo.gif\"]")).isDisplayed());

        // Verify Flights link exist

        // Verify Hotels link exist

        //Verify Cars link exist

        // Verify Cruises link exist
    }
}
