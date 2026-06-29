package org.foodDelivery.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

import org.testng.annotations.Listeners;

@CucumberOptions(
    features = "src/test/resources/features", 
    glue = {"org.foodDelivery.stepDefinitions", "org.foodDelivery.hooks"}, 
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-report.html"}
)
@Listeners({org.foodDelivery.listeners.ExtentListener.class})
public class TestRunner extends AbstractTestNGCucumberTests {

}
