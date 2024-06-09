package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory
{
	// Create WebDriver Object for given browser
	public WebDriver CreateBrowserInstance(String browser)
	{
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("Chrome"))
		{
			//driver= new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			// to run in incognito mode
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			
		}
		else if(browser.equalsIgnoreCase("Firefox"))
				{

		//driver= new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("-private");
			driver = new FirefoxDriver(foptions);
				}
		else if(browser.equalsIgnoreCase("IE"))
		{
			//driver= new InternetExplorerDriver();
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions ieoptions = new InternetExplorerOptions();
			ieoptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(ieoptions);
		}
		return driver;
	}
}
