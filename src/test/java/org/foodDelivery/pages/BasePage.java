package org.foodDelivery.pages;

import org.foodDelivery.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;


public class BasePage {
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    public WebDriver driver;

    BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    public void RedirectTo(String url){
        logger.info("Redirecting to URL: " + url);
        driver.get(url);
    }

    public WebElement FindElement(By element){
        return driver.findElement(element);
    }
    public void Click(By btn){
        logger.info("Clicking on element: " + btn.toString());
        FindElement(btn).click();
    }

    public void EnterText(By field, String text){
        logger.info("Entering text: '" + text + "' into element: " + field.toString());
        FindElement(field).clear();
        FindElement(field).sendKeys(text);
    }

    public String GetCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void pageLoadTimeout(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    public WebDriverWait webDriverWait(long time){
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public  boolean ExplicitWaitWithUrlContains(String s, long time){
        return webDriverWait(time).until(
                ExpectedConditions.urlContains(s)
        );
    }
    public void ExplicitWaitWithElementToBeClickable(By element, long time){
        webDriverWait(time).until(
                ExpectedConditions.elementToBeClickable(element)
        ).click();
    }

    public String GetText(By element){
        logger.info("Getting text from element: " + element.toString());
        return FindElement(element).getText();
    }
    public void SelectByDropdown(By path, String value){
        logger.info("Selecting dropdown value: '" + value + "' for element: " + path.toString());
        Select option = new Select(FindElement(path));
        option.selectByVisibleText(value);
    }
}
