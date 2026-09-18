package pages;

import base.BasePage;
import utils.ConfigReader;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By menu;
    private final By logout;

    public HomePage() {

        super();

        boolean ios = ConfigReader.get("platform")
                .equalsIgnoreCase("ios");

        if (ios) {

            menu = By.xpath("//*[@name='Menu']");

            logout = By.xpath("//*[@name='Log Out']");

        } else {

            menu = By.xpath("//*[@content-desc='Menu']");

            logout = By.xpath("//*[@text='Log Out']");
        }
    }

    public boolean isHomeDisplayed() {

        return driver.getPageSource().contains("Products")
                || driver.getPageSource().contains("PRODUCTS");
    }

    public void logout() {

        click(menu);
        click(logout);
    }
}