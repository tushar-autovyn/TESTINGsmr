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

public class HyperLocal_Status_Report_SMR {

    public static WebDriver driver;
    public WebDriverWait wait;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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


    @SuppressWarnings("static-access")
    @BeforeClass
    public void down() throws InterruptedException {

        this.driver = SMR_Bot_status.driver;
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
    public void Click_On_HYPERLOCAL_STATUS_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Hyperlocal = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Hyperlocal Status \"]")));
        Hyperlocal.click();
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

        Thread.sleep(10000);

        //Elements of Zone and Region Wise
        WebElement LeadGenerated = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[2]"));
        WebElement LeadAttempted = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[4]"));
        WebElement TotalConnected = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[5]"));
        WebElement RegNoConfirmed = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[6]"));
        WebElement RegNoNotConfirmed = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[7]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[8]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[9]"));
        WebElement TotalReported = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[10]"));
        WebElement PercentReported = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[11]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[12]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[13]"));
        WebElement NotConnected = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[14]"));
        WebElement NotAttempted = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'N2')]]/td[15]"));

        Thread.sleep(4000);
        //GET THE VALUES

        z1 = LeadGenerated.getText();
        z2 = LeadAttempted.getText();
        z3 = FollowUp.getText();
        z4 = TotalConnected.getText();
        z5 = RegNoConfirmed.getText();
        z6 = RegNoNotConfirmed.getText();
        z7 = AppointmentBooked.getText();
        z8 = PercentAppointmentBooked.getText();
        z9 = TotalReported.getText();
        z10 = PercentReported.getText();
        z11 = ReportedAtOwn.getText();
        z12 = ReportedAtOther.getText();
        z13 = NotConnected.getText();
        z14 = NotAttempted.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Lead Generated

            // Parse the Lead Generated value to a numeric type
            double LeadGeneratedValue = Double.parseDouble(z1);

            if (LeadGeneratedValue <= 0 || z1 == null) {
                // Fail the test if Lead Generated column Value is 0 or less
                Assert.fail("No Data Found for Zone And Region Wise   In HyperLocal status: :    " + z1);
            } else {
                // Print the Total Disposition value
                System.out.println("'Lead Generated' column Value of Zone And Region Wise Tab  In HyperLocal status::: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone And Region Wise Tab  In HyperLocal status:  " + e.getMessage());
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

        Thread.sleep(7000);

        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[2]"));
        ItemPerPage.click();


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
        WebElement LeadGenerated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement LeadAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement TotalConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement RegNoConfirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement RegNoNotConfirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement TotalReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));

        Thread.sleep(4000);
        //GET THE VALUES

        d1 = LeadGenerated.getText();
        d2 = LeadAttempted.getText();
        d3 = FollowUp.getText();
        d4 = TotalConnected.getText();
        d5 = RegNoConfirmed.getText();
        d6 = RegNoNotConfirmed.getText();
        d7 = AppointmentBooked.getText();
        d8 = PercentAppointmentBooked.getText();
        d9 = TotalReported.getText();
        d10 = PercentReported.getText();
        d11 = ReportedAtOwn.getText();
        d12 = ReportedAtOther.getText();
        d13 = NotConnected.getText();
        d14 = NotAttempted.getText();

        Thread.sleep(5000);

        try {

            // Parse the Lead Generated value to a numeric type
            double Lead_Generated = Double.parseDouble(d1);

            if (Lead_Generated <= 0 || d1 == null) {
                // Fail the test if Lead Generated value is 0 or less
                Assert.fail("No Data Found for Dealer Parent Group Wise  In HyperLocal status: : " + d1);
            } else {
                // Print the Lead Generated value
                System.out.println("'Lead Generated' column value of Dealer Parent Group Wise Tab In HyperLocal status: ::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer Parent Group Wise Tab  In HyperLocal status: " + e.getMessage());
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
        WebElement LeadGenerated = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[3]"));
        WebElement LeadAttempted = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[4]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[5]"));
        WebElement TotalConnected = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[6]"));
        WebElement RegNoConfirmed = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[7]"));
        WebElement RegNoNotConfirmed = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[8]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[9]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[10]"));
        WebElement TotalReported = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[11]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[12]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[13]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[14]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[15]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[contains(@class, 'mat-row')])[last()]//td[16]"));

        Thread.sleep(4000);
        //GET THE VALUES

        w1 = LeadGenerated.getText();
        w2 = LeadAttempted.getText();
        w3 = FollowUp.getText();
        w4 = TotalConnected.getText();
        w5 = RegNoConfirmed.getText();
        w6 = RegNoNotConfirmed.getText();
        w7 = AppointmentBooked.getText();
        w8 = PercentAppointmentBooked.getText();
        w9 = TotalReported.getText();
        w10 = PercentReported.getText();
        w11 = ReportedAtOwn.getText();
        w12 = ReportedAtOther.getText();
        w13 = NotConnected.getText();
        w14 = NotAttempted.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Lead Generated

            // Parse the Total Disposition value to a numeric type
            double Lead_Generated = Double.parseDouble(w1);

            if (Lead_Generated <= 0 || w1 == null) {
                // Fail the test if Lead Generated value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise  In HyperLocal status: : " + w1);
            } else {
                // Print the Lead Generated value
                System.out.println("'Lead Generated' column value of WorkShop Wise Tab In HyperLocal status: ::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop Wise Tab  In HyperLocal status: " + e.getMessage());
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

        Thread.sleep(30000);

        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
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
        WebElement LeadGenerated = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[2]"));
        WebElement LeadAttempted = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[4]"));
        WebElement TotalConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[5]"));
        WebElement RegNoConfirmed = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[6]"));
        WebElement RegNoNotConfirmed = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[7]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[8]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[9]"));
        WebElement TotalReported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[10]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[11]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[12]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[13]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[14]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[15]"));


        Thread.sleep(4000);
        //GET THE VALUES

        day1 = LeadGenerated.getText();
        day2 = LeadAttempted.getText();
        day3 = FollowUp.getText();
        day4 = TotalConnected.getText();
        day5 = RegNoConfirmed.getText();
        day6 = RegNoNotConfirmed.getText();
        day7 = AppointmentBooked.getText();
        day8 = PercentAppointmentBooked.getText();
        day9 = TotalReported.getText();
        day10 = PercentReported.getText();
        day11 = ReportedAtOwn.getText();
        day12 = ReportedAtOther.getText();
        day13 = NotConnected.getText();
        day14 = NotAttempted.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Lead Generated

            // Parse the Lead Generated value to a numeric type
            double Lead_Generated = Double.parseDouble(day1);

            if (Lead_Generated <= 0 || day1 == null) {
                // Fail the test if Lead Generated value is 0 or less
                Assert.fail("No Data Found for Day Wise Tab  In HyperLocal status: : " + day1);
            } else {
                // Print the Lead Generated value
                System.out.println("'Lead Generated' column value of Day Wise Tab In HyperLocal status: ::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day Wise Tab In HyperLocal status: " + e.getMessage());
        }
    }


    //..........................................................................................................
    @Test(priority = 12)
    public void Compare_LeadGenerated_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d1, z1);
    }

    //...................................................................................................
    @Test(priority = 13)
    public void Compare_LeadAttempted_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d2, z2);
    }

    //...................................................................................................
    @Test(priority = 14)
    public void Compare_FollowUp_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d3, z3);
    }

    //...................................................................................................
    @Test(priority = 15)
    public void Compare_TotalConnected_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d4, z4);
    }

    //...................................................................................................
    @Test(priority = 16)
    public void Compare_RegNoConfirmed_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d5, z5);
    }

    //...................................................................................................
    @Test(priority = 17)
    public void Compare_RegNoNotConfirmed_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d6, z6);
    }

    //...................................................................................................
    @Test(priority = 18)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d7, z7);
    }

    //...................................................................................................
    @Test(priority = 19)
    public void Compare_PercentAppointmentBooked_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        String normalizedZ10 = d8.trim().replace(" ", "");
        String normalizedW10 = z8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);

    }

    //...................................................................................................
    @Test(priority = 20)
    public void Compare_TotalReported_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d9, z9);
    }

    //...................................................................................................
    @Test(priority = 21)
    public void Compare_PercentReported_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d10, z10);
    }

    //...................................................................................................
    @Test(priority = 22)
    public void Compare_ReportedAtOwn_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d11, z11);
    }

    //...................................................................................................
    @Test(priority = 23)
    public void Compare_ReportedAtOther_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertEquals(d12, z12);
    }

    //...................................................................................................
    @Test(priority = 24)
    public void Compare_NotConnected_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d13, z13);
    }

    //...................................................................................................
    @Test(priority = 25)
    public void Compare_NotAttempted_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d14, z14);
    }

    //...................................................................................................
    @Test(priority = 26)
    public void Compare_LeadGenerated_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w1, z1);
    }

    //...................................................................................................
    @Test(priority = 27)
    public void Compare_LeadAttempted_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w2, z2);
    }

    //...................................................................................................
    @Test(priority = 28)
    public void Compare_FollowUp_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w3, z3);
    }

    //...................................................................................................
    @Test(priority = 29)
    public void Compare_TotalConnected_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w4, z4);
    }

    //...................................................................................................
    @Test(priority = 30)
    public void Compare_RegNoConfirmed_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w5, z5);
    }

    //...................................................................................................
    @Test(priority = 31)
    public void Compare_RegNoNotConfirmed_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w6, z6);
    }

    //...................................................................................................
    @Test(priority = 32)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w7, z7);
    }

    //...................................................................................................
    @Test(priority = 33)
    public void Compare_PercentAppointmentBooked_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        String normalizedZ10 = z8.trim().replace(" ", "");
        String normalizedW10 = w8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 34)
    public void Compare_TotalReported_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w9, z9);
    }

    //...................................................................................................
    @Test(priority = 35)
    public void Compare_PercentReported_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w10, z10);
    }

    //...................................................................................................
    @Test(priority = 36)
    public void Compare_ReportedAtOwn_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w11, z11);
    }

    //...................................................................................................
    @Test(priority = 37)
    public void Compare_ReportedAtOther_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w12, z12);
    }

    //...................................................................................................
    @Test(priority = 38)
    public void Compare_NotConnected_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w13, z13);
    }

    //...................................................................................................
    @Test(priority = 39)
    public void Compare_NotAttempted_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w14, z14);
    }

    //...................................................................................................
    @Test(priority = 40)
    public void Compare_LeadGenerated_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day1, z1);
    }

    //...................................................................................................
    @Test(priority = 41)
    public void Compare_LeadAttempted_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day2, z2);
    }

    //...................................................................................................
    @Test(priority = 42)
    public void Compare_FollowUp_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day3, z3);
    }

    //...................................................................................................
    @Test(priority = 43)
    public void Compare_TotalConnected_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day4, z4);
    }

    //...................................................................................................
    @Test(priority = 44)
    public void Compare_RegNoConfirmed_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day5, z5);
    }

    //...................................................................................................
    @Test(priority = 45)
    public void Compare_RegNoNotConfirmed_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day6, z6);
    }

    //...................................................................................................
    @Test(priority = 46)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, z7);
    }

    //...................................................................................................
    @Test(priority = 47)
    public void Compare_PercentAppointmentBooked_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        String normalizedZ10 = z8.trim().replace(" ", "");
        String normalizedW10 = day8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);

    }

    //...................................................................................................
    @Test(priority = 48)
    public void Compare_TotalReported_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day9, z9);
    }

    //...................................................................................................
    @Test(priority = 49)
    public void Compare_PercentReported_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day10, z10);
    }

    //...................................................................................................
    @Test(priority = 50)
    public void Compare_ReportedAtOwn_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day11, z11);
    }

    //...................................................................................................
    @Test(priority = 51)
    public void Compare_ReportedAtOthers_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day12, z12);
    }

    //...................................................................................................
    @Test(priority = 52)
    public void Compare_NotConnected_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day13, z13);
    }

    //...................................................................................................
    @Test(priority = 53)
    public void Compare_NotAttempted_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day14, z14);
    }

    //...................................................................................................
    @Test(priority = 54)
    public void Compare_LeadGenerated_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w1, d1);
    }

    //...................................................................................................
    @Test(priority = 55)
    public void Compare_LeadAttempted_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w2, d2);
    }

    //...................................................................................................
    @Test(priority = 56)
    public void Compare_FollowUp_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w3, d3);
    }

    //...................................................................................................
    @Test(priority = 57)
    public void Compare_TotalConnected_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w4, d4);
    }

    //...................................................................................................
    @Test(priority = 58)
    public void Compare_RegNoConfirmed_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w5, d5);
    }

    //...................................................................................................
    @Test(priority = 59)
    public void Compare_RegNoNotConfirmed_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w6, d6);
    }

    //...................................................................................................
    @Test(priority = 60)
    public void Compare_AppointmentBooked_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w7, d7);
    }

    //...................................................................................................
    @Test(priority = 61)
    public void Compare_PercentAppointmentBooked_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        String normalizedZ10 = w8.trim().replace(" ", "");
        String normalizedW10 = d8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);

    }

    //...................................................................................................
    @Test(priority = 62)
    public void Compare_TotalReported_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w9, d9);
    }

    //...................................................................................................
    @Test(priority = 63)
    public void Compare_PercentReported_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w10, d10);
    }

    //...................................................................................................
    @Test(priority = 64)
    public void Compare_ReportedAtOwn_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w11, d11);
    }

    //...................................................................................................
    @Test(priority = 65)
    public void Compare_ReportedAtOthers_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w12, d12);
    }

    //...................................................................................................
    @Test(priority = 66)
    public void Compare_NotConnected_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w13, d13);
    }

    //...................................................................................................
    @Test(priority = 67)
    public void Compare_NotAttempted_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w14, d14);
    }

    //...................................................................................................
    @Test(priority = 68)
    public void Compare_LeadGenerated_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day1, d1);
    }

    //...................................................................................................
    @Test(priority = 69)
    public void Compare_LeadAttempted_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day2, d2);
    }

    //...................................................................................................
    @Test(priority = 70)
    public void Compare_FollowUp_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day3, d3);
    }

    //...................................................................................................
    @Test(priority = 71)
    public void Compare_TotalConnected_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day4, d4);
    }

    //...................................................................................................
    @Test(priority = 72)
    public void Compare_RegNoConfirmed_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day5, d5);
    }

    //...................................................................................................
    @Test(priority = 73)
    public void Compare_RegNoNotConfirmed_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, d6);
    }

    //...................................................................................................
    @Test(priority = 74)
    public void Compare_AppointmentBooked_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day7, d7);
    }

    //...................................................................................................
    @Test(priority = 75)
    public void Compare_PercentAppointmentBooked_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        String normalizedZ10 = d8.trim().replace(" ", "");
        String normalizedW10 = day8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);

    }

    //...................................................................................................
    @Test(priority = 76)
    public void Compare_TotalReported_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day9, d9);
    }

    //...................................................................................................
    @Test(priority = 77)
    public void Compare_PercentReported_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day10, d10);
    }

    //...................................................................................................
    @Test(priority = 78)
    public void Compare_ReportedAtOwn_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day11, d11);
    }

    //...................................................................................................
    @Test(priority = 79)
    public void Compare_ReportedAtOther_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day12, d12);
    }

    //...................................................................................................
    @Test(priority = 80)
    public void Compare_NotConnected_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day13, d13);
    }

    //...................................................................................................
    @Test(priority = 81)
    public void Compare_NotAttempted_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day14, d14);
    }

    //...................................................................................................
    @Test(priority = 82)

    public void Compare_LeadGenerated_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day1, w1);
    }

    //...................................................................................................
    @Test(priority = 83)
    public void Compare_LeadAttempted_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day2, w2);
    }

    //...................................................................................................
    @Test(priority = 84)
    public void Compare_FollowUp_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day3, w3);
    }

    //...................................................................................................
    @Test(priority = 85)
    public void Compare_TotalConnected_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day4, w4);
    }

    //...................................................................................................
    @Test(priority = 86)
    public void Compare_RegNoConfirmed_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day5, w5);
    }

    //...................................................................................................
    @Test(priority = 87)
    public void Compare_RegNoNotConfirmed_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day6, w6);
    }

    //...................................................................................................
    @Test(priority = 88)
    public void Compare_AppointmentBooked_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day7, w7);
    }

    //...................................................................................................
    @Test(priority = 89)
    public void Compare_PercentAppointmentBooked_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        String normalizedZ10 = w8.trim().replace(" ", "");
        String normalizedW10 = day8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);

    }

    //...................................................................................................
    @Test(priority = 90)
    public void Compare_TotalReported_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day9, w9);
    }

    //...................................................................................................
    @Test(priority = 91)
    public void Compare_PercentReported_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day10, w10);
    }

    //...................................................................................................
    @Test(priority = 92)
    public void Compare_ReportedAtOwn_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day11, w11);
    }

    //...................................................................................................
    @Test(priority = 93)
    public void Compare_ReportedAtOther_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day12, w12);
    }

    //...................................................................................................
    @Test(priority = 94)
    public void Compare_NotConnected_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day13, w13);
    }

    //...................................................................................................
    @Test(priority = 95)
    public void Compare_NotAttempted_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day14, w14);
        Thread.sleep(4000);
    }
    //...................................................................................................


}
