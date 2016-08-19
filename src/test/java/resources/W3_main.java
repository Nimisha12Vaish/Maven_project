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

public class W3_main {
  @Test
  public String W3e2e_assign_powersystem(WebDriver driver) throws Exception{
	 
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property(); 
	BP_Portal obj = new BP_Portal();
  	  String RequestNo = obj.BPportal_power_system(driver);
  	  
	 // WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize(); 
	  try{
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(prop2.getProperty("W3_main_url"));
	    WebDriverWait wait=new WebDriverWait(driver, 300);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop2.getProperty("W3_main_login_user")))).sendKeys(prop2.getProperty("W3_main_username"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop2.getProperty("W3_main_login_pw")))).sendKeys(prop2.getProperty("W3_main_password"));
	  driver.findElement(By.id(prop2.getProperty("W3_main_login_button"))).click();   //SignIn
	  
	  Thread.sleep(900000);
	  //Thread.sleep(300000);
	
	  driver.findElement(By.xpath(prop2.getProperty("W3_main_requestid"))).sendKeys(RequestNo);
	  driver.findElement(By.xpath(prop2.getProperty("W3_main_apply"))).click();          //Apply
	  
	 
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/table/tbody/tr/td[4]"))).click();
	  System.out.println("Form moved to IR status");
	  
	  File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	  
	  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\Form_moved_to_IR_screenshot.png")); 
	  
	  
	  
	  Actions act=new Actions(driver);
 	  
 	  act.contextClick(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/table/tbody/tr/td[4]"))).perform();
 	  Thread.sleep(5000);
 	  driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign"))).click();
 	  driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign_name"))).sendKeys(prop2.getProperty("W3_main_reassign_id"));
 	  Thread.sleep(3000);
 	 driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign_submit"))).click();  // submit
 	
 	 Thread.sleep(2000);
 	
 	
 	  return RequestNo;
	  }
	  
	  catch(Exception e){
 File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		  
		  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\error_screenshot.png")); 
		 
			throw e;}
		  
  }
  
  @Test
  public String W3e2e_assign_systemstorage(WebDriver driver) throws Exception{
	  
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property(); 
	BP_Portal obj = new BP_Portal();
  	  String RequestNo = obj.BPportal_power_system(driver);
  	  
	 // WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize(); 
	  try{
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(prop2.getProperty("W3_main_url"));
	    WebDriverWait wait=new WebDriverWait(driver, 300);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop2.getProperty("W3_main_login_user")))).sendKeys(prop2.getProperty("W3_main_username"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop2.getProperty("W3_main_login_pw")))).sendKeys(prop2.getProperty("W3_main_password"));
	  driver.findElement(By.id(prop2.getProperty("W3_main_login_button"))).click();   //SignIn
	  
	  Thread.sleep(900000);
	  //Thread.sleep(300000);
	
	  driver.findElement(By.xpath(prop2.getProperty("W3_main_requestid"))).sendKeys(RequestNo);
	  driver.findElement(By.xpath(prop2.getProperty("W3_main_apply"))).click();          //Apply
	  
	 
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/table/tbody/tr/td[4]"))).click();
	  System.out.println("Form moved to IR status");
	  
	  File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	  
	  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\Form_moved_to_IR_screenshot.png")); 
	  
	  
	  
	  Actions act=new Actions(driver);
 	  
 	  act.contextClick(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/table/tbody/tr/td[4]"))).perform();
 	  Thread.sleep(5000);
 	  driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign"))).click();
 	  driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign_name"))).sendKeys(prop2.getProperty("W3_main_reassign_id"));
 	  Thread.sleep(3000);
 	 driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign_submit"))).click();  // submit
 	
 	 Thread.sleep(2000);
 	
 	
 	  return RequestNo;
	  }
	  
	  catch(Exception e){
 File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		  
		  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\error_screenshot.png")); 
		 
			throw e;}
	  
  }
  
  @Test
  public String W3e2e_assign_LinuxONE(WebDriver driver) throws Exception{
	  
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property(); 
	BP_Portal obj = new BP_Portal();
  	  String RequestNo = obj.BPportal_power_system(driver);
  	  
	 // WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize(); 
	  try{
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(prop2.getProperty("W3_main_url"));
	    WebDriverWait wait=new WebDriverWait(driver, 300);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop2.getProperty("W3_main_login_user")))).sendKeys(prop2.getProperty("W3_main_username"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop2.getProperty("W3_main_login_pw")))).sendKeys(prop2.getProperty("W3_main_password"));
	  driver.findElement(By.id(prop2.getProperty("W3_main_login_button"))).click();   //SignIn
	  
	  Thread.sleep(900000);
	  //Thread.sleep(300000);
	
	  driver.findElement(By.xpath(prop2.getProperty("W3_main_requestid"))).sendKeys(RequestNo);
	  driver.findElement(By.xpath(prop2.getProperty("W3_main_apply"))).click();          //Apply
	  
	 
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/table/tbody/tr/td[4]"))).click();
	  System.out.println("Form moved to IR status");
	  
	  File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	  
	  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\Form_moved_to_IR_screenshot.png")); 
	  
	  
	  
	  Actions act=new Actions(driver);
 	  
 	  act.contextClick(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/table/tbody/tr/td[4]"))).perform();
 	  Thread.sleep(5000);
 	  driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign"))).click();
 	  driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign_name"))).sendKeys(prop2.getProperty("W3_main_reassign_id"));
 	  Thread.sleep(3000);
 	 driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign_submit"))).click();  // submit
 	
 	 Thread.sleep(2000);
 	
 	
 	  return RequestNo;
	  }
	  
	  catch(Exception e){
 File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		  
		  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\error_screenshot.png")); 
		 
			throw e;}
  }
  }
  

  
 	  