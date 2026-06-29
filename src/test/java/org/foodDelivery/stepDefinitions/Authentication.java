package org.foodDelivery.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.foodDelivery.pages.LoginRegisterPage;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Authentication {
    private static final Logger logger = LogManager.getLogger(Authentication.class);

    LoginRegisterPage loginRegisterPage = new LoginRegisterPage();

    @Given("the user is in register page")
    public void the_user_is_in_register_page() {
        logger.info("Executing step: User is in register page");
        loginRegisterPage.redirectTo("https://food-ordering-app-z99l.vercel.app/login");
    }
    @When("user enter the all the details and clicks register button")
    public void user_enter_the_all_the_details_and_clicks_register_button() {
        logger.info("Executing step: User enters details and clicks register");
        loginRegisterPage.register();
    }
    @Then("user should land in the login page ready to login")
    public void user_should_land_in_the_login_page_ready_to_login() {
        logger.info("Executing step: Verifying user is on login page");
        Assert.assertTrue(loginRegisterPage.checkUrlContentMatches("/login"));
    }

    @Given("the user is in the login page")
    public void the_user_is_in_the_login_page() {
        logger.info("Executing step: User is in the login page");
        loginRegisterPage.redirectTo("https://food-ordering-app-z99l.vercel.app/login");
    }
    @When("user enter the email and password")
    public void user_enter_the_email_and_password() {
        logger.info("Executing step: User enters email and password");
        loginRegisterPage.login();
    }
    @Then("user should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page() {
        logger.info("Executing step: Verifying user is redirected to home page");
        Assert.assertTrue(loginRegisterPage.checkUrlContentMatches("/home"));
    }

}
