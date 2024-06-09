package Parallel;

import org.testng.Assert;

import com.pages.HomePage;

import Factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps 
{  
	String Title;
	HomePage homepage = new HomePage(DriverFactory.getInstance().getDriver());
	@Given("user is on HomePage")
	public void user_is_on_home_page() 
	{
		// No action needed here since navigation is already done in the @Before method
	}

	@When("user gets the title of the HomePage")
	public void user_gets_the_title_of_the_HomePage() 
	{
		 Title = homepage.PageTitle();
		 System.out.println("Title of The HomePage is:" +Title);
	}

	@Then("The Title of the HomePage should be {string}")
	public void the_title_of_the_HomePage_should_be(String ExpectedResult)
	{
	   Assert.assertTrue(Title.contentEquals(ExpectedResult));
	}

	@Then("Automobile Links should be present")
	public void automobile_links_should_be_present()
	{
	    Assert.assertTrue(homepage.AutomobileLinkpresent());
	}
	@When("User clicks on Automobile Link")
	public void user_clicks_on_automobile_link() 
	{
		homepage.click_AutoMobileLink();
	}

	@And("user gets the Title of the NavigatedPage")
	public void user_gets_the_title_of_the_NavigatedPage() {
	    Title =homepage.PageTitle();
	    System.out.println("The Title of Navigated Page is :"+Title);
	}

	@Then("The title of the NavigatedPage should be {string}")
	public void The_title_of_the_NavigatedPage_should_be(String ExpectedTitle)
	{
		Assert.assertTrue(Title.contains(ExpectedTitle));
	    }
}
