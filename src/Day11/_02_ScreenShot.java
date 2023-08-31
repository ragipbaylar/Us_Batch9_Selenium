package Day11;

import Utilities.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class _02_ScreenShot extends BaseDriver {

    @Test
    public void takeScreenShot() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("dhfuryeta");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        try {
            WebElement dashboard = driver.findElement(By.cssSelector("h6[class*='oxd-topbar-header']"));

            Assert.assertTrue(dashboard.isDisplayed());
        }catch (NoSuchElementException e){
            LocalDateTime localDateTime = LocalDateTime.now(); // Gets the date and time of the bug
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd_yyyy_hh_mm_ss_SSS"); // puts the date and time in a format that is suitable for a file name
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // Takes the screenshot
            File screenshotInTemporaryFile = takesScreenshot.getScreenshotAs(OutputType.FILE); // Stores it in a temporary file
            FileUtils.copyFile(screenshotInTemporaryFile,new File("screenShots/screenshot"+localDateTime.format(formatter)+".png"));// Creates a png file and saves the screen to that file
        }

        waitAndQuit();
    }
}
