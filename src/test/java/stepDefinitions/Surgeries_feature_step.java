package stepDefinitions;

import org.junit.Assert;

import DriverSetup.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.doctorslist;
import pageobject.surgeryList;

public class Surgeries_feature_step extends BaseClass
{
	surgeryList obj2 = new surgeryList(getDriver());

	@Given("user Navigates to the practo Webpage")
	public void user_navigates_to_the_practo_webpage()
	{
		boolean n = obj2.webpage_verify();
		Assert.assertEquals(n, true);
		if(n==true)
		{
			System.out.println("\n USER IS ON PRACTO WEBPAGE\n");
		}
		else
		{
			System.out.println("\n USER IS NOT ON THW WEBPAGE \n");
			System.out.println("-------------------------------------------------");
 
		}	
	}

	@Then("user clicks on surgery option")
	public void user_clicks_on_surgery_option() throws InterruptedException
	{
		obj2=   new surgeryList(driver);
		
		obj2.click_surgery_option();
		
	}
	@Then("print all the surgery options")
	public void  print_all_the_surgery_options() throws InterruptedException {
		obj2.select_surgeries();
	}
}
