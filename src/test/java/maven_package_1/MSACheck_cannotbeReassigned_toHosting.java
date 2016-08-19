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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MSACheck_cannotbeReassigned_toHosting  {
  @Test
  public void MSA_Check_cannot_reassigned() throws InterruptedException {
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
	  	    driver.get(prop.getProperty("W3_home_page_url"));
	  	    WebDriverWait wait=new WebDriverWait(driver, 180);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_login_user")))).sendKeys(prop.getProperty("W3_username"));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("W3_login_pw")))).sendKeys(prop.getProperty("W3_password"));
		  driver.findElement(By.id(prop.getProperty("W3_signin_button"))).click();
		  driver.findElement(By.partialLinkText("Admin")).click();
			
			//Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("tasks"))).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath(prop.getProperty("W3_Admin_managetask_apply"))));
		/*driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/"
								+ "div[1]/div/div/div/div/div/div/div[2]/div[8]/span[1]/span")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[2]/div[8]/span[1]/span")).click();
		System.out.println("All tasks appear");*/
		//Thread.sleep(20000);
				
		boolean flag=false;
		
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_Admin_task")))).click();  //task
		
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_select_MSA_check")))).click();  //MSA check
		//Thread.sleep(2000);
		System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_managetask_task_getText")))).getText());  //MSA Check get text
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(prop.getProperty("W3_Admin_managetask_apply"))));  //apply
		driver.findElement(By.xpath(prop.getProperty("W3_Admin_managetask_apply"))).click();// click apply
		driver.findElement(By.xpath(prop.getProperty("W3_Admin_managetask_apply"))).click();  //click apply
		System.out.println("All MSA check appear");
		
		
		Actions act=new Actions(driver);
		act.contextClick(driver.findElement(By.xpath(prop.getProperty("W3_Admin_task_first_element")))).perform(); //first task 
		act.sendKeys(Keys.RETURN).perform();
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(prop.getProperty("W3_Admin_task_reassign"))));
		driver.findElement(By.xpath(prop.getProperty("W3_managetask_reassign_userid"))).sendKeys(prop.getProperty("W3_managetask_reassign_username"));//reassign
		//Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_managetask_reassign_submit")))).click();//submit
		//Thread.sleep(10000);
		String a= "Please input valid user id to submit!";
		String b= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_managetask_reassign_invaliduser_message")))).getText();//message
		System.out.println(b);
		if(a.equals(driver.findElement(By.xpath(prop.getProperty("W3_managetask_reassign_invaliduser_message"))).getText()))
		{
			flag= true;
			System.out.println("The test case pass as the value of the flag is: "+flag);
			driver.close();
		}
		else
		{
			flag=false;
			System.out.println(flag);
		}
		
		Assert.assertTrue(flag, "fail");
		}
}

