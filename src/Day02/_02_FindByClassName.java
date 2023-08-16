package Day02;

import Utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_FindByClassName {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/232258017946157");

        WebElement firstName = driver.findElement(By.className("form-textbox"));
        // there might be multiple elements with the same locator
        // in this case Selenium returns the first one in the html code
        MyMethods.myWait(3);
        firstName.sendKeys("John");
//        driver.findElement(By.className("form-textbox")).sendKeys("John");
        MyMethods.myWait(3);
        driver.quit();


    }
}
