package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    public  WebDriver driver;
    public  WebDriverWait wait;
    public  JavascriptExecutor js;

    @BeforeClass()
    public void method1() {
        System.setProperty( "webdriver.chrome.driver", "D:\\Selenium dependency\\DreiverZ\\chromedriver.exe" );
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        wait = new WebDriverWait( driver,2000 );
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
    }

     @AfterClass
    public void deleteMethod(){
           driver.findElement( By.xpath( "//span[text()='Actions']" ) ).click();
           wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.xpath( "//i18n-string[text()='Delete']" )) ));
           driver.findElement( By.xpath( "//i18n-string[text()='Delete']" ) ).click();
           wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//button[@data-confirm-button='accept']" ) ) ));
           driver.findElement( By.xpath( "//button[@data-confirm-button='accept']" ) ).click();

       }
    }

