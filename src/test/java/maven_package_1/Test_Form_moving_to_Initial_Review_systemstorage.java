package maven_package_1;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Test_Excel_input;
import resources.Test_Property_use;
import resources.Test_W3_main;

public class Test_Form_moving_to_Initial_Review_systemstorage {
	ChromeDriver driver;
	//Properties prop = null;
	/*@BeforeTest
	public void startBrowser()
	{
		 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	}*/
  @Test
  public void IR_created_systemstorage() throws Exception {
	  Test_Property_use obj1 = new Test_Property_use();
	  Properties prop2 = obj1.property();
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	  
	  
  	  XSSFSheet sh = null;
	  Test_Excel_input testObj = new Test_Excel_input();
	  sh = testObj.readExcel();
	  
	  Test_W3_main IR = new Test_W3_main();
	  IR.W3e2e_assign_systemstorage(driver);
	  
	  System.out.println("Form moved to IR status");
	  
  }
}
