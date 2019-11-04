package lakshmi;

import core.engine.AsquaredWebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestNavigationDeveloped {//class begins
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        //driver = new ChromeDriver();
        driver = AsquaredWebDriverFactory.getDriver("chrome");
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void navigation(){//method navigation begins
        //Step 1	Go to http://newtours.demoaut.com
        driver.get("http://newtours.demoaut.com");//open/goto url

        //Assert page title : Welcome: Mercury Tours
        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        //Step 2	Click on SIGN-ON link in Header
        driver.findElement(By.linkText("SIGN-ON")).click();

        //Assert page title : Sign-on: Mercury Tours
        assertEquals("Sign-on: Mercury Tours", driver.getTitle());

        //Step 3	Click on SUPPORT link in Header
        driver.findElement(By.linkText("SUPPORT")).click();

        //Assert page title : Under Construction: Mercury Tours
        assertEquals("Under Construction: Mercury Tours", driver.getTitle());

        //Step 5	Click on Home link in left side menu
        driver.findElement(By.linkText("Home")).click();

        //Assert page title : Welcome: Mercury Tours
        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        //Step 6	Click on Flight link in left side menu
        driver.findElement(By.linkText("Flight")).click();

        //Assert page title : Welcome: Mercury Tours
        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        //Step 7	Click on Hotels link in left side menu
        driver.findElement(By.linkText("Hotels")).click();

        //Assert page title : Under Construction: Mercury Tours
        assertEquals("Under Construction: Mercury Tours", driver.getTitle());

        //Step 8	Click on Car Rentals link in left side menu
        driver.findElement(By.linkText("Car Rentals")).click();

        //Assert page title : Under Construction: Mercury Tours
        assertEquals("Under Construction: Mercury Tours",driver.getTitle());

        //Step 9	Click on Cruises link in left side menu
        driver.findElement(By.linkText("Cruises")).click();

        //Assert page title : Cruises: Mercury Tours
        assertEquals("Cruises: Mercury Tours", driver.getTitle());

        //Step 10	Click on Destinations link in left side menu
        driver.findElement(By.linkText("Destinations")).click();

        //Assert page title : Under Construction: Mercury Tours
        assertEquals("Under Construction: Mercury Tours", driver.getTitle());

        //Step 11	Click on Vacations link in left side menu
        driver.findElement(By.linkText("Vacations")).click();

        //Assert page title : Under Construction: Mercury Tours
        assertEquals("Under Construction: Mercury Tours", driver.getTitle());
//test

    }//method navigation ends


}//class ends


