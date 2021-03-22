package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdentifyElementsDifferentWay {

    public IdentifyElementsDifferentWay(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'SPORT & LOUNGE')]")
    public WebElement sportloungeV1;

    @FindBy(css = "a[name='20210318-vs-sport-and-lounge-d']")
    public WebElement sportloungeV2;

    @FindBy(name = "20210318-vs-sport-and-lounge-d")
    public WebElement sportloungeV3;

    @FindBy(xpath = "//a[@name='pink-tab-category-doc-7.02.20201']")
    public WebElement mockElementV1;

    @FindBy(css = "a[name='pink-tab-category-doc-7.02.20201']")
    public WebElement mockElementV2;

    @FindBy(name = "pink-tab-category-doc-7.02.2020'")
    public WebElement mockElementV3;


}
