package com.mobile.autotest.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:target/telstraTestHTMLReport","pretty:target/cucumber-json-report.json","pretty:target/cucumber.xml" }, 
		features = "src/test/resources/features/",
		glue = {"com.mobile.autotest.steps"}
)
public class TestRunner {

}
