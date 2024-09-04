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

public class Last_Attempt_Report_SMR {

    public static WebDriver driver;
    public WebDriverWait wait;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Adjust pattern based on your calendar format


    String z1;
    String z2;
    String z3;
    String z4;
    String z5;
    String z6;
    String z7;
    String z8;
    String z9;
    String z10;
    String z11;
    String z12;
    String z13;
    String z14;
    String z15;
    String d1;
    String d2;
    String d3;
    String d4;
    String d5;
    String d6;
    String d7;
    String d8;
    String d9;
    String d10;
    String d11;
    String d12;
    String d13;
    String d14;
    String d15;
    String w1;
    String w2;
    String w3;
    String w4;
    String w5;
    String w6;
    String w7;
    String w8;
    String w9;
    String w10;
    String w11;
    String w12;
    String w13;
    String w14;
    String w15;
    String day1;
    String day2;
    String day3;
    String day4;
    String day5;
    String day6;
    String day7;
    String day8;
    String day9;
    String day10;
    String day11;
    String day12;
    String day13;
    String day14;
    String day15;
    String s1;
    String s2;
    String s3;
    String s4;
    String s5;
    String s6;
    String s7;
    String s8;
    String s9;
    String s10;
    String s11;
    String s12;
    String s13;
    String s14;
    String s15;


    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        this.driver = BookingConversion_Report_SMR.driver;
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
    public void Click_On_The_LAST_ATTEMPT_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement LastAttempt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Last Attempt \"]")));
        LastAttempt.click();
        Thread.sleep(3000);

    }

    //........................................................................................................................
    @Test(priority = 7)
    public void Zone_And_Region_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the calendar to open date picker
        WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
        select.click();
        Thread.sleep(4000);

        // Get today's date
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");  // Example format

        // Select the 1st and 8rd day of the month
        int[] daysToSelect = {1, 8};
        for (int day : daysToSelect) {
            LocalDate date = today.withDayOfMonth(day);
            WebElement selectDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + date.format(formatter) + "\"]")));
            selectDate.click();
            Thread.sleep(2000);
        }

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(5000);

        //Elements of Zone and Region Wise
        WebElement TotalDispositions = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[2]"));
        WebElement AppointmentScheduled = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[3]"));
        WebElement AppointmentReScheduled = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[4]"));
        WebElement AppointmentConfirmed = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[5]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[6]"));
        WebElement CallMeLater = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[7]"));
        WebElement VehicleSoldToNew = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[8]"));
        WebElement RefuseForService = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[9]"));
        WebElement LowMileage = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[10]"));
        WebElement WrongNo = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[11]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[12]"));
        WebElement Appointment = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[13]"));
        WebElement InterestedViaOffers = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[14]"));
        WebElement InterestedWorkshopToCheck = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[15]"));
        WebElement AdhocAppointment = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[16]"));

        Thread.sleep(4000);
        //GET THE VALUES


        z1 = TotalDispositions.getText();
        System.out.println("Total Dispositions of zone and region wise In Last Attempt report   ::" + z1);

        z2 = AppointmentScheduled.getText();
        z3 = AppointmentReScheduled.getText();
        z4 = AppointmentConfirmed.getText();
        z5 = AppointmentCancelled.getText();
        z6 = CallMeLater.getText();
        z7 = VehicleSoldToNew.getText();
        z8 = RefuseForService.getText();
        z9 = LowMileage.getText();
        z10 = WrongNo.getText();
        z11 = CallNotConnected.getText();
        z12 = Appointment.getText();
        z13 = InterestedViaOffers.getText();
        z14 = InterestedWorkshopToCheck.getText();
        z15 = AdhocAppointment.getText();
        Thread.sleep(5000);

        try {
            // Find the attribute value of Total Disposition

            // Parse the Total Disposition value to a numeric type
            double TotalDispositionValue = Double.parseDouble(z1);

            if (TotalDispositionValue <= 0 || z1 == null) {
                // Fail the test if Total Disposition column Value is 0 or less
                Assert.fail("No Data Found for Zone And Region Wise In LAst Attempt report  " + z1);
            } else {
                // Print the Total Disposition value
                //     System.out.println("'Total Dispositions' column Value of Zone And Region Wise In LAst Attempt report::: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone And Region Wise In LAst Attempt report  " + e.getMessage());
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

        Thread.sleep(5000);

        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[2]"));
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
        WebElement TotalDispositions = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement AppointmentScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement AppointmentReScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement AppointmentConfirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement VehicleSoldToNew = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
        WebElement Appointment = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
        WebElement InterestedViaOffers = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
        WebElement InterestedWorkshopToCheck = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
        WebElement AdhocAppointment = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));

        Thread.sleep(4000);
        //GET THE VALUES

        d1 = TotalDispositions.getText();
        d2 = AppointmentScheduled.getText();
        d3 = AppointmentReScheduled.getText();
        d4 = AppointmentConfirmed.getText();
        d5 = AppointmentCancelled.getText();
        d6 = CallMeLater.getText();
        d7 = VehicleSoldToNew.getText();
        d8 = RefuseForService.getText();
        d9 = LowMileage.getText();
        d10 = WrongNo.getText();
        d11 = CallNotConnected.getText();
        d12 = Appointment.getText();
        d13 = InterestedViaOffers.getText();
        d14 = InterestedWorkshopToCheck.getText();
        d15 = AdhocAppointment.getText();
        Thread.sleep(5000);

        try {

            // Parse the Total Disposition value to a numeric type
            double totalDisposition = Double.parseDouble(d1);

            if (totalDisposition <= 0 || d1 == null) {
                // Fail the test if Total Disposition value is 0 or less
                Assert.fail("No Data Found for Dealer Parent Group Wise   In LAST ATTEMPT REPORT  : " + d1);
            } else {
                // Print the Total Disposition value
                System.out.println("'Total Dispositions' column value of Dealer Parent Group Wise Tab In LAST ATTEMPT REPORT::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer Parent Group Wise In LAST ATTEMPT REPORT " + e.getMessage());
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

        Thread.sleep(5000);


        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[3]"));
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
        WebElement TotalDispositions = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement AppointmentScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement AppointmentReScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement AppointmentConfirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement VehicleSoldToNew = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[13]"));
        WebElement Appointment = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));
        WebElement InterestedViaOffers = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[15]"));
        WebElement InterestedWorkshopToCheck = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[16]"));
        WebElement AdhocAppointment = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[17]"));

        Thread.sleep(4000);
        //GET THE VALUES

        w1 = TotalDispositions.getText();
        w2 = AppointmentScheduled.getText();
        w3 = AppointmentReScheduled.getText();
        w4 = AppointmentConfirmed.getText();
        w5 = AppointmentCancelled.getText();
        w6 = CallMeLater.getText();
        w7 = VehicleSoldToNew.getText();
        w8 = RefuseForService.getText();
        w9 = LowMileage.getText();
        w10 = WrongNo.getText();
        w11 = CallNotConnected.getText();
        w12 = Appointment.getText();
        w13 = InterestedViaOffers.getText();
        w14 = InterestedWorkshopToCheck.getText();
        w15 = AdhocAppointment.getText();
        Thread.sleep(5000);

        try {
            // Find the attribute value of total Disposition

            // Parse the Total Disposition value to a numeric type
            double totalDisposition = Double.parseDouble(w1);

            if (totalDisposition <= 0 || w1 == null) {
                // Fail the test if Total Disposition value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise  In LAST ATTEMPT REPORT: " + w1);
            } else {
                // Print the Total Due value
                System.out.println("'Total Dispositions' column value of WorkShop Wise Tab In LAST ATTEMPT REPORT::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop Wise In LAST ATTEMPT REPORT  " + e.getMessage());
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

        Thread.sleep(5000);

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
        WebElement TotalDispositions = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[2]"));
        WebElement AppointmentScheduled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[3]"));
        WebElement AppointmentReScheduled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[4]"));
        WebElement AppointmentConfirmed = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[5]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[6]"));
        WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[7]"));
        WebElement VehicleSoldToNew = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[8]"));
        WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[9]"));
        WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[10]"));
        WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[11]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[12]"));
        WebElement Appointment = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[13]"));
        WebElement InterestedViaOffers = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[14]"));
        WebElement InterestedWorkshopToCheck = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[15]"));
        WebElement AdhocAppointment = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[16]"));

        Thread.sleep(4000);
        //GET THE VALUES

        day1 = TotalDispositions.getText();
        day2 = AppointmentScheduled.getText();
        day3 = AppointmentReScheduled.getText();
        day4 = AppointmentConfirmed.getText();
        day5 = AppointmentCancelled.getText();
        day6 = CallMeLater.getText();
        day7 = VehicleSoldToNew.getText();
        day8 = RefuseForService.getText();
        day9 = LowMileage.getText();
        day10 = WrongNo.getText();
        day11 = CallNotConnected.getText();
        day12 = Appointment.getText();
        day13 = InterestedViaOffers.getText();
        day14 = InterestedWorkshopToCheck.getText();
        day15 = AdhocAppointment.getText();
        Thread.sleep(5000);

        try {
            // Find the attribute value of Total Due

            // Parse the Total Disposition value to a numeric type
            double totalDisposition = Double.parseDouble(day1);

            if (totalDisposition <= 0 || day1 == null) {
                // Fail the test if Total Disposition value is 0 or less
                Assert.fail("No Data Found for Day Wise In LAST ATTEMPT REPORT: " + day1);
            } else {
                // Print the Total Disposition value
                System.out.println("'Total Dispositions' column value of Day Wise Tab In LAST ATTEMPT REPORT ::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day Wise Tab In LAST ATTEMPT REPORT " + e.getMessage());
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

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[6]"));
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
        WebElement TotalDispositions = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[2]"));
        WebElement AppointmentScheduled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[3]"));
        WebElement AppointmentReScheduled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[4]"));
        WebElement AppointmentConfirmed = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[5]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[6]"));
        WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[7]"));
        WebElement VehicleSoldToNew = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[8]"));
        WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[9]"));
        WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[10]"));
        WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[11]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[12]"));
        WebElement Appointment = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[13]"));
        WebElement InterestedViaOffers = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[14]"));
        WebElement InterestedWorkshopToCheck = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[15]"));
        WebElement AdhocAppointment = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[16]"));

        Thread.sleep(4000);
        //GET THE VALUES

        s1 = TotalDispositions.getText();
        s2 = AppointmentScheduled.getText();
        s3 = AppointmentReScheduled.getText();
        s4 = AppointmentConfirmed.getText();
        s5 = AppointmentCancelled.getText();
        s6 = CallMeLater.getText();
        s7 = VehicleSoldToNew.getText();
        s8 = RefuseForService.getText();
        s9 = LowMileage.getText();
        s10 = WrongNo.getText();
        s11 = CallNotConnected.getText();
        s12 = Appointment.getText();
        s13 = InterestedViaOffers.getText();
        s14 = InterestedWorkshopToCheck.getText();
        s15 = AdhocAppointment.getText();
        Thread.sleep(5000);

        try {
            // Find the attribute value of Total Dispositions

            // Parse the Total Due value to a numeric type
            double totalDispositionValue = Double.parseDouble(s1);

            if (totalDispositionValue <= 0 || s1 == null) {
                // Fail the test if Total Dispositions value is 0 or less
                Assert.fail("No Data Found for Service Type Wise Tab In LAST ATTEMPT REPORT  :: " + s1);
            } else {
                // Print the Total Due value
                System.out.println("'Total Dispositions' column value of Service Type Wise Tab In LAST ATTEMPT REPORT ::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Service Type Wise Tab In LAST ATTEMPT REPORT " + e.getMessage());
        }
    }

    //..........................................................................................................
    @Test(priority = 12)
    public void Compare_TotalDispositions_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d1, z1);
    }

    //...................................................................................................
    @Test(priority = 13)
    public void Compare_AppointmentScheduled_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d2, z2);
    }

    //...................................................................................................
    @Test(priority = 14)
    public void Compare_Appointment_ReScheduled_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d3, z3);
    }

    //...................................................................................................
    @Test(priority = 15)
    public void Compare_AppointmentConfirmed_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d4, z4);
    }

    //...................................................................................................
    @Test(priority = 16)
    public void Compare_AppointmentCancelled_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d5, z5);
    }

    //...................................................................................................
    @Test(priority = 17)
    public void Compare_CallMeLater_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(d6, z6);
    }

    //...................................................................................................
    @Test(priority = 18)
    public void Compare_VehicleSoldToNew_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d7, z7);
    }

    //...................................................................................................
    @Test(priority = 19)
    public void Compare_RefuseForService_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d8, z8);
    }

    //...................................................................................................
    @Test(priority = 20)
    public void Compare_LowMileage_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d9, z9);
    }

    //...................................................................................................
    @Test(priority = 21)
    public void Compare_WrongNumber_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d10, z10);
    }

    //...................................................................................................
    @Test(priority = 22)
    public void Compare_CallNotConnected_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d11, z11);
    }

    //...................................................................................................
    @Test(priority = 23)
    public void Compare_Appointment_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d12, z12);
    }

    //...................................................................................................
    @Test(priority = 24)
    public void Compare_InterestedViaOffers_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d13, z13);
    }

    //...................................................................................................
    @Test(priority = 25)
    public void Compare_InterestedWorkshopToCheck_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d14, z14);
    }

    //...................................................................................................
    @Test(priority = 26)
    public void Compare_AdhocAppointment_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d15, z15);
    }

    //..................................................................................................
    @Test(priority = 27)
    public void Compare_TotalDispositions_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, z1);
    }

    //...................................................................................................
    @Test(priority = 28)
    public void Compare_AppointmentScheduled_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, z2);
    }

    //...................................................................................................
    @Test(priority = 29)
    public void Compare_Appointment_ReScheduled_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, z3);
    }

    //...................................................................................................
    @Test(priority = 30)
    public void Compare_AppointmentConfirmed_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(w4, z4);
    }

    //...................................................................................................
    @Test(priority = 31)
    public void Compare_AppointmentCancelled_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, z5);
    }

    //...................................................................................................
    @Test(priority = 32)
    public void Compare_CallMeLater_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w6, z6);
    }

    //...................................................................................................
    @Test(priority = 33)
    public void Compare_VehicleSOLDToNew_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, z7);
    }

    //...................................................................................................
    @Test(priority = 34)
    public void Compare_RefuseForService_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w8, z8);
    }

    //...................................................................................................
    @Test(priority = 35)
    public void Compare_LowMileage_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w9, z9);
    }

    //...................................................................................................
    @Test(priority = 36)
    public void Compare_WrongNumber_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w10, z10);
    }

    //...................................................................................................
    @Test(priority = 37)
    public void Compare_CallNotConnected_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w11, z11);
    }

    //...................................................................................................
    @Test(priority = 38)
    public void Compare_Appointment_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w12, z12);
    }

    //...................................................................................................
    @Test(priority = 39)
    public void Compare_InterestedViaOffers_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w13, z13);
    }

    //...................................................................................................
    @Test(priority = 40)
    public void Compare_InterestedWorkshopToCheck_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w14, z14);
    }

    //...................................................................................................
    @Test(priority = 41)
    public void Compare_AdhocAppointment_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w15, z15);
    }

    //...................................................................................................
    @Test(priority = 42)
    public void Compare_TotalDispositions_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, z1);
    }

    //...................................................................................................
    @Test(priority = 43)
    public void Compare_AppointmentScheduled_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, z2);
    }

    //...................................................................................................
    @Test(priority = 44)
    public void Compare_Appointment_ReScheduled_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, z3);
    }

    //...................................................................................................
    @Test(priority = 45)
    public void Compare_AppointmentConfirmed_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, z4);
    }

    //...................................................................................................
    @Test(priority = 46)
    public void Compare_AppointmentCancelled_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, z5);
    }

    //...................................................................................................
    @Test(priority = 47)
    public void Compare_CallMeLater_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, z6);
    }

    //...................................................................................................
    @Test(priority = 48)
    public void Compare_VehicleSOLDToNew_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, z7);
    }

    //...................................................................................................
    @Test(priority = 49)
    public void Compare_RefuseForService_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, z8);
    }

    //...................................................................................................
    @Test(priority = 50)
    public void Compare_LowMileage_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, z9);
    }

    //...................................................................................................
    @Test(priority = 51)
    public void Compare_WrongNumber_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day10, z10);
    }

    //...................................................................................................
    @Test(priority = 52)
    public void Compare_CallNotConnected_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day11, z11);
    }

    //...................................................................................................
    @Test(priority = 53)
    public void Compare_Appointment_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day12, z12);
    }

    //...................................................................................................
    @Test(priority = 54)
    public void Compare_InterestedViaOffers_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day13, z13);
    }

    //...................................................................................................
    @Test(priority = 55)
    public void Compare_InterestedWorkshopToCheck_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day14, z14);
    }

    //...................................................................................................
    @Test(priority = 56)
    public void Compare_AdhocAppointment_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day15, z15);
    }

    //...................................................................................................
    @Test(priority = 57)
    public void Compare_TotalDispositions_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, z1);
    }

    //...................................................................................................
    @Test(priority = 58)
    public void Compare_AppointmentScheduled_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, z2);
    }

    //...................................................................................................
    @Test(priority = 59)
    public void Compare_Appointment_ReScheduled_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, z3);
    }

    //...................................................................................................
    @Test(priority = 60)
    public void Compare_AppointmentConfirmed_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, z4);
    }

    //...................................................................................................
    @Test(priority = 61)
    public void Compare_AppointmentCancelled_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, z5);
    }

    //...................................................................................................
    @Test(priority = 62)
    public void Compare_CallMeLater_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, z6);
    }

    //...................................................................................................
    @Test(priority = 63)
    public void Compare_VehicleSOLDToNew_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(s7, z7);
    }

    //...................................................................................................
    @Test(priority = 64)
    public void Compare_RefuseForService_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, z8);
    }

    //...................................................................................................
    @Test(priority = 65)
    public void Compare_LowMileage_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, z9);
    }

    //...................................................................................................
    @Test(priority = 66)
    public void Compare_WrongNumber_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, z10);
    }

    //...................................................................................................
    @Test(priority = 67)
    public void Compare_CallNotConnected_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s11, z11);
    }

    //...................................................................................................
    @Test(priority = 68)
    public void Compare_Appointment_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s12, z12);
    }

    //...................................................................................................
    @Test(priority = 69)
    public void Compare_InterestedViaOffers_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s13, z13);
    }

    //...................................................................................................
    @Test(priority = 70)
    public void Compare_InterestedWorkshopToCheck_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s14, z14);
    }

    //...................................................................................................
    @Test(priority = 71)
    public void Compare_AdhocAppointment_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s15, z15);
    }

    //...................................................................................................
    @Test(priority = 72)
    public void Compare_TotalDispositions_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, d1);
    }

    //...................................................................................................
    @Test(priority = 73)
    public void Compare_AppointmentScheduled_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, d2);
    }

    //...................................................................................................
    @Test(priority = 74)
    public void Compare_Appointment_ReScheduled_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, d3);
    }

    //...................................................................................................
    @Test(priority = 75)
    public void Compare_AppointmentConfirmed_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, d4);
    }

    //...................................................................................................
    @Test(priority = 76)
    public void Compare_AppointmentCancelled_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, d5);
    }

    //...................................................................................................
    @Test(priority = 77)
    public void Compare_CallMelater_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w6, d6);
    }

    //...................................................................................................
    @Test(priority = 78)
    public void Compare_VehicleSOLDToNew_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, d7);
    }

    //...................................................................................................
    @Test(priority = 79)
    public void Compare_RefuseForService_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w8, d8);
    }

    //...................................................................................................
    @Test(priority = 80)
    public void Compare_LowMileage_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w9, d9);
    }

    //...................................................................................................
    @Test(priority = 81)
    public void Compare_WrongNumber_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w10, d10);
    }

    //...................................................................................................
    @Test(priority = 82)
    public void Compare_CallNotConnected_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w11, d11);
    }

    //...................................................................................................
    @Test(priority = 83)
    public void Compare_Appointment_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w12, d12);
    }

    //...................................................................................................
    @Test(priority = 84)
    public void Compare_InterestedViaOffers_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w13, d13);
    }

    //...................................................................................................
    @Test(priority = 85)
    public void Compare_InterestedWorkshopToCheck_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w14, d14);
    }

    //...................................................................................................
    @Test(priority = 86)
    public void Compare_AdhocAppointment_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w15, d15);
    }

    //...................................................................................................
    @Test(priority = 87)
    public void Compare_TotalDispositions_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, d1);
    }

    //...................................................................................................
    @Test(priority = 88)
    public void Compare_AppointmentScheduled_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, d2);
    }

    //...................................................................................................
    @Test(priority = 89)
    public void Compare_AppointmentReScheduled_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, d3);
    }

    //...................................................................................................
    @Test(priority = 90)
    public void Compare_AppointmentConfirmed_Column_DealerParentWise_With_DayWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(day4, d4);
    }

    //...................................................................................................
    @Test(priority = 91)
    public void Compare_AppointmentCancelled_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, d5);
    }

    //...................................................................................................
    @Test(priority = 92)
    public void Compare_CallMeLater_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, d6);
    }

    //...................................................................................................
    @Test(priority = 93)
    public void Compare_VehicleSOLDToNew_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, d7);
    }

    //...................................................................................................
    @Test(priority = 94)
    public void Compare_RefuseForService_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, d8);
    }

    //...................................................................................................
    @Test(priority = 95)
    public void Compare_LowMileage_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, d9);
    }

    //...................................................................................................
    @Test(priority = 96)
    public void Compare_WrongNumber_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day10, d10);
    }

    //...................................................................................................
    @Test(priority = 97)
    public void Compare_CallNotConnected_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day11, d11);
    }

    //...................................................................................................
    @Test(priority = 98)
    public void Compare_Appointment_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day12, d12);
    }

    //...................................................................................................
    @Test(priority = 99)
    public void Compare_InterestedViaOffers_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day13, d13);
    }

    //...................................................................................................
    @Test(priority = 100)
    public void Compare_InterestedWorkshopToCheck_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day14, d14);
    }

    //...................................................................................................
    @Test(priority = 101)
    public void Compare_AdhocAppointment_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day15, d15);
    }

    //...................................................................................................
    @Test(priority = 102)
    public void Compare_TotalDispositions_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, d1);
    }

    //...................................................................................................
    @Test(priority = 103)
    public void Compare_AppointmentScheduled_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, d2);
    }

    //...................................................................................................
    @Test(priority = 104)
    public void Compare_Appointment_ReScheduled_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, d3);
    }

    //...................................................................................................
    @Test(priority = 105)
    public void Compare_AppointmentConfirmed_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, d4);
    }

    //...................................................................................................
    @Test(priority = 106)
    public void Compare_AppointmentCancelled_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, d5);
    }

    //...................................................................................................
    @Test(priority = 107)
    public void Compare_CallMeLater_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, d6);
    }

    //...................................................................................................
    @Test(priority = 108)
    public void Compare_VehicleSOLDToNew_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, d7);
    }

    //...................................................................................................
    @Test(priority = 109)
    public void Compare_RefuseForService_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, d8);
    }

    //...................................................................................................
    @Test(priority = 110)
    public void Compare_LowMileage_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, d9);
    }

    //...................................................................................................
    @Test(priority = 111)
    public void Compare_WrongNumber_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, d10);
    }

    //...................................................................................................
    @Test(priority = 112)
    public void Compare_CallNotConnected_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s11, d11);
    }

    //...................................................................................................
    @Test(priority = 113)
    public void Compare_Appointment_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(s12, d12);
    }

    //...................................................................................................
    @Test(priority = 114)
    public void Compare_InterestedViaOffers_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s13, d13);
    }

    //...................................................................................................
    @Test(priority = 115)
    public void Compare_InterestedWorkshopToCheck_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s14, d14);
    }

    //...................................................................................................
    @Test(priority = 116)
    public void Compare_AdhocAppointment_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s15, d15);
    }

    //...................................................................................................
    @Test(priority = 117)

    public void Compare_TotalDispositions_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, w1);
    }

    //...................................................................................................
    @Test(priority = 118)
    public void Compare_AppointmentScheduled_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, w2);
    }

    //...................................................................................................
    @Test(priority = 119)
    public void Compare_Appointment_ReScheduled_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, w3);
    }

    //...................................................................................................
    @Test(priority = 120)
    public void Compare_AppointmentConfirmed_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, w4);
    }

    //...................................................................................................
    @Test(priority = 121)
    public void Compare_AppointmentCancelled_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, w5);
    }

    //...................................................................................................
    @Test(priority = 122)
    public void Compare_CallMeLater_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, w6);
    }

    //...................................................................................................
    @Test(priority = 123)
    public void Compare_VehicleSOLDToNew_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, w7);
    }

    //...................................................................................................
    @Test(priority = 124)
    public void Compare_RefuseForService_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, w8);
    }

    //...................................................................................................
    @Test(priority = 125)
    public void Compare_LowMileage_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, w9);
    }

    //...................................................................................................
    @Test(priority = 126)
    public void Compare_WrongNumber_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day10, w10);
    }

    //...................................................................................................
    @Test(priority = 127)
    public void Compare_CallNotConnected_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day11, w11);
    }

    //...................................................................................................
    @Test(priority = 128)
    public void Compare_Appointment_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day12, w12);
    }

    //...................................................................................................
    @Test(priority = 129)
    public void Compare_InterestedViaOffers_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day13, w13);
    }

    //...................................................................................................
    @Test(priority = 130)
    public void Compare_InterestedWorkshopToCheck_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day14, w14);
    }

    //...................................................................................................
    @Test(priority = 131)
    public void Compare_AdhocAppointment_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day15, w15);
    }

    //...................................................................................................
    @Test(priority = 132)
    public void Compare_TotalDispositions_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, w1);
    }

    //...................................................................................................
    @Test(priority = 133)
    public void Compare_AppointmentScheduled_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, w2);
    }

    //...................................................................................................
    @Test(priority = 134)
    public void Compare_Appointment_ReScheduled_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, w3);
    }

    //...................................................................................................
    @Test(priority = 135)
    public void Compare_AppointmentConfirmed_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, w4);
    }

    //...................................................................................................
    @Test(priority = 136)
    public void Compare_AppointmentCancelled_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, w5);
    }

    //...................................................................................................
    @Test(priority = 137)
    public void Compare_CallMeLater_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, w6);
    }

    //...................................................................................................
    @Test(priority = 138)
    public void Compare_VehicleSOLDToNew_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, w7);
    }

    //...................................................................................................
    @Test(priority = 139)
    public void Compare_RefuseForService_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, w8);
    }

    //...................................................................................................
    @Test(priority = 140)
    public void Compare_LowMileage_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, w9);
    }

    //...................................................................................................
    @Test(priority = 141)
    public void Compare_WrongNumber_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, w10);
    }

    //...................................................................................................
    @Test(priority = 142)
    public void Compare_CallNotConnected_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s11, w11);
    }

    //...................................................................................................
    @Test(priority = 143)
    public void Compare_Appointment_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s12, w12);
    }

    //...................................................................................................
    @Test(priority = 144)
    public void Compare_InterestedViaOffers_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s13, w13);
    }

    //...................................................................................................
    @Test(priority = 145)
    public void Compare_InterestedWorkshopToCheck_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s14, w14);
    }

    //...................................................................................................
    @Test(priority = 146)
    public void Compare_AdhocAppointment_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s15, w15);
    }

    //...................................................................................................
    @Test(priority = 147)
    public void Compare_TotalDispositions_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, day1);
    }

    //...................................................................................................
    @Test(priority = 148)
    public void Compare_AppointmentScheduled_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, day2);
    }

    //...................................................................................................
    @Test(priority = 149)
    public void Compare_Appointment_ReScheduled_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, day3);
    }

    //...................................................................................................
    @Test(priority = 150)
    public void Compare_AppointmentConfirmed_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, day4);
    }

    //...................................................................................................
    @Test(priority = 151)
    public void Compare_AppointmentCancelled_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(s5, day5);
    }

    //...................................................................................................
    @Test(priority = 152)
    public void Compare_CallMeLater_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, day6);
    }

    //...................................................................................................
    @Test(priority = 153)
    public void Compare_VehicleSOLDToNew_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, day7);
    }

    //...................................................................................................
    @Test(priority = 154)
    public void Compare_RefuseForService_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, day8);
    }

    //...................................................................................................
    @Test(priority = 155)
    public void Compare_LowMileage_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, day9);
    }

    //...................................................................................................
    @Test(priority = 156)
    public void Compare_WrongNumber_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, day10);
    }

    //...................................................................................................
    @Test(priority = 157)
    public void Compare_CallNotConnected_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s11, day11);
    }

    //...................................................................................................
    @Test(priority = 158)
    public void Compare_Appointment_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s12, day12);
    }

    //...................................................................................................
    @Test(priority = 159)
    public void Compare_InterestedViaOffers_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s13, day13);
    }

    //...................................................................................................
    @Test(priority = 160)
    public void Compare_InterestedWorkshopToCheck_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s14, day14);
    }

    //...................................................................................................
    @Test(priority = 161)
    public void Compare_AdhocAppointment_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s15, day15);
        Thread.sleep(5000);
    }
//...................................................................................................	


}
