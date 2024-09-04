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

public class DataAvailability_Report_SMR {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

//..................................................................................................
   @SuppressWarnings("static-access")
   @BeforeClass
	public void SMR() throws InterruptedException {
	 this.driver=Website_Lead_Report.driver;	
	 Thread.sleep(5000);
	}

	//..................................................................................................
		@Test(priority = 5)
		public void Click_On_Report() throws InterruptedException {
	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   //close the pop up message first
	   WebElement PopUp= driver.findElement(By.xpath("(//*[@title=\"Close message\"])"));
	   PopUp.click();
	   Thread.sleep(3000);
	   
	   WebElement report = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
	   report.click();
	   Thread.sleep(3000);
		
	    }
//.......................Navigate to Data Availability Report...........................................................................
		
	   @Test(priority = 6)
	   public void Click_On_Data_Availability_REPORT() throws InterruptedException {
	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  	   
	   WebElement DataAvail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Data Availability Report \"]")));
	   DataAvail.click();
	   Thread.sleep(7000);				
}
//...............To Validate Data is available for Report......................................................................................
	   @Test(priority = 7)
	   public void Data_Verification_For_Data_Availability_Report() throws InterruptedException {
		// Verify if the report contains data
		    List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@summary=\"table\"]//tr)"));
		    
		    // Check if the report contains data
		    if (reportRows.size() > 3) {
		        System.out.println("'Data Availability Report' contains data."); // Message when data is present
		    }

		    // Assert to fail the method if data is not present
		    Assert.assertTrue(reportRows.size() > 3, "The 'Data Availability Report' does not contain any data.");
		    Thread.sleep(5000);
		    }		   
//.............................Download Data Availability Report......................................................  
	   @Test(priority = 8)
	   public void Download_DATA_AVAILABILITY_Report() throws InterruptedException {
		//click on download icon
		WebElement DownloadIcon= driver.findElement(By.xpath("(//*[@class=\"mat-button-wrapper\"])"));
		DownloadIcon.click();
		Thread.sleep(3000);
		
		//click on Data Available Wise button
		WebElement dataavailablebutton= driver.findElement(By.xpath("//*[text()=\"data Available wise\"]"));
		dataavailablebutton.click();
		
		Thread.sleep(7000);
	   }  
//..................................................................................................	   
	   
		   
}
	   


