package Factory;
import java.lang.*;

import org.openqa.selenium.WebDriver;
public class DriverFactory 
{
	//Threadlocal is a class belong to java.lang package
	
	//create private constructor so that no one else can create object of that class
	
	private DriverFactory()
	{
		
	}
	 public static DriverFactory instance = new DriverFactory();
	 
	 public static DriverFactory getInstance()
	 {
		 return instance;
	 }

//Factory Design Pattern
ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

public WebDriver getDriver()
{
	return driver.get();
}

public void setDriver(WebDriver driverparam)
{
	driver.set(driverparam);
}
public void closebrowser()
{
	driver.get().close();
	driver.remove();
}
}