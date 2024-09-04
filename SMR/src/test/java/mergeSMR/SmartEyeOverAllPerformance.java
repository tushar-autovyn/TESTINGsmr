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

public class SmartEyeOverAllPerformance {

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
    String z8;
    String z9;
    String z10;
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


    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {

        this.driver = Service_Due_Analysis_Report.driver;
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
    public void Click_On_SmartEyeOverAllPerformance_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SmartEye = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Smart Eye Overall Performance \"]")));
        SmartEye.click();
        Thread.sleep(7000);

    }

    //..................................Zone And Region Wise Tab......................................................................................
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

        // Select the day before today's date
        LocalDate dayBeforeToday = today.minusDays(1);
        WebElement selectDayBeforeToday = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + dayBeforeToday.format(formatter) + "\"]")));
        selectDayBeforeToday.click();
        Thread.sleep(2000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(20000);

        //Elements of Zone and Region Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[2]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[3]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[4]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[5]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[6]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[7]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[8]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[9]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[10]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[11]"));

        Thread.sleep(4000);
        //GET THE VALUES

        z1 = TotalJCOpen_A.getText();
        z2 = JCOpenUsingSmartEye_B.getText();
        z3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        z4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        z5 = VehicleConvertedinBodyShop_E.getText();
        z6 = PercentJCOpenedUsingSmartEye.getText();
        z7 = PercentConverted_Vs_TotalJCOpen.getText();
        z8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        z9 = RevenueEarned.getText();
        z10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(z1);

            if (TotalJCOpen <= 0 || z1 == null) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Zone And Region Wise In-Smart_Eye_Overall_Performance: " + z1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Zone And Region Wise Tab In-Smart_Eye_Overall_Performance::: " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone And Region Wise In-Smart_Eye_Overall_Performance " + e.getMessage());
        }
    }

    //..................................Dealer Parent Group Wise Tab....................................................................................
    @Test(priority = 8)
    public void Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Dealer_Parent_Group_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
        Dealer_Parent_Group_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(22000);

        //Elements of Dealer Parent Group Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));

        Thread.sleep(4000);
        //GET THE VALUES

        d1 = TotalJCOpen_A.getText();
        d2 = JCOpenUsingSmartEye_B.getText();
        d3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        d4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        d5 = VehicleConvertedinBodyShop_E.getText();
        d6 = PercentJCOpenedUsingSmartEye.getText();
        d7 = PercentConverted_Vs_TotalJCOpen.getText();
        d8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        d9 = RevenueEarned.getText();
        d10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(d1);

            if (TotalJCOpen <= 0) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Dealer Parent Group Wise In-Smart_Eye_Overall_Performance : " + d1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Dealer Parent Group Wise Tab In-Smart_Eye_Overall_Performance::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer Parent Group Wise In-Smart_Eye_Overall_Performance  " + e.getMessage());
        }
    }

    //..................................Workshop Wise Tab....................................................................................
    @Test(priority = 9)
    public void Workshop_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Workshop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        Workshop_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(22000);

        //Elements of Workshop Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));

        Thread.sleep(4000);
        //GET THE VALUES

        w1 = TotalJCOpen_A.getText();
        w2 = JCOpenUsingSmartEye_B.getText();
        w3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        w4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        w5 = VehicleConvertedinBodyShop_E.getText();
        w6 = PercentJCOpenedUsingSmartEye.getText();
        w7 = PercentConverted_Vs_TotalJCOpen.getText();
        w8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        w9 = RevenueEarned.getText();
        w10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(w1);

            if (TotalJCOpen <= 0) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Workshop Wise In-Smart_Eye_Overall_Performance  : " + w1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Workshop Wise Tab In-Smart_Eye_Overall_Performance::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Workshop Wise Tab In-Smart_Eye_Overall_Performance " + e.getMessage());
        }
    }

    //...................................Day Wise Tab...................................................................................
    @Test(priority = 10)
    public void Day_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(20000);

        //Elements of Day Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[10]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[11]"));

        Thread.sleep(4000);
        //GET THE VALUES

        day1 = TotalJCOpen_A.getText();
        day2 = JCOpenUsingSmartEye_B.getText();
        day3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        day4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        day5 = VehicleConvertedinBodyShop_E.getText();
        day6 = PercentJCOpenedUsingSmartEye.getText();
        day7 = PercentConverted_Vs_TotalJCOpen.getText();
        day8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        day9 = RevenueEarned.getText();
        day10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(day1);

            if (TotalJCOpen <= 0) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Day Wise In-Smart_Eye_Overall_Performance: " + day1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Day Wise Tab In-Smart_Eye_Overall_Performance::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day Wise In-Smart_Eye_Overall_Performance  " + e.getMessage());
        }
    }

    //.................................Service Type Wise Tab.....................................................................................
    @Test(priority = 11)
    public void Service_Type_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Service = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
        Service.click();
        Thread.sleep(3000);


        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(22000);

        //Elements of Service Type Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[2]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[10]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[11]"));

        Thread.sleep(4000);
        //GET THE VALUES

        s1 = TotalJCOpen_A.getText();
        s2 = JCOpenUsingSmartEye_B.getText();
        s3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        s4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        s5 = VehicleConvertedinBodyShop_E.getText();
        s6 = PercentJCOpenedUsingSmartEye.getText();
        s7 = PercentConverted_Vs_TotalJCOpen.getText();
        s8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        s9 = RevenueEarned.getText();
        s10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(s1);

            if (TotalJCOpen <= 0) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Service Type Wise In-Smart_Eye_Overall_Performance : " + s1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Service Type Wise Tab In-Smart_Eye_Overall_Performance::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Service Type Wise Tab  " + e.getMessage());
        }
    }
