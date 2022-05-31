package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

                    /*
                    TC765: Validate Google search
                    1. Go to "https://www.google.com/"
                    2. Search for "Selenium"
                    3. Validate the results are more than zero
                     */

public class GoogleSearchPage {

    public  GoogleSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "input[class='gLFyf gsfi']")
    public WebElement searchInputBox;

    @FindBy(xpath = "//a[@class='MV3Tnb'][2]")
    public WebElement storeLink;
}

