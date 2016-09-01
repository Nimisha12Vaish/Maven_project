package maven_package_1;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Property_use;
import resources.W3_main;

public class Test_Submit_Extension_form_systemstorage {
	ChromeDriver driver;
	//Properties prop = null;
	/*@BeforeTest
	public void startBrowser()
	{
		 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	}*/
	
  @Test
  public void Submit_extension_systemstorage() throws Exception {
	  
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	 
	  W3_main obj = new W3_main();
	  String RequestNo = obj.W3e2e_assign_systemstorage(driver);
	  
	  WebDriverWait wait=new WebDriverWait(driver, 180);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("bpportal_listing_page_first_element_PS_APP"))));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop2.getProperty("Submission_id_in_bpportal_listing_page")))).sendKeys(RequestNo);
	  Thread.sleep(7000);
	  
	  Actions act=new Actions(driver);
	  //driver.findElement(By.xpath(prop2.getProperty("BP_First_Element"))).click();
	  driver.findElement(By.xpath("//*[@id='dojox_grid__View_3']/div/div/div/div[1]/table/tbody/tr/td[10]")).click();
	  System.out.println("Right click Extend");
	  act.contextClick(driver.findElement(By.xpath("//*[@id='dojox_grid__View_3']/div/div/div/div[1]/table/tbody/tr/td[10]"))).perform();
	  Thread.sleep(10000);
	  driver.findElement(By.xpath(prop2.getProperty("Right_click_Extend"))).click();
	  Thread.sleep(10000);
	  driver.findElement(By.xpath(prop2.getProperty("decision_date"))).clear();
	  driver.findElement(By.xpath(prop2.getProperty("decision_date"))).sendKeys("06/29/2016");
	  Thread.sleep(10000);
	  System.out.println("decision date added");
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  WebElement supp_doc = driver.findElement(By.id(prop2.getProperty("First_radio_button_extend")));
		jse.executeScript("arguments[0].scrollIntoView(false);", supp_doc);
		System.out.println(supp_doc.getAttribute("id"));
		supp_doc.click();
		
	    
	    Thread.sleep(12000);
	
	  System.out.println("Supporting doc Radio button selected");
	
	 
	 
	  Thread.sleep(3000);
	  WebElement attachment = driver.findElement(By.xpath(prop2.getProperty("Add_attchment")));
		
		jse.executeScript("arguments[0].scrollIntoView(false);", attachment);
		attachment.click();
	 
	  String parentwindow = driver.getWindowHandle();
		
		for(String newwindows: driver.getWindowHandles())
		{
			driver.switchTo().window(newwindows);
			
			Thread.sleep(3000);
		}

	  driver.findElement(By.xpath(prop2.getProperty("Browse_button"))).sendKeys("C:\\Users\\IBM_ADMIN\\Desktop\\Deal Reg\\2.7 docs\\2.7.txt");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(prop2.getProperty("Upload_file"))).click();
	  System.out.println("file is uploaded");
	  Thread.sleep(10000);
	  driver.findElement(By.xpath(prop2.getProperty("f_close_attachment_window"))).click();
	  
	  driver.findElement(By.xpath(prop2.getProperty("installation_date"))).clear();
	  driver.findElement(By.xpath(prop2.getProperty("installation_date"))).sendKeys("06/30/2016");
	  
	  driver.findElement(By.id(prop2.getProperty("BP_Submit_button"))).click();
	  System.out.println("Form is submitted");
	  
	  String str = driver.findElement(By.xpath(prop2.getProperty("BP_submission_id"))).getText();     //taking the submission id
	  String RegNo1 = str.replaceAll("[^0-9]", "");  
	  System.out.println(str);
	 // return RegNo1;
	  
	  
	  
  }
}
