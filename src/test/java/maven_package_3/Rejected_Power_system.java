package maven_package_3;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Property_use;
import resources.W3_main;

public class Rejected_Power_system {
	WebDriver driver;
	//Properties prop = null;
	/*@BeforeTest
	public void startBrowser()
	{
		 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	}*/
  @Test
  public void Rej_powersystem() throws Exception{
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
	  W3_main obj = new W3_main();
	  String RequestNo = obj.W3e2e_assign_powersystem(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  driver.findElement(By.linkText("Tasks")).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Request_ID_Task_tab")))).sendKeys(RequestNo);
	  driver.findElement(By.xpath(prop2.getProperty("W3_task_search_apply"))).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(.,'"+RequestNo+"')]"))).click();
	 // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(.,'326725')]"))).click();
	 	 Actions act=new Actions(driver);
	 	 act.contextClick(driver.findElement(By.xpath("//td[contains(.,'"+RequestNo+"')]"))).perform();
	 	 //act.contextClick(driver.findElement(By.xpath("//td[contains(.,'326725')]"))).perform();
	 	  driver.findElement(By.xpath(prop2.getProperty("W3_task_review"))).click();//review
	 	  Thread.sleep(5000);
	 	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_task_rej_click")))); //incomplete
	 	Thread.sleep(2000);
	 	driver.findElement(By.xpath(prop2.getProperty("W3_task_rej_click"))).click(); 
	 	 driver.findElement(By.xpath(prop2.getProperty("W3_task_inc_ok"))).click();   //OK
	 	Thread.sleep(3000);
	 	// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("W3_task_save_comments")))).click(); //save comments
	 	 driver.findElement(By.xpath(prop2.getProperty("W3_task_save_comments"))).click();
	 	 
	 	 driver.findElement(By.xpath(prop2.getProperty("W3_task_save_continue"))).click(); //save nd continue
	 	  Thread.sleep(2000);
	 	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_task_rej_click")))).click();//incomplete
	 
	 	  driver.findElement(By.xpath(prop2.getProperty("W3_task_mailbox"))).clear();
	 	  driver.findElement(By.xpath(prop2.getProperty("W3_task_mail_to"))).clear();
	 	  driver.findElement(By.xpath(prop2.getProperty("W3_task_mail_to"))).sendKeys(prop2.getProperty("W3_task_mail_to_name"));
	 	  driver.findElement(By.xpath(prop2.getProperty("W3_task_mail_cc"))).clear();
	 	  driver.findElement(By.xpath(prop2.getProperty("W3_task_mail_cc"))).sendKeys(prop2.getProperty("W3_task_mail_cc_name"));
	 	  Thread.sleep(5000);
	 	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_task_submit")))).click();
	 	
	 	Thread.sleep(2000);
	 	
	 	driver.quit();
  }
}
