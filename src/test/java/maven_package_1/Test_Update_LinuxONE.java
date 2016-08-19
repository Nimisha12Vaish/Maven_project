package maven_package_1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import resources.Excel_input;
import resources.Login;
import resources.Property_use;
import resources.W3_main;

public class Test_Update_LinuxONE {
	WebDriver driver;
	//Properties prop = null;
	@BeforeTest
	public void startBrowser()
	{
		 
		driver = new FirefoxDriver();
	}
	
  @Test
  public void test_upd_from_app_linuxone() throws Exception {
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
	 
	  W3_main obj = new W3_main();
	  String RequestNo = obj.W3e2e_assign_LinuxONE(driver);
	  
	  WebDriverWait wait=new WebDriverWait(driver, 180);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("bpportal_listing_page_first_element_PS_APP"))));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Submission_id_in_bpportal_listing_page")))).sendKeys(RequestNo);
	  Thread.sleep(7000);
	  Actions act = new Actions(driver);
	  act.contextClick(driver.findElement(By.xpath(prop2.getProperty("bpportal_listing_page_first_element_PS_APP")))).perform();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(prop2.getProperty("bpportal_listing_page_right_click_update"))).click();
	  Thread.sleep(10000);
	 /* driver.findElement(By.xpath(prop2.getProperty("decision_date"))).clear();
	  driver.findElement(By.xpath(prop2.getProperty("decision_date"))).sendKeys("07/18/2016");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath(prop2.getProperty("installation_date"))).clear();
	  driver.findElement(By.xpath(prop2.getProperty("installation_date"))).sendKeys("08/18/2016");*/
	  //wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop2.getProperty("BP_Submit_button")))).click();
	  Thread.sleep(5000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop2.getProperty("BP_Submit_button"))));
	  WebElement element = driver.findElement(By.id(prop2.getProperty("BP_Submit_button")));
	  js.executeScript("arguments[0].scrollIntoView(true);", element);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id(prop2.getProperty("BP_Submit_button"))));
	 element.click();
	  String str = driver.findElement(By.xpath(prop2.getProperty("BP_submission_id_for_update"))).getText();     //taking the submission id
	  String RegNo = str.replaceAll("[^0-9]", "");  
	  System.out.println("Submission id of updated registration from Power System Approved form is"+str);
	  
	  driver.close();
	 // return RegNo;
  }
}
