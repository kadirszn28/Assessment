package StepDefinitions.VictoriaSecret;

import Pages.HomePage;
import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PurchaseFlowTest {

    WebDriver driver = Driver.getDriver();
    HomePage homePage;
    Actions action;

    @Given("User navigate Victoria's Secret home page")
    public void user_navigate_Victoria_s_Secret_home_page() {
        homePage = new HomePage(driver);
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("User hover overs Sport&Lounge section")
    public void user_hover_overs_Sport_Lounge_section() {
        action = new Actions(driver);
        action.moveToElement(homePage.sportlounge).build().perform();
    }

    @When("User clicks Leggins section")
    public void user_clicks_Leggins_section() {
        action.moveToElement(homePage.leggins).click(homePage.leggins).build().perform();
    }

    @When("User chooses one product")
    public void user_chooses_one_product() {
        BrowserUtils.visibilityOfElementLocated(driver, 2000, By.xpath("//button[@class='fabric-plain-button-element fix fabric-modal-utility-close-button']"));
        homePage.xButton.click();
        BrowserUtils.visibilityOf(driver, 1500, homePage.item1);
        BrowserUtils.scrollIntoView(driver, homePage.item1);
        homePage.item1.click();
    }

    @When("User clicks color, size, add to bag")
    public void user_clicks_color_size_add_to_bag() {
        BrowserUtils.visibilityOf(driver, 1500, homePage.neonPink);
        BrowserUtils.scrollIntoView(driver, homePage.neonPink);
        homePage.neonPink.click();
        homePage.xsSize.get(0).click();
        homePage.addtoBagButton.get(0).click();

    }

    @When("User clicks checkout button")
    public void user_clicks_checkout_button() {
        BrowserUtils.visibilityOf(driver, 1500, homePage.checkoutButton);
        homePage.checkoutButton.click();
    }

    @When("User clicks checkout as guest button")
    public void user_clicks_checkout_as_guest_button() {
        BrowserUtils.visibilityOf(driver, 1500, homePage.checkOutAsAGuest);
        homePage.checkOutAsAGuest.click();
    }

    @Then("User validates validates {string} header")
    public void user_validates_validates_header(String actualMerchandiseSubTotalText) {
        Assert.assertEquals(homePage.textMerchandiseSubTotal.getText(), actualMerchandiseSubTotalText);
    }

    @Then("User validates merchandies subtotal amount {string}")
    public void user_validates_merchandies_subtotal_amount(String purchaseAmount) {
        Assert.assertEquals(homePage.purchaseAmount.getText(), purchaseAmount);
    }

    @Then("User validates description of merchandise subtotal")
    public void user_validates_description_of_merchandise_subtotal() {
        Assert.assertEquals(homePage.textAlertContent.getText(), ConfigReader.getProperty("textAlertContent"));
        driver.close();
    }

}
