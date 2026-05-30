package runners;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features",

		glue = {

				"stepdefinitions", "hooks" },

		plugin = {

				"pretty",

				"html:reports/cucumber.html" }

		,tags = "@Booking"

)

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override

	@DataProvider(parallel = false)

	public Object[][] scenarios() {

		return super.scenarios();
	}
}