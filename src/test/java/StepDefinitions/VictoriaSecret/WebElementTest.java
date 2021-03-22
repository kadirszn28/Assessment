package StepDefinitions.VictoriaSecret;

import Pages.HomePage;
import Pages.IdentifyElementsDifferentWay;
import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class WebElementTest {
    WebDriver driver = Driver.getDriver();
    IdentifyElementsDifferentWay identifyElementsDifferentWay;
    @When("User navigate Victoria's Secret Home page")
    public void user_navigate_Victoria_s_Secret_Home_page() {
        identifyElementsDifferentWay = new IdentifyElementsDifferentWay(driver);
        driver.get(ConfigReader.getProperty("url"));
    }
    @Then("User validates Web Elements")
    public void user_validates_Web_Elements() {
        Assert.assertTrue(identifyElementsDifferentWay.sportloungeV1.isDisplayed());
        Assert.assertTrue(identifyElementsDifferentWay.sportloungeV2.isDisplayed());
        Assert.assertTrue(identifyElementsDifferentWay.sportloungeV3.isDisplayed());
        Assert.assertFalse(identifyElementsDifferentWay.sportloungeV1.isSelected());
        Assert.assertFalse(identifyElementsDifferentWay.sportloungeV2.isSelected());
        Assert.assertFalse(identifyElementsDifferentWay.sportloungeV3.isSelected());
        driver.close();
    }
}
