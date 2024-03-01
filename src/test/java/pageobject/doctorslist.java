package pageobject;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class doctorslist  {
	public  WebDriver driver;
	public static JavascriptExecutor js ;
	
	
	//constructor
	public doctorslist(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
	
	// findBy locators 
	@FindBy(xpath="//a[@event=\"Nav:Interacted:Book an appointment\"]/div[1]")
	WebElement find_docs;
	@FindBy(xpath ="//*[@id=\"c-omni-container\"]/div/div[1]/div/input" )
	WebElement city_searchbox;
	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div[1]") 
	WebElement city_name;
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input")
	WebElement search_box;
	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]/div")
	WebElement doctor_option;
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]")
	WebElement patient_stories_button;
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]/ul/li[1]")
	WebElement patient_stories_10_option;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]")
	WebElement experience_button;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]/ul/li[1]")
	WebElement experience_5_option;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[4]/span")
	WebElement all_filters_button;
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[2]/div/label[1]")
	WebElement fees_selection_option;
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[3]/div/label[2]")
	WebElement availability_select_button;
	@FindBy(xpath="//span[@class='c-sort-dropdown__selected c-dropdown__selected']")
	WebElement sort_by_button;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/ul/li[1]")
	WebElement sort_by_menu_option;
	@FindBy(className="info-section")
	List<WebElement> doctor_name_list;
	
	//explicit wait checking xpath
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]/span/span/span")
	WebElement check_patient_stories;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]/span/span/span")
	WebElement check_experience;
	
	public boolean webpage_verify()
	{
		find_docs.getText();
		return true;
	}
	
	public void go_to_url() {
		js = (JavascriptExecutor) driver;
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	public void search_location() throws InterruptedException {
		
		
		city_searchbox.clear();
		city_searchbox.sendKeys("Bangalor");
		
		Thread.sleep(2000);
		
		// now city_name is getting stale, so i have written below code to remove the stale element
		boolean isNameHtmlElementStale = ExpectedConditions.stalenessOf(city_name).apply(driver);
		if(isNameHtmlElementStale) {
		     city_name.clear();
		}
		city_name.click();
		
		
	}
	
	public void search_doctors() throws InterruptedException {
		
		search_box.sendKeys("Doctor");
		Thread.sleep(2000);
		doctor_option.click();
	}
	
	public void select_patient_stories() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		patient_stories_button.click();
		
		patient_stories_10_option.click();
		Thread.sleep(5000);
		//check that 10+ option is clicked or not 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBePresentInElement( check_patient_stories, "10+ Patient Stories"));
		boolean patientStale= ExpectedConditions.stalenessOf(patient_stories_10_option).apply(driver);
		if(patientStale) {
			patient_stories_10_option.click();
		}
		
	}
	
	public void select_experience() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		experience_button.click();
		
		experience_5_option.click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBePresentInElement( check_experience, "5+ Years of experience"));
		boolean select_experience_stale= ExpectedConditions.stalenessOf(experience_5_option).apply(driver);
		if(select_experience_stale) {
			experience_5_option.click();
		}
		}
	
	public void select_fees() throws InterruptedException {
		// before selecting fees, first click on all filters
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
	     js.executeScript("arguments[0].click();", all_filters_button);
		all_filters_button.click();
	     Thread.sleep(5000);
		 // wait.until(ExpectedConditions.elementToBeSelected(all_filters_button));	
		//now fees selection
		
	     js.executeScript("arguments[0].click();",fees_selection_option);
	  //   fees_selection_option.click();
	     Thread.sleep(5000);
		 
	  // wait.until(ExpectedConditions.elementToBeSelected(fees_selection_option));		
		
		 boolean fees_selection_stale= ExpectedConditions.stalenessOf(fees_selection_option).apply(driver);
			if(fees_selection_stale) {
				fees_selection_option.click();
				wait.until(ExpectedConditions.elementToBeSelected(fees_selection_option));	
			}
		
		

		
		
	}
	
	public void select_availability() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		  js.executeScript("arguments[0].click();", all_filters_button);
		Thread.sleep(5000);
		

		
		
//		boolean isSelectButtonHtmlElementStale = ExpectedConditions.stalenessOf(availability_select_button).apply(driver);
//		if(isSelectButtonHtmlElementStale) {
//			availability_select_button = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[3]/div/label[2]"));
//		}
	//	
		//availability_select_button.click();
		js.executeScript("arguments[0].click();",availability_select_button );
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeSelected(availability_select_button));
//		
		 boolean availability_selection_stale= ExpectedConditions.stalenessOf(availability_select_button).apply(driver);
			if(availability_selection_stale) {
				js.executeScript("arguments[0].click();",availability_select_button );
				wait.until(ExpectedConditions.elementToBeSelected(availability_select_button));	
			}
	
		
	}

	public  void sort_by_relevance() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		sort_by_button.click();
		
		sort_by_menu_option.click();
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		//	wait.until(ExpectedConditions.elementToBeSelected(availability_select_button));
//			 wait.until(ExpectedConditions.stalenessOf(sort_by_menu_option));
		
		
	}
	
	public  void final_doctors_list() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(doctor_name_list.size());
		int i = 0;
		while(i <doctor_name_list.size()) {
			System.out.println(doctor_name_list.get(i).getText());
			i++;
			System.out.println("=====================================================");
			if(i==5) {
				break;
			}
		}
		
	}
	public  void close_the_browser() {
		driver.quit();
	}

}
