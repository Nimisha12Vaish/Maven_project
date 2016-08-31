package maven_package_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestAddComment {

	Properties prop1;
	 ChromeDriver driver;
	
	@BeforeTest
	public void startBrowser(){
		/*FirefoxProfile fprofile = new FirefoxProfile();
		fprofile.setPreference("browser.download.dir", "C:\\WebDriverdownloadPDFs");
		  fprofile.setPreference("browser.download.folderList", 2);
		  //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
		  fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",  "application/pdf;" ); //MIME types Of PDF File.
		  fprofile.setPreference( "browser.download.manager.showWhenStarting", false );
		  fprofile.setPreference( "pdfjs.disabled", true );
		  
		driver = new FirefoxDriver(fprofile);*/
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
	}
		

	 @Test
	  public void f() throws IOException, InterruptedException {
		  
		  //Reading data from pageObject.properties file
		//Reading data from pageObject.properties file
		  FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Office_Work\\deal_reg\\TC_3505\\DR_TC_Maven\\src\\test\\resources\\pageObject.properties");
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
		  
		 
		  //to login BP portal (instance of Login class)
		  driver.get("https://wwwbeta-sox.toronto.ca.ibm.com/partnerworld/wps/servlet/mem/deal/reg/form");
		  
		  
		  driver.findElement(By.id("username")).sendKeys("cdt2pps13@ca.ibm.com");
		
		  driver.findElement(By.id(prop1.getProperty("p_password_id"))).sendKeys(prop1.getProperty("p_password_value_id"));
		  driver.findElement(By.id(prop1.getProperty("p_signIn_id"))).click();	
		  
		WebDriverWait wait = new WebDriverWait(driver, 180);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/h1")));
		Thread.sleep(3000);
		driver.findElement(By.id(prop1.getProperty("f_opp_name_id"))).sendKeys(prop1.getProperty("f_opp_name_value"));
		
		driver.findElement(By.id(prop1.getProperty("f_decision_date_id"))).clear();
		 driver.findElement(By.id(prop1.getProperty("f_decision_date_id"))).sendKeys(prop1.getProperty("f_decision_date_value"));
		 
		Thread.sleep(3000);
		//get heading of attachment section
		String text = driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/div[1]/div/div[1]/form/div[2]/div/div[7]/h3")).getText();
		System.out.println(text);
		
		//text of attachment link
		String attachment_text = driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/div[1]/div/div[1]/form/div[2]/div/div[7]/p[3]")).getText();
		System.out.println(attachment_text);
		
		//click on add attachment
		WebElement attachment = driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/div[1]/div/div[1]/form/div[2]/div/div[7]/p[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", attachment);
		attachment.click();
		  
		System.out.println("opened dialog box");
		  
		Thread.sleep(3000);
		
		
		String parentwindow = driver.getWindowHandle();
		
		for(String newwindows: driver.getWindowHandles())
		{
			driver.switchTo().window(newwindows);
			
			Thread.sleep(3000);
			System.out.println("new window");
		}
		
		
		//get dialog box title
		String sub_title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[5]/div[2]/div/div/div/div/form/h2"))).getText();
		//String sub_title = driver.findElement(By.xpath("html/body/div[6]/div[2]/div/div/div/div/form/h2")).getText();
		System.out.println(sub_title);
		
		
		
		System.out.println("browse a file");
		//click on select file button
		String label = driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div/form/p/label")).getText();
		System.out.println(label);
		
		
		//WebElement file_input = driver.findElement(By.id("attachment"));
		//file_input.click();
		driver.findElement(By.id("attachment")).sendKeys("C:\\Office_Work\\sticky_notes.docx");
		
		System.out.println("File uploaded");
		Thread.sleep(4000);
		
		String button_value = driver.findElement(By.id("submit_attachments_btn")).getAttribute("value");
		System.out.println(button_value);
		
		driver.findElement(By.id("submit_attachments_btn")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("html/body/div[5]/div[1]/span[2]")).click();
		
		System.out.println("done");
		
		
		
		/*driver.switchTo().defaultContent();


		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[2]/span/span")).click();
		*/
	 }	
}
