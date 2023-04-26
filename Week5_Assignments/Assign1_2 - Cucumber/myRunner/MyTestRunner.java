package myRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
			features = "src/test/java/feature/assign1.feature",
			glue = "stepDefinitions",
			dryRun = false
		
		)




public class MyTestRunner extends AbstractTestNGCucumberTests{

}
