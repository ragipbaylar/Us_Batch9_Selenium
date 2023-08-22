package Day05;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_StatusOfElement extends BaseDriver {

    // isDisplayed
    // isSelected
    // isEnabled

    @Test
    public void statusTest() {
        driver.get("https://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        WebElement monday = driver.findElement(By.xpath("//input[@type='checkbox']"));
        boolean isDisplayed = monday.isDisplayed();
        boolean isEnabled = monday.isEnabled();
        boolean isSelected = monday.isSelected();

        System.out.println("isDisplayed = " + isDisplayed);
        System.out.println("isEnabled = " + isEnabled);
        System.out.println("isSelected = " + isSelected);

        MyMethods.myWait(2);
        monday.click();
        boolean isSelected1 = monday.isSelected();
        System.out.println("isSelected1 = " + isSelected1);

        MyMethods.myWait(2);
        monday.click();
        boolean isSelected2 = monday.isSelected();
        System.out.println("isSelected2 = " + isSelected2);
        
        
        WebElement saturday = driver.findElement(By.id("gwt-debug-cwCheckBox-Saturday-input"));
        System.out.println("saturday.isEnabled() = " + saturday.isEnabled());

        waitAndQuit();
    }
}
