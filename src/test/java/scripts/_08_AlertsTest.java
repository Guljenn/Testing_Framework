package scripts;


import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AlertHandler;

public class _08_AlertsTest extends Base {

    /*
    1. Go to https://www.etsy.com/
    2. Click on ”Sign in” button
    3. Validate “Sign in” modal is displayed
    4. Validate heading1 of the modal is “Sign in”
     */

    @Test(priority = 1, description = "TC001")
    public void testEtsySignInModal(){
        driver.get("https://www.etsy.com/");
        etsySearchPage.signInButton.click();
        Assert.assertTrue(etsySearchPage.signInModalHeading.isDisplayed());
        Assert.assertEquals(etsySearchPage.signInModalHeading.getText(), "Sign in");
    }

    /*
    1. Go to http://the-internet.herokuapp.com/
    2. Click on “JavaScript Alerts” link
    3. Click on “Click for JS Alert” button
    4. Validate the text of the alert displayed is “I am a JS
    Alert”
    5. Click on ”OK” button on the alert
    6. Validate “You successfully clicked an alert”
    message is displayed with its text
     */
    @Test(priority = 2, description = "TC002")
    public void testInformationWarningAlert(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("JavaScript Alerts"); // click on the link
        heroAppPage.clickOnAlertButton("Click for JS Alert"); // click on the alert tab
        Alert alert = driver.switchTo().alert(); // alert pops up so this is for switching driver focus to alert
        Assert.assertEquals(alert.getText(), "I am a JS Alert"); // validating the text from the alert
        alert.accept(); // this is for clicking ok
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You successfully clicked an alert"); // validating the text after you click ok

    }

    /*
    1. Go to http://the-internet.herokuapp.com/
    2. Click on “JavaScript Alerts” link
    3. Click on “Click for JS Confirm” button
    4. Validate the text of the alert displayed is “I am a JS
    Confirm”
    5. Click on ”Cancel” button on the alert
    6. Validate “You clicked: Cancel” message is
    displayed with its text
    7. Click on “Click for JS Confirm” button again
    8. Click on ”OK” button on the alert
    9. Validate “You clicked: Ok” message is displayed
    with its text
     */
    @Test(priority = 3, description = "TC003")
    public void testConfirmationAlert(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("JavaScript Alerts");
        heroAppPage.clickOnAlertButton("Click for JS Confirm");
        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm"); // switching window and validating text
        driver.switchTo().alert().dismiss(); // dismiss is cancel
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You clicked: Cancel");
        heroAppPage.clickOnAlertButton("Click for JS Confirm");
        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm");
        driver.switchTo().alert().accept();
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You clicked: Ok");
    }

    /*
            1. Go to http://the-internet.herokuapp.com/
        2. Click on “JavaScript Alerts” link
        3. Click on “Click for JS Prompt” button
        4. Validate the text of the alert displayed is “I
        am a JS prompt”
        5. Click on ”Cancel” button on the alert
        6. Validate “You entered: null” message is
        displayed with its text
        7. Click on “Click for JS Prompt” button again
        8. Type “Hello” in the alert input box
        9. Click on ”OK” button on the alert
        10. Validate “You entered: Hello” message is
        displayed with its text
     */
        @Test(priority = 4, description = "TC004" )
        public void testPromptAlert(){
            driver.get("http://the-internet.herokuapp.com/");
            heroAppPage.clickOnLink("JavaScript Alerts");
            heroAppPage.clickOnAlertButton("Click for JS Prompt");

            Assert.assertEquals(AlertHandler.getAlertSText(driver), "I am a JS prompt");
            AlertHandler.dismissAlert(driver);
            Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You entered: null");
            heroAppPage.clickOnAlertButton("Click for JS Prompt");
            AlertHandler.sendKeysToAlert(driver, "Hello");
            AlertHandler.acceptAlert(driver);
            Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You entered: Hello");
        }
          /*
            TASK-5 - Amazon Address Modal
            Go to https://www.amazon.com/
            Click on "Select your address" link in the top navigation bar
            Validate "Choose your location" modal is displayed
            Enter your zip code to input box
            Click on "Apply" button
            Validate the zip code entered displayed in the delivery message
             */

    @Test(priority = 5, description = "TASK-5 - Amazon Address Modal")
    public void testAmazonAddressModal(){
        driver.get("https://www.amazon.com/");
        amazonPage.selectAddressLink.click();
        Assert.assertTrue(amazonPage.popUpAlert.isDisplayed());
        Assert.assertTrue(amazonPage.heading4.isDisplayed() && amazonPage.heading4.getText().equals("Choose your location"));
        amazonPage.zipCodeInputBox.sendKeys("60585");
        amazonPage.applyButton.click();
        Assert.assertTrue(amazonPage.messageDisplay.isDisplayed());

        //Assert.assertTrue(amazonHomePage.messageDisplay.getText().contains(zipCode));


    }


}