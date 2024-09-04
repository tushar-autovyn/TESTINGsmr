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


public class BookingConversion_Report_SMR {

    public static WebDriver driver;
    public WebDriverWait wait;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String z1;

    String z2;
    String z3;

    String z4;
    String z5;
    String z6;
    String z7;
    String d1;
    String d2;
    String d3;
    String d4;
    String d5;
    String d6;
    String d7;
    String w1;
    String w2;
    String w3;
    String w4;
    String w5;
    String w6;
    String w7;
    String day1;
    String day2;
    String day3;
    String day4;
    String day5;
    String day6;
    String day7;
    String s1;
    String s2;
    String s3;
    String s4;
    String s5;
    String s6;
    String s7;

    @SuppressWarnings("static-access")
    @BeforeClass
    public void down() throws InterruptedException {

        this.driver = HyperLocal_Status_Report_SMR.driver;
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
    public void Click_On_BOOKING_CONVERSION_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement BookingConv = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Booking Conversion \"]")));
        BookingConv.click();
        Thread.sleep(4000);

    }

    //........................................................................................................................
    @Test(priority = 7)
    public void Zone_And_Region_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the calendar to open date picker
        WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
        select.click();
        Thread.sleep(4000);

        // Select start date (1st of the current month)
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


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
        WebElement PendingConfirmation = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[2]"));
        WebElement Confirmed = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[3]"));
        WebElement ReScheduled = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[4]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[5]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[6]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[7]"));
        WebElement TotalBooking = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[8]"));

        Thread.sleep(4000);
        //GET THE VALUES

        z1 = PendingConfirmation.getText();
        z2 = Confirmed.getText();
        z3 = ReScheduled.getText();
        z4 = ReportedAtOther.getText();
        z5 = ReportedAtOwn.getText();
        z6 = JobCardOpen.getText();
        z7 = TotalBooking.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Pending Confirmation

            // Parse the Pending Confirmation value to a numeric type
            double PendingConfirmationValue = Double.parseDouble(z1);

            if (PendingConfirmationValue <= 0 || z1 == null) {
                // Fail the test if PendingConfirmationValue column Value is 0 or less
                Assert.fail("No Data Found for Zone And Region Wise In Booking conversion Report : " + z1);
            } else {
                // Print the Pending Confirmation value
                System.out.println("'Pending Confirmation' column Value of Zone And Region Wise Tab In Booking conversion Report    ::: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone And Region Wise Tab In Booking conversion Report " + e.getMessage());
        }
    }

    //......................................................................................................................
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


        Thread.sleep(17000);

        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
        ItemPerPage.click();
        Thread.sleep(1000);

        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(3000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[6]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
                nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[6]"));
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }

        //Elements of Dealer Parent Wise
        WebElement PendingConfirmation = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement Confirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement ReScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement TotalBooking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));

        Thread.sleep(4000);
        //GET THE VALUES

        d1 = PendingConfirmation.getText();
        d2 = Confirmed.getText();
        d3 = ReScheduled.getText();
        d4 = ReportedAtOther.getText();
        d5 = ReportedAtOwn.getText();
        d6 = JobCardOpen.getText();
        d7 = TotalBooking.getText();

        Thread.sleep(5000);

        try {

            // Parse the Pending Confirmation value to a numeric type
            double Pending_Confirmation = Double.parseDouble(d1);

            if (Pending_Confirmation <= 0 || d1 == null) {
                // Fail the test if Pending Confirmation value is 0 or less
                Assert.fail("No Data Found for Dealer Parent Group Wise In Booking conversion Report : " + d1);
            } else {
                // Print the Pending Confirmation value
                System.out.println("'Pending Confirmation' column value of Dealer Parent Group Wise Tab In Booking conversion Report  ::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer Parent Group Wise Tab In Booking conversion Report " + e.getMessage());
        }
    }

    //.............................................................................................................................
    @Test(priority = 9)
    public void WorkShop_Wise_Tab() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement WorkShop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        WorkShop_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(17000);

        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));
        ItemPerPage.click();
        Thread.sleep(1000);

        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(3000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
                nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }

        //Elements of Workshop Wise
        WebElement PendingConfirmation = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement Confirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement ReScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement TotalBooking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));

        Thread.sleep(4000);
        //GET THE VALUES

        w1 = PendingConfirmation.getText();
        w2 = Confirmed.getText();
        w3 = ReScheduled.getText();
        w4 = ReportedAtOther.getText();
        w5 = ReportedAtOwn.getText();
        w6 = JobCardOpen.getText();
        w7 = TotalBooking.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Pending Confirmation

            // Parse the Pending Confirmation value to a numeric type
            double Pending_Confirmation = Double.parseDouble(w1);

            if (Pending_Confirmation <= 0 || w1 == null) {
                // Fail the test if Pending Confirmation value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise  In Booking conversion Report : " + w1);
            } else {
                // Print the Pending Confirmation value
                System.out.println("'Pending Confirmation' column value of WorkShop Wise Tab In Booking conversion Report::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop Wise Tab In Booking conversion Report " + e.getMessage());
        }
    }

    //..........................................................................................................
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

        Thread.sleep(17000);

        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[6]"));
        Actions actions1 = new Actions(driver);
        actions1.click(ItemPerPage).perform();

        Thread.sleep(2000);

        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(3000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[10]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
                nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[10]"));
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }

        //Elements of Day Wise
        WebElement PendingConfirmation = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[2]"));
        WebElement Confirmed = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[3]"));
        WebElement ReScheduled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[4]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[5]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[6]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[7]"));
        WebElement TotalBooking = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[8]"));

        Thread.sleep(4000);
        //GET THE VALUES

        day1 = PendingConfirmation.getText();
        day2 = Confirmed.getText();
        day3 = ReScheduled.getText();
        day4 = ReportedAtOther.getText();
        day5 = ReportedAtOwn.getText();
        day6 = JobCardOpen.getText();
        day7 = TotalBooking.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Pending Confirmation

            // Parse the Pending Confirmation value to a numeric type
            double Pending_Confirmation = Double.parseDouble(day1);

            if (Pending_Confirmation <= 0 || day1 == null) {
                // Fail the test if Pending Confirmation value is 0 or less
                Assert.fail("No Data Found for Day Wise Tab In Booking conversion Report: " + day1);
            } else {
                // Print the Pending Confirmation value
                System.out.println("'Pending Confirmation' column value of Day Wise Tab In Booking conversion Report ::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day Wise Tab In Booking conversion Report " + e.getMessage());
        }
    }

    //..........................................................................................................
    @Test(priority = 11)
    public void Service_Type_Wise_Tab() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Service_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
        Service_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[7]"));
        ItemPerPage.click();
        Thread.sleep(1000);

        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(3000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[14]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
                nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[14]"));
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }

        //Elements of Service Type Wise
        WebElement PendingConfirmation = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[2]"));
        WebElement Confirmed = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[3]"));
        WebElement ReScheduled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[4]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[5]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[6]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[7]"));
        WebElement TotalBooking = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[8]"));

        Thread.sleep(4000);
        //GET THE VALUES

        s1 = PendingConfirmation.getText();
        s2 = Confirmed.getText();
        s3 = ReScheduled.getText();
        s4 = ReportedAtOther.getText();
        s5 = ReportedAtOwn.getText();
        s6 = JobCardOpen.getText();
        s7 = TotalBooking.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Pending Confirmation

            // Parse the Pending Confirmation value to a numeric type
            double PendingConfirmationValue = Double.parseDouble(s1);

            if (PendingConfirmationValue <= 0 || s1 == null) {
                // Fail the test if Pending Confirmation value is 0 or less
                Assert.fail("No Data Found for Service Type Wise Tab In Booking conversion Report: " + s1);
            } else {
                // Print the Pending Confirmation value
                System.out.println("'Pending Confirmation' column value of Service Type Wise Tab In Booking conversion Report ::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Service Type Wise Tab  In Booking conversion Report  " + e.getMessage());
        }
    }
