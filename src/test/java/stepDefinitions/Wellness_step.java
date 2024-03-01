package stepDefinitions;

import org.junit.Assert;

import DriverSetup.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.corporateDetails;
import pageobject.doctorslist;

public class Wellness_step extends BaseClass
{

	corporateDetails obj3 = new corporateDetails(getDriver());

@Given("The user Navigates to the practo Webpage")
public void the_user_navigates_to_the_practo_webpage()
{
	boolean n = obj3.webpage_verify();
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

@Then("Clicks on the Health and Wellness plan under For Corporate section and fills the form with invalid email and Checks whether the schedule button is disabled")
public void clicks_on_the_health_and_wellness_plan_under_for_corporate_section_and_fills_the_form_with_invalid_email_and_checks_whether_the_schedule_button_is_disabled() 
{
	obj3=   new corporateDetails(driver);
	obj3.switch_to_corporate();
	obj3.enter_wrong_corporate_details();
}

@Then("Fills the form with valid email  and clicks on schedule demo button to capture the thankyou message")
public void fills_the_form_with_valid_email_and_clicks_on_schedule_demo_button_to_capture_the_thankyou_message() throws InterruptedException
{
	obj3.enter_correct_corporate_details();
	obj3.thankyou_display();
}


}
