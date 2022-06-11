package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayPage {

    public EbayPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gh-cat")
    public WebElement allCategoriesDropDown;

    @FindBy(id = "gh-cat")
    public WebElement dropDownCategories;

    @FindBy(id = "gh-btn")
    public WebElement searchButton;

    @FindBy(tagName = "h1")
    public WebElement heading1;

    @FindBy(xpath = "//h2[@class='title-banner__subtitle']")
    public WebElement heading2;


}
