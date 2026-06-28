package org.foodDelivery.pages;

import org.openqa.selenium.By;

public class LoginRegisterPage extends BasePage{

    By registerBtn = By.xpath("//a[@routerlink='/register']");
    By fullName = By.xpath("(//input[@placeholder='Enter your name'])[1]");
    By email = By.xpath("(//input[@placeholder='Enter your email'])[1]");
    By password = By.xpath("//input[@placeholder='Create a password (min 6, 1 uppercase, 1 number)']");
    By phoneNumber = By.xpath("//input[@placeholder='Enter 10-digit phone number']");
    By address = By.xpath("//textarea[@placeholder='Enter your full address']");
    By registerSubmitBtn = By.xpath("//button[@class='btn-register']");
    By errorMsg = By.xpath("//div[@class='error']");

    By loginemail = By.xpath("(//input[@placeholder='Enter your email'])");
    By loginpassword = By.xpath("//input[@placeholder='Enter your password']");
    By loginBtn = By.xpath("//button[@class='btn-login']");

    public void clickRegisterBtn() {
        Click(registerBtn);
    }

    public void register() {
        Click(registerBtn);
        EnterText(fullName, "Vermithos");
        EnterText(email, "vermithos6@gmail.com");
        EnterText(password, "Vermithos1@123");
        EnterText(phoneNumber, "8888888888");
        EnterText(address, "Old Velariya");
        Click(registerSubmitBtn);
    }


    public void redirectTo(String url){
        RedirectTo(url);
    }

    public void login(){
        EnterText(loginemail, "vermithos3@gmail.com");
        EnterText(loginpassword, "Vermithos1@123");
        Click(loginBtn);
    }

    public String getCurrentUrl() {

        return GetCurrentUrl();
    }

    public boolean checkUrlContentMatches(String s) {
        return ExplicitWaitWithUrlContains(s, 20);
    }
}
