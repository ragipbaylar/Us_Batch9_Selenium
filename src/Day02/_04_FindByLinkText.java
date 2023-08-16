package Day02;

import Utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _04_FindByLinkText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        String url1 = driver.getCurrentUrl(); // gets the current url on the browser

        WebElement careersLink = driver.findElement(By.linkText("Careers")); // we use it for a tag elements. Locates the elements by using their visible text

        System.out.println("careersLink.getText() = " + careersLink.getText());

        System.out.println("careersLink.getAttribute(\"href\") = " + careersLink.getAttribute("href")); // gets the specified attribute
        System.out.println("careersLink.getAttribute(\"class\") = " + careersLink.getAttribute("class"));

        careersLink.click(); // Clicks on the element

        String url2 = driver.getCurrentUrl(); // gets the current url on the browser
        System.out.println("url = " + url2);

        if (!url1.equals(url2)){
            System.out.println("test is passed");
        }else {
            System.out.println("test is failed");
        }

        MyMethods.myWait(3);
        driver.quit();

    }
}
