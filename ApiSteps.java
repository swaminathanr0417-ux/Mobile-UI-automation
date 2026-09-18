package stepdefinitions;

import api.ApiClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiSteps {
    private Response response;
    private final ApiClient api = new ApiClient();

    @When("I send a GET request for users")
    public void getUsers() { response = api.getUsers(); }

    @When("I create a test user")
    public void createUser() { response = api.createUser(); }

    @Then("the API response status should be {int}")
    public void status(int expected) { Assert.assertEquals(response.statusCode(), expected); }
}