//...............................Dump Wise Tab.......................................................................................		    


//...........................Data Validation for all tabs...............................................................................

    @Test(priority = 13)
    public void Compare_TotalJCOpen_A_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d1, z1);
    }

    //...................................................................................................
    @Test(priority = 14)
    public void Compare_JCOpenUsingSmartEye_B_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d2, z2);
    }

    //...................................................................................................
    @Test(priority = 15)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d3, z3);
    }

    //...................................................................................................
    @Test(priority = 16)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d4, z4);
    }

    //...................................................................................................
    @Test(priority = 17)
    public void Compare_VehicleConvertedInBodyShop_E_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d5, z5);
    }

    //...................................................................................................
    @Test(priority = 18)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d6, z6);
    }

    //...................................................................................................
    @Test(priority = 19)
    public void Compare_PercentConverted_Vs_Total_JCOpen_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d7, z7);
    }

    //...................................................................................................
    @Test(priority = 20)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d8, z8);
    }

    //...................................................................................................
    @Test(priority = 21)
    public void Compare_Revenue_Earned_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d9, z9);
    }

    //...................................................................................................
    @Test(priority = 22)
    public void Compare_Converted_At_OtherDealer_F_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d10, z10);
    }

    //...................................................................................................
    @Test(priority = 23)
    public void Compare_TotalJCOpen_A_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, z1);
    }

    //...................................................................................................
    @Test(priority = 24)
    public void Compare_JCOpenUsing_SmartEye_B_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, z2);
    }

    //...................................................................................................
    @Test(priority = 25)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, z3);
    }

    //...................................................................................................
    @Test(priority = 26)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, z4);
    }

    //...................................................................................................
    @Test(priority = 27)
    public void Compare_VehicleConvertedInBodyShop_E_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, z5);
    }

    //...................................................................................................
    @Test(priority = 28)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w6, z6);
    }

    //...................................................................................................
    @Test(priority = 29)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, z7);
    }

    //...................................................................................................
    @Test(priority = 30)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w8, z8);
    }

    //...................................................................................................
    @Test(priority = 31)
    public void Compare_Revenue_Earned_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w9, z9);
    }

    //...................................................................................................
    @Test(priority = 32)
    public void Compare_ConvertedAt_OtherDealer_F_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w10, z10);
    }

    //...................................................................................................
    @Test(priority = 33)
    public void Compare_TotalJCOpen_A_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, z1);
    }

    //...................................................................................................
    @Test(priority = 34)
    public void Compare_JCOpenUsing_SmartEye_B_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, z2);
    }

    //...................................................................................................
    @Test(priority = 35)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, z3);
    }

    //...................................................................................................
    @Test(priority = 36)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, z4);
    }

    //...................................................................................................
    @Test(priority = 37)
    public void Compare_VehicleConvertedInBodyShop_E_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, z5);
    }

    //...................................................................................................
    @Test(priority = 38)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, z6);
    }

    //...................................................................................................
    @Test(priority = 39)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, z7);
    }

    //...................................................................................................
    @Test(priority = 40)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, z8);
    }

    //...................................................................................................
    @Test(priority = 41)
    public void Compare_Revenue_Earned_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, z9);
    }

    //...................................................................................................
    @Test(priority = 42)
    public void Compare_ConvertedAt_OtherDealer_F_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day10, z10);
    }
