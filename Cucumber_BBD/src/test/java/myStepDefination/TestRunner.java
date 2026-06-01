package myStepDefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/myFeatures",
    glue = {"myStepDefination"},
//    tags = "@Regression",
    plugin = {
        "pretty",
        "html:target/htmlreports/report.html",
        "json:target/htmlreports/report.json",
        "junit:target/htmlreports/report.xml"
    }
)

public class TestRunner {

}