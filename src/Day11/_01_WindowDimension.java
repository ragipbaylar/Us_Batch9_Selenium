package Day11;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.Dimension;

public class _01_WindowDimension extends BaseDriver {

    @Test
    public void changeWindowSize(){
        driver.get("https://opensource-demo.orangehrmlive.com/");

        MyMethods.myWait(2);

        Dimension dimension = new Dimension(390,844);

        driver.manage().window().setSize(dimension);

        MyMethods.myWait(2);

        dimension = new Dimension(915,412);

        driver.manage().window().setSize(dimension);

        dimension = new Dimension(4000,3500);

        driver.manage().window().setSize(dimension);

        waitAndQuit();
    }
}
