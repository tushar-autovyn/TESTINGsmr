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

public class SMRE_Performance_Report_SMR {

    public static WebDriver driver;
    public WebDriverWait wait;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");


    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {

        this.driver = SmartEyeOverAllPerformance.driver;
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
    public void Click_On_SMRE_PERFORMANCE_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SMREPer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"SMRE Performance \"]")));
        SMREPer.click();
        Thread.sleep(7000);

    }
//........................................................................................................................

    @Test(priority = 7)
    public void Select_Parameter_VehicleChannel_SMRE_PERFORMANCE_REPORT() throws InterruptedException {
        //click on Vehicle Channel drop down

        WebElement VehicleChannel = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[1]"));
        Actions actions1 = new Actions(driver);
        actions1.click(VehicleChannel).perform();


        Thread.sleep(3000);

        //select option from Vehicle Channel

        WebElement VehicleChanneloption = driver.findElement(By.xpath("(//*[contains(text(),\"Select All\")])"));
        Actions actions2 = new Actions(driver);
        actions2.click(VehicleChanneloption).perform();


        Thread.sleep(3000);

    }

    //..........................................................................................................
    @Test(priority = 8)
    public void Select_Parameter_DelaerChannel_SMRE_PERFORMANCE_REPORT() throws InterruptedException {


        //select Dealer Channel dropdown
        WebElement DealerChannel = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[2]"));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(DealerChannel).perform();


        Thread.sleep(3000);

        //select option from Vehicle Channel

        WebElement DealerChanneloption = driver.findElement(By.xpath("(//*[contains(text(),\"Select All\")])"));
        DealerChanneloption.click();

        Thread.sleep(3000);

    }

    //..........................................................................................................
    @Test(priority = 9)
    public void Select_Parameter_ZONE_SMRE_PERFORMANCE_REPORT() throws InterruptedException {
        //select Zone dropdown
        WebElement Zone = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[3]"));
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(Zone).perform();


        Thread.sleep(3000);

        //select option from Zone Option

        WebElement Zoneoption = driver.findElement(By.xpath("(//*[contains(text(),\"Select All\")])"));
        Zoneoption.click();

        Thread.sleep(3000);

    }

    //..........................................................................................................
    @Test(priority = 10)
    public void Select_Parameter_REGION_SMRE_PERFORMANCE_REPORT() throws InterruptedException {


        //select Region dropdown
        WebElement Region = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
        Actions actions3 = new Actions(driver);
        actions3.doubleClick(Region).perform();


        Thread.sleep(3000);

        //select option from Region Option

        WebElement Regionoption = driver.findElement(By.xpath("(//*[contains(text(),\"Select All\")])"));
        Regionoption.click();

        Thread.sleep(3000);

    }

    //..........................................................................................................
    @Test(priority = 11)
    public void Select_Parameter_DEALER_NAME_SMRE_PERFORMANCE_REPORT() throws InterruptedException {
        //select Dealer Name dropdown
        WebElement DealerName = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));
        Actions actions4 = new Actions(driver);
        actions4.doubleClick(DealerName).perform();


        Thread.sleep(3000);

        //select option from Dealer Name Option

        WebElement DealerNameoption = driver.findElement(By.xpath("(//*[contains(text(),\"Select All\")])"));
        DealerNameoption.click();

        Thread.sleep(3000);

    }
    //..........................................................................................................

    @Test(priority = 12)
    public void Select_Parameter_WORKSHOP_NAME_SMRE_PERFORMANCE_REPORT() throws InterruptedException {
        //select Workshop Name dropdown
        WebElement WorkshopName = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[6]"));
        Actions actions5 = new Actions(driver);
        actions5.doubleClick(WorkshopName).perform();


        Thread.sleep(3000);

        //select option from Workshop Name

        WebElement WorkshopNameoption = driver.findElement(By.xpath("(//*[contains(text(),\"Select All\")])"));
        WorkshopNameoption.click();

        Thread.sleep(3000);

    }

    //..........................................................................................................
    @Test(priority = 13)
    public void Select_Parameter_REPORT_TYPE_SMRE_PERFORMANCE_REPORT() throws InterruptedException {
        //select Report Type dropdown
        WebElement ReportType = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[7]"));
        Actions actions7 = new Actions(driver);
        actions7.doubleClick(ReportType).perform();


        Thread.sleep(3000);

        //select option from Report Type

        WebElement Reportoption = driver.findElement(By.xpath("(//*[contains(text(),\"Zone And Region Wise\")])"));
        Reportoption.click();

        Thread.sleep(3000);

    }
    //..........................................................................................................

    @Test(priority = 14)
    public void Select_Parameter_SERVICE_TYPE_SMRE_PERFORMANCE_REPORT() throws InterruptedException {
        //select Service Type dropdown
        WebElement ServiceType = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[8]"));
        ServiceType.click();

        Thread.sleep(3000);

        //select option from Service Type

        WebElement Serviceoption = driver.findElement(By.xpath("(//*[contains(text(),\"Select All\")])"));
        Serviceoption.click();

        Thread.sleep(3000);

    }

    //..........................................................................................................
    @Test(priority = 15)
    public void Select_Date_Range_SMRE_Performance_REPORT() throws InterruptedException {

        // Click on the first calendar to open date picker
        WebElement firstCalendar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@type=\"button\"])[3]")));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(firstCalendar).perform();

        Thread.sleep(2000);

        // Select start date (1st of the current month) from the first calendar
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

        WebElement selectStart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
        selectStart.click();
        Thread.sleep(2000);

        // Click on the second calendar to open date picker
        WebElement secondCalendar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@type=\"button\"])[4]")));
        secondCalendar.click();
        Thread.sleep(2000);

        // Select today's date from the second calendar
        WebElement selectToday = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
        selectToday.click();
        Thread.sleep(2000);
    }


    //.....................................................................................................................
    @Test(priority = 16)
    public void Click_On_GENERATE_Zone_And_Region_Wise() throws InterruptedException {
        //click on Generate button

        WebElement Generate = driver.findElement(By.xpath("(//*[text()=\"Generate\"])"));
        Actions actions1 = new Actions(driver);
        actions1.click(Generate).perform();

        Thread.sleep(35000);
    }

    //............................................................................................
    @Test(priority = 17)
    public void Data_Verification_ZoneAndRegionWise() throws InterruptedException {
        // Locate all rows including header rows
        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role='rowgroup']//tr)"));

        // Check if the report contains only the data row (excluding two header rows)
        Assert.assertTrue(reportRows.size() > 2, "The report does not contain any data.");

    }
