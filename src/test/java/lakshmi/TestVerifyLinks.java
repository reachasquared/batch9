package lakshmi;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestVerifyLinks extends global {//classbegins
    @Test
    public void verifyLinks(){//method verifylinks begins
        // Go to http://newtours.demoaut.com/
        driver.get(baseUrl);
        // Verify page title is "Welcome: Mercury Tours"
        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        // Verify Home link exist
        assertEquals(true,driver.findElement(By.linkText("Home")).isDisplayed());
        // assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());//another method of asserting

        // Verify Flights link exist
        assertEquals(true,driver.findElement(By.linkText("Flights")).isDisplayed());


        // Verify Hotels link exist
        assertTrue(driver.findElement(By.linkText("Hotels")).isDisplayed());

        //Verify Cars link exist
        assertTrue(driver.findElement(By.linkText("Cars")).isDisplayed());

        // Verify Cruises link exist
        assertTrue(driver.findElement(By.linkText("Cruises")).isDisplayed());

    }//method verifylinks ends

}//class ends
