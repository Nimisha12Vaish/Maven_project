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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testcase2842_linuxOne {
	
	ChromeDriver driver;
	Properties prop1 = null;
	
	@Test
	public void f_2842_linuxOne() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
	 ChromeDriver driver=new ChromeDriver();
		//Reading data from pageObject.properties file
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\java\\property_files\\pageObject.properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//load the properties file
		prop1 = new Properties();
		try {
			prop1.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//creating instance of Firefox
		
		
		
		/*System.setProperty("webdriver.chrome.driver","C:\\Office_extra\\Set up\\chromedriver.exe" );
		driver = new ChromeDriver(); */
		
		//To login BP portal
		Login page_login = new Login();
		page_login.BP_portal_login(driver, prop1);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		
		//check the page is opened
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop1.getProperty("p_request_num"))));
		
		 Thread.sleep(2000);
		//select brand as Power Systems
			WebElement cb_linux = driver.findElement(By.id(prop1.getProperty("p_linuxOne")));
		 JavascriptExecutor js = (JavascriptExecutor) driver;	
			
		//Enter reg num
		 driver.findElement(By.id(prop1.getProperty("p_registration_id"))).sendKeys("L16N4M1");
		 Thread.sleep(8000);
		 
		 /*
		 //select brand as LinuxOne
			 WebElement cb_LinuxOne = wait.until(
			            ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("p_linuxOne_xpath"))));
			    driver.findElement(By.xpath(prop1.getProperty("p_linuxOne_xpath"))).click();
			    Thread.sleep(3000);
		 */
		  
		    //Select status as Approved or expired
			 WebElement element1 = wait.until(
			            ExpectedConditions.visibilityOfElementLocated(By.id(prop1.getProperty("p_status_cb_approved_id"))));
			 driver.findElement(By.id(prop1.getProperty("p_status_cb_approved_id"))).click();
			    
			 driver.findElement(By.id(prop1.getProperty("p_status_cb_expired_id"))).click();
			
		
		System.out.println("Brand selected as: LinuxOne , Status: Approved or Expired");
		Thread.sleep(10000);
		
		
		
		//Get the req number and registration num of first Approved or Expired registration
		WebElement first_reg = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_req")));
		String first_app_exp_reg_req_num = first_reg.getText();
		
		String reg_no_detail = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_no"))).getText();
		System.out.println("The request number of first submitted registration is: " + first_app_exp_reg_req_num + " and Registartion num is: " + reg_no_detail);
		
		//to extend the reg
		Actions rt_click = new Actions(driver);
		rt_click.contextClick(first_reg).perform();
		
		driver.findElement(By.xpath(prop1.getProperty("p_rt_click_extend"))).click();
		
		//to check if Deal reg form page is opened or not
		String form_title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("f_reg_title")))).getText();
		
		if(form_title.contains("Deal registration"))
		{
			System.out.println("Deal reg extension page is loaded");
		}
		else
		{
			System.out.println("error loading the Deal reg extension form page");
		}
		
		
		//Filling the form
		Thread.sleep(3000);
		driver.findElement(By.id(prop1.getProperty("f_bp_phone"))).clear();
		driver.findElement(By.id(prop1.getProperty("f_bp_phone"))).sendKeys(prop1.getProperty("f_bp_phone_value"));
		 
		driver.findElement(By.id(prop1.getProperty("f_decision_date_id"))).clear();
		driver.findElement(By.id(prop1.getProperty("f_decision_date_id"))).sendKeys(prop1.getProperty("f_decision_date_value"));
		 
		driver.findElement(By.id(prop1.getProperty("f_linux_install_date"))).clear();
		driver.findElement(By.id(prop1.getProperty("f_linux_install_date"))).sendKeys(prop1.getProperty("f_pw_install_date_value"));
		 
		//select the supporting documentation
		WebElement supp_doc = driver.findElement(By.id(prop1.getProperty("f_extension_supp_doc_rb_linux")));
		js.executeScript("arguments[0].scrollIntoView(false);", supp_doc);
		 
		supp_doc.click();
		 
		//option selected for extension request
		System.out.println("Supporting document option selected for extension is: " + driver.findElement(By.id(prop1.getProperty("f_extension_supp_doc_label_linux"))).getText());
		 
			Thread.sleep(3000);
			//get heading of attachment section
			String text = driver.findElement(By.xpath(prop1.getProperty("f_ext_add_attachment_header_linux"))).getText();
			System.out.println(text);
			
			//click on add attachment
			WebElement attachment = driver.findElement(By.xpath(prop1.getProperty("f_ext_add_attachment_linux")));
			
			js.executeScript("arguments[0].scrollIntoView(false);", attachment);
			attachment.click();
			  
			System.out.println("opened dialog box");
			  
			Thread.sleep(3000);
			
			
			String parentwindow = driver.getWindowHandle();
			
			for(String newwindows: driver.getWindowHandles())
			{
				driver.switchTo().window(newwindows);
				
				Thread.sleep(3000);
			}
			
			
			//get dialog box title
			String sub_title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("f_attach_subtitle")))).getText();
			System.out.println(sub_title);
			
			//to browse a file
			driver.findElement(By.id(prop1.getProperty("f_browse_attachment"))).sendKeys(prop1.getProperty("f_browse_file_path"));
			
			System.out.println("File uploaded");
			Thread.sleep(4000);
			
			//To upload a file
			driver.findElement(By.id(prop1.getProperty("f_upload_button"))).click();
			Thread.sleep(4000);
			
			//to close file attachment pop up window
			driver.findElement(By.xpath(prop1.getProperty("f_close_attachment_window2"))).click();
			
			//Submitting the form
			WebElement submit = driver.findElement(By.id(prop1.getProperty("f_submit_button_id")));
			submit.click();
		
			Thread.sleep(4000);
			//for verifying the form is submitted
			String submission_no = null;
			if(driver.getPageSource().contains("Your registration has been submitted successfully"))
			{
				System.out.println("Your registration has been submitted successfully");
				submission_no = driver.findElement(By.xpath(prop1.getProperty("f_submission_id_form"))).getText();
				System.out.println("Registration submission number is: " + submission_no);
				
				// To take Screenshot after submitting form
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  FileUtils.copyFile(file, new File(prop1.getProperty("TC2842_extension_form_submitted")));
			}
			else
			{
				System.out.println("Some issue while registering");
				File file3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  FileUtils.copyFile(file3, new File(prop1.getProperty("TC2842_form_issue")));
			}
			
			
			
			//Open Existing registration list page
			 driver.findElement(By.linkText(prop1.getProperty("f_listing_page"))).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 Thread.sleep(4000);
			 // Enter the registration number  
			 driver.findElement(By.xpath(prop1.getProperty("p_reg_id"))).clear();
			 driver.findElement(By.xpath(prop1.getProperty("p_reg_id"))).sendKeys(reg_no_detail);
			 	 
			 
			//Select brand as LinuxOne
			/* WebElement element3 = wait.until(
			            ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("p_linuxOne_xpath"))));
			    driver.findElement(By.xpath(prop1.getProperty("p_linuxOne_xpath"))).click();
			    */
			    Thread.sleep(3000);
			 
			 Thread.sleep(4000);
			 //Verify the "E" is appended with Request number
			String extended_reg_req_num = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_req"))).getText();
			
					
			if(extended_reg_req_num.endsWith("E"))
			{
				System.out.println("Extended registartion Request number is: " +  extended_reg_req_num + " i.e., appended with E");
			}
			
			else
			{
				System.out.println("Extended registartion Request number is: " + extended_reg_req_num + " i.e., NOT appended with E");
			}
			
			
			
		//VERIFY THE SUBMITTED, REJECTED, WITHDRAWN AND COMPLETE registrations CANT BE EXTENDED
		System.out.println("VERIFY THE SUBMITTED, REJECTED, WITHDRAWN AND COMPLETE registrations CANT BE EXTENDED");
		
		/*
		//Select brand as LinuxOne
		js.executeScript("arguments[0].scrollIntoView(false);", cb_linuxOne);
		wait.until(ExpectedConditions.elementToBeClickable(cb_linuxOne)).click();
		*/
		
		//clear the registration field
		driver.findElement(By.id(prop1.getProperty("p_registration_id"))).clear();
		
		//VERIFY FOR SUBMITTED REGISTRATIONS
		
		//Filter Submitted registrations
		WebElement cb_submitted = driver.findElement(By.id(prop1.getProperty("p_status_cb_submitted_id")));
		cb_submitted.click();
		
		Thread.sleep(3000);
		//Get the req number of first submitted registration
		WebElement first_sub_reg = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_req")));
		System.out.println("The request number of first submitted registration is: " + first_sub_reg.getText());
		
		//rt click on reg to check if we can extend it or not
		rt_click.contextClick(first_sub_reg).perform();
		
		
		TakesScreenshot scn = (TakesScreenshot) driver;
		File file1 = new File(prop1.getProperty("tc_2842_submitted_no_extend"));
		File scnShot = scn.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scnShot, file1);
		
		System.out.println("Captured screenshot that Registration with Submitted status cant be extended");
		Thread.sleep(4000);
		
		//VERIFY FOR REJECTED REGISTRATIONS
		
		//uncheck the submitted and filter the rejected registrations
		js.executeScript("arguments[0].scrollIntoView(false);", cb_submitted);
		cb_submitted.click();
		
		WebElement cb_rejected = driver.findElement(By.id(prop1.getProperty("p_status_cb_rejected_id")));
		cb_rejected.click();
		
		Thread.sleep(3000);
		//Get the req number of first rejected registration
		WebElement first_rej_reg = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_req")));
		String first_rej_reg_req_num = first_rej_reg.getText();
		System.out.println("The request number of first rejected registration is: " + first_rej_reg_req_num);
		
		rt_click.contextClick(first_rej_reg).perform();    //rt click on registration
		
		
		File scnShot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file2 = new File(prop1.getProperty("tc_2842_rejected_no_extend"));
		FileUtils.copyFile(scnShot2, file2);
		
		System.out.println("Captured screenshot that Registration with Rejected status cant be extended");
		Thread.sleep(4000);
		
		
		//VERIFY FOR INCOMPLETE and WITHDRAWN REGISTRATIONS
		
		//uncheck the rejected and filter the withdrawn and incomplete registrations
		js.executeScript("arguments[0].scrollIntoView(false);", cb_rejected);
		cb_rejected.click();
		
		driver.findElement(By.id(prop1.getProperty("p_status_cb_incomplete_id"))).click();
		driver.findElement(By.id(prop1.getProperty("p_status_cb_withdrawn_id"))).click();
		
		Thread.sleep(3000);
		//Get the req number of first incomplete or withdrawn registration
		WebElement first_iw_reg = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_req")));
		String first_iw_reg_req_num = first_iw_reg.getText();
		System.out.println("The request number of first incomplete or withdrawn registration is: " + first_iw_reg_req_num);
		
		rt_click.contextClick(first_iw_reg).perform();    //rt click on registration
		
		File scnShot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file3 = new File(prop1.getProperty("tc_2842_iw_no_extend"));
		FileUtils.copyFile(scnShot3, file3);
		
		System.out.println("Captured screenshot that Registration with Withdrawn and incomplete status cant be extended");

		driver.quit();
		
		
				
	}
	


}
