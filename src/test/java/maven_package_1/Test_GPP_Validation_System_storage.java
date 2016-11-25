package maven_package_1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
//import java.util.concurrent.TimeUnit;
//import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class Test_GPP_Validation_System_storage  {
	
	ChromeDriver driver;
	//Properties prop = null;
	@BeforeTest
	/*public void startBrowser()
	{
		 
		
	}*/
	
	 @Test
  public void gpp_validation_system() throws Exception {
	  Property_of_class obj1 = new Property_of_class();
	  Properties prop2 = obj1.property();
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	  Test_Login obj = new Test_Login();
	  obj.login_bp(driver);
	  driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	  
  	  XSSFSheet sh = null;
	  Test_Excel_input testObj = new Test_Excel_input();
	  sh = testObj.readExcel();
	  System.out.println("login");
	  
	  //driver.findElement(By.partialLinkText(prop2.getProperty("Template_link"))).click();
	 
	  //driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div/div/div[1]/div/form/p[6]/span/div[2]/input")).click();
	  
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,550)", "");
	    Thread.sleep(30000);
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement element = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='brandFilter2']")));
	    driver.findElement(By.xpath("//input[@id='brandFilter2']")).click();
	    Thread.sleep(12000);
	  
	 System.out.println("System Storage");
	  
	 
		
	  //driver.findElement(By.id(prop2.getProperty("Check_Approved_filter_id"))).click();
	  
	   
	   
	    WebElement element1 = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='statusFilter3']")));
	    driver.findElement(By.xpath("//input[@id='statusFilter3']")).click();
	    Thread.sleep(12000);
	  
	  
	  System.out.println("Approved");
	  
	 
	  Actions act=new Actions(driver);
	  driver.findElement(By.xpath(prop2.getProperty("BP_First_Element"))).click();
	  act.contextClick(driver.findElement(By.xpath(prop2.getProperty("BP_First_Element")))).perform();
	  //act.contextClick(driver.findElement(By.xpath(prop2.getProperty(("Template_Right_click"))))).perform();
	  driver.findElement(By.id(prop2.getProperty(("Copy_and_create_new_id")))).click();
	  Thread.sleep(7000);
	  driver.findElement(By.xpath(prop2.getProperty("decision_date"))).clear();
	  driver.findElement(By.xpath(prop2.getProperty("decision_date"))).sendKeys("11/29/2016");
	  Thread.sleep(7000);
	  if( driver.findElement(By.id(prop2.getProperty("Select_GPP_NO"))).isSelected())
	  {
		 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("power_gpp_opp_yes")));
		 WebElement element2 = driver.findElement(By.id("power_gpp_opp_yes")); 
		jse.executeScript("arguments[0].click();", element2);
		 // wait.until(
		            //ExpectedConditions.visibilityOfElementLocated(By.id("power_gpp_opp_yes")));
		  //driver.findElement(By.id(prop2.getProperty("Select_GPP_Yes"))).click(); 
		element2.click();
		  System.out.println("GPP values");
	  }
	  
	  
	  driver.findElement(By.id(prop2.getProperty("GPP_Opp_Num"))).sendKeys(sh.getRow(6).getCell(1).getStringCellValue());
	  System.out.println("Enter GPP Email");
	  driver.findElement(By.id(prop2.getProperty("GPP_Opp_Email"))).sendKeys(sh.getRow(7).getCell(1).getStringCellValue());
	  System.out.println("Enter GPP Number");
	  File file2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	  org.apache.commons.io.FileUtils.copyFile(file2, new File("C:\\Users\\IBM_ADMIN\\Desktop\\Regression_screenshots\\GPP error.png"));
	  driver.findElement(By.xpath(prop2.getProperty("installation_date"))).clear();
	  driver.findElement(By.xpath(prop2.getProperty("installation_date"))).sendKeys("12/30/2016");
	  driver.findElement(By.id(prop2.getProperty("BP_Submit_button"))).click();
	  String expected_form ="Your registration has been submitted successfully.";
	   String submitted_form = driver.findElement(By.xpath("//*[@class='ibm-columns']/div[1]/p[contains(.,'Your registration has been submitted successfully.')]")).getText();
	 boolean flag = true;
	   if(expected_form.equals(submitted_form))
	  {
		  flag= false;
	  }
	   else
	   {
		   flag=true;
	   }
	   Assert.assertTrue(flag, "the form is submitting");
	   driver.close();
	  
	  
	  
  }
}