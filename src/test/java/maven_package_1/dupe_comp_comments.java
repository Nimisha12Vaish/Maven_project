package maven_package_1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class dupe_comp_comments {
  @Test
  public void Dupe_complete_complete()throws InterruptedException {
	  
	  File file = new File("C:\\Users\\IBM_ADMIN\\Maven\\Maven_project\\src\\test\\java\\property_files\\config_regression.properties");

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
	  
	  
	 WebDriver driver= new FirefoxDriver();
	  	 driver.manage().window().maximize(); 
	  	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	    driver.get(prop.getProperty("W3_task_url"));
	  	    WebDriverWait wait=new WebDriverWait(driver, 180);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_login_user")))).sendKeys(prop.getProperty("W3_username"));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_login_pw")))).sendKeys(prop.getProperty("W3_password"));
		  driver.findElement(By.id(prop.getProperty("W3_signin_button"))).click();   //sign in
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_Task_first_element")))); 
		 //Thread.sleep(10000);
		  //wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_task_table")))).click();
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_task_drop_down")))).click();    // Task drop down

		  driver.findElement(By.xpath(prop.getProperty("W3_select_dupe_complete_comments"))).click();    // Select duplicate complete

		 Thread.sleep(5000);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_apply_button")))).click();    // Apply button


		  //Thread.sleep(10000);

		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_Task_first_element"))));   
		  Actions act = new Actions(driver);
		  act.contextClick(driver.findElement(By.xpath(prop.getProperty("W3_Task_first_element")))).perform();     // Right click on the first element

		  
		  //Thread.sleep(3000);
		  act.sendKeys(Keys.RETURN).perform();
		  //Thread.sleep(10000);
		//  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div[9]/div[5]/div/div[4]/div[7]/h2/a[contains(.,'Global')]")));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_select_approve")))).click();  //select approve
		  
		  driver.findElement(By.xpath(prop.getProperty("W3_submit_button"))).click();   //send email button
		  
		 String comment=  driver.findElement(By.xpath(prop.getProperty("W3_error_string"))).getText();
		  
		 System.out.println("error is: " + comment);
		  driver.quit();
  }} 