package com.automationpractice.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/java/featurefiles",
		glue="stepdefinitions",
		dryRun=true,
//		tags= {"@listdata"},
		monochrome = true,
		plugin={ "progress",
		          "html:target/Cucumber"
		        })

public class TestRunner{

}