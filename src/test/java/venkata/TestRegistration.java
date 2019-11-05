package venkata;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class TestRegistration extends global { //class beigns
@Test
public void registration () {// method begins



    // Go to newtours website
    logger.info("Go to newtours website");
    driver.get(baseUrl);

    //verify page title is "Welcome: Mercury Tours"
    logger.info("verify page title is \"Welcome: Mercury Tours\"");
    assertEquals("Welcome: Mercury Tours", driver.getTitle());


    //Verify REGISTER link is present
    logger.info("Verify REGISTER link is present");
    assertEquals();
    driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();


    //Click on REGISTER link
    logger.info("Click on REGISTER link");
    driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();

    //Enter asquared in First Name
    logger.info("Enter asquared in First Name");
    driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("asquared");

    //Enter asquared in Last Name
    logger.info("Enter asquared in Last Name");
    driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("asquared");

    //Enter 9049049044 in Phone
    logger.info("Enter 9049049044 in Phone");
    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9049049044");

    //Select UNITED KINGDOM from Country
    logger.info("Select UNITED KINGDOM from Country");
    driver.findElement(By.xpath("//select[@name='country']")).sendKeys("UNITED KINGDOM");
    //Click Submit
    logger.info("Click Submit");
    driver.findElement(By.xpath("//input[@name='register']")).click();

    //Verify "Dear asquare asquared," text is displayed
    logger.info("Verify \"Dear asquare asquared,\" text is displayed");
    driver.findElement(By.xpath(""));
     //verify Sign-off link exists
    logger.info("verify Sign-off link exists");

    // Verify REGISTER image is displayed
    logger.info("Verify REGISTER image is displayed");

    //click SIGN-OFF
    logger.info("click SIGN-OFF");


}//method ends

    private void assertEquals(String s, String title) {
    }

    private void assertEquals() {
    }
} //class ends

