package maven_package_1;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


//import com.google.common.collect.*;
public class reprocess_app {
  @Test
  public void Reprocess_Approved()throws InterruptedException, IOException {
	  
	  File file = new File("C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\java\\property_files\\config_regression.properties");

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
	  	    driver.get(prop.getProperty("W3_Reg_url"));
	  	    WebDriverWait wait=new WebDriverWait(driver, 180);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_login_user")))).sendKeys(prop.getProperty("W3_username"));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_login_pw")))).sendKeys(prop.getProperty("W3_password"));
		  driver.findElement(By.id(prop.getProperty("W3_signin_button"))).click();   //sign in
		  

		 
		  driver.findElement(By.xpath(prop.getProperty("W3_status_drop_down"))).click();    // Status drop down

		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_select_approved")))).click();    // Select approved

		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_reg_apply_button")))).click();    // Apply button


		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_first_element"))));   
		  Thread.sleep(2000);
		  Actions act = new Actions(driver);
		  act.contextClick(driver.findElement(By.xpath(prop.getProperty("W3_first_element")))).perform();     // Right click on the first element
		  
		  //Thread.sleep(3000);
		  String actualtext =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_right_click_reprocess")))).getText();
		  System.out.println("-----" + actualtext +"----");
		  String expResult="123";
		  System.out.println("====="+ expResult +"====="); 
		  boolean flag = false ;
		  try{
		  if(expResult.equals(actualtext))
		  {

			 flag=true; 
		  }
		  }
		  catch(Exception e){
			  System.out.println(e);
			  File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          
			  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Prod_Outage\\screenshot.png"));
		  }
		  
		 /* else
		  {
			  flag=false;
		  }
		  System.out.println(flag);
		  Assert.assertTrue(flag);*/
		  driver.quit();
  }} 