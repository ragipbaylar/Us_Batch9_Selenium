package Day09;

import Utilities.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _03_IFrame extends BaseDriver {

    /**
     * Go to "https://chercher.tech/practice/frames"
     * Type USA in the first box on the page
     * Check the checkbox
     * Select Avatar from animals
     **/

    @Test
    public void iFrameTest(){

        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0); // we are in the 1st frame

        WebElement topic = driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input[@type='text']"));
        topic.sendKeys("USA");

        driver.switchTo().frame(0); // we are in the inner frame. Index starts from 0 in every frame

        WebElement checkBox = driver.findElement(By.id("a"));
        checkBox.click();

//        driver.switchTo().parentFrame(); // it takes us one step back from the iframe
        driver.switchTo().defaultContent(); // takes us to the main page no matter how many frames we are in
//      We are on tha main page

        driver.switchTo().frame(1); // we are in the second frame

        WebElement animalSelect = driver.findElement(By.id("animals"));

        Select select = new Select(animalSelect);
        select.selectByIndex(3);

        driver.switchTo().parentFrame();

        waitAndQuit();
    }

}
