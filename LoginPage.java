package pages;

import base.BasePage;
import utils.ConfigReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By username;
    private By password;
    private By loginButton;
    private By errorMessage;

    public LoginPage() {
        super();

        boolean ios = ConfigReader.get("platform")
                .equalsIgnoreCase("ios");

        if (ios) {

            username = By.xpath(
                    "//XCUIElementTypeTextField[@name='test-Username']"
            );

            password = By.xpath(
                    "//XCUIElementTypeSecureTextField[@name='test-Password']"
            );

            loginButton = By.xpath(
                    "//*[@name='test-LOGIN']"
            );

            errorMessage = By.xpath(
                    "//*[@name='test-Error message']"
            );

        } else {

            username = By.id(
                    "com.saucelabs.mydemoapp.android:id/nameET"
            );

            password = By.id(
                    "com.saucelabs.mydemoapp.android:id/passwordET"
            );

            loginButton = By.id(
                    "com.saucelabs.mydemoapp.android:id/loginBtn"
            );

            errorMessage = By.id(
                    "com.saucelabs.mydemoapp.android:id/passwordErrorTV"
            );
        }
    }

    public void enterCredentials(String user, String pass) {

        type(username, user);
        type(password, pass);
    }

    public void tapLogin() {

        click(loginButton);
    }

    public boolean isErrorDisplayed() {

        return displayed(errorMessage);
    }
}