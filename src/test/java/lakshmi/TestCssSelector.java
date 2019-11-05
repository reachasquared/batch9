package lakshmi;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCssSelector extends global {//class begins

    @Test
    public void cssSelector() {//method cssSelector begins
        logger.info("Step1: Go to http://newtours.demoaut.com/");
        driver.get(baseUrl);

        // Verify page title is "Welcome: Mercury Tours"
        logger.info("Step 2: Verify page title is Welcome: Mercury Tours");
        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        // Verify Home link exist
        logger.info("Step 3:Verify Home link exist");
        assertTrue(driver.findElement(By.cssSelector("a[href^=\"mercurywelcome.php\"]")).isDisplayed());

        // Verify Logo exist
        logger.info("Step 4:Verify Logo image exist");
        assertTrue(driver.findElement(By.cssSelector("img[src^=\"/images/nav/logo.gif\"]")).isDisplayed());

        // Verify Flights link exist
        logger.info("Verify Flights link exist");
        assertTrue(driver.findElement(By.cssSelector("a[href^=\"mercuryreservation.php\"]")).isDisplayed());

        // Verify Hotels link exist
        logger.info("Verify Hotels link exist");
        assertTrue(driver.findElement(By.cssSelector("a[href^=\"mercuryunderconst.php\"")).isDisplayed());

        //Verify Cars link exist
        logger.info("Verify Cars link exist");
        assertTrue(driver.findElement(By.cssSelector("a[href^=\"mercuryunderconst.php\"]")).isDisplayed());

        // Verify Cruises link exist
        logger.info("Verify Cruises link exist");
        assertTrue(driver.findElement(By.cssSelector("a[href^=\"mercuryunderconst.php\"]")).isDisplayed());

    }//method cssSelector ends
}//class ends

