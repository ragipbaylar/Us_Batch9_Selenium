package Day08;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _03_Alerts extends BaseDriver {

    /**
     * Go to "http://demo.seleniumeasy.com/javascript-alert-box-demo.html"
     * Click on Click for Prompt Box Button
     * Type your message
     * Click on OK
     * Verify that you see your message.
     **/

    @Test
    public void sendKeysToAlertTest() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

        MyMethods.myWait(2);
        WebElement clickForPromptButton = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        clickForPromptButton.click();
        String ourMessage = "Our Batch is the Best";

        MyMethods.myWait(2);
        driver.switchTo().alert().sendKeys(ourMessage);

        MyMethods.myWait(2);
        driver.switchTo().alert().accept();

        WebElement message = driver.findElement(By.id("prompt-demo"));

        Assert.assertTrue(message.getText().contains(ourMessage));

        waitAndQuit();

    }
}
