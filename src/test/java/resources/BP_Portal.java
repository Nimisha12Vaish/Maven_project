package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import resources.Property_use;

public class BP_Portal {
	
  @Test
  public String BPportal_power_system(WebDriver driver) throws Exception {
	  
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
 	
	//  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
	//  ChromeDriver driver=new ChromeDriver();
	  	 driver.manage().window().maximize(); 
	  	 try{
	  
	  
	  	driver.get(prop2.getProperty("BP_url"));
	  	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  	driver.findElement(By.id(prop2.getProperty("BP_user_id"))).clear();
	  	driver.findElement(By.id(prop2.getProperty("BP_user_id"))).sendKeys(prop2.getProperty("BP_username"));
	  	driver.findElement(By.id(prop2.getProperty("BP_pass_id"))).clear();
	  	driver.findElement(By.id(prop2.getProperty("BP_pass_id"))).sendKeys(prop2.getProperty("BP_password"));
	  	
	  	driver.findElement(By.id(prop2.getProperty("BP_login_xpath"))).click();  //login
	  	
	  	WebDriverWait wait=new WebDriverWait(driver, 180); 
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("BP_template_power_system")))); //waiting for template to load 
	
	  	
	  	//driver.findElement(By.xpath("//*[@id='ibm_tab2_tab']")).click();
	  
	//    Thread.sleep(10000);
	    //String element= "***Selenium Test Purpose***";
	  	//Send_mail.Add_Log.info("Submitting the Registration from BP Portal");
	  	driver.findElement(By.xpath(prop2.getProperty("BP_template_power_system"))).click(); 

	       Actions act=new Actions(driver);
	 	  act.contextClick(driver.findElement(By.xpath(prop2.getProperty("BP_template_power_system")))).perform();  // Right click on the template
	  	driver.findElement(By.xpath(prop2.getProperty("BP_copy_create"))).click();                       // click copy and create
	  	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='storage_exculsive']"))).click();
	  Thread.sleep(20000);
	  	driver.findElement(By.xpath(prop2.getProperty("BP_submit_button"))).click();   //Submit button
	  
	 // 	Thread.sleep(4000);
	  String str = driver.findElement(By.xpath(prop2.getProperty("BP_submission_id"))).getText();     //taking the submission id
	  String RegNo = str.replaceAll("[^0-9]", "");  
	  System.out.println(str);
	  // extracting the submission id from the entire line of text
	   
	  
	  
	  	 
return RegNo;
	  	 }
	 catch(Exception e){
		  //TakesScreenshot driver= new FirefoxDriver();
		  File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		  
		  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\error_screenshot.png")); 
		 
			throw e;
			}
	  	 }	
  @Test
  public String BPportal_system_storage(WebDriver driver) throws Exception
  {
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
 	
	//  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
	//  ChromeDriver driver=new ChromeDriver();
	  	 driver.manage().window().maximize(); 
	  	 try{
	  
	  
	  	driver.get(prop2.getProperty("BP_url"));
	  	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  	driver.findElement(By.id(prop2.getProperty("BP_user_id"))).clear();
	  	driver.findElement(By.id(prop2.getProperty("BP_user_id"))).sendKeys(prop2.getProperty("BP_username"));
	  	driver.findElement(By.id(prop2.getProperty("BP_pass_id"))).clear();
	  	driver.findElement(By.id(prop2.getProperty("BP_pass_id"))).sendKeys(prop2.getProperty("BP_password"));
	  	
	  	driver.findElement(By.id(prop2.getProperty("BP_login_xpath"))).click();  //login
	  	
	  	WebDriverWait wait=new WebDriverWait(driver, 180); 
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("BP_template_system_storage")))); //waiting for template to load 
	
	  	
	  	//driver.findElement(By.xpath("//*[@id='ibm_tab2_tab']")).click();
	  
	//    Thread.sleep(10000);
	    //String element= "***Selenium Test Purpose***";
	  	//Send_mail.Add_Log.info("Submitting the Registration from BP Portal");
	  	driver.findElement(By.xpath(prop2.getProperty("BP_template_system_storage"))).click(); 

	       Actions act=new Actions(driver);
	 	  act.contextClick(driver.findElement(By.xpath(prop2.getProperty("BP_template_system_storage")))).perform();  // Right click on the template
	  	driver.findElement(By.xpath(prop2.getProperty("BP_copy_create"))).click();                       // click copy and create
	  	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='storage_exculsive']"))).click();
	  Thread.sleep(20000);
	  	driver.findElement(By.xpath(prop2.getProperty("BP_submit_button"))).click();   //Submit button
	  
	 // 	Thread.sleep(4000);
	  String str = driver.findElement(By.xpath(prop2.getProperty("BP_submission_id"))).getText();     //taking the submission id
	  String RegNo = str.replaceAll("[^0-9]", "");  
	  System.out.println(str);
	  // extracting the submission id from the entire line of text
	   
	  
	  
	  	 
return RegNo;
	  	 }
	 catch(Exception e){
		  //TakesScreenshot driver= new FirefoxDriver();
		  File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		  
		  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\error_screenshot.png")); 
		 
			throw e;
			}
  }
  
  @Test
  public String BPportal_LinuxONE(WebDriver driver) throws Exception{
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
 	
	//  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
	//  ChromeDriver driver=new ChromeDriver();
	  	 driver.manage().window().maximize(); 
	  	 try{
	  
	  
	  	driver.get(prop2.getProperty("BP_url"));
	  	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  	driver.findElement(By.id(prop2.getProperty("BP_user_id"))).clear();
	  	driver.findElement(By.id(prop2.getProperty("BP_user_id"))).sendKeys(prop2.getProperty("BP_username"));
	  	driver.findElement(By.id(prop2.getProperty("BP_pass_id"))).clear();
	  	driver.findElement(By.id(prop2.getProperty("BP_pass_id"))).sendKeys(prop2.getProperty("BP_password"));
	  	
	  	driver.findElement(By.id(prop2.getProperty("BP_login_xpath"))).click();  //login
	  	
	  	WebDriverWait wait=new WebDriverWait(driver, 180); 
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("BP_template_LinuxONE")))); //waiting for template to load 
	
	  	
	  	//driver.findElement(By.xpath("//*[@id='ibm_tab2_tab']")).click();
	  
	//    Thread.sleep(10000);
	    //String element= "***Selenium Test Purpose***";
	  	//Send_mail.Add_Log.info("Submitting the Registration from BP Portal");
	  	driver.findElement(By.xpath(prop2.getProperty("BP_template_LinuxONE"))).click(); 

	       Actions act=new Actions(driver);
	 	  act.contextClick(driver.findElement(By.xpath(prop2.getProperty("BP_template_LinuxONE")))).perform();  // Right click on the template
	  	driver.findElement(By.xpath(prop2.getProperty("BP_copy_create"))).click();                       // click copy and create
	  	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='storage_exculsive']"))).click();
	  Thread.sleep(20000);
	  	driver.findElement(By.xpath(prop2.getProperty("BP_submit_button"))).click();   //Submit button
	  
	 // 	Thread.sleep(4000);
	  String str = driver.findElement(By.xpath(prop2.getProperty("BP_submission_id"))).getText();     //taking the submission id
	  String RegNo = str.replaceAll("[^0-9]", "");  
	  System.out.println(str);
	  // extracting the submission id from the entire line of text
	   
	  
	 
	  	 
return RegNo;
	  	 }
	 catch(Exception e){
		  //TakesScreenshot driver= new FirefoxDriver();
		  File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		  
		  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\error_screenshot.png")); 
		 
			throw e;
			}
  }
  }

	  	
	  	
  