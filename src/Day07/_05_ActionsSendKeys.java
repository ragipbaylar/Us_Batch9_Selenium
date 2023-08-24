package Day07;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _05_ActionsSendKeys extends BaseDriver {

    @Test
    public void sendKeysTest(){
        driver.get("https://demoqa.com/auto-complete");

        MyMethods.myWait(2);
        WebElement singleColorInput = driver.findElement(By.id("autoCompleteSingleContainer"));

        Actions actions = new Actions(driver);
        Action action = actions.click(singleColorInput).
                keyDown(Keys.SHIFT).sendKeys("b").
                keyUp(Keys.SHIFT).sendKeys("lack").build();

        action.perform();

        MyMethods.myWait(2);

//        action = actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build(); // keyDown: presses a button and holds it
                                                                          // keyUp: Releases the button
        action = actions.sendKeys(Keys.ENTER).build(); // sendKeys: just hits the button like regular typing. Doesn't hold the button
        action.perform();

        waitAndQuit();





    }
}
