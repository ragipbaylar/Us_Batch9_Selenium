package Day02;

import Utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _03_FindElements {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/232258017946157");

        List<WebElement> labels = driver.findElements(By.className("form-label"));  // Locates all the elements that has the same locator
                                                                                    // and returns List<WebElements>  

        System.out.println("labels.size() = " + labels.size());

        for (WebElement label: labels){
            System.out.println("label.getText() = " + label.getText()); // getText() returns the visible text of an element if any
        }

        MyMethods.myWait(3);
        driver.quit();
    }
}
