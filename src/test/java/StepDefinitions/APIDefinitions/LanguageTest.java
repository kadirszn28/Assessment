package StepDefinitions.APIDefinitions;

import API.LanguageTestPojo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LanguageTest {

    Response response;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @When("User sends GET request")
    public void user_sends_GET_request() {
        RestAssured.baseURI = "https://api.victoriassecret.com";
        RestAssured.basePath = "settings/v1/languages?activeCountry=US";
    }

    @Then("User validates status code {int}")
    public void user_validates_status_code(Integer statusCode) {
        requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
        responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(statusCode).build();
        response = given().spec(requestSpecification).when().get().then().spec(responseSpecification).extract().response();
    }

    @Then("User validates following attributes")
    public void user_validates_following_attributes(io.cucumber.datatable.DataTable dataTable) {
        List<LanguageTestPojo> listofLanguageTest = response.as(new TypeRef<List<LanguageTestPojo>>() {
        });
        LanguageTestPojo languageTest = listofLanguageTest.get(0);
        List<Map<String, String>> maps = dataTable.asMaps();
        Assert.assertEquals(languageTest.getLanguageDescription(), maps.get(0).get("languageDescription"));
        Assert.assertEquals(languageTest.getLanguageCode(), maps.get(0).get("languageCode"));
        Assert.assertEquals(languageTest.getProxyLocation(), maps.get(0).get("proxyLocation"));
        Assert.assertEquals(languageTest.getEshopLanguageCode(), maps.get(0).get("eshopLanguageCode"));
        Assert.assertEquals(languageTest.getBrand(), maps.get(0).get("brand"));

    }

}
