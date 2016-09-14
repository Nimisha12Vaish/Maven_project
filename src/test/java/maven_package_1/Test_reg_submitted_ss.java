package maven_package_1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_reg_submitted_ss {
  @Test
  public void Email_submitted_SS()throws InterruptedException {
	  File file = new File("C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\java\\property_files\\config_New_1.properties");

	 	FileInputStream fileInput = null;
	 	try {
	 		fileInput = new FileInputStream(file);
	 	} catch (FileNotFoundException e) {
	 		e.printStackTrace();
	 	}
	 	Properties prop = new Properties();

	 	//load properties file
	 	try {
	 		prop.load(fileInput);
	 	} catch (IOException e) {
	 		e.printStackTrace();
	 	} 
	 	
	 	
	 	
	 	System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	  	 driver.manage().window().maximize(); 
	  	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	    driver.get(prop.getProperty("W3_URL_reg"));
	  	    WebDriverWait wait=new WebDriverWait(driver, 180);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_login_username")))).sendKeys(prop.getProperty("W3_login_username_value"));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_login_password")))).sendKeys(prop.getProperty("W3_login_password_value"));
		  driver.findElement(By.id(prop.getProperty("W3_login_button"))).click();   //sign in
		  
		  driver.findElement(By.xpath(prop.getProperty("W3_brand_ddl"))).click();    // Brand drop down
		  
		  driver.findElement(By.xpath(prop.getProperty("W3_storage_select"))).click();    // Select storage
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("W3_status_ddl"))).click();    // Status drop down
		  
		  driver.findElement(By.xpath(prop.getProperty("W3_submitted"))).click();    // Select submitted
		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("W3_apply_button"))).click();    // Apply button
			  
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_first_element"))));     
		  Actions act = new Actions(driver);
		  act.contextClick(driver.findElement(By.xpath(prop.getProperty("W3_first_element")))).perform();     // Right click on the first element
		  
		  //driver.findElement(By.xpath("html/body/div[11]/table/tbody/tr[6]/td[2]")).click();
		  Thread.sleep(3000);
		  String actualtext = driver.findElement(By.xpath(prop.getProperty("W3_email_notification"))).getText();
		  System.out.println("-----" + actualtext +"----");
		  String expResult="Email Notification";
		  System.out.println("====="+ expResult +"====="); 
		  boolean flag = false ;
		  String s2 = "Mail template:";
		  if(expResult.equals(actualtext))
		  {

			 driver.findElement(By.xpath(prop.getProperty("W3_email_notification"))).click();
			 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("W3_email_verify"))));
			 String s1 = driver.findElement(By.xpath(prop.getProperty("W3_email_verify"))).getText();
			 System.out.println(s1);
			 if(s1.equals(s2))
			 {
				 flag =true;
			 }else{
				   flag = false;
			      }
			System.out.println(flag); 
		  }
		  AssertJUnit.assertTrue(flag);
		  Thread.sleep(3000);
		  driver.quit();
		  
}}