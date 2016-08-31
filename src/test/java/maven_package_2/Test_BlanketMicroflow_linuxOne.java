package maven_package_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Test_BlanketMicroflow_linuxOne {

	ChromeDriver driver;
	Properties prop1;
	
	@Test
	public void f_BlanketMicroflow_linuxOne() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\resources\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
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
		
		//instance of login
		Login login = new Login();
		login.w3_login(driver, prop1);
		
		WebDriverWait owait = new WebDriverWait(driver, 180);
		
		//open Task tab
		owait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop1.getProperty("w3_task_tab")))).click();
		
		
		//select brand as LinuxOne
		driver.findElement(By.xpath(prop1.getProperty("w3_task_brand"))).click();
		
		
		WebElement linuxOne_cb = driver.findElement(By.xpath(prop1.getProperty("w3_task_linuxOne")));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", linuxOne_cb);
		linuxOne_cb.click();
		
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
		//select blanket as type of bid
		driver.findElement(By.id(prop1.getProperty("w3_t_bid_blanket"))).click();
		
		Thread.sleep(3000);
		//to open the comments section and add comments
		driver.findElement(By.xpath(prop1.getProperty("w3_t_veu_comments"))).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath(prop1.getProperty("w3_t_comment_frame0"))));
		
		WebElement body = driver.findElement(By.tagName("body"));
		body.sendKeys("Test Blanket microflow");
		
		driver.switchTo().defaultContent();
		
		
		
		//click on submit button
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop1.getProperty("w3_t_veu_continue"))).click();
		
		Thread.sleep(5000);
		
		//Wait for the Review registration - Summary page to load
		System.out.println("Welcome to Review registration - Summary");	
		
		Thread.sleep(7000);
		
		//Click on Submit button
		WebElement myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_t_summary_submit"))));
		
		myDynamicElement.click();
		System.out.println("submit button clicked");
		
		Thread.sleep(5000);
		
		//wait for the Task page to reload
		owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_task_page"))));
		System.out.println("Task list page is loaded successfully");

		
		
		//select Task as blanket check
		
		/*driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td[2]")).click();
		
		WebElement blanket_cb = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div[4]/div[2]"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", blanket_cb);
		
		blanket_cb.click();
		*/
		
		
		System.out.println("Step 2 - from Blanket check to Blanket complete");
		
		//Uncheck the Initial review checkbox
		Thread.sleep(4000);	
		driver.findElement(By.xpath(prop1.getProperty("w3_task_initial_review"))).click();
		Thread.sleep(3000);
				
		
		//enter the reg request number
		driver.findElement(By.id(prop1.getProperty("w3_t_req_id"))).sendKeys(reg_req_num);
		
		
		
		Thread.sleep(5000);
		
		//click on apply button
		driver.findElement(By.xpath(prop1.getProperty("w3_t_apply_button2"))).click();
		
		//to claim the registration
		Thread.sleep(5000);
		
		rt_click.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_req_num")))).perform();
		driver.findElement(By.xpath(prop1.getProperty("w3_t_claim"))).click();
		
		//click on submit button
		driver.findElement(By.xpath(prop1.getProperty("w3_t_claim_submit"))).click();
		
		Thread.sleep(10000);
		//To review registration
		rt_click.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_req_num")))).sendKeys(Keys.ENTER).perform();
		
		
		owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_t_submitted_blanket_check"))));
		
		System.out.println("Select the review decision");
		
		Thread.sleep(3000);
		//Add comments
		driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_comments"))).click();
		
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_frame1"))));
		
		WebElement body1 = driver.findElement(By.tagName("body"));
		body1.sendKeys("Ok to approve");
		
		driver.switchTo().defaultContent();
		
		
		//Select OK to approve
		driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_ok_to_approve"))).click();
		
		//click on Submit button
		driver.findElement(By.xpath(prop1.getProperty("w3_t_submitted_submit"))).click();
		
		Thread.sleep(7000);
		System.out.println("welcome back to Task list web page");
		
		
		Thread.sleep(5000);
		
		//To Approve the registration (Blanket complete to Approve)
		
		//click on apply button
		driver.findElement(By.xpath(prop1.getProperty("w3_t_apply_button2"))).click();
		
		//Verify the status of Task as Blanket complete
		String task_status = driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_task_bc"))).getText();
		
		System.out.println(task_status);
		
		
		rt_click.contextClick(driver.findElement(By.xpath(prop1.getProperty("w3_t_reg_task_bc")))).sendKeys(Keys.ENTER).perform();
		
		//Verify the review page is opened
		owait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop1.getProperty("w3_t_blanket_complete_review"))));
				
			System.out.println("Welcome to Blanket complete Review page");
		
		//open comments section
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(prop1.getProperty("w3_t_b_complete_comment"))).click();
			
			Thread.sleep(4000);
			
			driver.switchTo().frame(driver.findElement(By.id(prop1.getProperty("w3_t_b_complete_frame2"))));
			
			
			
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
			
			
			System.out.println("The registration is Submitted (using Blanket microflow)");
			
			
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
			
			
			/*login.BP_portal_login(driver, prop1);
			
			owait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop1.getProperty("p_request_num")))).sendKeys(reg_req_num);
			
			Thread.sleep(3000);
			
			System.out.println("registration status is: " + driver.findElement(By.xpath(prop1.getProperty("p_first_reg_status"))).getText());
			*/
			
			
			driver.quit();
	
			
		}
		else
		{
			System.out.println("Please assign reg to yourself");
			driver.close();
		}
			
			
	}
	
	
	
	
	
}
