package maven_package_3;

import java.util.Properties;

//import junit.framework.Assert;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Test_Property_use;
import resources.Test_W3_main;

public class Test_System_timer_Initial_Review_for_IBM_Input_LinuxONE {
 // @SuppressWarnings("deprecation")
@Test
  public void System_timer_LinuxONE() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	  Test_Property_use obj1 = new Test_Property_use();
	  Properties prop2 = obj1.property();
	  Test_W3_main obj = new Test_W3_main();
	  String RequestNo = obj.W3e2e_assign_LinuxONE(driver);
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
	 	  driver.findElement(By.xpath("//input[contains(@id,'customerNameFilter')]")).sendKeys("abc");
	 	  driver.findElement(By.xpath("//input[contains(@id,'clientIdFilter')]")).click();
	 	  driver.findElement(By.xpath("//span[@class='dijitReset dijitInline dijitButtonNode']/span[contains(.,'Search')]")).click();
	 	  driver.findElement(By.xpath("//td[contains(.,'abc')]")).click();
	 	 driver.findElement(By.xpath("//span[@class='dijitReset dijitInline dijitButtonNode']/span[contains(.,'Select')]")).click();
	 	 driver.findElement(By.xpath("//span[@class='dijitReset dijitInline dijitButtonNode']/span[contains(.,'Continue')]")).click();
	 	 driver.findElement(By.xpath("//label[contains(@for,'requireSectorReview_Yes_com_ibm_ciolab_dr_mytasks_registration_CategorizeCustomer')]")).click();
	 	 String Client_Brand_Actual_Time = driver.findElement(By.xpath("//span[contains(.,'Client & Brand time addition')]/b")).getText();
	 	 String IMT_Exec_Actual_Time = driver.findElement(By.xpath("//span[contains(.,'IMT & Exec time addition')]/b")).getText();
	 	 String Client_Brand_Expec_Time = "Client & Brand time addition";
	 	 String IMT_Exec_Expec_Time = "IMT & Exec time addition";
	 	Assert.assertEquals(Client_Brand_Expec_Time, Client_Brand_Actual_Time);
	 	Assert.assertEquals(IMT_Exec_Expec_Time, IMT_Exec_Actual_Time);
	 	
	 	  
	 	  
  }
}
