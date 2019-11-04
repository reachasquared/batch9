package Swetha;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;


import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestRegistrationXpath extends global
{
    @Test
    public void registrationXpath()
    {
        // Go to newtours website
        logger.info("step 1:Go to newtours website ");
        driver.get(baseUrl);

        //verify page title is "Welcome: Mercury Tours"
        logger.info("step 2:verify page title is Welcome: Mercury Tours");
        assertEquals("Welcome: Mercury Tours",driver.getTitle());


        //Verify REGISTER link is present using WebDriver linktext method
        logger.info("step3 :Verify REGISTER link is present using WebDriver linktext method");
        assertTrue(driver.findElement(By.linkText("REGISTER")).isDisplayed());

        //Click on REGISTER link using xpath
        logger.info("step4: Click on REGISTER link using xpath");
       driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();

        //Enter asquared in First Name - using xpath @name
        logger.info("step 5:Enter asquared in First Name - using xpath @name");
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("asquared");

        //Enter asquared in Last Name - using following-sibling by label
        logger.info("step 6:Enter asquared in Last Name - using following-sibling by label ");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("asquared");

        //Enter 9049049044 in Phone - using descendant by label
        logger.info("step 7:Enter 9049049044 in Phone - using descendant by label ");
       // driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[5]/td[1]/form[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]")).sendKeys("9049049044");
        driver.findElement(By.xpath("/descendant :: input[@name='phone']")).sendKeys("9049049044");

        //Select UNITED KINGDOM from Country
        logger.info("step 8 :Select UNITED KINGDOM from Country");
        driver.findElement(By.xpath("//select[@name='country']")).sendKeys("UNITED KINGDOM");


        //Click Submit
        logger.info("step 9:Click Submit ");
       // driver.findElement(By.name("register")).click();
        driver.findElement(By.xpath("//input[@name='register']")).click();

        //Verify "Dear asquare asquared," text is displayed
        logger.info("step 10 :Verify \"Dear asquare asquared,\" text is displayed ");
      // assertTrue(driver.findElement(By.cssSelector("tr:nth-child(3) td:nth-child(1) p:nth-child(1) font:nth-child(1) > b:nth-child(1)")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Dear asquared asquared,')]")).isDisplayed());

        //verify Sign-off link exists
        logger.info("step 11:verify Sign-off link exists ");
       // assertTrue(driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).isDisplayed());
      //  assertTrue(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td.mouseOut:nth-child(1) > a:nth-child(1)")).isDisplayed());


        // Verify REGISTER image is displayed
        logger.info("step 12: Verify REGISTER image is displayed");
        assertTrue(driver.findElement(By.xpath("//img[@src='/images/masts/mast_register.gif']")).isDisplayed());

       //  assertTrue(driver.findElement(By.cssSelector("img[src^=\"/images/masts/mast_register.gif\"")).isDisplayed());

        //click SIGN-OFF
        logger.info("step 13:click SIGN-OFF");
        driver.findElement(By.linkText("SIGN-OFF")).click();
      //  driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
        //driver.findElement(By.cssSelector("table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td.mouseOut:nth-child(1) > a:nth-child(1)")).click();

    }


}
