package org.foodDelivery.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class AdminPage extends BasePage{

    By adminBtn = By.xpath("//div[@class='toggle-tabs']/button[2]");
    By loginemail = By.xpath("(//input[@placeholder='Enter your email'])");
    By loginpassword = By.xpath("//input[@placeholder='Enter your password']");
    By loginBtn = By.xpath("//button[@class='btn-login']");
    By addProductLink = By.xpath("//a[@routerlink='/admin/products']");
    By addProductBtn = By.xpath("//button[@class='btn-primary']");
    By productname = By.xpath("//input[@placeholder='Enter product name']");
    By productprice = By.xpath("//input[@placeholder='Enter price']");
    By categoryDropdown = By.xpath("//select[@class='ng-untouched ng-pristine ng-valid']");
    By image = By.xpath("//input[@placeholder='Optional image URL']");
    By description = By.xpath("//textarea[@placeholder='Describe the product']");
    By saveProductBtn = By.xpath("//div[@class='add-form']/button");

    public void adminLogin(){
        logger.info("Starting admin login process...");
        RedirectTo("https://food-ordering-app-z99l.vercel.app");
        Click(adminBtn);
        EnterText(loginemail, "admin@food.com");
        EnterText(loginpassword, "admin123");
        Click(loginBtn);
        logger.info("Admin login process completed.");
    }

    public void clickAddProduct(){
        Click(addProductLink);
    }

    public void addProduct(){
        logger.info("Starting add product process...");
        Click(addProductBtn);
        EnterText(productname, "Chicken Lasagne");
        EnterText(productprice, "499");
        SelectByDropdown(categoryDropdown, "Non-Veg");
        EnterText(image, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzxkwxqoDCWlECnPAGBgpvjvnVwEcVX75wrk7v2wW0Tw&s=10");
        EnterText(description, "A classic chicken lasagne is a rich, comforting, and savory dish made by layering tender chicken");
        Click(saveProductBtn);
        logger.info("Add product process completed.");
    }

    public String productAddedSuccessfully(String productName) {
        By dynamicElement = By.xpath("//td[contains(text(), '" + productName + "')]");

        try {
            return FindElement(dynamicElement).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
