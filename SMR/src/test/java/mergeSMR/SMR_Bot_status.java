package mergeSMR;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class SMR_Bot_status {
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
    String z13;
    String z14;
    String z15;
    String z16;
    String z17;
    String z18;
    String z19;
    String z20;
    String z21;

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
    String d16;
    String d17;
    String d18;
    String d19;
    String d20;
    String d21;

    String w;
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
    String w16;
    String w17;
    String w18;
    String w19;
    String w20;
    String w21;

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
    String day16;
    String day17;
    String day18;
    String day19;
    String day20;
    String day21;

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
    String s16;
    String s17;
    String s18;
    String s19;
    String s20;
    String s21;


    @SuppressWarnings("static-access")
    @BeforeClass
    public void down() throws InterruptedException {

        this.driver = SMR_Due_Date_Wise.driver;
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
    @Test(priority = 6)
    public void Click_SMR_Bot_Status() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SMR = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"SMR Bot Status \"]")));
        SMR.click();
        Thread.sleep(3000);

    }

    //.........................................................................................................

    @Test(priority = 7)
    public void Zone_Region_Wise() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the calendar to open date picker
        WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
        select.click();
        Thread.sleep(4000);

        // Select start date (1st of the current month)
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");  // Example format

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

        Thread.sleep(35000);

        // Try to locate the Totalleads_recived element
        WebElement Totalleads_recived;
        try {
            Totalleads_recived = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[2]"));

            // Check if Totalleads_recived element is displayed
            if (!Totalleads_recived.isDisplayed()) {
                Assert.fail("No Data Found in Zone Region Wise in SMR BOOT status:  : Totalleads_recived element is not visible on the page.");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("No Data Found in Zone Region Wise in SMR BOOT status: Totalleads_recived element could not be found: " + e.getMessage());
            return; // Exit the test if the element is not found
        }

        // Check if Totalleads_recived is enabled
        if (!Totalleads_recived.isEnabled()) {
            Assert.fail("Totalleads_recived element is not enabled  in SMR BOOT status report:");
        }

        // Proceed with the rest of your element locators and text retrievals
        WebElement total_Booking = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[3]"));
        WebElement total_reported = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[4]"));
        WebElement totallead = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[5]"));
        WebElement fresh = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[6]"));
        WebElement pending = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[7]"));
        WebElement followUP = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[8]"));
        WebElement appointment_Booked = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[9]"));
        WebElement reported = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[10]"));
        WebElement reported_at_Own = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[11]"));
        WebElement reported_at_Other = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[12]"));
        WebElement lost = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[13]"));
        WebElement totalLeads = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[14]"));
        WebElement fresh2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[15]"));
        WebElement pending2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[16]"));
        WebElement follow_UP2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[17]"));
        WebElement appointment_Booked2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[18]"));
        WebElement reported2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[19]"));
        WebElement losreported_at_Own2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[20]"));
        WebElement reported_at_Other2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[21]"));
        WebElement lost2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[22]"));

        Thread.sleep(4000);

        // Get the values
        z1 = Totalleads_recived.getText();
        System.out.println("Total leads recieved of Zone and region wise in SMR BOOT status: ::" + z1);

        z2 = total_Booking.getText();
        z3 = total_reported.getText();
        z4 = totallead.getText();
        z5 = fresh.getText();
        z6 = pending.getText();
        z7 = followUP.getText();
        z8 = appointment_Booked.getText();
        z9 = reported.getText();
        z10 = reported_at_Own.getText();
        z11 = reported_at_Other.getText();
        z12 = lost.getText();
        z13 = totalLeads.getText();
        z14 = fresh2.getText();
        z15 = pending2.getText();
        z16 = follow_UP2.getText();
        z17 = appointment_Booked2.getText();
        z18 = reported2.getText();
        z19 = losreported_at_Own2.getText();
        z20 = reported_at_Other2.getText();
        z21 = lost2.getText();
        Thread.sleep(5000);

        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(z1);

            if (totalDueValue <= 0 || totalDueValue == null) {

                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Dealer_Parent_Group_Wise  in SMR BOOT status: : " + z1);
            } else {
                // Print the Total Due value
                //   System.out.println("Total Due value of Zone_region_Wise::: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone_Region_Wise  in SMR BOOT status: : " + e.getMessage());
        }
    }


    //...............................................................................................
    @Test(priority = 8)
    public void Dealer_Parent_Group_Wise() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Dealer_Parent_Group_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
        Dealer_Parent_Group_Wise.click();
        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(35000);
        // scroll down .........................................
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //.............................................................
        // scroll right side

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll right by 500 pixels
        js.executeScript("window.scrollBy(500,0)");
        //..........................................................................
        Thread.sleep(3000);
        // Check if Items per page can be set to 100
        try {
            WebElement Items_Per_page = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[2]"));
            if (Items_Per_page.isDisplayed()) {
                Items_Per_page.click();
                Thread.sleep(2000);

                WebElement click_On_Hundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
                click_On_Hundred.click();
                Thread.sleep(3000);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Pagination is disabled or less than 100 items are available.");
        }


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


        // Proceed with the rest of your element locators and text retrievals
        WebElement Totalleads_recived1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

        // Check if Total_Disposition element is displayed and not null
        if (Totalleads_recived1 != null && Totalleads_recived1.isDisplayed()) {
            d1 = Totalleads_recived1.getText();
            System.out.println("Total leads_recived of Dealer_Parent_Group_Wise in SMR BOT status ::" + d1);
        } else {
            Assert.fail("No data found for Dealer Parent Group Wise  of SMR Bot Status");
        }

        //Elements of Dealer Parent Wise
        WebElement total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement totallead = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement pending = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement followUP = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement reported_at_Own = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
        WebElement reported_at_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
        WebElement lost = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
        WebElement totalLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
        WebElement fresh2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));

        WebElement pending2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
        WebElement follow_UP2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
        WebElement appointment_Booked2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
        WebElement reported2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
        WebElement losreported_at_Own2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));
        WebElement reported_at_Other2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[21]"));
        WebElement lost2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[22]"));

        Thread.sleep(4000);

        if (Totalleads_recived1.isDisplayed()) {
            d1 = Totalleads_recived1.getText();
            //  System.out.println("Total leads recived in Dealer_Parent_Group_Wise ::" + d1);
        } else {
            Assert.fail("no data found for Dealer_Parent_Group_Wise of SMR Boot Status");
        }
        d1 = Totalleads_recived1.getText();
        d2 = total_Booking.getText();
        d3 = total_reported.getText();
        d4 = totallead.getText();
        d5 = fresh.getText();
        d6 = pending.getText();
        d7 = followUP.getText();
        d8 = appointment_Booked.getText();
        d9 = reported.getText();
        d10 = reported_at_Own.getText();
        d11 = reported_at_Other.getText();
        d12 = lost.getText();
        d13 = totalLeads.getText();
        d14 = fresh2.getText();

        d15 = pending2.getText();
        d16 = follow_UP2.getText();
        d17 = appointment_Booked2.getText();
        d18 = reported2.getText();
        d19 = losreported_at_Own2.getText();
        d20 = reported_at_Other2.getText();
        d21 = lost2.getText();
        Thread.sleep(5000);


        try {

            // Parse the Total Disposition value to a numeric type
            Integer value = Integer.parseInt(d1);

            if (value <= 0 || d1 == null) {
                // Fail the test if Total Disposition value is 0 or less
                Assert.fail("No Data Found for Dealer Parent Group Wise  of SMR Boot status: " + d1);
            } else {
                // Print the Total Disposition value
                // System.out.println("'Total Dispositions' column value of Dealer Parent Group Wise Tab is::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer Parent Group Wise  of SMR Boot status: " + e.getMessage());
        }
    }

    //...................................................................................................
    //...............................................................................................
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
        WebElement Totalleads_recived1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement totallead = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement pending = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement followUP = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement reported_at_Own = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));
        WebElement reported_at_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));
        WebElement lost = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[15]"));
        WebElement totalLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[16]"));
        WebElement fresh2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[17]"));
        WebElement pending2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[18]"));
        WebElement follow_UP2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[19]"));
        WebElement appointment_Booked2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[20]"));
        WebElement reported2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[21]"));
        WebElement losreported_at_Own2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[22]"));
        WebElement reported_at_Other2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[24]"));
        WebElement lost2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[25]"));

        Thread.sleep(4000);

        w1 = Totalleads_recived1.getText();
        w2 = total_Booking.getText();
        w3 = total_reported.getText();
        w4 = totallead.getText();
        w5 = fresh.getText();
        w6 = pending.getText();
        w7 = followUP.getText();
        w8 = appointment_Booked.getText();
        w9 = reported.getText();
        w10 = reported_at_Own.getText();
        w11 = reported_at_Other.getText();
        w12 = lost.getText();
        w13 = totalLeads.getText();
        w14 = fresh2.getText();
        w15 = pending2.getText();
        w16 = follow_UP2.getText();
        w17 = appointment_Booked2.getText();
        w18 = reported2.getText();
        w19 = losreported_at_Own2.getText();
        w20 = reported_at_Other2.getText();
        w21 = lost2.getText();
        Thread.sleep(5000);

        try {
            // Find the attribute value of Totalleads_recived1

            // Parse the Totalleads_recived1 value to a numeric type
            double Totalleads_recived = Double.parseDouble(w1);

            if (Totalleads_recived <= 0 || w1 == null) {
                // Fail the test if Totalleads_recived1 value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise  in SMR BOOT status report : " + w1);
            } else {
                // Print the Totalleads_recived1 value
                System.out.println("'Total leads recieved' column value of WorkShop Wise Tab in SMR BOOT status report::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop Wise Tab in SMR BOOT status report " + e.getMessage());
        }
    }


    //...............................................................................................
    @Test(priority = 10)
    public void Day_Wise() throws InterruptedException {
        Thread.sleep(7000);
        try {
            // Wait for the "Workshop Wise" button to be present and click it
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
            Day_Wise.click();
            Thread.sleep(3000);

            // Click on the generate report button
            WebElement generateReportButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
            generateReportButton.click();

            Thread.sleep(17000);

            // Attempt to set items per page to 100
            try {
                WebElement itemsPerPageDropdown = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
                itemsPerPageDropdown.click();
                Thread.sleep(2000);

                WebElement selectHundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
                selectHundred.click();
                Thread.sleep(3000);
            } catch (NoSuchElementException e) {
                System.out.println("Pagination is disabled or less than 100 items are available.");
            }

            // Check for pagination and handle if available
            try {
                WebElement paginationButton = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[8]"));
                if (paginationButton.isDisplayed()) {
                    paginationButton.click();
                    Thread.sleep(3000);
                } else {
                    System.out.println("Pagination is not enabled.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Pagination element not found, stopping pagination.");
            }

            WebElement Totalleads_recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));

            WebElement total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
            WebElement total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
            WebElement totallead = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
            WebElement fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
            WebElement pending = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
            WebElement followUP = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
            WebElement appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));
            WebElement reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[10]"));
            WebElement reported_at_Own = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[11]"));
            WebElement reported_at_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[13]"));
            WebElement lost = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[14]"));
            WebElement totalLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[15]"));
            WebElement fresh2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[16]"));

            WebElement pending2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[17]"));
            WebElement follow_UP2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[18]"));
            WebElement appointment_Booked2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[19]"));
            WebElement reported2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[20]"));
            WebElement losreported_at_Own2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[21]"));
            WebElement reported_at_Other2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[23]"));
            WebElement lost2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[24]"));


            Thread.sleep(4000);
            // Verify that the Total leads received element is displayed
            if (Totalleads_recived.isDisplayed()) {
                String totalLeadsReceivedText = Totalleads_recived.getText();
                System.out.println("Total leads received in Day wise in SMR BOOT status report : " + totalLeadsReceivedText);
            } else {
                Assert.fail("No data found for Day wise in SMR BOOT status report ");
            }

            day1 = Totalleads_recived.getText();
            day2 = total_Booking.getText();
            day3 = total_reported.getText();
            day4 = totallead.getText();
            day5 = fresh.getText();
            day6 = pending.getText();
            day7 = followUP.getText();
            day8 = appointment_Booked.getText();
            day9 = reported.getText();
            day10 = reported_at_Own.getText();
            day11 = reported_at_Other.getText();
            day12 = lost.getText();
            day13 = totalLeads.getText();
            day14 = fresh2.getText();

            day15 = pending2.getText();
            day16 = follow_UP2.getText();
            day17 = appointment_Booked2.getText();
            day18 = reported2.getText();
            day19 = losreported_at_Own2.getText();
            day20 = reported_at_Other2.getText();
            day21 = lost2.getText();
            Thread.sleep(5000);


            // Parse and validate the Total Disposition value
            Integer totalDispositionValue = Integer.parseInt(day1);
            if (totalDispositionValue <= 0 || day1 == null) {
                Assert.fail("No Data Found for Workshop Wise   in SMR BOOT status report : " + day1);
            } else {
                //   System.out.println("'Total Dispositions' column value of Workshop Wise Tab is: " + day1);
            }

        } catch (Exception e) {
            Assert.fail("No Data Found for Workshop Wise Tab in SMR BOOT status report  : " + e.getMessage());
        }
    }

    //...............................................................................................
    @Test(priority = 11)
    public void Service_Type_Wise() throws InterruptedException {
        Thread.sleep(7000);
        try {
            // Wait for the "Workshop Wise" button to be present and click it
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement Service_Type_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
            Service_Type_Wise.click();
            Thread.sleep(3000);

            // Click on the generate report button
            WebElement generateReportButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
            generateReportButton.click();

            Thread.sleep(30000);

            // Attempt to set items per page to 100
            try {
                WebElement itemsPerPageDropdown = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));
                itemsPerPageDropdown.click();
                Thread.sleep(2000);

                WebElement selectHundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
                selectHundred.click();
                Thread.sleep(3000);
            } catch (NoSuchElementException e) {
                System.out.println("Pagination is disabled or less than 100 items are available.");
            }

            // Check for pagination and handle if available
            try {
                WebElement paginationButton = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[10]"));
                if (paginationButton.isDisplayed()) {
                    paginationButton.click();
                    Thread.sleep(3000);
                } else {
                    System.out.println("Pagination is not enabled.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Pagination element not found, stopping pagination.");
            }

            //........................................................................................................................
            WebElement Totalleads_recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[2]"));

            WebElement total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
            WebElement total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
            WebElement totallead = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
            WebElement fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));
            WebElement pending = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
            WebElement followUP = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
            WebElement appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));
            WebElement reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[10]"));
            WebElement reported_at_Own = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[11]"));
            WebElement reported_at_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[13]"));
            WebElement lost = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[14]"));
            WebElement totalLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[15]"));
            WebElement fresh2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[16]"));

            WebElement pending2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[17]"));
            WebElement follow_UP2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[18]"));
            WebElement appointment_Booked2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[19]"));
            WebElement reported2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[20]"));
            WebElement losreported_at_Own2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[21]"));
            WebElement reported_at_Other2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[23]"));
            WebElement lost2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[24]"));
            Thread.sleep(4000);

            // Verify that the Total leads received element is displayed
            if (Totalleads_recived.isDisplayed()) {
                String totalLeadsReceivedText = Totalleads_recived.getText();
                System.out.println("Total leads received in Service_type Wise in SMR BOOT status report : " + totalLeadsReceivedText);
            } else {
                Assert.fail("No data found for Service_type Wise in SMR BOOT status report ");
            }
            // Get the values
            s1 = Totalleads_recived.getText();

            s2 = total_Booking.getText();
            s3 = total_reported.getText();
            s4 = totallead.getText();
            s5 = fresh.getText();
            s6 = pending.getText();
            s7 = followUP.getText();
            s8 = appointment_Booked.getText();
            s9 = reported.getText();
            s10 = reported_at_Own.getText();
            s11 = reported_at_Other.getText();
            s12 = lost.getText();
            s13 = totalLeads.getText();
            s14 = fresh2.getText();

            s15 = pending2.getText();
            s16 = follow_UP2.getText();
            s17 = appointment_Booked2.getText();
            s18 = reported2.getText();
            s19 = losreported_at_Own2.getText();
            s20 = reported_at_Other2.getText();
            s21 = lost2.getText();
            Thread.sleep(5000);


            // Parse and validate the Total Disposition value
            Integer totalDispositionValue = Integer.parseInt(s1);
            if (totalDispositionValue <= 0 || s1 == null) {
                Assert.fail("No Data Found for Service_type  Wise in SMR BOOT status report : " + s1);
            } else {
                // System.out.println("'Total Dispositions' column value of Service_type Wise Tab is: " + s1);
            }

        } catch (Exception e) {
            Assert.fail("No Data Found for ServiceType Wise Tab in SMR BOOT status report : " + e.getMessage());
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 12)
    public void Compare_Total_Leads_of_ZONE_and_Region_with_Dealer_Parent_Group_Wise() throws InterruptedException {

        Assert.assertEquals(z1, d1);
    }

    //..................................................................................
    @Test(priority = 13)
    public void Compare_Total_Leads_of_ZONE_and_Region_with_WorkShop_Wise() throws InterruptedException {

        Assert.assertEquals(z1, w);
    }

    //..................................................................................
    @Test(priority = 14)
    public void Compare_Total_Leads_of_ZONE_and_Region_with_Day_Wise() throws InterruptedException {

        Assert.assertEquals(z1, day1);
    }

    //..................................................................................
    @Test(priority = 15)
    public void Compare_Total_Leads_of_ZONE_and_Region_with_Service_type_Wise() throws InterruptedException {

        Assert.assertEquals(z1, s1);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 16)
    public void Compare_Total_booking_of_ZONE_and_Region_with_Dealer_Parent_Group_Wise() throws InterruptedException {

        Assert.assertEquals(z2, d2);
    }

    //..................................................................................
    @Test(priority = 17)
    public void Compare_Total_booking_of_ZONE_and_Region_with_WorkShop_Wise() throws InterruptedException {

        Assert.assertEquals(z2, w1);
    }

    //..................................................................................
    @Test(priority = 18)
    public void Compare_Total_booking_of_ZONE_and_Region_with_Day_Wise() throws InterruptedException {

        Assert.assertEquals(z2, day2);
    }

    //..................................................................................
    @Test(priority = 19)
    public void Compare_Total_booking_of_ZONE_and_Region_with_Service_type_wise() throws InterruptedException {

        Assert.assertEquals(z2, s2);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 20)
    public void Compare_Total_reported_of_ZONE_and_Region_with_Dealer_parent_group_wise() throws InterruptedException {

        Assert.assertEquals(z3, d3);
    }
    //............................................................................

    @Test(priority = 20)
    public void Compare_Total_reported_of_ZONE_and_Region_with_workshopwise_wise() throws InterruptedException {

        Assert.assertEquals(z3, w2);
    }
    //............................................................................

    @Test(priority = 21)
    public void Compare_Total_reported_of_ZONE_and_Region_with_Day_wise() throws InterruptedException {

        Assert.assertEquals(z3, day3);
    }
    //............................................................................

    @Test(priority = 22)
    public void Compare_Total_reported_of_ZONE_and_Region_with_service_type__wise() throws InterruptedException {

        Assert.assertEquals(z3, s3);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test(priority = 23)
    public void Compare_Total_LEADS_of_ZONE_and_Region_with_Dealer_parent_group_wise() throws InterruptedException {

        Assert.assertEquals(z4, d4);
    }
    //............................................................................

    @Test(priority = 24)
    public void Compare_Total_LEADS_of_ZONE_and_Region_with_Workshop_wise() throws InterruptedException {

        Assert.assertEquals(z4, w3);
    }
    //............................................................................

    @Test(priority = 25)
    public void Compare_Total_LEADS_of_ZONE_and_Region_with_Day_wise() throws InterruptedException {

        Assert.assertEquals(z4, day4);
    }
    //............................................................................

    @Test(priority = 25)
    public void Compare_Total_LEADS_of_ZONE_and_Region_with_service_type_wise() throws InterruptedException {

        Assert.assertEquals(z4, s4);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 26)
    public void Compare_Fresh_of_ZONE_and_Region_with_Dealer_parent_group_wise() throws InterruptedException {

        Assert.assertEquals(z5, d5);
    }
    //............................................................................

    @Test(priority = 27)
    public void Compare_Fresh_of_ZONE_and_Region_with_Worshop_wise() throws InterruptedException {

        Assert.assertEquals(z5, w4);
    }
    //............................................................................

    @Test(priority = 28)
    public void Compare_Fresh_of_ZONE_and_Region_with_Day_wise() throws InterruptedException {

        Assert.assertEquals(z5, day5);
    }
    //............................................................................

    @Test(priority = 29)
    public void Compare_Fresh_of_ZONE_and_Region_with_service_type_wise() throws InterruptedException {

        Assert.assertEquals(z5, s5);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test(priority = 30)
    public void Compare_PENDING_of_ZONE_and_Region_with_Dealer_parent_Group_wise() throws InterruptedException {

        Assert.assertEquals(z6, d6);
    }

    //.......................................................................................
    @Test(priority = 31)
    public void Compare_PENDING_of_ZONE_and_Region_with_Workshop_wise() throws InterruptedException {

        Assert.assertEquals(z6, w5);
    }

    //.......................................................................................
    @Test(priority = 32)
    public void Compare_PENDING_of_ZONE_and_Region_with_Day_wise() throws InterruptedException {

        Assert.assertEquals(z6, day6);
    }

    //.......................................................................................
    @Test(priority = 33)
    public void Compare_PENDING_of_ZONE_and_Region_with_Service_type_wise() throws InterruptedException {

        Assert.assertEquals(z6, s6);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test(priority = 33)
    public void Compare_FollowUP_of_ZONE_and_Region_with_Dealer_parent_group_wise() throws InterruptedException {

        Assert.assertEquals(z7, d7);
    }

    //.......................................................................................
    @Test(priority = 34)
    public void Compare_FollowUP_of_ZONE_and_Region_with_Workshop_wise() throws InterruptedException {

        Assert.assertEquals(z7, w6);
    }

    //.......................................................................................
    @Test(priority = 35)
    public void Compare_FollowUP_of_ZONE_and_Region_with_Day_wise() throws InterruptedException {

        Assert.assertEquals(z7, day7);
    }

    //.......................................................................................
    @Test(priority = 36)
    public void Compare_FollowUP_of_ZONE_and_Region_with_Service_type_wise() throws InterruptedException {

        Assert.assertEquals(z7, s7);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
    @Test(priority = 37)
    public void Compare_Appointment_booked_of_ZONE_and_Region_with_Dealer_parent_group_wise() throws InterruptedException {

        Assert.assertEquals(z8, d8);
    }

    //...........................................................................................
    @Test(priority = 38)
    public void Compare_Appointment_booked_of_ZONE_and_Region_with_workshop_wise() throws InterruptedException {

        Assert.assertEquals(z8, w7);
    }

    //...........................................................................................
    @Test(priority = 39)
    public void Compare_Appointment_booked_of_ZONE_and_Region_with_Day_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z8, day8);
    }

    //...........................................................................................
    @Test(priority = 40)
    public void Compare_Appointment_booked_of_ZONE_and_Region_with_service_type_wise() throws InterruptedException {

        Assert.assertEquals(z8, s8);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test(priority = 41)
    public void Compare_Reported_at_OWN_of_ZONE_and_Region_with_Dealer_Parent_Group_Wise() throws InterruptedException {

        Assert.assertEquals(z19, d19);
    }

    //..................................................................................
    @Test(priority = 42)
    public void Compare_Reported_at_OWN_of_ZONE_and_Region_with_WorkshoP_Wise() throws InterruptedException {

        Assert.assertEquals(z19, w18);
    }

    //..................................................................................
    @Test(priority = 43)
    public void Compare_Reported_at_OWN_of_ZONE_and_Region_with_Day_Wise() throws InterruptedException {

        Assert.assertEquals(z19, day19);
    }

    //..................................................................................
    @Test(priority = 44)
    public void Compare_Reported_at_OWN_of_ZONE_and_Region_with_service_type_Wise() throws InterruptedException {

        Assert.assertEquals(z19, s19);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //..................................................................................
    @Test(priority = 45)
    public void Compare_Reported_at_Other_of_ZONE_and_Region_with_Dealer_parent_group_Wise() throws InterruptedException {

        Assert.assertEquals(z20, d20);
    }

    //..................................................................................
    @Test(priority = 46)
    public void Compare_Reported_at_Other_of_ZONE_and_Region_with_Workshop_Wise() throws InterruptedException {

        Assert.assertEquals(z20, w19);
    }

    //..................................................................................
    @Test(priority = 47)
    public void Compare_Reported_at_Other_of_ZONE_and_Region_with_Day_Wise() throws InterruptedException {

        Assert.assertEquals(z20, day20);
    }

    //..................................................................................
    @Test(priority = 48)
    public void Compare_Reported_at_Other_of_ZONE_and_Region_with_service_type_Wise() throws InterruptedException {

        Assert.assertEquals(z20, s20);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test(priority = 49)
    public void Compare_LOST_of_ZONE_and_Region_with_Dealer_parent_Group_Wise() throws InterruptedException {


        Assert.assertEquals(z21, d21);
    }

    //......................................................................................
    @Test(priority = 50)
    public void Compare_LOST_of_ZONE_and_Region_with_Worshop_Wise() throws InterruptedException {


        Assert.assertEquals(z21, w20);
    }

    //......................................................................................
    @Test(priority = 51)
    public void Compare_LOST_of_ZONE_and_Region_with_Day_Wise() throws InterruptedException {


        Assert.assertEquals(z21, day21);
    }

    //......................................................................................
    @Test(priority = 52)
    public void Compare_LOST_of_ZONE_and_Region_with_service_type_Wise() throws InterruptedException {


        Assert.assertEquals(z21, s21);
        Thread.sleep(5000);
    }
}



