package maven_package_1;


import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Date_print {
  @Test
  public void verify_Accept_Reject_Due_Date() {
	  //create Calendar instance
	  WebDriver driver = new FirefoxDriver();
	    Calendar now = Calendar.getInstance();
	   
	    System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1)
	                        + "/"
	                        + now.get(Calendar.DATE)
	                        + "/"
	                        + now.get(Calendar.YEAR));
	   
	    //add days to current date using Calendar.add method
	    now.add(Calendar.DATE,5);
	 
	    System.out.println("date after five days : " + (now.get(Calendar.MONTH) + 1)
	                        + "/"
	                        + now.get(Calendar.DATE)
	                        + "/"
	                        + now.get(Calendar.YEAR));
      
	    String Expected_date = (now.get(Calendar.MONTH) + 1)
                + "/"
                + now.get(Calendar.DATE)
                + "/"
                + now.get(Calendar.YEAR);
	    boolean flag = false;
	    String Actual_date = driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[3]/div[9]/div[1]/span/span/div")).getText();
	    
	    if(Actual_date!= null)
	    {
	    	flag = true;
	    	System.out.println("Actual date is "+ Actual_date);
	    	Assert.assertEquals(Actual_date, Expected_date, "Expected date is not 5 days ahead of current date");
	    }
	    else
	    {
	    	flag = false;
	    }
	    Assert.assertTrue(flag, "Accept/Reject Due Date is null");
	   
  }
}
