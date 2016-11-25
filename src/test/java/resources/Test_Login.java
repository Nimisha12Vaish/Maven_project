package resources;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Test_Login {
	
	
	
  @Test
  public void login_bp(ChromeDriver driver) throws Exception {
	 
	  Property_of_class obj1 = new Property_of_class();
	  Properties prop2 = obj1.property();
  	  XSSFSheet sh = null;
  	  Test_Excel_input testObj = new Test_Excel_input();
  	  sh = testObj.readExcel();
  	  
  	 
	  driver.manage().window().maximize();
	 
	  driver.get(sh.getRow(0).getCell(1).getStringCellValue());
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	  
	    driver.findElement(By.id(prop2.getProperty("BP_user_id"))).clear();
	    
	    driver.findElement(By.id(prop2.getProperty("BP_user_id"))).sendKeys(sh.getRow(1).getCell(1).getStringCellValue());
	    
	  	
	  	driver.findElement(By.id(prop2.getProperty("BP_pass_id"))).clear();
	  	driver.findElement(By.id(prop2.getProperty("BP_pass_id"))).sendKeys(sh.getRow(2).getCell(1).getStringCellValue());
	  	driver.findElement(By.id(prop2.getProperty("BP_login_id"))).click();
	  	
	 
	  }
	  	
	  	@Test
		public void login_w3(ChromeDriver driver) throws Exception {
	  		
			 Property_of_class obj1 = new Property_of_class();
			  Properties prop2 = obj1.property();
	  	  XSSFSheet sh = null;
	  	  Test_Excel_input testObj = new Test_Excel_input();
	  	  sh = testObj.readExcel();
	  	  
	  	 
		  driver.manage().window().maximize();
		  
		  driver.get(sh.getRow(3).getCell(1).getStringCellValue());
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		  
		    driver.findElement(By.id(prop2.getProperty("W3_user_id"))).clear();
		    
		    driver.findElement(By.id(prop2.getProperty("W3_user_id"))).sendKeys(sh.getRow(4).getCell(1).getStringCellValue());
		    
		  	
		  	driver.findElement(By.id(prop2.getProperty("W3_pass_id"))).clear();
		  	driver.findElement(By.id(prop2.getProperty("W3_pass_id"))).sendKeys(sh.getRow(5).getCell(1).getStringCellValue());
		  	driver.findElement(By.id(prop2.getProperty("W3_login_id"))).click();
	  	  
	  	  
	  		
	  	}

		
	  	
	  
  }

