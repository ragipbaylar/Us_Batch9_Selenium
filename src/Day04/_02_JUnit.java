package Day04;

import Utilities.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;

public class _02_JUnit extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://formsmarts.com/form/yu?mode=h5");
        WebElement businessRadioButton = driver.findElement(By.cssSelector("input[value=\"Business\"]"));
        businessRadioButton.click();

        WebElement DiscoverXYZ = driver.findElement(By.cssSelector("div[id=\"section_1\"]>select[aria-required=\"true\"]"));
        DiscoverXYZ.click();

        WebElement onlineAdvertising = driver.findElement(By.cssSelector("div[id=\"section_1\"]>select[aria-required=\"true\"]>:nth-child(4)"));
        onlineAdvertising.click();

        WebElement howOften = driver.findElement(By.cssSelector("input[value=\"Every Day\"]"));
        howOften.click();

        WebElement yourExperience = driver.findElement(By.cssSelector("input[value=\"Good\"]"));
        yourExperience.click();

        WebElement howLong = driver.findElement(By.cssSelector("select[id=\"u_cQ9_4597\"]"));
        howLong.click();

        WebElement howLongOption = driver.findElement(By.cssSelector("option[value*=\"month\"]"));
        howLongOption.click();

        Assert.assertTrue(businessRadioButton.isSelected());
        Assert.assertTrue(howOften.isSelected());
        Assert.assertTrue(yourExperience.isSelected());

        waitAndQuit();

    }
}
