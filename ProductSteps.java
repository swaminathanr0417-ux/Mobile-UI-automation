package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductPage;

public class ProductSteps {
    private final ProductPage product = new ProductPage();

    @When("the user opens the first product")
    public void openProduct() { product.openFirstProduct(); }

    @When("adds the product to the cart")
    public void addProduct() { product.addFirstProductToCart(); }

    @When("opens the cart")
    public void openCart() { product.openCart(); }

    @Then("the cart page should be displayed")
    public void verifyCart() { Assert.assertTrue(product.cartPageVisible()); }
}
