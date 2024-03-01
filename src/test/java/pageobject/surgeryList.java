package pageobject;

import java.time.Duration;
import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;



public class surgeryList  {
	public  WebDriver driver;
	public static JavascriptExecutor js ;

	public surgeryList(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@event=\"Nav:Interacted:Book an appointment\"]/div[1]")
	WebElement find_docs;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/span/a/i")
	WebElement practo_image;
	@FindBy(xpath="(//*[@class='product-tab__title'])[5]")
	WebElement surgery_option;
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/div/div[19]/div")
	WebElement surg_element;
	@FindBy(xpath="//p[@data-qa-id='surgical-solution-ailment-name']")
	List<WebElement> surgeries_list;
	
	public boolean webpage_verify()
	{
		find_docs.getText();
		return true;
	}
	
	
	
	public void click_surgery_option() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		surgery_option.click();

		
	}


	public void select_surgeries() throws InterruptedException {
		
		js.executeScript("arguments[0].scrollIntoView();",surg_element);
		 Thread.sleep(2000);
		
		
		for(int i=0; i<surgeries_list.size();i++) {
			System.out.println(surgeries_list.get(i).getText());
		}
	}

}
