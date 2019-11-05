package rushna;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestVerifyLinks extends global {//class begins
    @Test
    public void verifylinks(){//method verifylinks begins

    // Go to http://newtours.demoaut.com/

    logger.info("Step 1 Go to http://newtours.demoaut.com/");
    driver.get(baseUrl);

    // Verify page title is "Welcome: Mercury Tours"
        logger.info("Step 2: Verify page title is \"Welcome: Mercury Tours\"");
        assertEquals("Welcome: Mercury Tours",driver.getTitle());

    // Verify Home link exist
        logger.info("Step 3: Verify Home Link\"");
        assertEquals(true, driver.findElement(By.linkText("Home")).isDisplayed());

    // Verify Flights link exist
        logger.info("Step 5: Verify Flights Link\"");
        assertEquals(true,driver.findElement(By.linkText("Flights")).isDisplayed());

    // Verify Hotels link exist
        logger.info("Step 6: Verify Hotels Link\"");
        assertEquals(true,driver.findElement(By.linkText("Hotels")).isDisplayed());

    //Verify Cars link exist
        logger.info("Step 7: Verify Car Rentals Link\"");
        assertEquals(true,driver.findElement(By.linkText("Car Rentals")).isDisplayed());

    // Verify Cruises link exist
        logger.info("Step 8: Verify Cruises Link\"");
        assertEquals(true,driver.findElement(By.linkText("Cruises")).isDisplayed());

    }//method verifylink ends

}//class ends
