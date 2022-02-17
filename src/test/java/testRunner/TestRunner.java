package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/features/Orders.feature"},
		glue={"stepDefinitions","appHooks"},
		dryRun =false, // checks only mapping of steps in feature file to step defn, dosent execute test cases
		monochrome= true, //output in console in readable format
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"}
		//tags="@smoketest"
		//strict=true //fails execution if pending steps are found
		)
public class TestRunner {

}
