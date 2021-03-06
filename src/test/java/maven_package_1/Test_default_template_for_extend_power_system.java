package maven_package_1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Test_Excel_input;
import resources.Test_Login;
import resources.Property_of_class;

public class Test_default_template_for_extend_power_system extends Test_Login {
	ChromeDriver driver;
	//Properties prop = null;
	/*@BeforeTest
	public void startBrowser()
	{
		 
		
	}*/
  @Test
  public void Default_template_power_extend() throws Exception {
	  Property_of_class obj1 = new Property_of_class();
	  Properties prop2 = obj1.property();
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	  
  	  XSSFSheet sh = null;
	  Test_Excel_input testObj = new Test_Excel_input();
	  sh = testObj.readExcel();
	  
	 // BP_Portal obj3 = new BP_Portal();
	  //String RegNo = obj3.BPportal();
	  
	  //driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	Test_Login obj = new Test_Login();
	  obj.login_w3(driver);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  driver.findElement(By.linkText("Admin")).click();
	 // Thread.sleep(300000);
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_main_requestid")))).sendKeys(prop2.getProperty("Template_power_extend"));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(prop2.getProperty("W3_Admin_managetask_apply"))).click();          //Apply
	  
	 
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_Admin_task_first_element"))));
	  
	  Actions act=new Actions(driver);
 	  
 	  act.contextClick(driver.findElement(By.xpath(prop2.getProperty("W3_Admin_task_first_element")))).perform();
 	 Thread.sleep(5000);
 	  driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign"))).click();
 	  driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign_name"))).sendKeys(prop2.getProperty("W3_main_reassign_id"));
 	  Thread.sleep(3000);
 	 driver.findElement(By.xpath(prop2.getProperty("W3_main_reassign_submit"))).click();
	  Thread.sleep(2000);
	  
	  
	  
	  driver.findElement(By.linkText("Tasks")).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_Task_first_element"))));
	  driver.findElement(By.xpath(prop2.getProperty("Request_ID_Task_tab"))).sendKeys(prop2.getProperty("Template_power_extend"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_Admin_task_first_element"))));
	  driver.findElement(By.xpath(prop2.getProperty("Apply_button_Task_tab"))).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Initial_Review_first_element_Tasks_tab")))).click();
	  
	  act.contextClick(driver.findElement(By.xpath(prop2.getProperty("Initial_Review_first_element_Tasks_tab")))).perform();
	  act.sendKeys(Keys.RETURN).perform();
	  //Thread.sleep(5000);
	  //driver.findElement(By.xpath(prop2.getProperty("Right_click_IR_Review"))).click();
	  Thread.sleep(5000);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Rejected_button"))));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(prop2.getProperty("Rejected_button"))).click();
	  driver.findElement(By.xpath(prop2.getProperty("Comments_ok"))).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(prop2.getProperty("Save_comments_button"))).click();
	  driver.findElement(By.xpath(prop2.getProperty("Continue_save_button"))).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(prop2.getProperty("Rejected_button"))).click();
	  Thread.sleep(5000);
	 // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Mail_template")))).click();
	  
	  File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	  
	  FileUtils.copyFile(file1, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\mail_templates_for_Rejected_update_ps.png")); 
	  
      System.out.println("default template for extension request for Rejected passed");
      
      driver.close();

	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
