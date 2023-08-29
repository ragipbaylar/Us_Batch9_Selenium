package Day09;

import Utilities.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class _04_Window extends BaseDriver {
    /**
     * Go to "https://www.selenium.dev/"
     * Click on Watch the videos
     * Print the title and url of new tab
     * Close the new tab
     **/

    @Test
    public void windowTest() {
        driver.get("https://www.selenium.dev/");

        String mainTabId = driver.getWindowHandle(); // each tab has a unique id(window handle). we can get the id of the first tab with this method
        System.out.println("mainTabId = " + mainTabId);

        WebElement watchTheVideos = driver.findElement(By.xpath("//a[text()='Watch the Videos']"));
        watchTheVideos.click();

        Set<String> idNumbersOfAllTabs = driver.getWindowHandles(); // gives us ids of all open tabs together

        for (String id : idNumbersOfAllTabs) {
            System.out.println("id = " + id);
        }

        for (String id : idNumbersOfAllTabs) { // we compare all ids with the id of the first tab. if they are different switch to that tab
            if (!id.equals(mainTabId)) {
                driver.switchTo().window(id);
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.close(); // closes the current tab which is the 2nd tab

//        System.out.println("driver.getTitle() = " + driver.getTitle());
//        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        // The above souts throws NoSuchWindowException. Because we closed the second tab but driver is still on that tab.
        // It doesn't switch to the first tab automatically. To be able to work on it we should switch to it by using its id.

        driver.switchTo().window(mainTabId); // switched to the 1st tab

        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        waitAndQuit();
    }

}
