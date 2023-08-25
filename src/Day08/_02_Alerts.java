package Day08;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_Alerts extends BaseDriver {

    @Test
    public void alertTestDismissTest(){
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

        MyMethods.myWait(2);
        WebElement clickOnMeButton2 = driver.findElement(By.xpath("(//button[@class = \"btn btn-default btn-lg\"])[1]"));
        clickOnMeButton2.click();

        MyMethods.myWait(2);
        driver.switchTo().alert().dismiss(); // Switches to the alert and dismisses it by clicking on cancel button

        waitAndQuit();
    }
}
