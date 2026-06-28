package org.foodDelivery.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org/foodDelivery/stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
//        dryRun = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
 