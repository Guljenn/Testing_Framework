package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _04_GoogleSearchTest extends Base{

    @Test (priority = 1, description = "TC765: Validate Google search")
    public void testGoogleSearch(){
        driver.get("https://www.google.com");

        googleSearchPage.searchInputBox.sendKeys("Selenium" + Keys.ENTER);

        String results = googleSearchResultPage.resultTag.getText();
        Assert.assertTrue(Integer.parseInt(results.substring(results.indexOf(" ")+1, results.indexOf("results")-1).replace(",", "")) > 0);


    }

    /*
    1. Go to https://www.google.com/
    2. Click on Store Link
    3. Validate that the title is "Google Store for Google Made Devices & Accessories"
     */


    @Test(priority = 2, description = "TC123: Validate Google Store link")
    public void testGoogleStoreLink(){
        driver.get("https://www.google.com");

        Waiter.waitForVisibilityOfWebElement(driver, googleSearchPage.storeLink, 30);

        googleSearchPage.storeLink.click();

        // Throws exception - use explicit wait to resolve issue

        // Creating your own utility method
        Waiter.waitUntilTitleIs(driver, 30, "Google Store for Google Made Devices & Accessories");

        Assert.assertEquals(driver.getTitle(), "Google Store for Google Made Devices & Accessories");

    }

}
