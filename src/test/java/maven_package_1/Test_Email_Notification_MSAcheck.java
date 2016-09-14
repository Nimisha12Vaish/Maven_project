package maven_package_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Email_Notification_MSAcheck {
  
public void Email_Notify_MSACheck() throws InterruptedException {
		
		File file = new File("C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\java\\property_files\\config1.properties");

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
			driver.get(prop.getProperty("W3_URL"));
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_username")))).sendKeys(prop.getProperty("W3_username_value"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_password")))).sendKeys(prop.getProperty("W3_password_value"));
			driver.findElement(By.id(prop.getProperty(("W3_login_button")))).click();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(prop.getProperty("W3_task_tab"))).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
			
		  driver.findElement(By.xpath(prop.getProperty("W3_task_ddl"))).click();  //task ddl

		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("W3_MSAcheck_select")))); // MSA check
		  
		  driver.findElement(By.xpath(prop.getProperty("W3_MSAcheck_select"))).click();    // MSA check
		  driver.findElement(By.xpath(prop.getProperty("W3_brand_select"))).click();          //select brand

		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("W3_Power_select"))));    // power system
		  
		  driver.findElement(By.xpath(prop.getProperty("W3_Power_select"))).click();// power system

		  driver.findElement(By.xpath(prop.getProperty("W3_apply_button"))).click();   //Apply
		  
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("W3_first_element"))));  //first element
		  Actions act=new Actions(driver);
		  act.contextClick(driver.findElement(By.xpath(prop.getProperty("W3_first_element")))).perform();  //right click first element 
		  
		  
		  String actualtext = driver.findElement(By.xpath(prop.getProperty("W3_email_notification"))).getText();
		  System.out.println("-----" + actualtext +"----");
		  String expResult="Email Notification";
		  System.out.println("====="+ expResult +"====="); 
		  boolean flag = false ;
		  String s2 = "Mail template:";
		  if(expResult.equals(actualtext))
		  {
			
			 driver.findElement(By.xpath(prop.getProperty("W3_email_notification"))).click();
			 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("W3_verify"))));
			 String s1 = driver.findElement(By.xpath(prop.getProperty("W3_verify"))).getText();
			 System.out.println(s1);
			 if(s1.equals(s2))
			 {
				 flag =true;
			 }else{
				   flag = false;
			      }
			System.out.println(flag); 
		  }
		  Assert.assertTrue(flag, "mail template page was not found");
		  
		  
		  
		  
		  
		  
	  }

}
