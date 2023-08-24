package Day07;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _06_ActionsSendKey2 extends BaseDriver {

    @Test
    public void arrowKeysTest() {

        driver.get("https://demoqa.com/auto-complete");
        WebElement singleColorInput = driver.findElement(By.id("autoCompleteSingleContainer"));

        MyMethods.myWait(2);

        Actions actions = new Actions(driver);
        Action action = actions.click(singleColorInput).sendKeys("i").build();
        action.perform();

        MyMethods.myWait(2);

        action = actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
        action.perform();

//        action = actions.sendKeys(Keys.ARROW_DOWN).build();
//        action.perform();
//
//        MyMethods.myWait(2);
//
//        action = actions.sendKeys(Keys.ARROW_DOWN).build();
//        action.perform();
//
//        MyMethods.myWait(2);
//
//        action = actions.sendKeys(Keys.ENTER).build();
//        action.perform();

//        action = actions.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN)
//                .keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ENTER).build();
//        action.perform();

        waitAndQuit();
    }
}
