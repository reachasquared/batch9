package asquared;

import core.engine.global;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestXpathExamples extends global {
    /**
     * This class is aimed to demonstrate different ways of locating objects using xpath
     */
    @Test
    public void testXpathExamples() {
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

        //Enter asquared in Last Name - using following-sibling by label
        /*
            First located the object by label 'Last' > then move to grand parent using /..
            used following-sibling to locate input box

            <tr>
                <td align="right">
                    <font face="Arial, Helvetica, sans-serif" size="2">
                        <b>Last
                            Name: </b></font>
                </td>
                <td>
                  <input maxlength="60" name="lastName" size="20">
                </td>
            </tr>
         */
        driver.findElement(By.xpath(
                "//b[contains(text(),'Last')]/../../following-sibling::td/input"
        )).sendKeys("asquared");

        //Enter 9049049044 in Phone - using descendant by label
        /*
        * First located label 'Phone' then move back to great grand parent using /..
        * used descendant to locate the input box
        *
        * <tr>
            <td align="right"><font face="Arial, Helvetica, sans-serif" size="2"><b>Phone:</b></font></td>
            <td>
              <input maxlength="20" name="phone" size="15">
            </td>
          </tr>
        * */
        driver.findElement(By.xpath("//b[contains(text(),'Phone:')]/../../../descendant::td[2]/input"))
                .sendKeys("9049049044");

        //Select UNITED KINGDOM from Country
        /*
         * Located the element using name attribute > Converted the input element into Select object
         * then selected the option using selectByVisibleText method
         * */
        new Select(
                driver.findElement(By.xpath("//select[@name='country']"))
        ).selectByVisibleText("UNITED STATES ");

        //Verify SUBMIT Button exists
        /*
         * Located the button using 'src' attribute
         * */
        assertTrue(
                driver.findElement(By.xpath(
                        "//input[@src='/images/forms/submit.gif']"
                )).isDisplayed()
        );

        //Enter Asquared QA Automation in Address field
        /*
         * Located 'Address' label and used 'following'
         */
        //Cleared the input field
        driver.findElement(By.xpath("//b[contains(text(),'Address:')]/following::input[1]")).clear();
        // entering value
        driver.findElement(By.xpath("//b[contains(text(),'Address:')]/following::input[1]")).sendKeys("Asquared QA Automation");

        /*
         * Also in chropath test the below xpaths to understand it more
         *  1. //b[contains(text(),'Address:')]
         *  2. //b[contains(text(),'Address:')]/following::input
         *  3. //b[contains(text(),'Address:')]/following::input[1]
         *
         *  working with parent, preceding-sibling
         *
         *  4. //input[@name='confirmPassword']
         *  5. //input[@name='confirmPassword']/parent::td
         *  6. //input[@name='confirmPassword']/parent::td/preceding-sibling::td
         *  7. //input[@name='confirmPassword']/parent::td/preceding-sibling::td/font/b
         * */

    }
}
