package Day07;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _03_ActionsDragAndDrop extends BaseDriver {

    @Test
    public void dragAndDropTest() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement norway = driver.findElement(By.id("box101"));

        MyMethods.myWait(2);

        Actions actions = new Actions(driver);
        Action action = actions.dragAndDrop(oslo, norway).build();
        action.perform();

        MyMethods.myWait(2);

        WebElement washington = driver.findElement(By.id("box3"));
        WebElement usa = driver.findElement(By.id("box103"));

        action = actions.clickAndHold(washington).moveToElement(usa).release().build(); // Does the same thing in a different way. Repeats human behaviour.
        action.perform();

        String backGroundColorOfWashington = washington.getCssValue("background-color"); // gives any style attribute of the element
        System.out.println("backGroundColorOfWashington = " + backGroundColorOfWashington);

        Assert.assertTrue(backGroundColorOfWashington.equals("rgba(0, 255, 0, 1)"));

        waitAndQuit();
    }
}
