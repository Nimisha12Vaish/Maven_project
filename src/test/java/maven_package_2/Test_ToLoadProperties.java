package maven_package_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test_ToLoadProperties {
	
	public void load(Properties prop1){
	
	
	 //Reading data from pageObject.properties file
	  FileInputStream fis = null;
	try {
		fis = new FileInputStream("C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\java\\property_files\\pageObject.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	//load properties file
	  prop1 = new Properties();
	  try {
		prop1.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	}
	
	
}