//..................................................................................................................			

    //..........................................................................................................
    @Test(priority = 13)
    public void Compare_PENDING_CONFIRMATION_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d1, z1);
    }

    //...................................................................................................
    @Test(priority = 14)
    public void Compare_CONFIRMED_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d2, z2);
    }

    //...................................................................................................
    @Test(priority = 15)
    public void Compare_RESCHEDULED_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d3, z3);
    }

    //...................................................................................................
    @Test(priority = 16)
    public void Compare_REPORTED_AT_OTHER_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d4, z4);
    }

    //...................................................................................................
    @Test(priority = 17)
    public void Compare_REPORTED_AT_OWN_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d5, z5);
    }

    //...................................................................................................
    @Test(priority = 18)
    public void Compare_JOB_CARD_OPEN_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d6, z6);
    }

    //...................................................................................................
    @Test(priority = 19)
    public void Compare_TOTALBOOKING_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(d7, z7);
    }

    //...................................................................................................
    @Test(priority = 20)
    public void Compare_PENDING_CONFIRMATION_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, z1);
    }

    //...................................................................................................
    @Test(priority = 21)
    public void Compare_CONFIRMED_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w2, z2);
    }

    //...................................................................................................
    @Test(priority = 22)
    public void Compare_RESCHEDULED_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, z3);
    }

    //...................................................................................................
    @Test(priority = 23)
    public void Compare_REPORTED_AT_OTHER_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, z4);
    }

    //...................................................................................................
    @Test(priority = 24)
    public void Compare_REPORTED_AT_OWN_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(w5, z5);
    }

    //...................................................................................................
    @Test(priority = 25)
    public void Compare_JOB_CARD_OPEN_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w6, z6);
    }

    //...................................................................................................
    @Test(priority = 26)
    public void Compare_TOTAL_BOOKING_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, z7);
    }

    //...................................................................................................
    @Test(priority = 27)
    public void Compare_PENDING_CONFIRMATION_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, z1);
    }

    //...................................................................................................
    @Test(priority = 28)
    public void Compare_CONFIRMED_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, z2);
    }

    //...................................................................................................
    @Test(priority = 29)
    public void Compare_RESCHEDULED_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, z3);
    }

    //...................................................................................................
    @Test(priority = 30)
    public void Compare_REPORTED_AT_OTHER_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, z4);
    }

    //...................................................................................................
    @Test(priority = 31)
    public void Compare_REPORTED_AT_OWN_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, z5);
    }

    //...................................................................................................
    @Test(priority = 32)
    public void Compare_JOB_CARD_OPEN_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, z6);
    }

    //...................................................................................................
    @Test(priority = 33)
    public void Compare_TOTAL_BOOKING_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, z7);
    }

    //...................................................................................................
    @Test(priority = 34)
    public void Compare_PENDING_CONFIRMATION_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, z1);
    }

    //...................................................................................................
    @Test(priority = 35)
    public void Compare_CONFIRMED_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, z2);
    }

    //...................................................................................................
    @Test(priority = 36)
    public void Compare_RESCHEDULED_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, z3);
    }

    //...................................................................................................
    @Test(priority = 37)
    public void Compare_REPORTED_AT_OTHER_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, z4);
    }

    //...................................................................................................
    @Test(priority = 38)
    public void Compare_REPORTED_AT_OWN_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, z5);
    }

    //...................................................................................................
    @Test(priority = 39)
    public void Compare_JOB_CARD_OPEN_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, z6);
    }

    //...................................................................................................
    @Test(priority = 40)
    public void Compare_TOTAL_BOOKING_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, z7);
    }

    //...................................................................................................
    @Test(priority = 41)
    public void Compare_PENDING_CONFIRMATION_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, d1);
    }

    //...................................................................................................
    @Test(priority = 42)
    public void Compare_CONFIRMED_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, d2);
    }

    //...................................................................................................
    @Test(priority = 43)
    public void Compare_RESCHEDULED_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w3, d3);
    }

    //...................................................................................................
    @Test(priority = 44)
    public void Compare_REPORTED_AT_OTHER_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, d4);
    }

    //...................................................................................................
    @Test(priority = 45)
    public void Compare_REPORTED_AT_OWN_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, d5);
    }

    //...................................................................................................
    @Test(priority = 46)
    public void Compare_JOB_CARD_OPEN_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w6, d6);
    }

    //...................................................................................................
    @Test(priority = 47)
    public void Compare_TOTAL_BOOKING_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, d7);
    }

    //...................................................................................................
    @Test(priority = 48)
    public void Compare_PENDING_CONFIRMATION_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, d1);
    }

    //...................................................................................................
    @Test(priority = 49)
    public void Compare_CONFIRMED_Column_DealerParentWise_With_DayWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(day2, d2);
    }

    //...................................................................................................
    @Test(priority = 50)
    public void Compare_RESCHEDULED_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, d3);
    }

    //...................................................................................................
    @Test(priority = 51)
    public void Compare_REPORTED_AT_OTHER_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, d4);
    }

    //...................................................................................................
    @Test(priority = 52)
    public void Compare_REPORTED_AT_OWN_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, d5);
    }

    //...................................................................................................
    @Test(priority = 53)
    public void Compare_JOB_CARD_OPEN_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, d6);
    }

    //...................................................................................................
    @Test(priority = 54)
    public void Compare_TOTAL_BOOKING_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, d7);
    }

    //...................................................................................................
    @Test(priority = 55)
    public void Compare_PENDING_CONFIRMATION_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, d1);
    }

    //...................................................................................................
    @Test(priority = 56)
    public void Compare_CONFIRMED_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, d2);
    }

    //...................................................................................................
    @Test(priority = 57)
    public void Compare_RESCHEDULED_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(s3, d3);
    }

    //...................................................................................................
    @Test(priority = 58)
    public void Compare_REPORTED_AT_OTHER_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, d4);
    }

    //...................................................................................................
    @Test(priority = 59)
    public void Compare_REPORTED_AT_OWN_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, d5);
    }

    //...................................................................................................
    @Test(priority = 60)
    public void Compare_JOB_CARD_OPEN_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, d6);
    }

    //...................................................................................................
    @Test(priority = 61)
    public void Compare_TOTAL_BOOKING_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, d7);
    }

    //...................................................................................................
    @Test(priority = 62)

    public void Compare_PENDING_CONFIRMATION_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, w1);
    }

    //...................................................................................................
    @Test(priority = 63)
    public void Compare_CONFIRMED_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, w2);
    }

    //...................................................................................................
    @Test(priority = 64)
    public void Compare_RESCHEDULED_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, w3);
    }

    //...................................................................................................
    @Test(priority = 65)
    public void Compare_REPORTED_AT_OTHER_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, w4);
    }

    //...................................................................................................
    @Test(priority = 66)
    public void Compare_REPORTED_AT_OWN_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, w5);
    }

    //...................................................................................................
    @Test(priority = 67)
    public void Compare_JOB_CARD_OPEN_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, w6);
    }

    //...................................................................................................
    @Test(priority = 68)
    public void Compare_TOTAL_BOOKING_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, w7);
    }

    //...................................................................................................
    @Test(priority = 69)
    public void Compare_PENDING_CONFIRMATION_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, w1);
    }

    //...................................................................................................
    @Test(priority = 70)
    public void Compare_CONFIRMED_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, w2);
    }

    //...................................................................................................
    @Test(priority = 71)
    public void Compare_RESCHEDULED_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, w3);
    }

    //...................................................................................................
    @Test(priority = 72)
    public void Compare_REPORTED_AT_OTHER_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, w4);
    }

    //...................................................................................................
    @Test(priority = 73)
    public void Compare_REPORTED_AT_OWN_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, w5);
    }

    //...................................................................................................
    @Test(priority = 74)
    public void Compare_JOB_CARD_OPEN_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, w6);
    }

    //...................................................................................................
    @Test(priority = 75)
    public void Compare_TOTAL_BOOKING_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, w7);
    }

    //...................................................................................................
    @Test(priority = 76)
    public void Compare_PENDING_CONFIRMATION_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, day1);
    }

    //...................................................................................................
    @Test(priority = 77)
    public void Compare_CONFIRMED_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, day2);
    }

    //...................................................................................................
    @Test(priority = 78)
    public void Compare_RESCHEDULED_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, day3);
    }

    //...................................................................................................
    @Test(priority = 79)
    public void Compare_REPORTED_AT_OTHER_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, day4);
    }

    //...................................................................................................
    @Test(priority = 80)
    public void Compare_REPORTED_AT_OWN_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, day5);
    }

    //...................................................................................................
    @Test(priority = 81)
    public void Compare_JOB_CARD_OPEN_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, day6);
    }

    //...................................................................................................
    @Test(priority = 82)
    public void Compare_TOTAL_BOOKING_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, day7);
        Thread.sleep(5000);
    }
//...................................................................................................	


}
