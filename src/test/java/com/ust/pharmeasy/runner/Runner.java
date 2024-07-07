package com.ust.pharmeasy.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions( features = "classpath:features",
					glue = "com.ust.pharmeasy.stepdefinitions",
					dryRun =true
		)
 
 
public class Runner extends AbstractTestNGCucumberTests {
 
}
 
