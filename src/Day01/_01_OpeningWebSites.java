package Day01;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class _01_OpeningWebSites {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Creates a ChromeDriver object and assigns it to driver variable
//        WebDriver driver1 = new SafariDriver();
//        WebDriver driver2 = new EdgeDriver();
//        WebDriver driver3 = new InternetExplorerDriver();
//        WebDriver driver4 = new FirefoxDriver();

        driver.get("https://www.google.com/"); // opens up the web page

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit(); // quits (closes) the driver completely
    }
}
