package Day07;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _02_ActionsHoverOver extends BaseDriver {

    /**
     * Go to "https://www.ebay.com/"
     * Hover over Electronics menu
     * Click on Headphones
     * Assert that the url contains Headphones keyword
     **/

    @Test
    public void hoverOverTest() {
        driver.get("https://www.ebay.com/");

        WebElement electronics = driver.findElement(By.linkText("Electronics"));

        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(electronics).build();
        action.perform();

        MyMethods.myWait(2);

        WebElement headphones = driver.findElement(By.xpath("//a[text()='Headphones']"));
        headphones.click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("Headphones"));

        waitAndQuit();

    }
}













