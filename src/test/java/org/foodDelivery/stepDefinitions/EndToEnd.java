package org.foodDelivery.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.foodDelivery.pages.CartPage;
import org.foodDelivery.pages.LoginRegisterPage;
import org.foodDelivery.pages.ProductsPage;
import org.testng.Assert;

public class EndToEnd {
    private static final Logger logger = LogManager.getLogger(EndToEnd.class);

    LoginRegisterPage loginPage = new LoginRegisterPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    @Given("user enters the login page with valid credentials")
    public void user_enters_the_login_page_with_valid_credentials() {
        logger.info("Executing step: User logs in with user credentials");
        loginPage.redirectTo("https://food-ordering-app-z99l.vercel.app/login");
        loginPage.login();
    }
    @When("the user adds the product to the cart and places order")
    public void the_user_adds_the_product_to_the_cart_and_places_order() {
        logger.info("Executing step: User navigates to product page (scenario 2)");
        Assert.assertTrue(loginPage.checkUrlContentMatches("/home"));
        productsPage.navigateToProductPage();
        Assert.assertTrue(loginPage.checkUrlContentMatches("/products"));
        logger.info("Executing step: User adds products, navigates to cart, and increments quantity");
        productsPage.addToCart();
        Assert.assertTrue(loginPage.checkUrlContentMatches("/cart"));
        cartPage.PlaceOrder();

    }
    @Then("the user should be able to see the order status")
    public void the_user_should_be_able_to_see_the_order_status() {
        Assert.assertTrue(loginPage.checkUrlContentMatches("/order"));
    }

}
