package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private final By firstProduct = By.xpath("//*[contains(@text,'Sauce Labs')][1]");
    private final By addToCart = By.xpath("//*[contains(@text,'ADD TO CART') or contains(@label,'ADD TO CART')]");
    private final By cart = By.xpath("//*[contains(@content-desc,'cart') or contains(@name,'cart')]");

    public void openFirstProduct() { click(firstProduct); }
    public void addFirstProductToCart() { click(addToCart); }
    public void openCart() { click(cart); }
    public boolean cartPageVisible() {
        return driver.getPageSource().toLowerCase().contains("cart");
    }
}
