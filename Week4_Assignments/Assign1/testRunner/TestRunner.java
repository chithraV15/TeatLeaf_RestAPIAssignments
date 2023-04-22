package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/feature/createIncWithScnOutline.feature",
		glue = "stepDefinition",
		dryRun = false
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
