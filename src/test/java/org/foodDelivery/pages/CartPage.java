package org.foodDelivery.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{
    By placeOrderBtn = By.xpath("//button[@class='btn-place-order']");

    public void PlaceOrder(){
        Click(placeOrderBtn);
    }
}
