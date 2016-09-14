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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Test_proxy_voting_power {
	
	
	ChromeDriver driver;
	Properties prop1;
	
	@Test
	public void f_proxy_voting_power() throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
		//to load pageObject.properties file
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\java\\property_files\\pageObject.properties");
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
		new Test_Login().w3_login(driver, prop1);
		
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
		driver.findElement(By.id(prop1.getProperty("w3_t_proxy_cust_name"))).sendKeys("Khariim's Test Account");
		System.out.println("Entered customer name");
		
		
		//click search button
		driver.findElement(By.xpath(prop1.getProperty("w3_t_proxy_cust_search"))).click();
		
		//select the customer
		driver.findElement(By.xpath(prop1.getProperty("w3_t_proxy_cust_select"))).click();
		
		driver.findElement(By.xpath(prop1.getProperty("w3_t_proxy_cust_select1"))).click();
									 		 
	
	
	//to open the comments section and add comments
			driver.findElement(By.xpath(prop1.getProperty("w3_t_veu_comments"))).click();
			
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath(prop1.getProperty("w3_t_comment_frame0"))));
			
			WebElement body = driver.findElement(By.tagName("body"));
			body.sendKeys("Test proxy voting flow");
			
			driver.switchTo().defaultContent();
			
			
			//click on Continue button
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop1.getProperty("w3_t_veu_continue"))).click();
			
			
			Thread.sleep(7000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			if(driver.findElement(By.id("isFederalRequest_Yes_com_ibm_ciolab_dr_mytasks_registration_CategorizeCustomer_0")).isSelected())
			{
				System.out.println("Enter IBM Input reviewers");
			}
			
			else
			{
				//select IBM Input review as YES
				WebElement input_review = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div[4]/div[5]/div/div[4]/div[2]/fieldset/label[1]"));
				js.executeScript("arguments[0].scrollIntoView(false);", input_review);
				input_review.click();
			}
	
			Thread.sleep(5000);
			//Enter IBM Input reviewers
			
			
			
			WebElement input_client = driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_0"));
			js.executeScript("arguments[0].scrollIntoView(false);", input_client);
			
			
			input_client.clear();
			input_client.sendKeys("ankitagupta26@in.ibm.com");
			Thread.sleep(3000);
			input_client.sendKeys(Keys.ENTER);
			
			
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_1")).clear();
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_1")).sendKeys("kushruti@in.ibm.com");
			Thread.sleep(3000);
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_1")).sendKeys(Keys.ENTER);
			
			
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_2")).clear();
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_2")).sendKeys("ankitagupta26@in.ibm.com");
			Thread.sleep(3000);
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_2")).sendKeys(Keys.ENTER);
			
			
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_3")).clear();
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_3")).sendKeys("ankitagupta26@in.ibm.com");
			Thread.sleep(3000);
			driver.findElement(By.id("com_ibm_ciolab_core_SuggestInput_3")).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			
			//Click on Submit button
			driver.findElement(By.xpath(prop1.getProperty("w3_t_summary_submit"))).click();
			
			
			//Review registration - search for duplicates to load successfully
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div[4]/div[5]/div/div/div/div[8]/h2")));
			System.out.println("Welcome to Review registration - search for duplicates");
			driver.findElement(By.xpath("//span[contains(.,'Continue')]")).click(); 			//click on Continue button
			
			//Review registration - Summary to load successfully
			Thread.sleep(5000);
			System.out.println("Welcome to Review registration - Summary");
			driver.findElement(By.xpath("//span[contains(.,'Submit')]")).click(); 			//click on Continue button
		
			
			
			//Wait for the Task tab page to reload
			owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_task_page"))));

			System.out.println("Step 2 - For IBM Input Client and Brand review");
			
			//Uncheck the Initial review checkbox
			Thread.sleep(4000);	
			driver.findElement(By.xpath(prop1.getProperty("w3_task_initial_review"))).click();
			
			
			//enter the reg request number
			Thread.sleep(4000);	
			driver.findElement(By.id(prop1.getProperty("w3_t_req_id"))).clear();
			driver.findElement(By.id(prop1.getProperty("w3_t_req_id"))).sendKeys(reg_req_num);
			
			Thread.sleep(5000);
			//click on apply button
			driver.findElement(By.xpath(prop1.getProperty("w3_t_apply_button2"))).click();
			
			Thread.sleep(5000);
			//For review of IBM INPUT BRAND TASK
			
			rt_click.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_req_num")))).sendKeys(Keys.ENTER).perform();
			
			owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_t_ibm_input"))));
			
			//Add comments
			driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_comments"))).click();
			
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_frame1"))));
			
			WebElement body1 = driver.findElement(By.tagName("body"));
			body1.sendKeys("Voting on behalf of Shruti - proxy voting");
			
			driver.switchTo().defaultContent();
			
			
			//Select OK to approve
			driver.findElement(By.xpath(prop1.getProperty("w3_t_input_approve"))).click();
			
			//click on Submit button
			driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_submit"))).click();
			
			Thread.sleep(5000);
			
			//For review of IBM INPUT CLIENT TASK
			rt_click.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_req_num")))).sendKeys(Keys.ENTER).perform();
			
			owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_t_ibm_input"))));
			
			//Add comments
			driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_comments"))).click();
			
			
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.id(prop1.getProperty("w3_t_b_complete_frame2"))));
			
			WebElement body2 = driver.findElement(By.tagName("body"));
			body2.sendKeys("IBM Input Client voting on behalf of Ankita  - proxy voting");
			
			driver.switchTo().defaultContent();
			
			
			//Select OK to approve
			driver.findElement(By.xpath(prop1.getProperty("w3_t_input_approve"))).click();
			
			//click on Submit button
			driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_submit"))).click();
	
			
			
			Thread.sleep(7000);
			System.out.println("welcome back to Task list web page");
			
			
			Thread.sleep(5000);
			
			//To Approve the registration (IBM Input Complete to Approved)
			
			//click on apply button
			driver.findElement(By.xpath(prop1.getProperty("w3_t_apply_button2"))).click();
			
			
			//Verify the status of Task as IBM Input complete
			String task_status = driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_task_bc"))).getText();
			
			System.out.println(task_status);
			
			
			rt_click.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_task_bc")))).sendKeys(Keys.ENTER).perform();
			
			//Verify the review page is opened
			owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_t_input_complet_review"))));
					
				System.out.println("Welcome to Input complete Review page");
				
			Thread.sleep(7000);
			//open comments section
				
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_comment"))).click();
				
				Thread.sleep(4000);
				
				driver.switchTo().frame(driver.findElement(By.id(prop1.getProperty("w3_t_b_complete_frame3"))));
				
				
				
				driver.findElement(By.tagName("body")).sendKeys("final - ok to approve");
				
				driver.switchTo().defaultContent();
				
				
				
				// select approve
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_aprrove"))).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_send_mail"))).click();
			
				
				Thread.sleep(3000);
				
				System.out.println(driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_reg_num_pop_up"))).getText());
				
				//to auto-generate the reg number
				//driver.findElement(By.xpath("//div[2]/div/div/div[3]/div[2]/fieldset/div[4]/div[1]/input")).click();
				
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_auto_gen_reg_num"))).click();
				
				Thread.sleep(4000);
				
				String auto_gen_reg_num = driver.findElement(By.xpath("//div[2]/div/div/div[3]/div[2]/fieldset/div[4]/div[2]/div/input")).getAttribute("value");
				System.out.println("Reg num is: " + auto_gen_reg_num);
				
				
				
				Thread.sleep(4000);
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_auto_gen_continue"))).click();
			
				
				String send_mail = owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_t_b_complete_send_mail_page")))).getText();
				
				System.out.println(send_mail + " template selection");
				
				Thread.sleep(5000);
				
				
				//select mail template
				WebElement select_mail_temp = driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_send_mail_select")));
				
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(false);", select_mail_temp);
				
				select_mail_temp.click();
				
				Thread.sleep(3000);
				//sent to and Cc details
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_send_to"))).clear();
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_send_to"))).sendKeys(prop1.getProperty("w3_t_b_complet_send_to_value"));
				
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_cc"))).clear();
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_cc"))).sendKeys(prop1.getProperty("w3_t_b_complete_cc_value"));
				
				
				Thread.sleep(2000);
				
				//click on Submit button
				driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_submit"))).click();
				
				
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
