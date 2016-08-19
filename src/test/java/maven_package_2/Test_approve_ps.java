package maven_package_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Test_approve_ps {
	
	
	WebDriver driver = new FirefoxDriver();
	Properties prop1;
	
	@Test
	public void f_proxy_voting_power() throws InterruptedException, IOException{
		
		//to load pageObject.properties file
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("C:\\Office_Work\\deal_reg\\TC_3505\\DR_TC_Maven\\src\\test\\resources\\pageObject.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop1 = new Properties();
		
		try {
			prop1.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//using Annonymous object of Login (If you have to use an object only once, annonymous object is a good approach.) 
		new Login().w3_login(driver, prop1);
		
		WebDriverWait owait = new WebDriverWait(driver, 180);
		
	
		
		
		//open Task tab
		owait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop1.getProperty("w3_task_tab")))).click();
		
		
		//select brand as PowerSystems
		driver.findElement(By.xpath(prop1.getProperty("w3_task_brand"))).click();
		driver.findElement(By.xpath(prop1.getProperty("w3_task_power_systems"))).click();
		
		
		
		Thread.sleep(3000);
		
		//select Task as Initial Review
		driver.findElement(By.xpath(prop1.getProperty("w3_task"))).click();
		driver.findElement(By.xpath(prop1.getProperty("w3_task_initial_review"))).click();

		//click on apply button
		driver.findElement(By.xpath(prop1.getProperty("w3_t_apply_button"))).click();
		
		Thread.sleep(4000);
		
		
		//click on Assigned to me header twice - to get the assigned task at the top
		driver.findElement(By.xpath(prop1.getProperty("w3_t_assigned_to_me_header"))).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop1.getProperty("w3_t_assigned_to_me_header"))).click();
		
		
		
		//to verify the reg is assigned to me
		String actual_assigned_to_me = driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_assigned_to_me"))).getText();
		
		if(actual_assigned_to_me.equalsIgnoreCase("Yes"))
		{
			System.out.println("Yes, the reg is assigned to myself");
			
			System.out.println("Task is: " + driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_task"))).getText());
		
		
		//to get the req number of first registration
		WebElement reg_req_num_xpath = driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_req_num")));
		String reg_req_num = reg_req_num_xpath.getText();
		System.out.println("Reg request num is: " + reg_req_num);
		
		//to create instance of Actions
		Actions rt_click = new Actions(driver);
		
		Thread.sleep(3000);
		//click on Review 
		rt_click.contextClick(reg_req_num_xpath).sendKeys(Keys.ENTER).perform();
		
		
		Thread.sleep(7000);
		
		//Opened review web page
		String page_text = driver.findElement(By.xpath(prop1.getProperty("w3_t_review_verify_user"))).getText();
		
		System.out.println("Welcome to: " + page_text);
		
		Thread.sleep(3000);
	//Type of bid is Neither bydefault
		
		//type customer name
		/*driver.findElement(By.id(prop1.getProperty("w3_t_proxy_cust_name"))).sendKeys("Khariim's Test Account");
		System.out.println("Entered customer name");
		
		
		//click search button
		driver.findElement(By.xpath(prop1.getProperty("w3_t_proxy_cust_search"))).click();
		
		//select the customer
		driver.findElement(By.xpath(prop1.getProperty("w3_t_proxy_cust_select"))).click();
		
		driver.findElement(By.xpath(prop1.getProperty("w3_t_proxy_cust_select1"))).click();
		*/	
	
	//to open the comments section and add comments
			driver.findElement(By.xpath(prop1.getProperty("w3_t_veu_comments"))).click();
			
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath(prop1.getProperty("w3_t_comment_frame0"))));
			
			WebElement body = driver.findElement(By.tagName("body"));
			body.sendKeys("Test auto approve flow");
			
			driver.switchTo().defaultContent();
			
			
			//click on Continue button
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop1.getProperty("w3_t_veu_continue"))).click();
			
			
			Thread.sleep(7000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
			WebDriverWait wait = new WebDriverWait(driver, 180);
			
			/*System.out.println(wait.until(
		            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div/div/div[4]/div[5]/div/div[3]/div[1]"))).getText());
			
			
			wait.until(
		            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div/div/div[4]/div[5]/div/div[3]/div[1]")));  
		            */
			
			Thread.sleep(8000);
			 
			 System.out.println("categorized customer");
			 
			 /*
			 driver.findElement(By.xpath("//div/div/div/div/div[4]/div[5]/div/div[1]/div[2]/div/div/input")).sendKeys("test");
			 Thread.sleep(3000);
			 
			 driver.findElement(By.xpath("//div/div/div/div/div[4]/div[5]/div/div[2]/div[2]/fieldset/div[1]/input")).click();
			 */
			 
			 
			 Thread.sleep(10000);
			 
			if(driver.findElement(By.xpath("//div[contains(.,'federal request')]/div[contains(.,'Decision')]/fieldset/div[2]/input")).isSelected())
			{
				System.out.println("Classify this as a federal request is NO");
			}
			
			else
			{
				//select Classify this as a federal request as NO
				System.out.println("click federal request as NO");		

				Thread.sleep(6000);
				
				WebElement no = driver.findElement(By.xpath("//div[contains(.,'federal request')]/div[contains(.,'Decision')]/fieldset/div[2]/input"));
				js.executeScript("arguments[0].scrollIntoView('false');", no);
				no.click();
				
				/*wait.until(
			            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(.,'federal request')]/div[contains(.,'Decision')]/fieldset/div[2]"))).click(); 
			            */
				
				
				
			}
			
			
			Thread.sleep(10000);
			
			if(driver.findElement(By.xpath("//div[contains(.,'IBM Input review')]/div[contains(.,'Decision')]/fieldset/div[2]/input")).isSelected())
			{
				System.out.println("Registration requires IBM Input review is NO");
			}
			
			else
			{
				//select Registration requires IBM Input review as NO
				System.out.println("click IBM Input review as NO");
				Thread.sleep(6000);
				
				
				WebElement no = driver.findElement(By.xpath("//div[contains(.,'IBM Input review')]/div[contains(.,'Decision')]/fieldset/div[2]/input"));
				js.executeScript("arguments[0].scrollIntoView('false');", no);
				no.click();
				
				/*wait.until(
			            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(.,'IBM Input review')]/div[contains(.,'Decision')]/fieldset/div[2]"))).click(); 
				*/
			}
	
			Thread.sleep(2000);
			
			
			//Click on Submit button
			driver.findElement(By.xpath(prop1.getProperty("w3_t_summary_submit2"))).click();
			
			
			//Review registration - search for duplicates to load successfully
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/div/div[4]/div[5]/div/div/div/div[8]/h2")));
			System.out.println("Welcome to Review registration - search for duplicates");
			driver.findElement(By.xpath(prop1.getProperty("w3_t_search_dupe_continue"))).click(); 			//click on Continue button
			
			
			// to verify the summary page is opened
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='ibm-columns']/div/fieldset/div[contains(.,'Approve')]/div/input")));
			
			System.out.println("opened summary page");
			
			
			Thread.sleep(10000);
			//click on approve
			driver.findElement(By.xpath("//*[@class='ibm-columns']/div/fieldset/div[contains(.,'Approve')]/div/input")).click(); 			
			
			
			Thread.sleep(5000);
			//click on auto gen
			driver.findElement(By.xpath("//div[4]/div[2]/fieldset/div[4]/span/span")).click();
			
			Thread.sleep(5000);
			//click continue
			driver.findElement(By.xpath("//div/div/div/div/div[4]/div[7]/span[2]/span")).click();
			
				
				//Thread.sleep(10000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(.,'send email response')]")));
				System.out.println("Welcome to last page");
				Thread.sleep(10000);
				//mail submit
				driver.findElement(By.xpath("//span[contains(.,'Submit')]")).click();
				
				
				//Verify the status of Registration
				//Click on registration tab
				
				Thread.sleep(5000);
				driver.findElement(By.xpath(prop1.getProperty("w3_registartion_tab"))).click();
				
				owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_reg_tab_opened"))));
				
				driver.findElement(By.xpath(prop1.getProperty("w3_req_num"))).sendKeys(reg_req_num);  //enter req num
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath(prop1.getProperty("w3_apply_button"))).click(); //click on apply button
				
				Thread.sleep(9000);
				
				System.out.println("Registartion status is: " + driver.findElement(By.xpath(prop1.getProperty("w3_reg_status"))).getText()); //get status of reg
				
				/*Thread.sleep(3000);
				
				//To open View history
				rt_click.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_reg_status")))).perform();   
				  
				Thread.sleep(4000);
				driver.findElement(By.xpath(prop1.getProperty("rt_click_view_history"))).click();
				
				// Switch to new window opened - print form
				for (String winHandle : driver.getWindowHandles()) {
				    driver.switchTo().window(winHandle); 
				    Thread.sleep(15000);
				}
				
				String rr_Vh_req_no =  driver.findElement(By.xpath(prop1.getProperty("VH_history_req_no"))).getText();
				System.out.println("Request no. in View History is: " + rr_Vh_req_no);
				  
				//Take screenshot of View History
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				File file8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file8, new File(prop1.getProperty("proxy_voting_power_history")));
				*/	
				
				driver.quit(); // close both opened window when done with it
			
	}
	else
	{
		System.out.println("Please assign reg to yourself");
		driver.close();
	}
				
			
	
	}
	
	

}
