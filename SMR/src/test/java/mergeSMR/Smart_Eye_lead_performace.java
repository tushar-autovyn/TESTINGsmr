package mergeSMR;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Smart_Eye_lead_performace {
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


    String s1;
    String s2;
    String s3;
    String s4;
    String s5;
    String s6;
    String s7;
    String s8;


    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        this.driver = EW_CCP_BOTLeadConversion_Report.driver;
        Thread.sleep(5000);
    }

    // ..................................................................................................
    @Test(priority = 5)
    public void Click_On_Report() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement report = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
        report.click();
        Thread.sleep(3000);

    }

    // ..............................................................................................................
    @Test(priority = 6)
    public void Click_On_The_Smart_Eye_Lead_Performace() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Cross = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Smart Eye Lead Performance \"]")));
        Cross.click();
        Thread.sleep(3000);

    }
    // .........................................................................................................

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

        Thread.sleep(10000);

        // Try to locate the Total_Lead_Recived element
        WebElement Total_Lead_Recived;
        try {
            Total_Lead_Recived = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[2]"));

            // Check if Total_Lead_Recived element is displayed
            if (!Total_Lead_Recived.isDisplayed()) {
                System.out.println("No Data Found in Zone Region Wise: Total_Lead_Recived element is not visible on the page In Smart_Eye_Lead_Performance.");
                Assert.fail("No Data Found in Zone Region Wise: Total_Lead_Recived element is not visible on the page In Smart_Eye_Lead_Performance.");
                return; // Exit the test if the element is not visible
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Data Found in Zone Region Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance: " + e.getMessage());
            Assert.fail("No Data Found in Zone Region Wise: Total_Lead_Recived element could not be found  In Smart_Eye_Lead_Performance: " + e.getMessage());
            return; // Exit the test if the element is not found
        }

        // Check if Total_Lead_Recived is enabled
        if (!Total_Lead_Recived.isEnabled()) {
            System.out.println("Total_Lead_Recived element is not enabled In Smart_Eye_Lead_Performance");
            Assert.fail("Total_Lead_Recived element is not enabled In Smart_Eye_Lead_Performance");
        }

        // Retrieve the text and check if it's null or empty
        z1 = Total_Lead_Recived.getText();
        if (z1 == null || z1.isEmpty()) {
            System.out.println("No Data Found for Zone_Region_Wise: Total_Lead_Recived value is null or empty In Smart_Eye_Lead_Performance");
            Assert.fail("No Data Found for Zone_Region_Wise: Total_Lead_Recived value is null or empty In Smart_Eye_Lead_Performance");
            return; // Exit the test if the value is null or empty
        }


        // Proceed with the rest of your element locators and text retrievals
        WebElement Actual_Earning = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[3]"));
        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[4]"));
        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[5]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[6]"));
        WebElement Pending_Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[7]"));
        WebElement Follow_up_and_Pending_FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[8]"));
        WebElement Refused = driver.findElement(By.xpath("(//tr[td[contains(., 'NORTH')]])[1]/td[9]"));

        Thread.sleep(4000);

        d1 = Total_Lead_Recived.getText();
        System.out.println("Total lead  recived  of zone region  wise In Smart_Eye_Lead_Performance   ::" + d1);

        z2 = Actual_Earning.getText();
        z3 = Total_Reported.getText();
        z4 = Total_Booking.getText();
        z5 = Fresh.getText();
        z6 = Pending_Fresh.getText();
        z7 = Follow_up_and_Pending_FollowUp.getText();
        z8 = Refused.getText();

        Thread.sleep(5000);

        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(z1);

            if (totalDueValue <= 0) {
                // Fail the test if Total Due value is 0 or less
                System.out.println("No Data Found for Zone_Region_Wise: Total_Lead_Recived In Smart_Eye_Lead_Performance:: " + z1);
                Assert.fail("No Data Found for Zone_Region_Wise: Total_Lead_Recived In Smart_Eye_Lead_Performance:: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            System.out.println("No Data Found for Zone_Region_Wise of Total_Lead_Recived In Smart_Eye_Lead_Performance: " + e.getMessage());
            Assert.fail("No Data Found for Zone_Region_Wise of Total_Lead_Recived  In Smart_Eye_Lead_Performance: " + e.getMessage());
        }
    }

    // .........................................................................................................

    @Test(priority = 8)
    public void Dealer_Parent_Group_Wise() throws InterruptedException {

        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Dealer_Parent_Group_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
        Dealer_Parent_Group_Wise.click();
        Thread.sleep(3000);

        //...............................................................................................

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(clickOnGenerate).perform();

        Thread.sleep(25000);


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);
        // Check if Items per page can be set to 100
        try {
            WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-3\"]"));
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
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }
        // Try to locate the Total_Lead_Recived element
        WebElement Total_Lead_Recived;
        try {
            Total_Lead_Recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

            // Check if Total_Lead_Recived element is displayed and not null
            if (Total_Lead_Recived == null || !Total_Lead_Recived.isDisplayed()) {
                System.out.println("No Data Found in Dealer_parent_Group_Wise: Total_Lead_Recived element is not visible on the page In Smart_Eye_Lead_Performance.");
                Assert.fail("No Data Found in Dealer_parent_Group_Wise: Total_Lead_Recived element is not visible on the page In Smart_Eye_Lead_Performance.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Data Found in Dealer_parent_Group_Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance: " + e.getMessage());
            Assert.fail("No Data Found in Dealer_parent_Group_Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance: " + e.getMessage());
            return; // Exit the test if the element is not found
        }

        // Check if Total_Lead_Recived is enabled
        if (!Total_Lead_Recived.isEnabled()) {
            System.out.println("Total_Lead_Recived element is not enabled In Smart_Eye_Lead_Performance");
            Assert.fail("Total_Lead_Recived element is not enabled In Smart_Eye_Lead_Performance");
        }

        // Retrieve the text and check if it's null or empty
        d1 = Total_Lead_Recived.getText();

        if (d1 == null || d1.isEmpty()) {
            System.out.println("No Data Found for Zone_Region_Wise: Total_Lead_Recived value is null or empty  In Smart_Eye_Lead_Performance");
            Assert.fail("No Data Found for Zone_Region_Wise: Total_Lead_Recived value is null or empty In Smart_Eye_Lead_Performance");
            return; // Exit the test if the value is null or empty
        }

        //  System.out.println("Total_Lead_Recived of Dealer_parent_Group_Wise ::" + d1);


        // Proceed with the rest of your element locators and text retrievals
        WebElement Actual_Earning = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement Pending_Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement Follow_up_and_Pending_FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement Refused = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));

        Thread.sleep(4000);
        d1 = Total_Lead_Recived.getText();
        System.out.println("Total lead  recived  of dealer parent group wise In Smart_Eye_Lead_Performance::" + d1);

        d2 = Actual_Earning.getText();
        d3 = Total_Reported.getText();
        d4 = Total_Booking.getText();
        d5 = Fresh.getText();
        d6 = Pending_Fresh.getText();
        d7 = Follow_up_and_Pending_FollowUp.getText();
        d8 = Refused.getText();

        Thread.sleep(5000);

        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(d1);

            if (totalDueValue <= 0) {
                // Fail the test if Total Due value is 0 or less
                ///    System.out.println("No Data Found for Dealer_parent_Group_Wise: Total_Lead_Recived:: " + d1);
                Assert.fail("No Data Found for Dealer_parent_Group_Wise: Total_Lead_Recived In Smart_Eye_Lead_Performance:: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            //  System.out.println("No Data Found for Dealer_parent_Group_Wise of Total_Lead_Recived: " + e.getMessage());
            Assert.fail("No Data Found for Dealer_parent_Group_Wise of Total_Lead_Recived In Smart_Eye_Lead_Performance: " + e.getMessage());
        }
    }

    // .........................................................................................................

    @Test(priority = 9)
    public void Workshop_Wise() throws InterruptedException {

        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Workshop_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        Workshop_Wise.click();
        Thread.sleep(3000);

        //...............................................................................................

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(clickOnGenerate).perform();

        Thread.sleep(25000);


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);
        // Check if Items per page can be set to 100
        try {
            WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-5\"]"));
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
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }
        // Try to locate the Total_Lead_Recived element
        WebElement Total_Lead_Recived;
        try {
            Total_Lead_Recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[2]"));

            // Check if Total_Lead_Recived element is displayed and not null
            if (Total_Lead_Recived == null || !Total_Lead_Recived.isDisplayed()) {
                System.out.println("No Data Found in Workshop_Wise: Total_Lead_Recived element is not visible on the page   In Smart_Eye_Lead_Performance.");
                Assert.fail("No Data Found in Workshop_Wise: Total_Lead_Recived element is not visible on the page   In Smart_Eye_Lead_Performance.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Data Found in Workshop_Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance: " + e.getMessage());
            Assert.fail("No Data Found in Workshop_Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance: " + e.getMessage());
            return; // Exit the test if the element is not found
        }

        // Check if Total_Lead_Recived is enabled
        if (!Total_Lead_Recived.isEnabled()) {
            System.out.println("Workshop_Wise element is not enabled  In Smart_Eye_Lead_Performance");
            Assert.fail("Workshop_Wise element is not enabled In Smart_Eye_Lead_Performance");
        }

        // Retrieve the text and check if it's null or empty
        w1 = Total_Lead_Recived.getText();

        if (w1 == null || w1.isEmpty()) {
            System.out.println("No Data Found for Workshop_Wise: Total_Lead_Recived value is null or empty In Smart_Eye_Lead_Performance");
            Assert.fail("No Data Found for Workshop_Wise: Total_Lead_Recived value is null or empty In Smart_Eye_Lead_Performance");
            return; // Exit the test if the value is null or empty
        }

        //		    System.out.println("Total_Lead_Recived of Workshop_Wise ::" + w1);


        // Proceed with the rest of your element locators and text retrievals
        WebElement Actual_Earning = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement Pending_Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement Follow_up_and_Pending_FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement Refused = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));

        Thread.sleep(4000);
        w1 = Total_Lead_Recived.getText();
        System.out.println("Total lead  recived  of Workshop_Wise  In Smart_Eye_Lead_Performance ::" + w1);

        w2 = Actual_Earning.getText();
        w3 = Total_Reported.getText();
        w4 = Total_Booking.getText();
        w5 = Fresh.getText();
        w6 = Pending_Fresh.getText();
        w7 = Follow_up_and_Pending_FollowUp.getText();
        w8 = Refused.getText();

        Thread.sleep(5000);

        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(w1);

            if (totalDueValue <= 0) {
                Assert.fail("No Data Found for Workshop_Wise: Total_Lead_Recived  In Smart_Eye_Lead_Performance :: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            //  System.out.println("No Data Found for Dealer_parent_Group_Wise of Total_Lead_Recived: " + e.getMessage());
            Assert.fail("No Data Found for Workshop_Wise of Total_Lead_Recived   In Smart_Eye_Lead_Performance: " + e.getMessage());
        }
    }
    // .........................................................................................................

    @Test(priority = 10)
    public void Day_Wise() throws InterruptedException {

        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);

        //...............................................................................................

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(clickOnGenerate).perform();

        Thread.sleep(25000);


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);
        // Check if Items per page can be set to 100
        try {
            WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-7\"]"));
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
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[10]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }
        // Try to locate the Total_Lead_Recived element
        WebElement Total_Lead_Recived;
        try {
            Total_Lead_Recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));

            // Check if Total_Lead_Recived element is displayed and not null
            if (Total_Lead_Recived == null || !Total_Lead_Recived.isDisplayed()) {
                System.out.println("No Data Found in Day_Wise: Total_Lead_Recived element is not visible on the page In Smart_Eye_Lead_Performance.");
                Assert.fail("No Data Found in Day_Wise: Total_Lead_Recived element is not visible on the page In Smart_Eye_Lead_Performance.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Data Found in Day_Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance   : " + e.getMessage());
            Assert.fail("No Data Found in Day_Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance: " + e.getMessage());
            return; // Exit the test if the element is not found
        }

        // Check if Total_Lead_Recived is enabled
        if (!Total_Lead_Recived.isEnabled()) {
            System.out.println("Day_Wise element is not enabled In Smart_Eye_Lead_Performance  ");
            Assert.fail("Day_Wise element is not enabled In Smart_Eye_Lead_Performance");
        }

        // Retrieve the text and check if it's null or empty
        day1 = Total_Lead_Recived.getText();

        if (day1 == null || day1.isEmpty()) {
            System.out.println("No Data Found for Day_Wise: Total_Lead_Recived value is null or empty  In Smart_Eye_Lead_Performance");
            Assert.fail("No Data Found for Day_Wise: Total_Lead_Recived value is null or empty In Smart_Eye_Lead_Performance");
            return; // Exit the test if the value is null or empty
        }

        //    System.out.println("Total_Lead_Recived of Day_Wise ::" + w1);


        // Proceed with the rest of your element locators and text retrievals
        WebElement Actual_Earning = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
        WebElement Pending_Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement Follow_up_and_Pending_FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement Refused = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));

        Thread.sleep(4000);
        day1 = Total_Lead_Recived.getText();
        System.out.println("Total lead  recived  of Day_Wise In Smart_Eye_Lead_Performance  ::" + day1);

        day2 = Actual_Earning.getText();
        day3 = Total_Reported.getText();
        day4 = Total_Booking.getText();
        day5 = Fresh.getText();
        day6 = Pending_Fresh.getText();
        day7 = Follow_up_and_Pending_FollowUp.getText();
        day8 = Refused.getText();

        Thread.sleep(5000);

        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(day1);

            if (totalDueValue <= 0) {
                Assert.fail("No Data Found for Day_Wise: Total_Lead_Recived In Smart_Eye_Lead_Performance  :: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            //  System.out.println("No Data Found for Dealer_parent_Group_Wise of Total_Lead_Recived: " + e.getMessage());
            Assert.fail("No Data Found for Day_Wise of Total_Lead_Recived  In Smart_Eye_Lead_Performance: " + e.getMessage());
        }
    }
    // .........................................................................................................

    @Test(priority = 11)
    public void User_Wise() throws InterruptedException {

        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement User_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" User Wise \"]")));
        User_Wise.click();
        Thread.sleep(3000);

        //...............................................................................................

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(clickOnGenerate).perform();

        Thread.sleep(25000);


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);
        // Check if Items per page can be set to 100
        try {
            WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-9\"]"));
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
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[12]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }
        // Try to locate the Total_Lead_Recived element
        WebElement Total_Lead_Recived;
        try {
            Total_Lead_Recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[2]"));

            // Check if Total_Lead_Recived element is displayed and not null
            if (Total_Lead_Recived == null || !Total_Lead_Recived.isDisplayed()) {
                System.out.println("No Data Found in User_Wise: Total_Lead_Recived element is not visible on the page In Smart_Eye_Lead_Performance.");
                Assert.fail("No Data Found in User_Wise: Total_Lead_Recived element is not visible on the page In Smart_Eye_Lead_Performance.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Data Found in User_Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance: " + e.getMessage());
            Assert.fail("No Data Found in User_Wise: Total_Lead_Recived element could not be found In Smart_Eye_Lead_Performance: " + e.getMessage());
            return; // Exit the test if the element is not found
        }

        // Check if Total_Lead_Recived is enabled
        if (!Total_Lead_Recived.isEnabled()) {
            System.out.println("User_Wise element is not enabled In Smart_Eye_Lead_Performance");
            Assert.fail("User_Wise element is not enabled In Smart_Eye_Lead_Performance");
        }

        // Retrieve the text and check if it's null or empty
        s1 = Total_Lead_Recived.getText();

        if (s1 == null || s1.isEmpty()) {
            System.out.println("No Data Found for User_Wise: Total_Lead_Recived value is null or empty   In Smart_Eye_Lead_Performance");
            Assert.fail("No Data Found for User_Wise: Total_Lead_Recived value is null or empty In Smart_Eye_Lead_Performance");
            return; // Exit the test if the value is null or empty
        }

        //    System.out.println("Total_Lead_Recived of User_Wise ::" + w1);


        // Proceed with the rest of your element locators and text retrievals
        WebElement Actual_Earning = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));
        WebElement Pending_Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
        WebElement Follow_up_and_Pending_FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
        WebElement Refused = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));

        Thread.sleep(4000);
        s1 = Total_Lead_Recived.getText();
        System.out.println("Total lead  recived  of User_Wise In Smart_Eye_Lead_Performance ::" + s1);

        s2 = Actual_Earning.getText();
        s3 = Total_Reported.getText();
        s4 = Total_Booking.getText();
        s5 = Fresh.getText();
        s6 = Pending_Fresh.getText();
        s7 = Follow_up_and_Pending_FollowUp.getText();
        s8 = Refused.getText();

        Thread.sleep(5000);

        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(day1);

            if (totalDueValue <= 0) {
                Assert.fail("No Data Found for User_Wise: Total_Lead_Recived In Smart_Eye_Lead_Performance:: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            //  System.out.println("No Data Found for Dealer_parent_Group_Wise of Total_Lead_Recived: " + e.getMessage());
            Assert.fail("No Data Found for User_Wise of Total_Lead_Recived In Smart_Eye_Lead_Performance: " + e.getMessage());
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 12)
    public void Compare_Total_Lead_Recived_Of_ZONE_Region_Wise_from__Dealer_Parent_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z1, d1);
    }

    //..............................................................................................
    @Test(priority = 13)
    public void Compare_Total_Lead_Recived_Of_ZONE_Region_Wise_from_Worshop_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z1, w1);
    }

    //..............................................................................................
    @Test(priority = 14)
    public void Compare_Total_Lead_Recived_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z1, day1);
    }

    //..............................................................................................
    @Test(priority = 15)
    public void Compare_Total_Lead_Recived_Of_ZONE_Region_Wise_from_user_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z1, s1);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //..............................................................................................
    @Test(priority = 16)
    public void Compare_Actual_Earning_Of_ZONE_Region_Wise_from_Dealer_parent_group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z2, d2);
    }

    //..............................................................................................
    @Test(priority = 17)
    public void Compare_Actual_Earning_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z2, w2);
    }

    //..............................................................................................
    @Test(priority = 18)
    public void Compare_Actual_Earning_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z2, day2);
    }

    //..............................................................................................
    @Test(priority = 19)
    public void Compare_Actual_Earning_Of_ZONE_Region_Wise_from_user_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z2, s2);
    }
    //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 20)
    public void Compare_Total_Reported_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z3, d3);
    }

    //..............................................................................................
    @Test(priority = 21)
    public void Compare_Total_Reported_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z3, w3);
    }

    //..............................................................................................
    @Test(priority = 22)
    public void Compare_Total_Reported_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z3, day3);
    }

    //..............................................................................................
    @Test(priority = 23)
    public void Compare_Total_Reported_Of_ZONE_Region_Wise_from_user_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z3, s3);
    }
    //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 24)
    public void Compare_Total_Booking_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z4, d4);
    }

    //..............................................................................................
    @Test(priority = 25)
    public void Compare_Total_Booking_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z4, w4);
    }

    //..............................................................................................
    @Test(priority = 26)
    public void Compare_Total_Booking_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z4, day4);
    }

    //..............................................................................................
    @Test(priority = 27)
    public void Compare_Total_Booking_Of_ZONE_Region_Wise_from_user_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z4, s4);
    }

    //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 28)
    public void Compare_Fresh_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z5, d5);
    }

    //..............................................................................................
    @Test(priority = 29)
    public void Compare_Fresh_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z5, w5);
    }

    //..............................................................................................
    @Test(priority = 30)
    public void Compare_Fresh_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z5, day5);
    }

    //..............................................................................................
    @Test(priority = 31)
    public void Compare_Fresh_Of_ZONE_Region_Wise_from_user_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z5, s5);
    }
    //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 32)
    public void Compare_Pending_Fresh_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z6, d6);
    }

    //..............................................................................................
    @Test(priority = 33)
    public void Compare_Pending_Fresh_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z6, w6);
    }

    //..............................................................................................
    @Test(priority = 34)
    public void Compare_Pending_Fresh_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z6, day6);
    }

    //..............................................................................................
    @Test(priority = 35)
    public void Compare_Pending_Fresh_Of_ZONE_Region_Wise_from_user_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z6, s6);
    }
    //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 36)
    public void Compare_Follow_up_and_Pending_FollowUp_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z7, d7);
    }

    //..............................................................................................
    @Test(priority = 37)
    public void Compare_Follow_up_and_Pending_FollowUp_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z7, w7);
    }

    //..............................................................................................
    @Test(priority = 38)
    public void Compare_Follow_up_and_Pending_FollowUp_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z7, day7);
    }

    //..............................................................................................
    @Test(priority = 39)
    public void Compare_Follow_up_and_Pending_FollowUp_Of_ZONE_Region_Wise_from_user_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z7, s7);
    }
    //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 40)
    public void Compare_Refused_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z8, d8);
    }

    //..............................................................................................
    @Test(priority = 41)
    public void Compare_Refused_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z8, w8);
    }

    //..............................................................................................
    @Test(priority = 42)
    public void Compare_Refused_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z8, day8);
    }

    //..............................................................................................
    @Test(priority = 43)
    public void Compare_Refused_Of_ZONE_Region_Wise_from_user_wise() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(z8, s8);
    }
    //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.......E  N  D....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}

