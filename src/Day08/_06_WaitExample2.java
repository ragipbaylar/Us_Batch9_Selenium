package Day08;

import Utilities.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _06_WaitExample2 extends BaseDriver {

    /**
     * Go to http://demo.seleniumeasy.com/ajax-form-submit-demo.html
     * Type Name and a Comment
     * Click on Submit Button
     * Verify you see "Success" keyword.
     **/

    @Test
    public void waitTest() {
        driver.get("http://demo.seleniumeasy.com/ajax-form-submit-demo.html");

        WebElement nameInput = driver.findElement(By.id("title"));
        nameInput.sendKeys("Batch 9");

        WebElement commentInput = driver.findElement(By.id("description"));
        commentInput.sendKeys("We are coming!!!");

        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.id("submit-control"),"Form submited Successfully!"));

        WebElement successMessage = driver.findElement(By.id("submit-control"));

        Assert.assertTrue(successMessage.getText().contains("Successfully"));

        waitAndQuit();
    }

    //Homework

    /**
     * Go to "https://www.demoblaze.com/index.html"
     * Click on Samsung Galaxy s6
     * Click on "Add to Cart"
     * Close the alert
     * Click on Product Store to go back to the main page
     * Verify that you are on the main page
     **/

}
