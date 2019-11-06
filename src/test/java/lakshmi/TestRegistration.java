package lakshmi;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestRegistration extends global {//class begins

    @Test
    public void registration() {//method registration begins

        // Go to newtours website
        logger.info("Go to newtours website");
        driver.get(baseUrl);

        //verify page title is "Welcome: Mercury Tours"
        logger.info("verify page title is Welcome: Mercury Tours");
        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        //Verify REGISTER link is present using WebDriver linktext method
        logger.info("Verify REGISTER link is present using WebDriver linktext method");
        assertTrue(driver.findElement(By.linkText("REGISTER")).isDisplayed());

        //Click on REGISTER link using xpath
        logger.info("Click on REGISTER link using xpath");
        driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();

        //Enter asquared in First Name - using xpath @name
        logger.info("Enter asquared in First Name - using xpath @name");
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("asquared");

        //Enter asquared in Last Name - using following-sibling by label
        logger.info("Enter asquared in Last Name - using following-sibling by label");
        driver.findElement(By.xpath("//b[contains(text(),'Last')]/../../following-sibling::td/input")).sendKeys("asquared");

        //Enter 9049049044 in Phone - using descendant by label
        logger.info("Enter 9049049044 in Phone - using descendant by label");
        driver.findElement(By.xpath("//input[@name='phone']/../../descendant::td/input")).sendKeys("9049049044");

        //Select UNITED KINGDOM from Country
        logger.info("Select UNITED KINGDOM from Country");
        new Select(
                driver.findElement(By.xpath("//select[@name='country']"))

        ).selectByVisibleText("UNITED KINGDOM");


        //Click Submit
        logger.info("Click Submit");
        driver.findElement(By.xpath("//input[@name='register']")).click();

        //Verify "Dear asquare asquared," text is displayed
        logger.info("Verify Dear asquare asquared, text is displayed");
        driver.findElement(By.xpath("//b[contains(text(),'Dear asquared asquared,')]")).isDisplayed();

        //verify Sign-off link exists
        logger.info("verify Sign-off link exists");
        driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).isDisplayed();

        // Verify REGISTER image is displayed
        logger.info(" Verify REGISTER image is displayed");
        driver.findElement(By.xpath("//tr[2]//td[1]//table[1]//tbody[1]//tr[1]//td[2]")).isDisplayed();
        //click SIGN-OFF
        driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();


    }//method registration ends


}//class ends
