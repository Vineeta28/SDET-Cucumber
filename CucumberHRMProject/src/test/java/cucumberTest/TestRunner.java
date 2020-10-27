package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "Feature",
	    glue = {"stepDefinitions"},
		tags = "@activity3",
		strict = true,
		dryRun = false,
		format = {"pretty","html: test-reports"},
	    monochrome = true
	)


	public class TestRunner {

	}



