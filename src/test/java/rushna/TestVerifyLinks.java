package rushna;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestVerifyLinks extends global {//class begins
    @Test
    public void verifylinks(){//method verifylinks begins

    // Go to http://newtours.demoaut.com/
        driver.get(baseUrl);

    // Verify page title is "Welcome: Mercury Tours"
        assertEquals("Welcome: Mercury Tours",driver.getTitle());

    // Verify Home link exist

        assertEquals(true, driver.findElement(By.linkText("Home")).isDisplayed());

    // Verify Flights link exist

        assertEquals(true,driver.findElement(By.linkText("Flights")).isDisplayed());

    // Verify Hotels link exist

        assertEquals(true,driver.findElement(By.linkText("Hotels")).isDisplayed());

    //Verify Cars Rentals link exist

        assertEquals(true,driver.findElement(By.linkText("Car Rentals")).isDisplayed());

    // Verify Cruises link exist

        assertEquals(true,driver.findElement(By.linkText("Cruises")).isDisplayed());

    }//method verifylink ends

}//class ends
