package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/java/features/loginSalesforceStatic.feature"},
glue="stepDefinition",
publish=true)

public class StaticRunner extends AbstractTestNGCucumberTests {

}
