package Day03;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_Navigate extends BaseDriver {

    public static void main(String[] args) {
       driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyMethods.myWait(3);
        WebElement element = driver.findElement(By.id("alerttest"));
        element.click();

        // navigate keeps the history of the browser
        // and takes us back and forth between the page in the history

        MyMethods.myWait(3);
        driver.navigate().back(); // Takes us to the previous page like we are using the arrow buttons
        MyMethods.myWait(3);
        driver.navigate().forward(); // Takes us to the forward page like we are using the arrow buttons

        waitAndQuit();
    }
}
