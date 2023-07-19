package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="C:\\FrameWorks\\CucumberFrameWorkFaceBook\\Login.feature",
		glue="StepDefinitions",
		dryRun=false
		)

public class Runner extends AbstractTestNGCucumberTests {

}
