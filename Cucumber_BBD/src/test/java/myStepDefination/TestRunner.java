package myStepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/myFeatures", 
glue = {"myStepDefination"}, 
tags = "@Regression",
plugin = {"pretty", "html:target/htmlreports/report.html",
		             "json:target/htmlreports/report",
		             "junit:target/htmlreports/report"})
public class TestRunner {

}
