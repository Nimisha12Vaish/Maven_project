package maven_package_2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase3497_power {
	
Properties prop1;
ChromeDriver driver; 
	
@BeforeTest
public void startBrowser(){
	
	//System.setProperty("webdriver.chrome.driver","C:\\Office_extra\\Set up\\chromedriver.exe" );
	System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
	 ChromeDriver driver=new ChromeDriver();
}
	
  @Test
  public void f_3497_power() throws InterruptedException, IOException {
	 
	  //Reading data from pageObject.properties file
	  FileInputStream fis = null;
	try {
		fis = new FileInputStream("C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\java\\property_files\\pageObject.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  //load properties file
	  prop1 = new Properties();
	  try {
		prop1.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	  
	 
	  //To login BP portal (instance of Login class)
	  Login login = new Login();
	  login.BP_portal_login(driver, prop1);
	  
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 180);
	  
	  Thread.sleep(7000);
	  
	//Enter reg num
		 driver.findElement(By.id(prop1.getProperty("p_registration_id"))).sendKeys("P16ZQ3T");
		 Thread.sleep(4000);
		 
		 
	//select brand as power systems
		/* WebElement element = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("p_ps_xpath"))));
		    driver.findElement(By.xpath(prop1.getProperty("p_ps_xpath"))).click();
		    Thread.sleep(3000);
		  
		 System.out.println("Power System Brand");
		 */
		 
		 
		 
		 //Select status as Approved or expired
		 WebElement element1 = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(By.id(prop1.getProperty("p_status_cb_approved_id"))));
		    driver.findElement(By.id(prop1.getProperty("p_status_cb_approved_id"))).click();
		 
		    
		    driver.findElement(By.id(prop1.getProperty("p_status_cb_expired_id"))).click();
		
		
		    Thread.sleep(10000);
		
		
		//Check if approved or expired registration exists
		if(driver.findElement(By.xpath(prop1.getProperty("p_first_reg_sub"))).isDisplayed())
			System.out.println("Registration exists");
		
		else
		{
			System.out.println("No approved/expired Registration ");
		}
		
		//Details of first approved or expired registration 
		String reg_sub_detail = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_sub"))).getText();
		String reg_req_detail = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_req"))).getText();
		String reg_no_detail = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_no"))).getText();
		System.out.println("Registration details are: Submission ID = " + reg_sub_detail + ", Request ID = " + reg_req_detail + " and Registration no. = " + reg_no_detail);
		
		
		//Re-register the approved or expired registration
		Actions rt_click_act = new Actions(driver);
		rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("p_first_reg_sub")))).perform();
		
		driver.findElement(By.xpath(prop1.getProperty("p_rt_click_reRegister"))).click();

		//Verifying the Deal registration form page is opened
		WebDriverWait oWDW = new WebDriverWait(driver, 180);
		String actualtext =  oWDW.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("f_reg_title")))).getText();
		String expectedtext = "Deal registration form";
		 
		try{
			 if (actualtext.contains(expectedtext))
				 System.out.println("Form Page is opened");
			  }
			  catch(Exception e){
				  System.out.println(e);
			  }
		 
		 //Fill required fields in form
		 WebElement country = driver.findElement(By.id(prop1.getProperty("f_country_id")));
		 country.clear();
		 country.sendKeys(prop1.getProperty("f_country_value"));
		 country.sendKeys(Keys.TAB);
		 
		 driver.findElement(By.id(prop1.getProperty("f_eu_street_add_id"))).sendKeys(prop1.getProperty("f_eu_street_add_value"));
		 
		 driver.findElement(By.id(prop1.getProperty("f_bp_phone"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_bp_phone"))).sendKeys(prop1.getProperty("f_bp_phone_value"));
		 
		 
		 driver.findElement(By.id(prop1.getProperty("f_leading_prog"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_leading_prog"))).sendKeys(prop1.getProperty("leading_program_value_ps"));
		 driver.findElement(By.id(prop1.getProperty("f_leading_prog"))).sendKeys(Keys.TAB);
		
		
		Thread.sleep(2000);
		driver.findElement(By.id(prop1.getProperty("f_opp_name_id"))).clear();
		driver.findElement(By.id(prop1.getProperty("f_opp_name_id"))).sendKeys(prop1.getProperty("f_opp_name_value"));
		
		Thread.sleep(2000);
		 driver.findElement(By.id(prop1.getProperty("f_decision_date_id"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_decision_date_id"))).sendKeys(prop1.getProperty("f_decision_date_value"));
		 
		 /*
		 driver.findElement(By.id(prop1.getProperty("f_pw_distributor_name"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_pw_distributor_name"))).sendKeys("Avnet Inc");
		 driver.findElement(By.id(prop1.getProperty("f_pw_distributor_name"))).sendKeys(Keys.TAB);
		 
		 driver.findElement(By.id(prop1.getProperty("f_hw_id"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_hw_id"))).sendKeys(prop1.getProperty("f_hw_value"));
		 driver.findElement(By.id(prop1.getProperty("f_hw_id"))).sendKeys(Keys.TAB);
		 
		 driver.findElement(By.id(prop1.getProperty("f_mc_model_id"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_mc_model_id"))).sendKeys(prop1.getProperty("f_mc_model_value"));
		 
		 driver.findElement(By.id(prop1.getProperty("f_h/w_opp"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_h/w_opp"))).sendKeys(prop1.getProperty("f_h/w_opp_value"));
		 */
		 Thread.sleep(2000);
		 driver.findElement(By.id(prop1.getProperty("f_pw_install_date"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_pw_install_date"))).sendKeys(prop1.getProperty("f_pw_install_date_value"));
		 
		//To take Screenshot of form
		 File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file1, new File(prop1.getProperty("form_filled")));
		 
		 //Submitting the form
		 WebElement submit = driver.findElement(By.id(prop1.getProperty("f_submit_button_id")));

			if (submit.isDisplayed())
			    ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true",submit.isDisplayed());
			submit.click();
			
		//for verifying the form is submitted
			String submission_no = null;
		if(driver.getPageSource().contains("Your registration has been submitted successfully"))
			{
				System.out.println("Your registration has been submitted successfully");
				submission_no = driver.findElement(By.xpath(prop1.getProperty("f_submission_id_form"))).getText();
				System.out.println(submission_no);
				
				// To take Screenshot after submitting form
				File file2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  FileUtils.copyFile(file2, new File(prop1.getProperty("form_submitted")));
			}
			else
			{
				System.out.println("Some issue while registering");
				File file3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  FileUtils.copyFile(file3, new File(prop1.getProperty("form_issue")));
			}
		 
		//Open Existing registration list page
		 driver.findElement(By.linkText(prop1.getProperty("f_listing_page"))).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 // Enter the registration number
		 driver.findElement(By.id(prop1.getProperty("p_registration_id"))).sendKeys(reg_no_detail);
		 
		 //Take screenshot of registration details
		 File file4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file4, new File(prop1.getProperty("registration_detail")));
		 
		// Current window details
		 String parentwindow = driver.getWindowHandle();
		 
		 Thread.sleep(5000);
		// To view form
		rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("p_first_reg_req")))).sendKeys(Keys.ENTER).perform();
		
		// Switch to new window opened (view record)
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		    Thread.sleep(9000);
		}
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    String pdf_text= driver.findElement(By.partialLinkText("Save")).getText();
	    System.out.println(pdf_text);
		
	    //Take screen shot of View record
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    File file5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file5, new File(prop1.getProperty("view_form")));
	   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close(); // close newly opened View Record window when done with it
		driver.switchTo().window(parentwindow); // switch back to the original window
		
		//Save form as PDF
		/*rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("p_first_reg_sub")))).perform();
			
		driver.findElement(By.xpath(prop1.getProperty("p_rt_click_save_as_pdf"))).click();
		System.out.println("Saved PDF at C:\\WebDriverdownloads");
		*/
		
		
		 
		 // TO VERIFY ON W3 SITE
		 login.w3_login(this.driver, this.prop1);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  
		 driver.findElement(By.id(prop1.getProperty("w3_reg_id"))).sendKeys(reg_no_detail);
		 driver.findElement(By.xpath(prop1.getProperty("w3_apply_button"))).click();
		  
		 Thread.sleep(9000);
		  
		//Details of Re-registration 
		String reReg_eu = driver.findElement(By.xpath(prop1.getProperty("w3_reg_fe_end_user"))).getText();
		String reReg_bp_name = driver.findElement(By.xpath(prop1.getProperty("w3_reg_bp_name"))).getText();
		String reReg_req_no = driver.findElement(By.xpath(prop1.getProperty("w3_reg_req_no"))).getText();
		System.out.println("Re-registration details are: End user = " + reReg_eu + ", BP name = " + reReg_bp_name + " and Req no. = " + reReg_req_no);
		
		//To verify the Request Number is appended with 'R' or not
		boolean appended = reReg_req_no.endsWith("R");
		System.out.println("The Request Number is appended with R: " + appended);
		

		// To view record
		String w3_window = driver.getWindowHandle();
		rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_reg_fe_end_user")))).perform();    
		driver.findElement(By.xpath(prop1.getProperty("rt_click_view_record"))).click();
		  
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
				    driver.switchTo().window(winHandle); 
				    Thread.sleep(15000);
				}
		  
		String rr_req_no =  driver.findElement(By.xpath(prop1.getProperty("VR_view_req_no"))).getText();
		System.out.println("Request no. in View Record is: " + rr_req_no);
		  
		/*//Take screenshot
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    File file6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file6, new File(prop1.getProperty("rr_ss_view_record")));
		*/
	   
		Thread.sleep(3000);
		//To download the Excel Sheet
		driver.findElement(By.partialLinkText("Export")).click();
		  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(w3_window); // switch back to the original window
	  
		//To open Print record
		rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_reg_fe_end_user")))).perform();   
		  
		driver.findElement(By.xpath(prop1.getProperty("rt_click_print_record"))).click();
		
		// Switch to new window opened - print form
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		    Thread.sleep(15000);
		}
		
		String rr_pr_req_no =  driver.findElement(By.xpath(prop1.getProperty("PR_print_req_no"))).getText();
		System.out.println("Request no. in print record is: " + rr_pr_req_no);
		  
		//Take screenshot of print record
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 File file7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file7, new File(prop1.getProperty("rr_ss_print_record")));
		
		 driver.close(); // close newly opened window when done with it
		 driver.switchTo().window(w3_window); 
			
		//To open View history
		rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_reg_fe_end_user")))).perform();   
		  
		driver.findElement(By.xpath(prop1.getProperty("rt_click_view_history"))).click();
		
		// Switch to new window opened - print form
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		    Thread.sleep(15000);
		}
		
		String rr_Vh_req_no =  driver.findElement(By.xpath(prop1.getProperty("VH_history_req_no"))).getText();
		System.out.println("Request no. in View History is: " + rr_Vh_req_no);
		  
		//Take screenshot of View History
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File file8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file8, new File(prop1.getProperty("rr_ss_history_record")));
			
		
		driver.quit(); // close both opened window when done with it
								
  }
  
}
