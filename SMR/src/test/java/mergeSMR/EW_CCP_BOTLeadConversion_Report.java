package mergeSMR;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

public class EW_CCP_BOTLeadConversion_Report {

    public static WebDriver driver;
    public WebDriverWait wait;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

    String z1;
    String z2;
    String z3;
    String z4;
    String z5;
    String z6;
    String z7;
    String z8;
    String d1;
    String d2;
    String d3;
    String d4;
    String d5;
    String d6;
    String d7;
    String d8;
    String w1;
    String w2;
    String w3;
    String w4;
    String w5;
    String w6;
    String w7;
    String w8;
    String day1;
    String day2;
    String day3;
    String day4;
    String day5;
    String day6;
    String day7;
    String day8;


    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        this.driver = Last_Attempt_Report_SMR.driver;
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
    public void Click_On_EW_CCP_BOTLeadConversion_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement EWCCP = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"EW-CCP Bot Lead Conversion \"]")));
        EWCCP.click();
        Thread.sleep(7000);

    }

    //..................................Zone And Region Wise Tab......................................................................................
    @Test(priority = 7)
    public void Zone_And_Region_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //click on Select Campaign Name dropdown
        Thread.sleep(3000);
        WebElement Campaign = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[1]"));
        Campaign.click();

        Thread.sleep(3000);

        //select Campaign Name- ALL
        WebElement CampaignName = driver.findElement(By.xpath("//*[text()=\" All\"]"));
        CampaignName.click();
        Thread.sleep(4000);

        // Click on the calendar to open date picker
        WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
        select.click();
        Thread.sleep(4000);

        // Select start date (1st of the current month)
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");


        WebElement selectStart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
        selectStart.click();
        Thread.sleep(2000);

        // Select today's date
        WebElement selectToday = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
        selectToday.click();
        Thread.sleep(2000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        //Elements of Zone and Region Wise
        WebElement TotalLeadsRecieved = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[2]"));
        WebElement NotAttemptedLeads = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[3]"));
        WebElement NotConnectedLeads = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[4]"));
        WebElement ConnectedFollowUpLeads = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[5]"));
        WebElement ProposalSharedLeads = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[6]"));
        WebElement ReadyToPurchaseLeads = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[7]"));
        WebElement PurchaseCompletedLeads = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[8]"));
        WebElement PurchaseCancelledLeads = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[9]"));

        Thread.sleep(4000);
        //GET THE VALUES

        z1 = TotalLeadsRecieved.getText();
        z2 = NotAttemptedLeads.getText();
        z3 = NotConnectedLeads.getText();
        z4 = ConnectedFollowUpLeads.getText();
        z5 = ProposalSharedLeads.getText();
        z6 = ReadyToPurchaseLeads.getText();
        z7 = PurchaseCompletedLeads.getText();
        z8 = PurchaseCancelledLeads.getText();


        Thread.sleep(5000);

        try {
            // Find the attribute value of 'Total Leads Recieved'

            // Parse the 'Total Leads Recieved' value to a numeric type
            double TotalLeadRecieved = Double.parseDouble(z1);

            if (TotalLeadRecieved <= 0 || z1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Zone And Region Wise In EW-CCP-lead conversion_Report " + z1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'Total Leads Recieved' column Value of Zone And Region Wise Tab In EW-CCP-lead conversion_Report::: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone And Region Wise Tab In EW-CCP-lead conversion_Report " + e.getMessage());
        }
    }

    //.................................Dealer Parent Group Wise tab.....................................................................................
    @Test(priority = 8)
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

        //Elements of Dealer Parent Group Wise
        WebElement TotalLeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement NotAttemptedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement NotConnectedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement ConnectedFollowUpLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement ProposalSharedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement ReadyToPurchaseLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement PurchaseCompletedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement PurchaseCancelledLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));

        Thread.sleep(4000);
        //GET THE VALUES

        d1 = TotalLeadsRecieved.getText();
        d2 = NotAttemptedLeads.getText();
        d3 = NotConnectedLeads.getText();
        d4 = ConnectedFollowUpLeads.getText();
        d5 = ProposalSharedLeads.getText();
        d6 = ReadyToPurchaseLeads.getText();
        d7 = PurchaseCompletedLeads.getText();
        d8 = PurchaseCancelledLeads.getText();


        Thread.sleep(5000);

        try {
            // Find the attribute value of 'Total Leads Recieved'

            // Parse the 'Total Leads Recieved' value to a numeric type
            double TotalLeadRecieved = Double.parseDouble(d1);

            if (TotalLeadRecieved <= 0 || d1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Dealer Parent Group Wise In EW-CCP-lead conversion_Report : " + d1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'Total Leads Recieved' column Value of Dealer Parent Group Wise Tab In EW-CCP-lead conversion_Report::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer Parent Group Wise Tab In EW-CCP-lead conversion_Report " + e.getMessage());
        }
    }

    //.................................Workshop Wise Tab.....................................................................................
    @Test(priority = 9)
    public void Workshop_Wise_Tab() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement WorkShop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        WorkShop_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        //Elements of Workshop Wise
        WebElement TotalLeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement NotAttemptedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement NotConnectedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement ConnectedFollowUpLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement ProposalSharedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement ReadyToPurchaseLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement PurchaseCompletedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement PurchaseCancelledLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));

        Thread.sleep(4000);
        //GET THE VALUES

        w1 = TotalLeadsRecieved.getText();
        w2 = NotAttemptedLeads.getText();
        w3 = NotConnectedLeads.getText();
        w4 = ConnectedFollowUpLeads.getText();
        w5 = ProposalSharedLeads.getText();
        w6 = ReadyToPurchaseLeads.getText();
        w7 = PurchaseCompletedLeads.getText();
        w8 = PurchaseCancelledLeads.getText();


        Thread.sleep(5000);

        try {
            // Find the attribute value of 'Total Leads Recieved'

            // Parse the 'Total Leads Recieved' value to a numeric type
            double TotalLeadRecieved = Double.parseDouble(w1);

            if (TotalLeadRecieved <= 0 || w1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Workshop Wise EW-CCP-lead conversion_Report : " + w1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'Total Leads Recieved' column Value of Workshop Wise Tab EW-CCP-lead conversion_Report::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Workshop Wise Tab EW-CCP-lead conversion_Report " + e.getMessage());
        }
    }

    //.....................................Day Wise Tab.................................................................................
    @Test(priority = 10)
    public void Day_Wise_Tab() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        //Elements of Day Wise
        WebElement TotalLeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
        WebElement NotAttemptedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement NotConnectedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement ConnectedFollowUpLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement ProposalSharedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
        WebElement ReadyToPurchaseLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement PurchaseCompletedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement PurchaseCancelledLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));

        Thread.sleep(4000);
        //GET THE VALUES

        day1 = TotalLeadsRecieved.getText();
        day2 = NotAttemptedLeads.getText();
        day3 = NotConnectedLeads.getText();
        day4 = ConnectedFollowUpLeads.getText();
        day5 = ProposalSharedLeads.getText();
        day6 = ReadyToPurchaseLeads.getText();
        day7 = PurchaseCompletedLeads.getText();
        day8 = PurchaseCancelledLeads.getText();


        Thread.sleep(5000);

        try {
            // Find the attribute value of 'Total Leads Recieved'

            // Parse the 'Total Leads Recieved' value to a numeric type
            double TotalLeadRecieved = Double.parseDouble(day1);

            if (TotalLeadRecieved <= 0 || day1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Day Wise In EW-CCP-lead conversion_Report   : " + day1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'Total Leads Recieved' column Value of Day Wise Tab  In EW-CCP-lead conversion_Report::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day Wise Tab In EW-CCP-lead conversion_Report " + e.getMessage());
        }
    }

    //.....................................Dump Wise Tab.................................................................................
