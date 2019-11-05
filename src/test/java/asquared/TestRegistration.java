package asquared;

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
        logger.info("verify page title is \"Welcome: Mercury Tours\"");
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
        driver.findElement(By.xpath("//b[contains(text(),'Last')]/../../following-sibling::td/input")).sendKeys("asquared");

        //Enter 9049049044 in Phone - using descendant by label
        driver.findElement(By.xpath("//b[contains(text(),'Phone:')]/../../../descendant::td[2]/input"))
                .sendKeys("9049049044");

        //Select UNITED KINGDOM from Country
        new Select(driver.findElement(By.xpath("//select[@name='country']"))).selectByVisibleText("UNITED STATES ");

        //Click Submit

        //Verify "Dear asquare asquared," text is displayed

        //verify Sign-off link exists

        // Verify REGISTER image is displayed

        //click SIGN-OFF


    }//method registration ends

}//class ends

