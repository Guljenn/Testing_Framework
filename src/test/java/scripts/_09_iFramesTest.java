package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _09_iFramesTest extends Base{

    /*
    Go to http://the-internet.herokuapp.com/
    Click on "Frames" link
    Click on "iFrame" link
    Clear text "Your content goes here." in the content box
    Enter "Hello World" in the content box
    Validate the text of the content box is "Hello World"
    Validate the heading3 as "An iFrame containing the TinyMCE WYSIWYG Editor"
     */

    @Test(priority = 1)
    public void testIFrame1(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Frames");

        heroAppPage.iFrameLink.click();


        //switch to inner html - iframe
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("mce_0_ifr");
        driver.switchTo().frame(heroAppPage.innerIFrame);

        heroAppPage.contentBox.clear();

        heroAppPage.contentBox.sendKeys("Hello World");
        Assert.assertEquals(heroAppPage.contentBox.getText(), "Hello World");

        //Switch back to parent html - outer
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        Assert.assertEquals(heroAppPage.iFrameHeading3.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
    }
    /*
    1.Go to https://www.rediff.com/
    2.Validate money iFrame displayed with cell one and cell two
     */

    @Test(priority = 2)
    public void testMoneyIFrame(){

        driver.get("https://www.rediff.com/");

        driver.switchTo().frame(0);

        Assert.assertTrue(rediffHomePage.iFrame1.isDisplayed());
        Assert.assertTrue(rediffHomePage.iFrame2.isDisplayed());

    }

//    @FindBy(css = "div[class^='cell']")
//    public List<WebElement> moneyCells;

//      driver.get("https://www.rediff.com/");
//
//    driver.switchTo().frame(rediffHomePage.moneyIFrame);
//    //driver.switchTo().frame(0);
//    //driver.switchTo().frame("moneyiframe");
//
//    for(WebElement element : rediffHomePage.moneyCells){
//        Assert.assertTrue(element.isDisplayed());
}
