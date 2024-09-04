package mergeSMR;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Website_Lead_Report {
    public static WebDriver driver;
    public WebDriverWait wait;

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

    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        Thread.sleep(5000);
        this.driver = UserList_SMR_Report.driver;

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

    // ..............................................................................................................
    @Test(priority = 6)
    public void Click_On_Website_lead_Report() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Cross = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Website Lead Report \"]")));
        Cross.click();
        Thread.sleep(3000);

    }

    @SuppressWarnings("unused")
    @Test(priority = 7)
    public void Zone_Region_Wise() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the calendar to open date picker
        WebElement select = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
        select.click();
        Thread.sleep(4000);

        // Select start date (1st of the current month)
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

        WebElement selectStart = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
        selectStart.click();
        Thread.sleep(2000);

        // Select today's date
        WebElement selectToday = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
        selectToday.click();
        Thread.sleep(2000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(35000);

        // Try to locate the Totalleads_recived element
        WebElement Lead_Generated;
        try {
            Lead_Generated = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[2]"));

            // Check if Totalleads_recived element is displayed
            if (!Lead_Generated.isDisplayed()) {
                Assert.fail(
                        "No Data Found in Zone Region Wise: Lead generated element element is not visible on the page In website Lead Report.");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("No Data Found in Zone Region Wise: Lead generated element element could not be found In website Lead Report : "
                    + e.getMessage());
            return; // Exit the test if the element is not found
        }

        // Check if Totalleads_recived is enabled
        if (!Lead_Generated.isEnabled()) {
            Assert.fail("Lead generated element is not enabled In website Lead Report ");
        }

        // Proceed with the rest of your element locators and text retrievals
        WebElement Lead_attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[3]"));
        WebElement Total_connected = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[4]"));
        WebElement followup = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[5]"));
        WebElement appointment_booked = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[6]"));
        WebElement appointment_booked_percent = driver
                .findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[7]"));
        WebElement Total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[8]"));
        WebElement Total_Reported_PERCENT = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[9]"));
        WebElement Reported_At_OWN = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[10]"));
        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[11]"));
        WebElement Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[12]"));
        WebElement Not_Attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[13]"));

        Thread.sleep(4000);

        z1 = Lead_Generated.getText();
        System.out.println("Lead_generated of Zone and region wise In website Lead Report ::" + z1);

        z2 = Lead_attempted.getText();
        z3 = Total_connected.getText();
        z4 = followup.getText();
        z5 = appointment_booked.getText();
        z6 = appointment_booked_percent.getText();
        z7 = Total_reported.getText();
        z8 = Total_Reported_PERCENT.getText();
        z9 = Reported_At_OWN.getText();
        z10 = Reported_At_Other.getText();
        z11 = Not_Connected.getText();
        z12 = Not_Attempted.getText();

        Thread.sleep(5000);

        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(z1);

            if (totalDueValue == null) {

                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Zone_Region_wise_Wise  Lead Generated   In website Lead Report :: " + z1);
            } else {
                // Print the Total Due value
                // System.out.println("Total Due value of Zone_region_Wise::: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone_Region_Wise of Lead Generated   In website Lead Report : " + e.getMessage());
        }
    }

    // ...............................................................................................
    @Test(priority = 8)
    public void Dealer_Parent_Group_Wise() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement Dealer_Parent_Group_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
        Dealer_Parent_Group_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(23000);

        // Check if Items per page can be set to 100
        try {
            WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-3\"]"));
            Items_Per_page.click();
            Thread.sleep(2000);

            WebElement click_On_Hundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
            click_On_Hundred.click();
            Thread.sleep(3000);
        } catch (NoSuchElementException e) {
            System.out.println("Pagination is disabled or less than 100 items are available.");
        }

        boolean paginationExists = false;

        // Check for the pagination button and click if available
        try {
            WebElement click_On_pagination = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[4]"));
            paginationExists = click_On_pagination.isDisplayed();

            if (paginationExists) {
                click_On_pagination.click();
                Thread.sleep(2000);
            } else {
                System.out.println("Pagination is not enabled.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Pagination element not found, stopping pagination.");
        }

        // Proceed with the rest of your element locators and text retrievals
        WebElement Lead_Generated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement Lead_attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement Total_connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement followup = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement appointment_booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement appointment_booked_percent = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement Total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement Total_Reported_PERCENT = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement Reported_At_OWN = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
        WebElement Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
        WebElement Not_Attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));

        Thread.sleep(2000);

        if (Lead_Generated.isDisplayed()) {
            d1 = Lead_Generated.getText();
            System.out.println("Dealer_Parent_Group_Wise In website Lead Report ::" + d1);
        } else {
            Assert.fail("no data found for Dealer_Parent_Group_Wise   In website Lead Report  ");
        }

        d2 = Lead_attempted.getText();
        d3 = Total_connected.getText();
        d4 = followup.getText();
        d5 = appointment_booked.getText();
        d6 = appointment_booked_percent.getText();
        d7 = Total_reported.getText();
        d8 = Total_Reported_PERCENT.getText();
        d9 = Reported_At_OWN.getText();
        d10 = Reported_At_Other.getText();
        d11 = Not_Connected.getText();
        d12 = Not_Attempted.getText();

        Thread.sleep(5000);

        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(d1);

            if (totalDueValue <= 0) {

                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Dealer_parent_Group_Wise  Lead Generated   In website Lead Report:: " + d1);
            } else {
                // Print the Total Due value
                // System.out.println("Total Due value of Zone_region_Wise::: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer_parent_Group_Wise of Lead Generated  In website Lead Report: " + e.getMessage());
        }
    }

    // ...............................................................................................
    @Test(priority = 9)
    public void workshop_Wise() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement WorkShop_Wise = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        WorkShop_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(20000);

        // Check if Items per page can be set to 100
        try {
            WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-5\"]"));
            Items_Per_page.click();


            WebElement click_On_Hundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
            click_On_Hundred.click();
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            System.out.println("Pagination is disabled or less than 100 items are available.");
        }

        boolean paginationExists = false;

        // Check for the pagination button and click if available
        try {
            WebElement click_On_pagination = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[6]"));
            paginationExists = click_On_pagination.isDisplayed();

            if (paginationExists) {
                click_On_pagination.click();
                Thread.sleep(3000);
            } else {
                System.out.println("Pagination is not enabled.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Pagination element not found, stopping pagination.");
        }

        // Proceed with the rest of your element locators and text retrievals
        WebElement Lead_Generated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement Lead_attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement Total_connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement followup = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement appointment_booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement appointment_booked_percent = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement Total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement Total_Reported_PERCENT = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement Reported_At_OWN = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));
        WebElement Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[13]"));
        WebElement Not_Attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));

        Thread.sleep(2000);

        if (Lead_Generated.isDisplayed()) {
            w1 = Lead_Generated.getText();
            System.out.println("Lead_Generated of Workshop_Wise In website Lead Report ::" + w1);
        } else {
            Assert.fail("no data found for Workshop_Wise  In website Lead Report");
        }

        w2 = Lead_attempted.getText();
        w3 = Total_connected.getText();
        w4 = followup.getText();
        w5 = appointment_booked.getText();
        w6 = appointment_booked_percent.getText();
        w7 = Total_reported.getText();
        w8 = Total_Reported_PERCENT.getText();
        w9 = Reported_At_OWN.getText();
        w10 = Reported_At_Other.getText();
        w11 = Not_Connected.getText();
        w12 = Not_Attempted.getText();

        Thread.sleep(5000);

        try {

            // Parse the Total Disposition value to a numeric type
            Integer value = Integer.parseInt(w1);

            if (value <= 0 || w1 == null) {
                // Fail the test if Total Disposition value is 0 or less
                Assert.fail("No Data Found for Workshop_Wise     In website Lead Report : " + w1);
            } else {
                // Print the Total Disposition value
                // System.out.println("'Total Dispositions' column value of Dealer Parent Group
                // Wise Tab is::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Workshop_Wise Tab    In website Lead Report " + e.getMessage());
        }
    }

    // ...............................................................................................
    @Test(priority = 10)
    public void Day_Wise() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);


        Thread.sleep(20000);

        // Check if Items per page can be set to 100
        try {
            WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-7\"]"));
            Items_Per_page.click();


            WebElement click_On_Hundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
            click_On_Hundred.click();

        } catch (NoSuchElementException e) {
            System.out.println("Pagination is disabled or less than 100 items are available.");
        }

        boolean paginationExists = false;

        // Check for the pagination button and click if available
        try {
            WebElement click_On_pagination = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[8]"));
            paginationExists = click_On_pagination.isDisplayed();

            if (paginationExists) {
                click_On_pagination.click();
                Thread.sleep(2000);
            } else {
                System.out.println("Pagination is not enabled.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Pagination element not found, stopping pagination.");
        }

        // Proceed with the rest of your element locators and text retrievals
        WebElement Lead_Generated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
        WebElement Lead_attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement Total_connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement followup = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement appointment_booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
        WebElement appointment_booked_percent = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement Total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement Total_Reported_PERCENT = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));
        WebElement Reported_At_OWN = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[10]"));
        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[11]"));
        WebElement Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[12]"));
        WebElement Not_Attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[13]"));

        Thread.sleep(2000);

        if (Lead_Generated.isDisplayed()) {
            day1 = Lead_Generated.getText();
            System.out.println("Lead_Generated of Day_Wise In website Lead Report::" + day1);
        } else {
            Assert.fail("no data found for Day_Wise  In website Lead Report");
        }

        day2 = Lead_attempted.getText();
        day3 = Total_connected.getText();
        day4 = followup.getText();
        day5 = appointment_booked.getText();
        day6 = appointment_booked_percent.getText();
        day7 = Total_reported.getText();
        day8 = Total_Reported_PERCENT.getText();
        day9 = Reported_At_OWN.getText();
        day10 = Reported_At_Other.getText();
        day11 = Not_Connected.getText();
        day12 = Not_Attempted.getText();

        Thread.sleep(5000);

        try {

            // Parse the Total Disposition value to a numeric type
            Integer value = Integer.parseInt(day1);

            if (value <= 0) {
                // Fail the test if Total Disposition value is 0 or less
                Assert.fail("No Data Found for Day_Wise In website Lead Report : " + day1);
            } else {
                // System.out.println("'Total Dispositions' column value of Dealer Parent Group
                // Wise Tab is::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day_Wise Tab In website Lead Report " + e.getMessage());
        }
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 12)
    public void Compare_Lead_Generated_Of_ZONE_Region_Wise_from__Dealer_Parent_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z1, d1);
    }

    // ..............................................................................................
    @Test(priority = 13)
    public void Compare_Lead_Generated_Of_ZONE_Region_Wise_from_Worshop_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z1, w1);
    }

    // ..............................................................................................
    @Test(priority = 14)
    public void Compare_Lead_Generated_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z1, day1);
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test(priority = 16)
    public void Compare_Lead_attempted_Of_ZONE_Region_Wise_from_Dealer_parent_group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z2, d2);
    }

    // ..............................................................................................
    @Test(priority = 17)
    public void Compare_Lead_attempted_dispostion_Of_ZONE_Region_Wise_from_workshop__Wise()
            throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z2, w2);
    }

    // ..............................................................................................
    @Test(priority = 18)
    public void Compare_Lead_attempted_dispostion_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z2, day2);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 20)
    public void Compare_Total_connected_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise()
            throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z3, d3);
    }

    // ..............................................................................................
    @Test(priority = 21)
    public void Compare_Total_connected_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z3, w3);
    }

    // ..............................................................................................
    @Test(priority = 22)
    public void Compare_Total_connected_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z3, day3);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 24)
    public void Compare_followUP_dispostion_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise()
            throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z4, d4);
    }

    // ..............................................................................................
    @Test(priority = 25)
    public void Compare_followUP_dispostion_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z4, w4);
    }

    // ..............................................................................................
    @Test(priority = 26)
    public void Compare_followUP_dispostion_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z4, day4);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 28)
    public void Compare_Appointment_Booked_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise()
            throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z5, d5);
    }

    // ..............................................................................................
    @Test(priority = 29)
    public void Compare_Appointment_Booked_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z5, w5);
    }

    // ..............................................................................................
    @Test(priority = 30)
    public void Compare_Appointment_Booked_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z5, day5);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 32)
    public void Compare_Appointment_Booked_Percent_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise()
            throws InterruptedException {
        Thread.sleep(1000);
        String normalizedZ10 = z6.trim().replace(" ", "");
        String normalizedW10 = d6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    // ..............................................................................................
    @Test(priority = 33)
    public void Compare_Appointment_Booked_Percent_Of_ZONE_Region_Wise_from_workshop__Wise()
            throws InterruptedException {
        Thread.sleep(1000);
        String normalizedZ10 = z6.trim().replace(" ", "");
        String normalizedW10 = w6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    // ..............................................................................................
    @Test(priority = 34)
    public void Compare_Appointment_Booked_Percent_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        String normalizedZ10 = z6.trim().replace(" ", "");
        String normalizedW10 = day6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 36)
    public void Compare_Total_Reported_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z7, d7);
    }

    // ..............................................................................................
    @Test(priority = 37)
    public void Compare_Total_Reported_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z7, w7);
    }

    // ..............................................................................................
    @Test(priority = 38)
    public void Compare_Total_Reported_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z7, day7);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 40)
    public void Compare_Total_Reported_Percent_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise()
            throws InterruptedException {
        Thread.sleep(1000);

        String normalizedZ10 = z8.trim().replace(" ", "");
        String normalizedW10 = d8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    // ..............................................................................................
    @Test(priority = 41)
    public void Compare_Total_Reported_Percent_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        String normalizedZ10 = z8.trim().replace(" ", "");
        String normalizedW10 = w8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    // ..............................................................................................
    @Test(priority = 42)
    public void Compare_Total_Reported_Percent_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        String normalizedZ10 = z8.trim().replace(" ", "");
        String normalizedW10 = day8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 44)
    public void Compare_Reported_at_OWN_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise()
            throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z9, d9);
    }

    // ..............................................................................................
    @Test(priority = 45)
    public void Compare_Reported_at_OWN_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z9, w9);
    }

    // ..............................................................................................
    @Test(priority = 46)
    public void Compare_Reported_at_OWN_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z9, day9);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 48)
    public void Compare_Reported_at_Other_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise()
            throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z10, d10);
    }

    // ..............................................................................................
    @Test(priority = 49)
    public void Compare_Reported_at_Other_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z10, w10);
    }

    // ..............................................................................................
    @Test(priority = 50)
    public void Compare_Reported_at_Other_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z10, day10);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test(priority = 52)
    public void Compare_Not_Connected_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z11, d11);
    }

    // ..............................................................................................
    @Test(priority = 53)
    public void Compare_Not_Connected_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z11, w11);
    }

    // ..............................................................................................
    @Test(priority = 54)
    public void Compare_Not_Connected_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z11, day11);
    }

    // .>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 56)
    public void Compare_Not_Attempted_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z12, d12);
    }

    // ..............................................................................................
    @Test(priority = 57)
    public void Compare_Not_Attempted_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z12, w12);
    }

    // ..............................................................................................
    @Test(priority = 58)
    public void Compare_Not_Attempted_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z12, day12);
    }
}
