package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DropDownHandler;
import utilities.Waiter;

public class _07_DropDownTest extends Base {
    /*
    /*
    1. Go to https://www.facebook.com/
    2. Click on “Create New Account” link
    3. Enter below information and click on Sign Up button
    First name = John
    Last Name = Doe
    Email address = johndoe55555@gmail.com
    Password = abcd1234
    Birthday = April 1, 1990
    Gender = Male
    4. Validate below error message is displayed with
    expected text
    Please choose a more secure password. It should be
    longer than 6 characters, unique to you, and difficult
    for others to guess.
     */

    @Test(priority = 1, description = "TC001 Validate Facebook error message for password")
    public void testUnsecurePasswordErrorMessage() {
        driver.get("https://www.facebook.com");

        faceBookPage.createNewAccountLink.click();

        faceBookPage.firstName.sendKeys("John");
        Waiter.pause(2);
        faceBookPage.lastName.sendKeys("Doe");
        Waiter.pause(2);
        faceBookPage.emailAddress.sendKeys("johndoe55555@gmail.com");
        Waiter.pause(2);
        faceBookPage.emailConfig.sendKeys("johndoe55555@gmail.com");
        Waiter.pause(2);
        faceBookPage.password.sendKeys("abcd1234");

        // To be able to select an option from dropdown, we need an instance of Select class

//        Select monthSelector = new Select(faceBookPage.monthDropdown);
//        monthSelector.selectByVisibleText("Apr");
        DropDownHandler.selectOptionByVisibleText(faceBookPage.monthDropdown, "Apr");

//        Select daySelector = new Select(faceBookPage.dayDropdown);
//        daySelector.selectByValue("1");
        DropDownHandler.selectOptionByValue(faceBookPage.dayDropdown, "1");

//        Select yearSelector = new Select(faceBookPage.yearDropdown);
//        yearSelector.selectByValue("1990");
        DropDownHandler.selectOptionByValue(faceBookPage.yearDropdown, "1990");

        faceBookPage.genderRadioButtons.get(1).click();
        faceBookPage.signUp.click();


        String expectedText = "Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.";

        Waiter.waitUntilTextToBePresentInElement(driver, 60, faceBookPage.errorMessage, expectedText);
        Assert.assertEquals(faceBookPage.errorMessage.getText(), expectedText, "Invalid Result");

    }
        /*
        1. Go to https://www.expedia.com
        2. Select “Flights” from “More travel” dropdown
        3. Select “Premium economy” from “Economy”
        dropdown
        4. Validate “Premium economy” is selected
         */

    @Test(priority = 2, description = "TC002 Validate Expedia Dropdowns")
    public void validateExpediaDropDown() {
        driver.get("https://www.expedia.com");

        expediaPage.moreTravelDropdown.click();
        expediaPage.flights.click();
       // Waiter.pause(30);

        expediaPage.flightTypesDropdown.click();
        expediaPage.flightOptions.get(1).click();

        Assert.assertEquals(expediaPage.flightTypesDropdown.getText(), "Premium economy");
    }
    /*
    1. Go to https://www.ebay.com/
    2. Select “Art” from “All Categories”
    dropdown
    3. Click on “Search” button
    4. Validate “Welcome to eBay Art”
    heading1
    5. Validate “Find Prints, Paintings,
    Posters, and More.” heading2
    NOTE: Validation includes headings to be
    displayed and texts to be exactly matching
    above texts
     */

    @Test(priority = 3, description = "TC003 Validate Heading2")
    public void validateEbayDropDown(){
        driver.get("https://www.ebay.com/");

        ebayPage.allCategoriesDropDown.click();
        DropDownHandler.selectOptionByVisibleText(ebayPage.dropDownCategories, "Art");
        ebayPage.searchButton.click();

        String heading1 = "Welcome to eBay Art";
        String heading2 = "Find Prints, Paintings, Posters, and More.";

        Assert.assertTrue(ebayPage.heading1.isDisplayed());
        Assert.assertEquals(ebayPage.heading1.getText(), heading1);
        Assert.assertTrue(ebayPage.heading2.isDisplayed());
        Assert.assertEquals(ebayPage.heading2.getText(), heading2);
        }


    }




