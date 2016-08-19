package maven_package_1;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Excel_input;
import resources.Property_use;
import resources.W3_main;

public class Form_moving_to_Initial_Review_LinuxONE {
	WebDriver driver;
	//Properties prop = null;
	@BeforeTest
	public void startBrowser()
	{
		 
		driver = new FirefoxDriver();
	}
  @Test
  public void IR_created_linuxone() throws Exception {
	  Property_use obj1 = new Property_use();
	  Properties prop2 = obj1.property();
	  
	  
  	  XSSFSheet sh = null;
	  Excel_input testObj = new Excel_input();
	  sh = testObj.readExcel();
	  
	  W3_main IR = new W3_main();
	  IR.W3e2e_assign_LinuxONE(driver);
	  
	  System.out.println("Form moved to IR status");
	  
  }
}
