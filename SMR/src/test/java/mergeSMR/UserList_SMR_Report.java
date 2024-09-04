package mergeSMR;

import java.time.Duration;
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

public class UserList_SMR_Report {

    public static WebDriver driver;
    public WebDriverWait wait;

    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {

        this.driver = SMRE_Performance_Report_SMR.driver;
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
    //..................................................................................................
    @Test(priority = 6)
    public void Click_On_USER_LIST_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement UserList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"User List \"]")));
        UserList.click();
        Thread.sleep(30000);
    }

    //................................................................................................................
//		   @Test(priority = 7)
//		   public void Select_WORKSHOP_NAME_Parameter() throws InterruptedException {
//		       //click on Workshop Name dropdown
//			   WebElement Workshop= driver.findElement(By.xpath("(//*[@role=\"combobox\"])[1]"));
//			   Actions actions1 = new Actions(driver);
//		       actions1.click(Workshop).perform();
//
//			   
//			   Thread.sleep(3000);
//			   
//			   //Select option
//			   
//			   WebElement option= driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
//			   option.click();
//			   Thread.sleep(3000);	   
//		   }
//		 //.........................................................................................................................  
//		   @Test(priority = 8)
//		   public void Click_On_Generate_Button() throws InterruptedException {
//			   
//			 //click on Generate Button
//			   WebElement Generate= driver.findElement(By.xpath("(//*[text()=\"Generate\"])"));
//			   Actions actions1 = new Actions(driver);
//		       actions1.click(Generate).perform();
//
//			   
//			   Thread.sleep(8000);
//			    	   
//		   }
//		//.............................................................................................................   
    @Test(priority = 9)
    public void Data_Verification_User_List() throws InterruptedException {
        // Verify if the report contains data
        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"rowgroup\"][2]//tr)"));

        // Check if the report contains data
        if (reportRows.size() > 1) {
            System.out.println("The report contains data."); // Message when data is present
        }

        // Assert to fail the method if data is not present
        Assert.assertTrue(reportRows.size() > 1, "The report does not contain any data.");
        Thread.sleep(5000);
    }


//..........................................................................................................		   

}

		    
		   

