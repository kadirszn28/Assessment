package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'SPORT & LOUNGE')]")
    public WebElement sportlounge;

    @FindBy(xpath = "//section[@id='category-nav-5']//ul[@data-submenu-index='1']//li[@data-option-index='1']//a")
    public WebElement leggins;

    @FindBy(xpath = "//button[@class='fabric-plain-button-element fix fabric-modal-utility-close-button']")
    public WebElement xButton;

    @FindBy(xpath = "//article[@data-uuid='59028534-bea1-40ac-87c3-04234db71d68']")
    public WebElement item1;

    @FindBy(xpath = "//div[@data-generic-id='11190333'][@data-value='03T3']")
    public WebElement neonPink;

    @FindBy(xpath = "//div[@class='fabric-purchasable-product-component-box-selectors-group-option'][contains(text(),'XS')]")
    public List<WebElement> xsSize;

    @FindBy(xpath = "//button[@type='submit']")
    public List<WebElement> addtoBagButton;

    @FindBy(xpath = "//button[@class='fabric-primary-button-element fabric-add-to-bag-overlay-checkout-button']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//a[@class='fabric-primary-grey-button-element checkoutAsGuestButton']")
    public WebElement checkOutAsAGuest;

    @FindBy(xpath = "//span[contains(text(),'Merchandise Subtotal')]")
    public WebElement textMerchandiseSubTotal;

    @FindBy(xpath = "//span[@class='fabric-h2-typography-element price']")
    public WebElement purchaseAmount;

    @FindBy(xpath = "//div[@class='alert-content']")
    public WebElement textAlertContent;


}
