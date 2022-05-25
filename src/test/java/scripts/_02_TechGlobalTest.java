package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class _02_TechGlobalTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }

    @Test
    public void testApplicationFormHeading(){
        driver.get("https://www.techglobalschool.com/apply-now");


        String expectedHeading = "Application Form"; // requirement
        WebElement heading = driver.findElement(By.tagName("h1"));

        Assert.assertEquals(heading.getText(), expectedHeading);
    }

    @AfterMethod
    public void teardown () {
        Driver.quitDriver();
    }






}
