package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private Reusable_methods methods;


    @BeforeClass (alwaysRun = true)
    public void before_class() {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\safe glazing\\Desktop\\Selenium\\chromedriver.exe" );

    }

    @BeforeMethod(groups ={"smoke_test"})
    @Parameters({"login_email", "login_password"})
    public void Login(String login_email, String login_password) {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://app.hubspot.com/login" );
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        wait = new WebDriverWait( driver,5 );
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        methods=new Reusable_methods(wait,driver);
        methods.login001(login_email, login_password);
    }

//    @BeforeMethod (alwaysRun = true)
//
//    public void before_method(){
//
//
//    }

     @AfterClass (alwaysRun = true)
    public void deleteMethod(){
           driver.findElement( By.xpath( "//span[text()='Actions']" ) ).click();
           wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.xpath( "//i18n-string[text()='Delete']" )) ));
           driver.findElement( By.xpath( "//i18n-string[text()='Delete']" ) ).click();
           wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//button[@data-confirm-button='accept']" ) ) ));
           driver.findElement( By.xpath( "//button[@data-confirm-button='accept']" ) ).click();

          try {
              methods=new Reusable_methods(wait,driver);
              methods.logout();

          }catch (StaleElementReferenceException ex){
              methods=new Reusable_methods(wait,driver);
              methods.logout();
          }

       }
    }