//............................................................................................................................

    @Test(priority = 19)
    public void ClickOn_Edit_And_Select_ReportType_WorkshopWise() throws InterruptedException {
        //Click on Edit button to fill details for next report type
        WebElement Edit = driver.findElement(By.xpath("(//*[contains(text(),\"Edit\")])"));
        Edit.click();
        Thread.sleep(4000);

        //click on Report Type dropdown
        WebElement ReportType = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[8]"));
        ReportType.click();
        Thread.sleep(2000);

        //click on Report Type Option- Workshop Wise
        WebElement WorkshopWise = driver.findElement(By.xpath("(//*[contains(text(),\"Workshop Wise\")])"));
        WorkshopWise.click();
        Thread.sleep(2000);
    }

    //........................................................................................................................
    @Test(priority = 20)
    public void Generate_WorkshopWise_Report() throws InterruptedException {
        //click on Generate button

        WebElement Generate = driver.findElement(By.xpath("(//*[text()=\"Generate\"])"));
        Actions actions1 = new Actions(driver);
        actions1.click(Generate).perform();

        Thread.sleep(35000);
    }

    //............................................................................................
    @Test(priority = 21)
    public void Data_Verification_WorkshopWise() throws InterruptedException {
        // Verify if the report contains data
        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"rowgroup\"][2]//tr)"));
        Assert.assertTrue(reportRows.size() > 1, "The report does not contain any data. No data validation can be done");


    }

    //...........................................................................................................................
    @Test(priority = 22)
    public void ClickOn_Edit_And_Select_ReportType_SMREWise() throws InterruptedException {
        //Click on Edit button to fill details for next report type
        WebElement Edit = driver.findElement(By.xpath("(//*[contains(text(),\"Edit\")])"));
        Edit.click();
        Thread.sleep(4000);

        //click on Report Type dropdown
        WebElement ReportType = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[8]"));
        ReportType.click();
        Thread.sleep(2000);

        //click on Report Type Option- Workshop Wise
        WebElement WorkshopWise = driver.findElement(By.xpath("(//*[contains(text(),\"SMRE Wise\")])"));
        WorkshopWise.click();
        Thread.sleep(2000);
    }

    //........................................................................................................................
    @Test(priority = 23)
    public void Generate_SMREWise_Report() throws InterruptedException {
        //click on Generate button

        WebElement Generate = driver.findElement(By.xpath("(//*[text()=\"Generate\"])"));
        Actions actions1 = new Actions(driver);
        actions1.click(Generate).perform();

        Thread.sleep(35000);
    }

    //............................................................................................
    @Test(priority = 24)
    public void Data_Verification_SMREWise() throws InterruptedException {
        // Verify if the report contains data
        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"rowgroup\"][2]//tr)"));
        Assert.assertTrue(reportRows.size() > 1, "The report does not contain any data. No data validation can be done");

        Thread.sleep(5000);
    }


}
   

