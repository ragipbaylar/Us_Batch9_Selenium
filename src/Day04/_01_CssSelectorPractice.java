package Day04;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_CssSelectorPractice extends BaseDriver {
    /**
     * Go to "https://formsmarts.com/form/yu?mode=h5"
     * Select Business
     * Click on Discover XYZ and select Online Advertising
     * Select Every Day
     * Select Good
     * Click on XYZ and select the 3rd option
     * Use Css Selector only
     **/
    public static void main(String[] args) {
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

        if (businessRadioButton.isSelected()){
            System.out.println("Test is passed");
        }else {
            System.out.println("Test is failed");
        }

        if (howOften.isSelected()){
            System.out.println("Test is passed");
        }else {
            System.out.println("Test is failed");
        }

        if (yourExperience.isSelected()){
            System.out.println("Test is passed");
        }else {
            System.out.println("Test is failed");
        }

        waitAndQuit();


    }
}
