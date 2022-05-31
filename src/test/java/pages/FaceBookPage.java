package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FaceBookPage {

    public FaceBookPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class='_6ltg']>a")
    public WebElement createNewAccountLink;

    @FindBy(css = "span[class='_5k_3']>span>input")
    public List<WebElement> genderRadioButtons;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='reg_email__']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@name='reg_email_confirmation__']")
    public WebElement emailConfig;

    @FindBy(xpath = "//input[@autocomplete='new-password']")
    public WebElement password;

  //  @FindBy(css = "input[data-type='password']")
  //  public WebElement inputPassword;

    @FindBy(id = "month")
    public WebElement monthDropdown;

    @FindBy(id = "day")
    public WebElement dayDropdown;

    @FindBy(id = "year")
    public WebElement yearDropdown;

    @FindBy(id = "reg_error_inner")
    public WebElement errorMessage;


    @FindBy(xpath = "//button[@name='websubmit']")
    public WebElement signUp;



}
