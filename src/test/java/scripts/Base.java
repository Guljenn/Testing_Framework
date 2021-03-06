package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    SoftAssert softAssert;
    EtsySearchPage etsySearchPage;
    TGApplicationPage tgApplicationPage;
    GoogleSearchPage googleSearchPage;
    GoogleSearchResultPage googleSearchResultPage;
    HeroAppPage heroAppPage;
    FaceBookPage faceBookPage;
    ExpediaPage expediaPage;
    EbayPage ebayPage;
    AmazonPage amazonPage;
    RediffHomePage rediffHomePage;
    TGHomePage tgHomePage;
    ComfyEliteHomePage comfyEliteHomePage;



    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait = new FluentWait(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        etsySearchPage = new EtsySearchPage(driver);
        tgApplicationPage = new TGApplicationPage(driver);
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        heroAppPage = new HeroAppPage(driver);
        faceBookPage = new FaceBookPage(driver);
        expediaPage = new ExpediaPage(driver);
        ebayPage = new EbayPage(driver);
        amazonPage = new AmazonPage(driver);
        rediffHomePage = new RediffHomePage(driver);
        tgHomePage = new TGHomePage(driver);
        comfyEliteHomePage = new ComfyEliteHomePage(driver);



    }

    @AfterMethod
    public void teardown(){
        // TODO build a method that will take a screenshot of failures
        softAssert.assertAll();

        Driver.quitDriver();
    }
}
