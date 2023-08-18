package Day03;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _02_CssSelector extends BaseDriver {
    /**
     * Go to "http://demo.seleniumeasy.com/basic-first-form-demo.html"
     * Type your message into the input box
     * Click on Show Message button
     * Check if the message shown next to Your Message and the message you sent are the same
     * Locate elements by Css Selector
     **/
    public static void main(String[] args) {
//        tagName[attribute='value']
//        tagName[attribute='value'][attribute='value'].......
//        tagName[attribute='value']>[attribute='value'].......
//        [attribute='value']

        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
        WebElement messageInput = driver.findElement(By.cssSelector("input[id=\"user-message\"]"));
        String enteredMessage = "Hello Batch 9";
        messageInput.sendKeys(enteredMessage);

        WebElement showMessageButton = driver.findElement(By.cssSelector("button[onclick=\"showInput();\"]"));
        showMessageButton.click();

        WebElement displayedMessage = driver.findElement(By.cssSelector("span[title=\"text message\"]"));

        if (displayedMessage.getText().equals(enteredMessage)){
            System.out.println("Test is passed");
        }else {
            System.out.println("Test is failed");
        }

        waitAndQuit();
    }
}