//...................................................................................................	

    @Test(priority = 43)
    public void Compare_TotalJCOpen_A_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, z1);
    }

    //...................................................................................................
    @Test(priority = 44)
    public void Compare_JCOpenUsing_SmartEye_B_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, z2);
    }

    //...................................................................................................
    @Test(priority = 45)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, z3);
    }

    //...................................................................................................
    @Test(priority = 46)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, z4);
    }

    //...................................................................................................
    @Test(priority = 47)
    public void Compare_VehicleConvertedInBodyShop_E_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, z5);
    }

    //...................................................................................................
    @Test(priority = 48)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, z6);
    }

    //...................................................................................................
    @Test(priority = 49)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, z7);
    }

    //...................................................................................................
    @Test(priority = 50)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, z8);
    }

    //...................................................................................................
    @Test(priority = 51)
    public void Compare_Revenue_Earned_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, z9);
    }

    //...................................................................................................
    @Test(priority = 52)
    public void Compare_ConvertedAt_OtherDealer_F_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, z10);
    }

    //...................................................................................................
    @Test(priority = 53)
    public void Compare_TotalJCOpen_A_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, d1);
    }

    //...................................................................................................
    @Test(priority = 54)
    public void Compare_JCOpenUsing_SmartEye_B_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, d2);
    }

    //...................................................................................................
    @Test(priority = 55)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, d3);
    }

    //...................................................................................................
    @Test(priority = 56)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, d4);
    }

    //...................................................................................................
    @Test(priority = 57)
    public void Compare_VehicleConvertedInBodyShop_E_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, d5);
    }

    //...................................................................................................
    @Test(priority = 58)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w6, d6);
    }

    //...................................................................................................
    @Test(priority = 59)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, d7);
    }

    //...................................................................................................
    @Test(priority = 60)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w8, d8);
    }

    //...................................................................................................
    @Test(priority = 61)
    public void Compare_Revenue_Earned_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w9, d9);
    }

    //...................................................................................................
    @Test(priority = 62)
    public void Compare_ConvertedAt_OtherDealer_F_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w10, d10);
    }

    //...................................................................................................
    @Test(priority = 63)
    public void Compare_TotalJCOpen_A_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, d1);
    }

    //...................................................................................................
    @Test(priority = 64)
    public void Compare_JCOpenUsing_SmartEye_B_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, d2);
    }

    //...................................................................................................
    @Test(priority = 65)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, d3);
    }

    //...................................................................................................
    @Test(priority = 66)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, d4);
    }

    //...................................................................................................
    @Test(priority = 67)
    public void Compare_VehicleConvertedInBodyShop_E_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, d5);
    }

    //...................................................................................................
    @Test(priority = 68)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, d6);
    }

    //...................................................................................................
    @Test(priority = 69)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, d7);
    }

    //...................................................................................................
    @Test(priority = 70)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, d8);
    }

    //...................................................................................................
    @Test(priority = 71)
    public void Compare_Revenue_Earned_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, d9);
    }

    //...................................................................................................
    @Test(priority = 72)
    public void Compare_ConvertedAt_OtherDealer_F_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day10, d10);
    }

    //...................................................................................................
    @Test(priority = 73)
    public void Compare_TotalJCOpen_A_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, d1);
    }

    //...................................................................................................
    @Test(priority = 74)
    public void Compare_JCOpenUsing_SmartEye_B_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, d2);
    }

    //...................................................................................................
    @Test(priority = 75)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, d3);
    }

    //...................................................................................................
    @Test(priority = 76)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, d4);
    }

    //...................................................................................................
    @Test(priority = 77)
    public void Compare_VehicleConvertedInBodyShop_E_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, d5);
    }

    //...................................................................................................
    @Test(priority = 78)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, d6);
    }

    //...................................................................................................
    @Test(priority = 79)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, d7);
    }

    //...................................................................................................
    @Test(priority = 80)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, d8);
    }

    //...................................................................................................
    @Test(priority = 81)
    public void Compare_Revenue_Earned_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, d9);
    }

    //...................................................................................................
    @Test(priority = 82)
    public void Compare_ConvertedAt_OtherDealer_F_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, d10);
    }

    //...................................................................................................
    @Test(priority = 83)

    public void Compare_TotalJCOpen_A_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, w1);
    }

    //...................................................................................................
    @Test(priority = 84)
    public void Compare_JCOpenUsing_SmartEye_B_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, w2);
    }

    //...................................................................................................
    @Test(priority = 85)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, w3);
    }

    //...................................................................................................
    @Test(priority = 86)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, w4);
    }

    //...................................................................................................
    @Test(priority = 87)
    public void Compare_VehicleConvertedInBodyShop_E_Column_WorkshopWise_With_DayWise() throws InterruptedException {
        Assert.assertEquals(day5, w5);
    }

    //...................................................................................................
    @Test(priority = 88)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day6, w6);
    }

    //...................................................................................................
    @Test(priority = 89)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, w7);
    }

    //...................................................................................................
    @Test(priority = 90)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, w8);
    }

    //...................................................................................................
    @Test(priority = 91)
    public void Compare_Revenue_Earned_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, w9);
    }

    //...................................................................................................
    @Test(priority = 92)
    public void Compare_ConvertedAt_OtherDealer_F_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day10, w10);
    }

    //...................................................................................................
    @Test(priority = 93)
    public void Compare_TotalJCOpen_A_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, w1);
    }

    //...................................................................................................
    @Test(priority = 94)
    public void Compare_JCOpenUsing_SmartEye_B_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, w2);
    }

    //...................................................................................................
    @Test(priority = 95)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, w3);
    }

    //...................................................................................................
    @Test(priority = 96)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, w4);
    }

    //...................................................................................................
    @Test(priority = 97)
    public void Compare_VehicleConvertedInBodyShop_E_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, w5);
    }

    //...................................................................................................
    @Test(priority = 98)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, w6);
    }

    //...................................................................................................
    @Test(priority = 99)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, w7);
    }

    //...................................................................................................
    @Test(priority = 100)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, w8);
    }

    //...................................................................................................
    @Test(priority = 101)
    public void Compare_Revenue_Earned_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, w9);
    }

    //...................................................................................................
    @Test(priority = 102)
    public void Compare_ConvertedAt_OtherDealer_F_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, w10);
    }

    //...................................................................................................
    @Test(priority = 103)
    public void Compare_TotalJCOpen_A_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, day1);
    }

    //...................................................................................................
    @Test(priority = 104)
    public void Compare_JCOpenUsing_SmartEye_B_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, day2);
    }

    //...................................................................................................
    @Test(priority = 105)
    public void Compare_VehicleConvertedInBodyShop_OwnWorkshop_C_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, day3);
    }

    //...................................................................................................
    @Test(priority = 106)
    public void Compare_VehicleConvertedInBodyShop_RegionParent_D_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, day4);
    }

    //...................................................................................................
    @Test(priority = 107)
    public void Compare_VehicleConvertedInBodyShop_E_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, day5);
    }

    //...................................................................................................
    @Test(priority = 108)
    public void Compare_Percent_JCOpen_UsingSmartEye_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, day6);
    }

    //...................................................................................................
    @Test(priority = 109)
    public void Compare_Percent_Converted_Vs_TotalJCOpen_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, day7);
    }

    //...................................................................................................
    @Test(priority = 110)
    public void Compare_Percent_Converted_Vs_OpenedUsing_SmartEye_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, day8);
    }

    //...................................................................................................
    @Test(priority = 111)
    public void Compare_Revenue_Earned_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, day9);
    }

    //...................................................................................................
    @Test(priority = 112)
    public void Compare_ConvertedAt_OtherDealer_F_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, day10);
    }
//...................................................................................................	


}

