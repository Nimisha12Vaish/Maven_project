package maven_package_2;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Login{
	
	public void BP_portal_login(WebDriver driver, Properties prop1){
		
		System.out.println("Bp portal Started");
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  
			  //Login to BP portal
			  driver.get(prop1.getProperty("p_portal_url"));
			  WebDriverWait wait=new WebDriverWait(driver, 180);
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop1.getProperty("p_username_id")))).sendKeys(prop1.getProperty("p_username_value_id"));
			  //driver.findElement(By.id(prop1.getProperty("username_id"))).sendKeys(prop1.getProperty("username_value_id"));
			  driver.findElement(By.id(prop1.getProperty("p_password_id"))).sendKeys(prop1.getProperty("p_password_value_id"));
			  driver.findElement(By.id(prop1.getProperty("p_signIn_id"))).click();	
	}
	
public void w3_login(WebDriver driver, Properties prop1){
		
		System.out.println("w3 started");
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  
			  //Login to w3 
			  driver.get(prop1.getProperty("w3_url_reg"));
			 WebDriverWait wait=new WebDriverWait(driver, 180);
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop1.getProperty("w3_username_id")))).sendKeys(prop1.getProperty("w3_username_value_id"));
			  
			  //driver.findElement(By.id(prop1.getProperty("w3_username_id"))).sendKeys(prop1.getProperty("w3_username_value_id"));
			  driver.findElement(By.id(prop1.getProperty("w3_password_id"))).sendKeys(prop1.getProperty("w3_password_value_id"));
			  driver.findElement(By.id(prop1.getProperty("W3_login_button"))).click();
	}
}
