package maven_package_1;

import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Test_Excel_input;
import resources.Test_Login;
import resources.Property_of_class;

public class Test_Request_ID_in_Manage_Tasks_tab {
	ChromeDriver driver;
	//Properties prop = null;
	/*@BeforeTest
	public void startBrowser()
	{
		 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	}*/
  @Test
  public void Request_id_manage_tasks() throws Exception {
	  Property_of_class obj1 = new Property_of_class();
	  Properties prop2 = obj1.property();
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	  Test_Login obj = new Test_Login();
	  obj.login_w3(driver);
	  driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	  
  	  XSSFSheet sh = null;
	  Test_Excel_input testObj = new Test_Excel_input();
	  sh = testObj.readExcel();
	  System.out.println("login");
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  driver.findElement(By.linkText("Admin")).click();
	  Thread.sleep(4000);
	  //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_Admin_task_first_element"))));
	  driver.findElement(By.xpath(prop2.getProperty("W3_main_requestid"))).sendKeys("S193397");
	  driver.findElement(By.xpath(prop2.getProperty("W3_Admin_managetask_apply"))).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("W3_Admin_task_first_element"))));
	  String Request_ID = driver.findElement(By.xpath(prop2.getProperty("W3_manage_task_Request_id_capture"))).getText();
	  System.out.println("Request id textbox is present and is working fine in Manage Tasks tab "+Request_ID);
  }
}
