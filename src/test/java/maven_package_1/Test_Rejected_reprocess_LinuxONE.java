package maven_package_1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Test_Excel_input;
import resources.Test_Login;
import resources.Test_Property_use;

public class Test_Rejected_reprocess_LinuxONE {
	ChromeDriver driver;
	//Properties prop = null;
	/*@BeforeTest
	public void startBrowser()
	{
		 
		
	}*/
	
	 @Test
  public void Test_Rej_linuxone() throws Exception {
	  Test_Property_use obj1 = new Test_Property_use();
	  Properties prop2 = obj1.property();
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	  Test_Login obj = new Test_Login();
	  obj.login_w3(driver);
	  driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	  
  	  XSSFSheet sh = null;
	  Test_Excel_input testObj = new Test_Excel_input();
	  sh = testObj.readExcel();
	  
	  driver.findElement(By.linkText(prop2.getProperty("w3_registrations_tab"))).click();
	  Thread.sleep(4000);
	  WebDriverWait wait=new WebDriverWait(driver, 180);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  driver.findElement(By.xpath(prop2.getProperty("Brand_drop_down"))).click();
	  //driver.findElement(By.xpath(prop2.getProperty("Brand_LinuxONE"))).click();
	  
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Brand_LinuxONE")))).click();
	Thread.sleep(3000);
	  driver.findElement(By.xpath(prop2.getProperty("Status_drop_down"))).click();
	  
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Status_Rejected")))).click();
	  Thread.sleep(3000);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Submission_text_box")))).sendKeys(prop2.getProperty("Reject_Reprocess_linuxone"));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(prop2.getProperty("Registrations_Apply_button"))).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Power_Rej_first_element"))));
	  String str = driver.findElement(By.xpath(prop2.getProperty("Request_No_first_element"))).getText();
	  String Submission_id = str.replaceAll("[^0-9]", "");
	  System.out.println("Submission id of rejected reprocessed LinuxONE registration is "+Submission_id);
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
	  //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("first_ele_reg"))));
	  //driver.findElement(By.xpath(prop2.getProperty("Registrations_Clear_button"))).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Power_Rej_first_element"))));
	 String Expected_request_id = driver.findElement(By.xpath(prop2.getProperty("Request_No_first_element"))).getText();
	 String Expected_submission_id = Expected_request_id.replaceAll("[^0-9]", "");
	 boolean flag = true ;
	  
	  if(Expected_submission_id.equals(Submission_id))
	  {

		 flag=false; 
	  }
	  else
	  {
		  flag=true;
	  }
	  System.out.println(flag);
	  AssertJUnit.assertTrue(flag);
	 // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("first_ele_reg"))));
	  driver.findElement(By.xpath(prop2.getProperty("Submission_text_box"))).sendKeys(Submission_id);
	  driver.findElement(By.xpath(prop2.getProperty("Registrations_Apply_button"))).click();
	  String Task_status =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Reg_IR_task")))).getText();
	  System.out.println("Power system Rejected registration now in Initial Review after Reporocess" + Task_status);
	  driver.close();
	  
	  
  }
}
