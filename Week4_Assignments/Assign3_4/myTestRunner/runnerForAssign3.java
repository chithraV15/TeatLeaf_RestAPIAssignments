package myTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			
				features = "src/test/java/feature/Assign3Incident.feature",
				glue = {"myStepDefinition","hooks"},
				dryRun = false
		
		)


public class runnerForAssign3 extends AbstractTestNGCucumberTests{

}
