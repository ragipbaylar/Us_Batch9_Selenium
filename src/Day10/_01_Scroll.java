package Day10;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _01_Scroll extends BaseDriver {

    @Test
    public void scrollTest() {
        driver.get("https://p-del.co/");

        WebElement imgWithOrange = driver.findElement(By.xpath("//img[@data-gallery-uid='218']"));

        MyMethods.myWait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", imgWithOrange);

        waitAndQuit();
    }

    @Test
    public void javaScriptClickTest() {
/**
 * Go to "https://www.selenium.dev/"
 * Click on all of the links that opens up a new tab except the ones that has "mailto" word in their href attribute
 * Print out titles and urls of them
 * Then close them one by one except the main
 * Print the title and url of the main tab
 * Then close it.
 * **/

        driver.get("https://www.selenium.dev/");

        List<WebElement> urls = driver.findElements(By.xpath("//a[@target='_blank']"));

        String mainTabId = driver.getWindowHandle();

        for (WebElement url : urls) { // clicks on all links without mailto word in href attribute
            if (!url.getAttribute("href").contains("mailto")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", url); // Javascript click.
                // We use it when selenium regular click is not able to click on the element
                MyMethods.myWait(2);
            }
        }

        Set<String> tabIds = driver.getWindowHandles();

        for (String id: tabIds){ // switches to all tabs except the main tab and gets url and title of them
            if (!id.equals(mainTabId)){
                driver.switchTo().window(id);
                System.out.println("driver.getTitle() = " + driver.getTitle());
                System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            }
        }

        for (String id: tabIds){ // closes all tabs except the main tab
            if (!id.equals(mainTabId)){
                driver.switchTo().window(id);
                driver.close();
                MyMethods.myWait(2);
            }
        }

        driver.switchTo().window(mainTabId);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        waitAndQuit();
    }
}
