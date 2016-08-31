package maven_package_2;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;





public class TestCode {
	
	ChromeDriver driver;
	
	@Test
	public void f() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
		System.out.println("started");
		driver.get("http://sit-stgpwblueweb.lexington.ibm.com:9084/DealRegW3/#RegistrationRequest/List");
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dijit_form_ValidationTextBox_0"))).sendKeys("ankitagupta26@in.ibm.com");
		
		 //driver.findElement(By.id("username")).sendKeys("ankitagupta26@in.ibm.com");
		  driver.findElement(By.id("dijit_form_ValidationTextBox_1")).sendKeys("a14gupta");
		  
		  
		  
		  
		  driver.findElement(By.id("com_ibm_ciolab_core_Button_0")).click();
		  
		 
		  
		  Thread.sleep(9000);
		  System.out.println("page is opened");
		  
		 
		  driver.findElement(By.id("com_ibm_ciolab_dr_regrequest_ListFilter_0_businessPartnerFilter")).sendKeys("Softchoice");
		  System.out.println("BP filtered");
		  
		  
		  
		  /*
		  WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='brandFilter1']"));

			// Create instance of Javascript executor
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(false);", checkbox1);	
			checkbox1.getAttribute("id");
			System.out.println("value" + checkbox1.getAttribute("id"));
		  checkbox1.click(); 
		  //checkbox1.click();
		   * 
		   */
		  
		  
		  
		  
		
	}
	
	
	
	

}
