package Day08;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _05_WaitExample1 extends BaseDriver {

    /**
     * Go to  "http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html"
     * Click on Timer Button
     * Verify that you see WebDriver text
     **/

    @Test
    public void waitTest(){
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        WebElement timerButton = driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        timerButton.click();

//        MyMethods.myWait(20);
        // it waits for entire 20 sec. Even though the text becomes WebDriver in 10 secs.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBe(By.id("demo"),"WebDriver"));
        // waits until the text of the element becomes WebDriver for 20 secs.
        // if it becomes WebDriver before 20 sec Selenium keeps running the code
        // if it doesn't become WebDriver in 20 secs it throws TimeOutException

        WebElement message = driver.findElement(By.id("demo"));
        String messageText = message.getText();
        System.out.println("messageText = " + messageText);

        Assert.assertEquals("WebDriver",messageText);

        waitAndQuit();

    }



}
