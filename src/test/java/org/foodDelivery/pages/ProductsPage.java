package org.foodDelivery.pages;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage{

//    By emailInput = By.name("email");
//
//    By passwordInput = By.name("password");

//    By loginButton = By.xpath("(//button[@type='submit'])[1]");

    By productPageLink = By.xpath("//a[@routerlink='/products']");

    By product = By.xpath("//div[@class='product-card'][3]");

    By addToCartButton = By.xpath("//button[@class='btn-add-cart']");

    By goToCartButton = By.xpath("//button[@class='btn-go-cart']");

    By incrementQuantityButton = By.xpath("//button[@class='qty-btn'][2]");

    By placeOrderButton = By.xpath("//button[@class='btn-place-order']");

    By cartValue = By.xpath("//span[@class='cart-badge']");


    public void navigateToProductPage(){
        Click(productPageLink);
    }

    public void addToCart() {
        logger.info("Adding product to cart...");
        ExplicitWaitWithElementToBeClickable(product, 25);
        ExplicitWaitWithElementToBeClickable(addToCartButton, 15);
        ExplicitWaitWithElementToBeClickable(goToCartButton, 15);
        logger.info("Product added and navigated to cart.");
    }


    public void incrementQuantity() {
        logger.info("Incrementing product quantity in cart...");
        Click(incrementQuantityButton);
    }

    public String getQuantity() {
        return GetText(cartValue);
    }
}
