package mergeSMR;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DueVsDone_Report_SMR {

    public static WebDriver driver;
    public WebDriverWait wait;

    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        this.driver = Dealer_subscription.driver;
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
    public void Click_On_DUE_VS_DONE_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement DueVsDone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Due Vs Done \"]")));
        DueVsDone.click();
        Thread.sleep(4000);

    }

    //........................................................................................................................
    @Test(priority = 7)
    public void Select_REGION_Parameter() throws InterruptedException {
        //click on Region dropdown
        WebElement Region = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[1]"));
        Region.click();

        Thread.sleep(3000);

        //Select option

        WebElement option = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
        option.click();
        Thread.sleep(3000);
    }

    //.........................................................................................................................
    @Test(priority = 8)
    public void Select_WORKSHOP_Parameter() throws InterruptedException {
        //click on Region dropdown
        WebElement Workshop = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[2]"));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(Workshop).perform();


        Thread.sleep(3000);

        //Select option

        WebElement option = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
        option.click();
        Thread.sleep(3000);
    }

    //.........................................................................................................................
    @Test(priority = 9)
    public void Select_SERVICE_TYPE_Parameter() throws InterruptedException {
        //click on some field to close dropdown
        WebElement field = driver.findElement(By.xpath("(//*[@role=\"img\"])[8]"));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(field).perform();

        Thread.sleep(3000);

        //click on Region dropdown
        WebElement Service = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[3]"));
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(Service).perform();


        Thread.sleep(3000);

        //Select option

        WebElement option = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
        option.click();
        Thread.sleep(3000);
    }

    //.........................................................................................................................
    @Test(priority = 10)
    public void Select_VEHICLE_CHANNEL_Parameter() throws InterruptedException {
        //click on Region dropdown
        WebElement Channel = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
        Channel.click();

        Thread.sleep(3000);

        //Select option

        WebElement option = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
        option.click();
        Thread.sleep(3000);
    }

    //.........................................................................................................................
    @Test(priority = 11)
    public void Click_On_Generate_Button() throws InterruptedException {

        //click on Generate Button
        WebElement Generate = driver.findElement(By.xpath("(//*[text()=\"Generate\"])"));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(Generate).perform();


        Thread.sleep(20000);

    }
//.............................................................................................................   

    @Test(priority = 12)
    public void Data_Verification_DueVsDone() throws InterruptedException {
        // Verify if the report contains data
        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"rowgroup\"][2]//tr)"));
        Assert.assertTrue(reportRows.size() > 1, "The report does not contain any data In Due-Vs-Done Report.");


    }

// //...................................................................................  
//   @Test(priority = 13)
//   public void Download_DueVsDone() throws InterruptedException {
//   Thread.sleep(3000);
//   WebElement Download= driver.findElement(By.xpath("(//*[@role=\"img\"])[8]"));
//   Download.click();
//   
//   Thread.sleep(2000);
//   
//   WebElement Excel= driver.findElement(By.xpath("(//*[contains(text(),\"Excel\")])"));
//   Excel.click();
//   
//   Thread.sleep(4000);
//   
//   }
}
