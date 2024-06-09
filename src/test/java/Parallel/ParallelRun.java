package Parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/Parallel"},
		glue={"Parallel"},
		plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/"},
		monochrome= true,
		publish = true
		
)
public class ParallelRun extends AbstractTestNGCucumberTests
{
	@Override //override method to convert scenario into test
	@DataProvider(parallel= true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	
}
