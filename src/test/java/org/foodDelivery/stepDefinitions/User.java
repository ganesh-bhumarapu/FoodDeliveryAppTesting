package org.foodDelivery.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.foodDelivery.pages.LoginRegisterPage;
import org.foodDelivery.pages.ProductsPage;
import org.testng.Assert;

public class User {

    LoginRegisterPage loginPage = new LoginRegisterPage();
    ProductsPage productsPage = new ProductsPage();

    @Given("the user logged in with user credentails")
    public void the_user_logged_in_with_user_credentails() {
        loginPage.redirectTo("https://food-ordering-app-z99l.vercel.app/login");
        loginPage.login();
    }
    @When("the user navigates to the products page")
    public void the_user_navigates_to_the_products_page() {
        Assert.assertTrue(loginPage.checkUrlContentMatches("/home"));
        productsPage.navigateToProductPage();
        Assert.assertTrue(loginPage.checkUrlContentMatches("/products"));
    }
    @When("the user inspects the product and adds to cart")
    public void the_user_inspects_the_product_and_adds_to_cart() {
       productsPage.addToCart();
    }
    @Then("the user should be able to see it in the cart page")
    public void the_user_should_be_able_to_see_it_in_the_cart_page() {
        Assert.assertTrue(loginPage.checkUrlContentMatches("/cart"));
    }

    @Given("the user logged in with user credentails1")
    public void the_user_logged_in_with_user_credentails1() {
        loginPage.redirectTo("https://food-ordering-app-z99l.vercel.app/login");
        loginPage.login();
    }
    @When("the user navigates to the product page1")
    public void the_user_navigates_to_the_product_page1() {
        Assert.assertTrue(loginPage.checkUrlContentMatches("/home"));
        productsPage.navigateToProductPage();
        Assert.assertTrue(loginPage.checkUrlContentMatches("/products"));
    }
    @When("adds the products to the cart and user navigate to the cart page and increment the product from cart")
    public void adds_the_products_to_the_cart_and_user_navigate_to_the_cart_page_and_places_order() {
        productsPage.addToCart();
        Assert.assertTrue(loginPage.checkUrlContentMatches("/cart"));
        productsPage.incrementQuantity();
    }
    @Then("the user should see the difference in the updated quantity")
    public void the_user_should_land_in_the_delivery_page() {
        Assert.assertNotEquals(productsPage.getQuantity(), "1");
    }


}
