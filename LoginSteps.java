package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage login = new LoginPage();
    private final HomePage home = new HomePage();

    @Given("the user launches the application")
    public void launch() { Assert.assertNotNull(login); }

    @When("the user enters valid username and password")
    public void validCredentials() { login.enterCredentials("standard_user", "secret_sauce"); }

    @When("the user enters invalid username and password")
    public void invalidCredentials() { login.enterCredentials("invalid_user", "invalid_password"); }

    @When("taps the login button")
    public void tapLogin() { login.tapLogin(); }

    @Then("the user should be logged in successfully")
    public void loggedIn() { Assert.assertTrue(home.isHomeDisplayed()); }

    @Then("an error message should be displayed")
    public void error() { Assert.assertTrue(login.isErrorDisplayed()); }

    @When("the user logs out")
    public void logout() { home.logout(); }
}
