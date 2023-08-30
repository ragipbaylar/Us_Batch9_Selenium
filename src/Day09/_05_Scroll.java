package Day09;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class _05_Scroll extends BaseDriver {

    // We use scroll to load more elements or to be able to see the element that are hidden unless you scroll down

    // We use JavaScriptExecutor interface to perform scroll

//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("window.scrollTo(0, 3000)") -> Scrolls down to 3000th pixel. The first number represents horizontal line, the second number represents vertical line;
//    js.executeScript("window.scrollBy(0, 3000);")
//    js.executeScript("window.scrollTo(0, document.body.scrollHeight);") -> scrolls down to the end of the page right away


    @Test
    public void scrollTest(){
        driver.get("https://p-del.co/");

        MyMethods.myWait(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 5000)"); // takes us to the 5000th pixel
        MyMethods.myWait(2);
//        js.executeScript("window.scrollTo(0, 5000)"); // this doesn't move because it is already on 5000th pixel
//        js.executeScript("window.scrollTo(0, 2000)"); // takes us to the 2000th back

        js.executeScript("window.scrollBy(0, 3000);"); // scrolls down by 3000 pixels whenever we use it
        MyMethods.myWait(2);
        js.executeScript("window.scrollBy(0, -8000);");

        MyMethods.myWait(2);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); // scrolls down to the end of the page

        MyMethods.myWait(2);
        js.executeScript("window.scrollTo(0, 0)"); // Takes us to the top of the page

        waitAndQuit();
    }

}
