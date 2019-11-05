package rushna;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class TestRegistration extends global { //class begins
    @Test
    public void registrations () {// method registration begins

            // Go to newtours website
        logger.info("Go to newtours website");
        driver.get(baseUrl);

            //verify page title is "Welcome: Mercury Tours"
        logger.info("verify page title is\"Welcome: Mercury Tours\"");
        assertEquals("Welcome: Mercury Tours",driver.getTitle());

            //Verify REGISTER link is present using WebDriver linktext method
        logger.info("Verify REGISTER link is present using WebDriver linktext method");
        assertEquals(true,driver.findElement(By.linkText("REGISTER")).isDisplayed());

            //Click on REGISTER link using xpath

        logger.info("Click on REGISTER link using xpath");
        driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();

            //Enter asquared in First Name - using xpath @name
        logger.info("Enter asquared in First Name - using xpath @name");
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("asquared");

            //Enter asquared in Last Name - using following-sibling by label
        logger.info("Enter asquared in Last Name - using following-sibling by label");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("<input maxlength=\"60\" name=\"lastName\" size=\"20\" style=\"\" xpath=\"1\">");

            //Enter 9049049044 in Phone - using descendant by label
        logger.info("Enter 9049049044 in Phone - using descendant by label");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("<input maxlength=\"20\" name=\"phone\" size=\"15\" xpath=\"1\">");

            //Select UNITED KINGDOM from Country
        logger.info("Select UNITED KINGDOM from Country"); //help
        Select drpCountry = new Select(driver.findElement(By.name("//select[@name='country']"))); drpCountry.selectByVisibleText("UNITED KINGDOM");

            //Click Submit
        logger.info("Click Submit");
        driver.findElement(By.id("Submit"));

            //Verify "Dear asquare asquared," text is displayed
        logger.info("Verify \"Dear asquare asquared,\" text is displayed"); //help

            //verify Sign-off link exists
        logger.info("verify Sign-off link exists"); //help

            // Verify REGISTER image is displayed
        logger.info("Verify REGISTER image is displayed"); //help

            //click SIGN-OFF
        logger.info("click SIGN-OFF");
        driver.findElement(By.linkText("SIGN-OFF")).click();
    }
}//class ends