//	   @Test(priority = 11)
//		public void Dump_Wise_Tab() throws InterruptedException, TimeoutException {
//		    // Wait for the page to load
//		    Thread.sleep(6000);
//		    
//		    // Initialize WebDriverWait
//		    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		    
//		    // Click on the "Dump Wise" option
//		    WebElement Dump_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dump Wise \"]")));
//		    Dump_Wise.click();
//		    Thread.sleep(2000);
//		    
//		 // Click on the calendar to open date picker
//	        WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
//	        select.click();
//	        Thread.sleep(3000);
//		    
//	     // Calculate dates
//		    LocalDate today = LocalDate.now();
//		    LocalDate twoDaysAgo = today.minusDays(2);
//		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
//
//		    // Select start date (2 days before today)
//		    WebElement selectStart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + twoDaysAgo.format(formatter) + "\"]")));
//		    selectStart.click();
//		    Thread.sleep(2000);
//
//		    // Select today's date
//		    WebElement selectToday = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
//		    selectToday.click();
//		    Thread.sleep(2000);
//		    
//		    //click on Generate button
//		    
//		    WebElement Generate= driver.findElement(By.xpath("//*[text()=\"Generate\"]"));
//		    Generate.click();
//		    Thread.sleep(20000);
//		    				    			    			    
////		    // Click on the "Download" Icon 
//		    WebElement Download = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-button-wrapper\"])[1]")));
//		    Actions actions1 = new Actions(driver);
//           actions1.click(Download).perform();
//
//		    Thread.sleep(6000);
//		    
//		 // Click on the "Dump Wise" Option 
//		    WebElement DumpWise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()=\"Dump-Wise\"])")));
//		    Actions actions2 = new Actions(driver);
//            actions2.click(DumpWise).perform();
//
//		    Thread.sleep(7000);			   
//}
//.................................Data Validation.........................................................................
    @Test(priority = 12)
    public void Compare_TotalLeadsRecieved_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d1, z1);
    }

    //...................................................................................................
    @Test(priority = 13)
    public void Compare_NotAttemptedLeads_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d2, z2);
    }

    //...................................................................................................
    @Test(priority = 14)
    public void Compare_NotConnectedLeads_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d3, z3);
    }

    //...................................................................................................
    @Test(priority = 15)
    public void Compare_ConnectedFollowUpLeads_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(d4, z4);
    }

    //...................................................................................................
    @Test(priority = 16)
    public void Compare_ProposalSharedLeads_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d5, z5);
    }

    //...................................................................................................
    @Test(priority = 17)
    public void Compare_ReadyToPurchaseLeads_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d6, z6);
    }

    //...................................................................................................
    @Test(priority = 18)
    public void Compare_PurchaseCompletedLeads_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(d7, z7);
    }

    //...................................................................................................
    @Test(priority = 19)
    public void Compare_PurchaseCancelledLeads_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d8, z8);
    }

    //...................................................................................................
    @Test(priority = 20)
    public void Compare_TotalLeadsRecieved_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, z1);
    }

    //...................................................................................................
    @Test(priority = 21)
    public void Compare_NotAttemptedLeads_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, z2);
    }

    //...................................................................................................
    @Test(priority = 22)
    public void Compare_NotConnectedLeads_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, z3);
    }

    //...................................................................................................
    @Test(priority = 23)
    public void Compare_ConnectedFollowUpLeads_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(w4, z4);
    }

    //...................................................................................................
    @Test(priority = 24)
    public void Compare_ProposalSharedLeads_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(w5, z5);
    }

    //...................................................................................................
    @Test(priority = 25)
    public void Compare_ReadyToPurchaseLeads_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(w6, z6);
    }

    //...................................................................................................
    @Test(priority = 26)
    public void Compare_PurchaseCompletedLeads_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, z7);
    }

    //...................................................................................................
    @Test(priority = 27)
    public void Compare_PurchaseCancelledLeads_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w8, z8);
    }

    //...................................................................................................
    @Test(priority = 28)
    public void Compare_TotalLeadRecieved_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, z1);
    }

    //...................................................................................................
    @Test(priority = 29)
    public void Compare_NotAttemptedLeads_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, z2);
    }

    //...................................................................................................
    @Test(priority = 30)
    public void Compare_NotConnectedLeads_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, z3);
    }

    //...................................................................................................
    @Test(priority = 31)
    public void Compare_ConnectedFollowUpLeads_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, z4);
    }

    //...................................................................................................
    @Test(priority = 32)
    public void Compare_ProposalSharedLeads_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, z5);
    }

    //...................................................................................................
    @Test(priority = 33)
    public void Compare_ReadyToPurchaseLeads_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, z6);
    }

    //...................................................................................................
    @Test(priority = 34)
    public void Compare_PurchaseCompletedLeads_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, z7);
    }

    //...................................................................................................
    @Test(priority = 35)
    public void Comare_PurchaseCancelledLeads_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(day8, z8);
    }

    //...................................................................................................
    @Test(priority = 36)
    public void Compare_TotalLeadsRecieved_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, d1);
    }

    //...................................................................................................
    @Test(priority = 37)
    public void Compare_NotAttemptedLeads_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, d2);
    }

    //...................................................................................................
    @Test(priority = 38)
    public void Compare_NotConnectedLeads_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, d3);
    }

    //...................................................................................................
    @Test(priority = 39)
    public void Compare_ConnectedFollowUpLeads_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, d4);
    }

    //...................................................................................................
    @Test(priority = 40)
    public void Compare_ProposalSharedLeads_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, d5);
    }

    //...................................................................................................
    @Test(priority = 41)
    public void Compare_ReadyToPurchaseLeads_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w6, d6);
    }

    //...................................................................................................
    @Test(priority = 42)
    public void Compare_PurchaseCompletedLeads_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, d7);
    }

    //...................................................................................................
    @Test(priority = 43)
    public void Compare_PurchaseCancelledLeads_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w8, d8);
    }

    //...................................................................................................
    @Test(priority = 44)
    public void Compare_TotalLeadsRecieved_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, d1);
    }

    //...................................................................................................
    @Test(priority = 45)
    public void Compare_NotAttemptedLeads_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, d2);
    }

    //...................................................................................................
    @Test(priority = 46)
    public void Compare_NotConnectedLeads_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, d3);
    }

    //...................................................................................................
    @Test(priority = 47)
    public void Compare_ConnectedFollowUpLeads_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, d4);
    }

    //...................................................................................................
    @Test(priority = 48)
    public void Compare_ProposalSharedLeads_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, d5);
    }

    //...................................................................................................
    @Test(priority = 49)
    public void Compare_ReadyToPurchaseLeads_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, d6);
    }

    //...................................................................................................
    @Test(priority = 50)
    public void Compare_PurchaseCompletedLeads_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, d7);
    }

    //...................................................................................................
    @Test(priority = 51)
    public void Compare_PurchaseCancelledLeads_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, d8);
    }

    //...................................................................................................
    @Test(priority = 52)

    public void Compare_TotalLeadsRecieved_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, w1);
    }

    //...................................................................................................
    @Test(priority = 53)
    public void Compare_NotAttemptedLeads_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, w2);
    }

    //...................................................................................................
    @Test(priority = 54)
    public void Compare_NotConnectedLeads_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, w3);
    }

    //...................................................................................................
    @Test(priority = 55)
    public void Compare_ConnectedFollowUpLeads_Column_WorkshopWise_With_DayWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(day4, w4);
    }

    //...................................................................................................
    @Test(priority = 56)
    public void Compare_ProposalSharedLeads_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, w5);
    }

    //...................................................................................................
    @Test(priority = 57)
    public void Compare_ReadyToPurchaseLeads_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, w6);
    }

    //...................................................................................................
    @Test(priority = 58)
    public void Compare_PurchaseCompletedLeads_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, w7);
    }

    //...................................................................................................
    @Test(priority = 59)
    public void Compare_PurchaseCancelledLeads_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, w8);

        Thread.sleep(4000);
    }
//...................................................................................................	


}
