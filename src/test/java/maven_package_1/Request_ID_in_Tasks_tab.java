package maven_package_1;

import org.testng.annotations.Test;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Excel_input;
import resources.Login;
import resources.Property_use;

public class Request_ID_in_Tasks_tab {
	WebDriver driver;
	//Properties prop = null;
	@BeforeTest
	public void startBrowser()
	{
		 
		driver = new FirefoxDriver();
	}
  @Test
  public void Request_id_tasks() throws Exception {
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
	  Login obj = new Login();
	  obj.login_w3(driver);
	  driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	  
  	  XSSFSheet sh = null;
	  Excel_input testObj = new Excel_input();
	  sh = testObj.readExcel();
	  System.out.println("login");
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  driver.findElement(By.linkText("Tasks")).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_Task_first_element"))));
	  driver.findElement(By.xpath(prop2.getProperty("Request_ID_Task_tab"))).sendKeys("S193397");
	  driver.findElement(By.xpath(prop2.getProperty("Apply_button_Task_tab"))).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_Task_first_element"))));
	  String Request_ID = driver.findElement(By.xpath(prop2.getProperty("W3_Request_id_capture"))).getText();
	  System.out.println("Request id textbox is present and is working fine in Tasks tab "+Request_ID);
	  
	  
	  
  }
}
