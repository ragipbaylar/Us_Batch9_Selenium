package Day06;

import Utilities.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class _01_SelectPractice extends BaseDriver {
    /**
     * Go to https://www.facebook.com/
     * Click on Create New Account
     * Enter name, lastname and email
     * Verify that an input is displayed that says enter your email again
     * and it was not there at the beginning
     * Re-enter your email
     * Create a password
     * Select date of birth
     * Select Gender
     * And Verify it is selected
     **/

    @Test
    public void faceBookSignUpTest() {
        driver.get("https://www.facebook.com/");
        WebElement createAccount = driver.findElement(By.cssSelector("a[data-testid^='open-registration']"));
        createAccount.click();

        WebElement name = driver.findElement(By.name("firstname"));
        name.sendKeys("Batch 9");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("The Best");

        WebElement email = driver.findElement(By.cssSelector("input[aria-label^=\"Mobile number\"]"));
        email.sendKeys("batch9@gmail.com");

        WebElement emailConfirm = driver.findElement(By.cssSelector("input[aria-label=\"Re-enter email\"]"));
        Assert.assertTrue(emailConfirm.isDisplayed());

        emailConfirm.sendKeys("batch9@gmail.com");

        WebElement password = driver.findElement(By.id("password_step_input"));
        password.sendKeys("batch91234");

//--------------Selecting random month
        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        int randomIndex = (int) (Math.random() * 12); // Math.random() -> 0-0.999999999999999   (int)11.99999999 = 11
        selectMonth.selectByIndex(randomIndex);

//---------------Selecting random day
        WebElement day = driver.findElement(By.cssSelector("select[id=\"day\"]"));
        Select selectDay = new Select(day);

        List<WebElement> listOfDays = driver.findElements(By.cssSelector("select[id=\"day\"]>option"));
        randomIndex = (int) (Math.random() * listOfDays.size());
        selectDay.selectByIndex(randomIndex);

//---------------Selecting random year
        WebElement year = driver.findElement(By.cssSelector("select[id=\"year\"]"));
        Select selectYear = new Select(year);

        List<WebElement> listOfYears = driver.findElements(By.cssSelector("select[id=\"year\"]>option"));
        randomIndex = (int) (Math.random() * listOfYears.size());
        selectYear.selectByIndex(randomIndex);

//---------------Selecting random gender
        List<WebElement> listOfSex = driver.findElements(By.xpath("//label[text()='Female' or text()='Male']/following-sibling::input"));
        randomIndex = (int) (Math.random() * listOfSex.size());
        listOfSex.get(randomIndex).click();

        Assert.assertTrue(listOfSex.get(randomIndex).isSelected());

        waitAndQuit();
    }

}
