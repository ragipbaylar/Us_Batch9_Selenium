package Day09;

import Utilities.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _02_IFrame extends BaseDriver {

    /**
     * Go to "https://chercher.tech/practice/frames"
     * Type USA in the first box on the page
     * Select Avatar from animals
     **/

    @Test
    public void IFrameTest() {
        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0); // switch to an iframe by using its index. This is the fastest way.

//        driver.switchTo().frame("frame1"); // switch to an iframe by using its name or id. It works slower than index

//        WebElement iFrame = driver.findElement(By.id("frame1"));
//        driver.switchTo().frame(iFrame);

        WebElement topic = driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input[@type='text']"));
        topic.sendKeys("USA");

        driver.switchTo().parentFrame(); // it takes us one step back from the iframe

        driver.switchTo().frame(1);

        WebElement animalSelect = driver.findElement(By.id("animals"));

        Select select = new Select(animalSelect);
        select.selectByIndex(3);

        driver.switchTo().parentFrame();

        waitAndQuit();
    }
}
