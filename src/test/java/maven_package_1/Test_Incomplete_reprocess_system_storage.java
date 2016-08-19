package maven_package_1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Excel_input;
import resources.Login;
import resources.Property_use;
import maven_package_3.Incomplete_System_storage;

public class Test_Incomplete_reprocess_system_storage extends Incomplete_System_storage {
 
	WebDriver driver;
	//Properties prop = null;
	@BeforeTest
	public void startBrowser()
	{
		 
		driver = new FirefoxDriver();
	}
	
	 @Test
  public void Test_Inc_Rep() throws Exception {
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
	  Login obj = new Login();
	  obj.login_w3(driver);
	  driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	  
  	  XSSFSheet sh = null;
	  Excel_input testObj = new Excel_input();
	  sh = testObj.readExcel();
	  
	  driver.findElement(By.linkText(prop2.getProperty("w3_registrations_tab"))).click();
	  Thread.sleep(4000);
	  WebDriverWait wait=new WebDriverWait(driver, 180);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  driver.findElement(By.xpath(prop2.getProperty("Brand_drop_down"))).click();
	  //driver.findElement(By.xpath(prop2.getProperty("Brand_LinuxONE"))).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Brand_system_storage")))).click();
	 Thread.sleep(3000);
	  driver.findElement(By.xpath(prop2.getProperty("Status_drop_down"))).click();
	  Thread.sleep(3000);
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Status_Incomplete")))).click();
	 Thread.sleep(3000);
	 
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Submission_text_box")))).sendKeys(prop2.getProperty("Incomplete_Reprocess_system_storage"));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(prop2.getProperty("Registrations_Apply_button"))).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Power_Rej_first_element"))));
	  
	  String str = driver.findElement(By.xpath(prop2.getProperty("Request_No_first_element"))).getText();
	  String Submission_id = str.replaceAll("[^0-9]", "");
	  System.out.println("Submission id of incomplete reprocessed system storage registration is "+Submission_id);
	  Thread.sleep(10000);
	  Actions act = new Actions(driver);
	  act.contextClick(driver.findElement(By.xpath(prop2.getProperty("Power_Rej_first_element")))).perform();
	  //Thread.sleep(10000);
	  //driver.findElement(By.xpath("html/body/div[7]/table")).sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
	  driver.findElement(By.xpath(prop2.getProperty("Reprocess_menu"))).click();
	 // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Reprocess_menu")))).click();
	  driver.findElement(By.xpath(prop2.getProperty("Repr_IR"))).click();
	  driver.findElement(By.xpath(prop2.getProperty("Repr_IR_Submit"))).click();
	 // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("No_record_found"))));
	 // driver.findElement(By.xpath(prop2.getProperty("Registrations_Clear_button"))).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Power_Rej_first_element"))));
	 // driver.findElement(By.xpath(prop2.getProperty("Submission_text_box"))).sendKeys(Submission_id);
	 // driver.findElement(By.xpath(prop2.getProperty("Registrations_Apply_button"))).click();
	  String Task_status =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Reg_IR_task")))).getText();
	  System.out.println("system storage incomplete registration now in Initial Review after Reporocess" + Task_status);
	  
	  driver.close();
}
}
