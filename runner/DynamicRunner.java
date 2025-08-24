package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/java/features/dynamic.feature"},
glue="stepDefinition",
publish=true)

public class DynamicRunner extends AbstractTestNGCucumberTests {

}
