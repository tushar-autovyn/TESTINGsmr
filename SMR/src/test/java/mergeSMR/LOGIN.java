package mergeSMR;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LOGIN {

    public static WebDriver driver;
    public WebDriverWait wait;

    @SuppressWarnings("deprecation")
    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://dealercrm.co.in/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 1)
    public void Username() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Username = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-0\"]")));
        Username.sendKeys("North2RSM00001");

        Thread.sleep(2000);
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 2)
    public void Password() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-1\"]")));
        password.sendKeys("MarutiCNM#@123");
        Thread.sleep(2000);
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 3)
    public void Login_Button() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
        password.click();
        Thread.sleep(20000);
    }

    // wait for 15 Second  and put the captcha code

//.....................................................................................................

    @Test(priority = 4)
    public void SUBMIT_Button() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Submit\"]")));
        Submit.click();
        Thread.sleep(3000);


    }

}
