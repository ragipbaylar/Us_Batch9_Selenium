package Day06;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _04_ActionsDoubleClick extends BaseDriver {

    @Test
    public void doubleClickTest(){
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        MyMethods.myWait(2);

        Actions actions = new Actions(driver);
        Action action = actions.doubleClick(doubleClickButton).build();
        action.perform();

        waitAndQuit();
    }
}
