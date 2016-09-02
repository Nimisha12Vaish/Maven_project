package maven_package_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase3505 {
	
	Properties prop1 = null;
	ChromeDriver driver; 
		
	/*@BeforeTest
	public void startBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();	
	}*/
	

  @Test
  public void f_3505() throws IOException, InterruptedException {
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
	  
	  //load properties file
	  prop1 = new Properties();
	  try {
		prop1.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  //to login w3 (instance of Login class)
	  Login page_login = new Login();
	  page_login.w3_login(this.driver, this.prop1);

	 
	  //Select brand as System Storage and Business Partner as "SoftChoice Corporation"
	  /*driver.findElement(By.id(prop1.getProperty("w3_business_partner"))).sendKeys(prop1.getProperty("w3_business_partner_value"));
	  System.out.println("BP filtered");
	  */
	  Thread.sleep(4000);
	  
	  
	//Select brand as System Storage
	  driver.findElement(By.xpath(prop1.getProperty("w3_brand"))).click();
	  driver.findElement(By.xpath(prop1.getProperty("w3_storage_select"))).click();
	  System.out.println("Brand is selected as System Storage");
	  
	  //Select Status as approved
	  driver.findElement(By.id(prop1.getProperty("w3_status_id"))).click();
	  driver.findElement(By.xpath(prop1.getProperty("w3_approved_id"))).click();
	  Thread.sleep(2000);
	  
	//Enter reg number
	  driver.findElement(By.xpath(prop1.getProperty("w3_reg_number"))).sendKeys("S164B9W");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(prop1.getProperty("w3_apply_button"))).click(); 		//click on apply button
	  
	  Thread.sleep(20000);
	  
	  Actions rt_click_act = new Actions(driver);
	 
	  //To get the registration number of 6th registration
	  WebElement element = driver.findElement(By.xpath(prop1.getProperty("w3_reg_fe_end_user")));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  
	  js.executeScript("arguments[0].scrollIntoView(false);", element);
	  
	  String exp_reg_no = element.getText();
	  System.out.println("registartion number is: " + exp_reg_no); 
	  
	  //To get the req num
	 String exp_reg_req_num = driver.findElement(By.xpath(prop1.getProperty("w3_reg_req_no"))).getText();
	 System.out.println("Registartion Request number is: " + exp_reg_req_num); 
	 
	  //right click on registration
	  rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_reg_fe_end_user")))).perform();
	 
	  driver.findElement(By.xpath(prop1.getProperty("rt_click_w3_expire"))).click();    //click on expire
		
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(prop1.getProperty("open_mail_template_dd"))).click();   //open the mail template drop down
		
	  Thread.sleep(5000);
	  driver.findElement(By.xpath(prop1.getProperty("select_mail_template_2"))).click();	//select mail template
		
	  driver.findElement(By.xpath(prop1.getProperty("mail_select_button"))).click();  //click on Select button
		
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(prop1.getProperty("mail_submit"))).click();   //click on Submit button
	  
	  Thread.sleep(3000);
	  System.out.println("Submitted Mail template");
		
		//To enter the comment
		WebElement frame = driver.findElement(By.xpath(prop1.getProperty("iframe_enter_comment")));
		driver.switchTo().frame(frame);
		WebElement body = driver.findElement(By.tagName("body"));
		body.sendKeys("Registration expired");
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop1.getProperty("iframe_comment_submit"))).click();        //To click on submit button
		
		Thread.sleep(9000);
		//check if registration page is opened
		if(driver.findElement(By.xpath(prop1.getProperty("reg_page_open_check"))).isDisplayed())
		
			System.out.println("Registration tab is successfully loaded");
		else
		{
			System.out.println("Registration tab is not opened");
		}
		
		//enter the reg number
		//driver.findElement(By.xpath(prop1.getProperty("w3_reg_number"))).sendKeys(exp_reg_no);
		driver.findElement(By.xpath(prop1.getProperty("w3_req_num"))).sendKeys(exp_reg_req_num);
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop1.getProperty("w3_apply_button"))).click();    //click apply button
		 
		Thread.sleep(12000);
		String status = driver.findElement(By.xpath(prop1.getProperty("w3_reg_status"))).getText();  //to get status of registration
		  
		//Verify the status as Expired
		  if(status.equalsIgnoreCase("exp"))
		  System.out.println("Status of registartion is expired");
		  
		  else
		  {
			  System.out.println("Registration is not expired");
		  }
		  
		 String parentwindow = driver.getWindowHandle();          		// Current window details
		 
		 Thread.sleep(4000);
		 rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_reg_status")))).perform();		//right click on registration
		 driver.findElement(By.xpath(prop1.getProperty("rt_click_view_record"))).click(); 		//to view record
	 
		 //Transfer control to View record window
		 for(String winHandle: driver.getWindowHandles())
		 {
			 driver.switchTo().window(winHandle);
			 System.out.println("Opened View record page");
			 Thread.sleep(9000);
		 }
	  
	  
		//To take screenshot of email notification
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File Scnshot = oScn.getScreenshotAs(OutputType.FILE);
		File ofile = new File(prop1.getProperty("tc3505_view_record"));
	  	FileUtils.copyFile(Scnshot, ofile);
	  	System.out.println("Taken Screenshot of View record page");
	  	driver.close();												//close the view record window
	  
	  	driver.switchTo().window(parentwindow);						//control back to parent window
	  
	  	//To view history
	  	Thread.sleep(4000);
	  	rt_click_act.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_reg_status")))).perform();
	  	driver.findElement(By.xpath(prop1.getProperty("rt_click_view_history"))).click();
	  
	  	//Transfer control to View history window
	  	for(String winHandle: driver.getWindowHandles())
	  	{
	  		driver.switchTo().window(winHandle);
	  		Thread.sleep(9000);
	  	}
	  
	  	//open the email attachment
	  	driver.findElement(By.xpath(prop1.getProperty("email_attachment"))).click();
	  
	  	Thread.sleep(4000);
	  
	  	//To transfer control to Email attachment
	  	for(String subwinHandle: driver.getWindowHandles())
	  	{
	  		if(subwinHandle.equals("Email"))
	  		{
	  		driver.switchTo().window(subwinHandle);
	  		       
	  		}
	  		Thread.sleep(4000);
	  	}
	  	
	  	
	  	//To get attachment title
	  	String email_attachment_title = driver.findElement(By.xpath(prop1.getProperty("attachment_title"))).getText();
	  	System.out.println("Attachment title is: " + email_attachment_title);
	  	Thread.sleep(2000);
	  	
	  	/*String Sent_date = driver.findElement(By.xpath(".//*[@id='emailDiv']/table/tbody/tr[2]/td[1]")).getText();
	  	System.out.println(Sent_date);
	  	
	  	String Sent_by = driver.findElement(By.xpath("//*[@id='emailDiv']/table/tbody/tr[2]/td[5]")).getText();
	  	System.out.println(Sent_by); */
	  	

	  //To get Sent To details
	  	String Sent_To = driver.findElement(By.xpath(prop1.getProperty("email_sent_To"))).getText();
	  	System.out.println("Sent To: " + Sent_To);
	  	
	  	//To get Sent CC details
	  	String Sent_CC = driver.findElement(By.xpath(prop1.getProperty("email_sent_cc"))).getText();
	  	System.out.println("Sent CC: " + Sent_CC);
	  	driver.close();
	  	
	  	Thread.sleep(3000);
	  	driver.switchTo().window(parentwindow); 	//control back to parent window
	  	
	  	/*
	  //Login to BP portal
	  	page_login.BP_portal_login(driver, prop1);
	  	//String exp_reg_no = "S16FXV3";
	  	Thread.sleep(10000);
	  	
	  	
	  	
	  	driver.findElement(By.id(prop1.getProperty("p_request_num"))).sendKeys(exp_reg_req_num);  //enter the expired reg number
	  	//driver.findElement(By.id(prop1.getProperty("p_registration_id"))).sendKeys(exp_reg_no);  //enter the expired reg number
	  	
	  	Thread.sleep(7000);
	  //select brand as System Storage
	  	WebDriverWait wait = new WebDriverWait(driver, 80);
		 WebElement cb_ss = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("p_ss_xpath"))));
		    driver.findElement(By.xpath(prop1.getProperty("p_ss_xpath"))).click();
		    Thread.sleep(3000);
	  	
	    */
	  	
	  	/* WebElement checkbox1 = driver.findElement(By.id(prop1.getProperty("p_brand_cb_all")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", checkbox1);	
			checkbox1.click();
	  	*/
	  	
	  	/*
	  	//To verify the status of reg
	  	Thread.sleep(2000);
	  	String portal_status = driver.findElement(By.xpath(prop1.getProperty("p_first_reg_status"))).getText();
	  	System.out.println("Registration status is: " + portal_status);
	  	
	  	
	  	if(portal_status.equalsIgnoreCase("Expired")){
	  		System.out.println("Registration is in Expired status in BP portal listing page");	
	  	}
	  	else{
	  		System.out.println("Registration is NOT in Expired status in BP portal listing page");
	  	} 
	  	*/
	  	
	 driver.quit();	
	  
  }
}
