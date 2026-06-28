package org.foodDelivery.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.foodDelivery.utils.DriverFactory;

public class Hooks {

    @Before
    public void initializeDriver(){
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void quitDriver(){
        DriverFactory.quitDriver();
    }
}
