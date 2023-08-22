package Day05;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _03_SelectClass extends BaseDriver {
    /**
     * What is Select Class?
     * It is a class that allows us to handle select tags
     * We create a Select object and then we use this object to handle select elements
     **/

    @Test
    public void test1() {
        driver.get("https://formsmarts.com/form/yu?mode=h5");
        MyMethods.myWait(2);
        WebElement discoverXYZ = driver.findElement(By.id("u_oAd_4588"));

        Select select = new Select(discoverXYZ);
//        select.selectByVisibleText("Referred by Existing Customer");
//        select.selectByValue("Offline Advertising");

        int randomIndex = ((int)(Math.random()*5))+1;
        select.selectByIndex(randomIndex);

    }

}
