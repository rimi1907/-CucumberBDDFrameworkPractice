package Parallel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Factory.BrowserFactory;
import Factory.DriverFactory;
import Util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ApplicationHooks
{
	private WebDriver driverInstance;
	private WebDriver driver;
	BrowserFactory bf = new BrowserFactory();
	@Before(order =0)
	public void launchApplication() throws Exception
	{	 
		String browser=ConfigReader.getPropertValueByKey("browser");
		String url =ConfigReader.getPropertValueByKey("url");
	
	
		driverInstance =bf.CreateBrowserInstance(browser);
		DriverFactory.getInstance().setDriver(driverInstance);
		driver = DriverFactory.getInstance().getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	
	@After(order=0)
	public void teardown()
	{
		DriverFactory.getInstance().closebrowser();
	}
	@After(order=1)
	public void TakeScreenshotOnFailure(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			String ScreenshotName = scenario.getName().replaceAll("", "_");
			byte[] sourcepath =ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", ScreenshotName);
			
	}
	
}
}
