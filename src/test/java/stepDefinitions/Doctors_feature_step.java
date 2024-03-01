package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import DriverSetup.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.doctorslist;

public class Doctors_feature_step extends BaseClass
{
	
	doctorslist obj1 = new doctorslist(getDriver());
	@Given("user Navigates to the Practo Webpage")
	public void user_navigates_to_the_practo_webpage()
	{
		boolean n = obj1.webpage_verify();
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

	@Then("selects a desired city")
	public void selects_a_desired_city() throws InterruptedException {
		obj1.search_location();
	}

	@Then("searches any doctor  in that city")
	public void searches_any_doctor_in_that_city() throws InterruptedException {
	    obj1.search_doctors();
	}

	@When("sort by number of patients stories")
	public void sort_by_number_of_patients_stories() throws InterruptedException {
		obj1.select_patient_stories();

	}

	@When("apply filters of Experience")
	public void apply_filters_of_experience() throws InterruptedException {
		obj1.select_experience();
	}

	@When("apply filter of Fees")
	public void apply_filter_of_fees() throws InterruptedException {
		obj1.select_fees();
	}

	@When("apply filter of Availability")
	public void apply_filter_of_availability() throws InterruptedException {
		obj1.select_availability();
	}
	@When("sort by relevance")
	public void sort_by_relevance() throws InterruptedException {
		obj1.sort_by_relevance();
	}

	@Then("print the details")
	public void print_the_details() {
	   obj1.final_doctors_list();
	}

}
