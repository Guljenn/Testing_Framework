package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComfyEliteHomePage {

    public ComfyEliteHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[aria-label='Facebook Social Link']")
    public WebElement facebookIcon;


}
