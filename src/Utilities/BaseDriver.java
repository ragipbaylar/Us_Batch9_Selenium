package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static void getDriver(){
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // Expands the driver until the edges of the screen.

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        //
    }
}
