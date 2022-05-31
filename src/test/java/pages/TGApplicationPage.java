package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

public class TGApplicationPage {


    public TGApplicationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

        @FindBy(id = "comp-kuiqjide2")
        public WebElement heading1;
    }
