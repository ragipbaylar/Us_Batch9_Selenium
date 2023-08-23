package Day06;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _03_ActionsSingleClick extends BaseDriver {

    @Test
    public void singleClickTest(){
        driver.get("https://demoqa.com/buttons");

        WebElement singleClickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

        MyMethods.myWait(2);

        Actions actions = new Actions(driver);

        Action action = actions.click(singleClickButton).build(); // Selenium prepares the action for us and waits to perform it
        action.perform(); // can perform same action multiple times
//        action.perform();
//        action.perform();

//        actions.click(singleClickButton).build().perform(); // to perform the same action you need to type entire line again

        waitAndQuit();

    }
}
