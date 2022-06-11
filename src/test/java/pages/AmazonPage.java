package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    public AmazonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "glow-ingress-line2")
    public WebElement selectAddressLink;

    @FindBy(css = "div[class='a-popover-wrapper']")
    public WebElement popUpAlert;

    @FindBy(tagName = "h4")
    public WebElement heading4;

    @FindBy(css = "input[class='GLUX_Full_Width a-declarative']")
    public WebElement zipCodeInputBox;

    @FindBy(css = "div[class='a-row a-spacing-top-micro']")
    public WebElement messageDisplay;

    @FindBy(css = "div[class='a-column a-span4 a-span-last']")
    public WebElement applyButton;
}
