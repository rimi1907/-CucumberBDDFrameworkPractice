package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{	
	WebDriver driver;
  @FindBy(id="nav_automobile") 
  WebElement auto_link;
  
  
  public HomePage(WebDriver driver)
  {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  public String PageTitle()
  {
	 return driver.getTitle();
	
  }
  public void click_AutoMobileLink()
  {
	  auto_link.click();
  }
  
  public boolean AutomobileLinkpresent()
  {
	  return auto_link.isDisplayed();
  }
}

