package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				features = {"src/test/java/feature/Incident.feature", "src/test/java/feature/changeReq.feature"},
				glue = "stepDefinition",
				
				dryRun = false
		
		
		)


public class RunnerTagsExample extends AbstractTestNGCucumberTests{

}
