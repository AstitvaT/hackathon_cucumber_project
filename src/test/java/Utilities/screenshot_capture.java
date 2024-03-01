package Utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class screenshot_capture {
	
public static void final_message_screenshot(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File homeSRC = ts.getScreenshotAs(OutputType.FILE);
		File homePageLOC = new File(System.getProperty("user.dir") + "//screenshot//final_thankyou_message.png");
		try {
 
			FileUtils.copyFile(homeSRC, homePageLOC);
 
		} catch (IOException e) {
 
			e.printStackTrace();
		}
	}

}
