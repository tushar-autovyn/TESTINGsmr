package mergeSMR;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoDialer_SMR_Report {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

//..................................................................................................
@SuppressWarnings("static-access")
@BeforeClass
	public void SMR() throws InterruptedException {
	 this.driver=DataAvailability_Report_SMR.driver;	
	 Thread.sleep(5000);
	}
		
	//..................................................................................................
		@Test(priority = 5)
		public void Click_On_Report() throws InterruptedException {
	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   WebElement report = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
	   report.click();
	   Thread.sleep(3000);
		
	    }
//..............................................................................................................
//.................................Navigate To Auto Dialer Report.................................................................
	   @Test(priority = 6)
	   public void Click_On_AutoDialer_REPORT() throws InterruptedException {
	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   WebElement AutoDialer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Auto Dialer Report \"]")));
	   AutoDialer.click();
	   Thread.sleep(7000);
				
}
//................Navigate to Zone And Region Wise Tab and select date range......................................................................................
	   @Test(priority = 7)
	   public void Zone_And_Region_Wise_Tab() throws InterruptedException {
	       wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	       
	       Thread.sleep(4000);

	      

	       // Click on the generate report button
	       WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	       clickOnGenerate.click();

	       Thread.sleep(25000);
	   }

//............................To Validate if data is present in Zone And Region Wise tab..............................................................................................	   
	   
	   @Test(priority = 8)
	   public void Data_Verification_Zone_And_Region_Wise() throws InterruptedException {
		   // Verify if the report contains data
		    List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"rowgroup\"][2]//tr)"));
		    
		    // Check if the report contains data
		    if (reportRows.size() > 1) {
		        System.out.println("Zone And Region Wise report contains data In Auto Dialer Report."); // Message when data is present
		    }

		    // Assert to fail the method if data is not present
		    Assert.assertTrue(reportRows.size() > 1, "The Zone and Region Wise report does not contain any data In Auto Dialer Report..");
		    
		    // Additional validation: Check if a specific element is not equal to zero
		    WebElement specificElement = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[2]"));
		    String elementText = specificElement.getText();
		    
		    // Assert that the specific element is not equal to zero
		    Assert.assertNotEquals(elementText, "0", "The specific element is equal to zero, failing the test In Auto Dialer Report..");
		}		   
//...................................................................................  
//...............Navigate to Dealer Parent Group Wise Tab and select date range......................................................................................
	   
	   @Test(priority = 9)
	   public void Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
		   Thread.sleep(7000);
	       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       
	       WebElement Dealer_Parent_Group_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
	       Dealer_Parent_Group_Wise.click();
	       Thread.sleep(3000);
	       
	     
	       // Click on the generate report button
	       WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	       clickOnGenerate.click();
	       
	       Thread.sleep(30000);
	   }
//...........................To Validate Data is available for Dealer Parent Group Wise tab..................................................................................................	   
	   @Test(priority = 10)
	   public void Data_Verification_Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
		// Locate the column element using the provided XPath
		   List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[2]//tr"));
	       
		 // Check if the report contains data
		       if (reportRows.size() > 1) {
		           System.out.println("Dealer Parent Group Wise report contains data In Auto Dialer Report.."); // Message when data is present
		       }
		       
		       // Assert to fail the method if data is not present
		       Assert.assertTrue(reportRows.size() > 1, "The Dealer Parent Group Wise report does not contain any data  In Auto Dialer Report..");
		   }
	   
//...............Navigate to Workshop Wise Tab and select date range......................................................................................
	 	   
	 	   @Test(priority = 11)
	 	   public void Workshop_Wise_Tab() throws InterruptedException {
	 		   Thread.sleep(7000);
	 	       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	       
	 	       WebElement Workshop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
	 	      Workshop_Wise.click();
	 	       Thread.sleep(3000);
	 	       
	 	   
	 		       
	 	       // Click on the generate report button
	 	       WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	 	       clickOnGenerate.click();
	 	       
	 	       Thread.sleep(30000);
	 	   }
//..........................To Validate Data is available for Workshop Wise tab.............................................................................................	   
	 	  
	 	   @Test(priority = 12)
	 	   public void Data_Verification_Workshop_Wise_Tab() throws InterruptedException {
	 		// Verify if the report contains data
		       List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[3]//tr"));
		       
		       // Check if the report contains data
		       if (reportRows.size() > 1) {
		           System.out.println("Workshop Wise report contains data In Auto Dialer Report.."); // Message when data is present
		       }
		       
		       // Assert to fail the method if data is not present
		       Assert.assertTrue(reportRows.size() > 1, "The Workshop Wise report does not contain any data In Auto Dialer Report.In Auto Dialer Report..");
		   }
//...................................Navigate to Day Wise tab and select date range................................................  
	 	 
	 	   @Test(priority = 13)
	 	   public void Day_Wise_Tab() throws InterruptedException {
	 		   Thread.sleep(7000);
	 	       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	       
	 	       WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
	 	       Day_Wise.click();
	 	       Thread.sleep(3000);
	 	       
	 	     
	 		       
	 	       //Click on the generate report button
	 	       WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	 	       clickOnGenerate.click();
	 	       
	 	       Thread.sleep(30000);
	 	   }
