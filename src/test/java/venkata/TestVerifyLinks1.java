package venkata;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestVerifyLinks1 extends global {//class begins

    @Test
    public void verifyLinks() {//method verifyLinks begins
        // Go to http://newtours.demoaut.com/
        driver.get(baseUrl);

        // Verify page title is "Welcome: Mercury Tours"
        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        // Verify Home link exist
        assertEquals(true, driver.findElement(By.linkText("Home")).isDisplayed());

        assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());

        assertTrue(driver.findElement(By.cssSelector("a[href^=\"mercurywelcome.php\"]")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("img[src^=\"/images/nav/logo.gif\"]")).isDisplayed());

        // Verify Flights link exist

        // Verify Hotels link exist

        //Verify Cars link exist

        // Verify Cruises link exist
    }//method verifyLinks ends

}//class ends
