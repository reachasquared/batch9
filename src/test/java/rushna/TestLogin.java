package rushna;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestLogin extends global { // class begin
    @Test
    public void login(){ //method login begins

// Step 1	Go to http://newtours.demoaut.com
    logger.info("Step 1  Go to http://newtours.demoaut.com");
    driver.get(baseUrl);

//Assert page title : Welcome: Mercury Tours
        logger.info("Assert page title: Welcome: Mercury Tours");
        assertEquals("Welcome: Mercury Tours",driver.getTitle());

//Verify User Name and Password fields and Sign-in button exist
        logger.info("Verfiy User Name exist");
        assertEquals(true,driver.findElement(By.name("userName")).isDisplayed());

        logger.info("Verify password exist");
        assertTrue(driver.findElement(By.name("password")).isDisplayed());

        logger.info("Sign-in password exist");
        assertTrue(driver.findElement(By.name("login")).isDisplayed());

//Step 2	Enter asquared in user name field
        logger.info(" Enter asquared in user name field");//
        driver.findElement(By.name("userName")).sendKeys("asquared");

//Step 3	Enter asquared in password field
        logger.info("Enter asquared in password field");
        driver.findElement(By.name("password")).sendKeys("asquared");

//Step 4	Click on Sign-in
        logger.info("Step 4 Click on Sign-in");
        driver.findElement(By.name("login")).click();


//Assert page title is Find a Flight: Mercury Tours:
        logger.info("Assert page title is Find a Flight: Mercury Tours:");
        assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());

//Step 5 Click on SIGN-OFF
        logger.info("Step 5 Click on SIGN-OFF");
        driver.findElement(By.linkText("SIGN-OFF")).click();


    }
}
