package org.foodDelivery.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.foodDelivery.pages.AdminPage;
import org.foodDelivery.pages.LoginRegisterPage;
import org.testng.Assert;

public class Admin {

    AdminPage adminPage = new AdminPage();
    LoginRegisterPage loginPage = new LoginRegisterPage();

    @Given("the user logged in with admin credentials and user landed in the dashboard page")
    public void the_user_logged_in_with_admin_credentials_and_user_landed_in_the_dashboard_page() {
        adminPage.adminLogin();
        Assert.assertTrue(loginPage.checkUrlContentMatches("/admin"));
    }
    @When("the user selects the add product")
    public void the_user_selects_the_add_product() {
        adminPage.clickAddProduct();
        Assert.assertTrue(loginPage.checkUrlContentMatches("/admin/products"));
    }
    @When("the user enters the all necessary details of the product")
    public void the_user_enters_the_all_necessary_details_of_the_product() {
       adminPage.addProduct();
    }
    @Then("check whether the product is added or not")
    public void check_whether_the_product_is_added_or_not() {
        Assert.assertEquals(adminPage.productAddedSuccessfully("Chicken Lasagne"), "Chicken Lasagne");
    }
}
