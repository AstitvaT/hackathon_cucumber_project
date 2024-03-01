package pageobject;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.screenshot_capture;



public class corporateDetails  {
	public WebDriver driver ;
	public static JavascriptExecutor js;
	public corporateDetails(WebDriver driver) {
		this.driver = driver;
		js =(JavascriptExecutor) driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@event=\"Nav:Interacted:Book an appointment\"]/div[1]")
	WebElement find_docs;
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]")
	WebElement corporate_option;
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/div/div[1]/a")
	WebElement health_wellness_plan;
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement corporate_name;
	@FindBy(xpath="//*[@id=\"organizationName\"]")
	WebElement corporate_organization;
	@FindBy(xpath="//*[@id=\"contactNumber\"]")
	WebElement corporate_number;
	@FindBy(xpath="//*[@id=\"officialEmailId\"]")
	WebElement corporate_email;
	@FindBy(xpath="//*[@id=\"organizationSize\"]")
	WebElement organization;
	@FindBy(xpath="//*[@id=\"interestedIn\"]")
	WebElement interested;
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/form/button")
	WebElement schedule_button;
	@FindBy(xpath="/html/body/div[4]/div/div/div/div[1]")
	WebElement message_display;
	
	public boolean webpage_verify()
	{
		find_docs.getText();
		return true;
	}
	
	
	public void switch_to_corporate() {
		// js code to scroll at the beginning of the page 
		
		//js.executeScript("window.scrollTo(0,0);");
		corporate_option.click();
		health_wellness_plan.click();
		}

	
	public void enter_wrong_corporate_details() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		corporate_name.sendKeys("Astitva Tribhuwan");
		
		
		corporate_organization.sendKeys("Cognizant Technologies Solution");
		
		
		corporate_number.sendKeys("9999999999");
		
		
		corporate_email.sendKeys("xxx@com");
		
		
		Select organization_size = new Select(organization);
		organization_size.selectByIndex(4);
		
		
		Select interested_in_dropdown = new Select(interested);
		interested_in_dropdown.selectByIndex(1);
		
	}
	
	public void enter_correct_corporate_details() throws InterruptedException {
		
		corporate_name.clear();
		corporate_name.sendKeys("Astitva Tribhuwan");
		
		
		corporate_organization.clear();
		corporate_organization.sendKeys("Cognizant Technologies Solution");
		
		
		corporate_number.clear();
		corporate_number.sendKeys("7709143385");
		
		
		corporate_email.clear();
		corporate_email.sendKeys("2303702@cognizant.com");
		

		// now click on schedule button 
		
		
	
	}
	public void thankyou_display() throws InterruptedException {
          schedule_button.click();
		
	
		
		// display thank u message 
		Thread.sleep(30000);
		screenshot_capture.final_message_screenshot(driver);
		System.out.println(message_display.getText());
	}

}