//..........................To Validate if data is available for Day Wise tab..................................................................................................	   
	 	   
	 	   @Test(priority = 14)
	 	   public void Data_Verification_Day_Wise_Tab() throws InterruptedException {
	 		// Verify if the report contains data
		       List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[4]//tr"));
		       
		       // Check if the report contains data
		       if (reportRows.size() > 1) {
		           System.out.println("Day Wise report contains data In Auto Dialer Report.."); // Message when data is present
		       }
		       
		       // Assert to fail the method if data is not present
		       Assert.assertTrue(reportRows.size() > 1, "The Day Wise report does not contain any data In Auto Dialer Report..");
		   }
//.................................Navigate to SMRE Wise tab and select date range............................................  
	 	  
	 	   @Test(priority = 15)
	 	   public void SMRE_Wise_Tab() throws InterruptedException {
	 		   Thread.sleep(7000);
	 	       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	       
	 	       WebElement SMRE_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" SMRE Wise \"]")));
	 	       SMRE_Wise.click();
	 	       Thread.sleep(3000);
	 	       
	 	    
	 		       
	 	       //Click on the generate report button
	 	       WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	 	       clickOnGenerate.click();
	 	       
	 	       Thread.sleep(30000);
	 	   }
//............................To Validate data is available for SMRE Wise tab................................................................................................	   
	 	   
	 	   @Test(priority = 16)
	 	   public void Data_Verification_SMRE_Wise_Tab() throws InterruptedException {
	 		// Verify if the report contains data
		       List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[6]//tr"));
		       
		       // Check if the report contains data
		       if (reportRows.size() > 1) {
		           System.out.println("SMRE Wise report contains data In Auto Dialer Report.."); // Message when data is present
		       }
		       
		       // Assert to fail the method if data is not present
		       Assert.assertTrue(reportRows.size() > 1, "The SMRE Wise report does not contain any data In Auto Dialer Report..");
		   }
//.................................Navigate to Dump Wise Tab and select all parameters..................................................  
	 	 
	 	   @Test(priority = 17)
	 	   public void Dump_Wise_Tab() throws InterruptedException {
	 		   Thread.sleep(7000);
	 	       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	       
	 	       WebElement Dump_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dump Wise \"]")));
	 	       Dump_Wise.click();
	 	       Thread.sleep(3000);
	 	       
	 	    
	 		   WebElement dealerparent= driver.findElement(By.xpath("(//*[@role=\"combobox\"])[1]"));
	 		   dealerparent.click();
	 		   Thread.sleep(2000);
	 		    
	 		   //select option from dealer parent
	 		   WebElement dealerparentoption= driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[1]"));
	 		   dealerparentoption.click();
	 		   Thread.sleep(2000);
	 		    
	 		   //select Workshop dropdown
	 		   WebElement Workshop= driver.findElement(By.xpath("(//*[@role=\"combobox\"])[2]"));
	 		   Actions actions2 = new Actions(driver);
               actions2.doubleClick(Workshop).perform();

	 		   Thread.sleep(2000);
	 		    
	 		   //select option from dealer parent
	 		   WebElement Workshopoption= driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[1]"));
	 		   Workshopoption.click();
	 		   Thread.sleep(2000);
	 		   
	 		   //click on field to close workshop dropdown
	 		   WebElement download= driver.findElement(By.xpath("(//*[@class=\"mat-button-wrapper\"])[1]"));
	 		   Actions actions3 = new Actions(driver);
               actions3.doubleClick(download).perform();

		 	   Thread.sleep(3000);
	 		      
	 	       //Click on the generate report button
	 	       WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	 	       Actions actions4 = new Actions(driver);
               actions4.doubleClick(clickOnGenerate).perform();

	 	       
	 	       Thread.sleep(30000);
	 	       
	 	   }
//......................To Validate Data is available in Dump Wise tab..................................................................................................	   
	 	   
	 	   @Test(priority = 18)
	 	   public void Data_Verification_Dump_Wise_Tab() throws InterruptedException {
	 		// Verify if the report contains data
		       List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[5]//tr"));
		       
		       // Check if the report contains data
		       if (reportRows.size() > 1) {
		           System.out.println("Dump Wise report contains data In Auto Dialer Report.."); // Message when data is present
		       }
		       
		       // Assert to fail the method if data is not present
		       Assert.assertTrue(reportRows.size() > 1, "The Dump Wise report does not contain any data In Auto Dialer Report..");
		   }
//..........................Download Dump Wise Report.......................................................  
	 	   
	 	  @Test(priority = 19)
	 	   public void Download_Dump_Wise_Report() throws InterruptedException {
	 		  
	 	  WebElement download= driver.findElement(By.xpath("(//*[@class=\"mat-button-wrapper\"])[1]"));
	 	  download.click();
	 	  Thread.sleep(3000);
	 	  
	 	 WebElement DumpWise= driver.findElement(By.xpath("//*[text()=\"Dump-Wise\"]"));
	      DumpWise.click();

		    Thread.sleep(8000);
	} 		   
//.....................................................................................................................
	 	  
	 	  
}

