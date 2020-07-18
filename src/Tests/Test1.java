package Tests;

import Tests.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 extends BaseDriver{

    @Test(priority = 0)
    public void login() {
//        https://app.hubspot.com/login
        driver.get( "https://app.hubspot.com/login" );
        WebDriverWait wait = new WebDriverWait( driver, 5 );
        login( wait );
    }

//        Click on contacts dropdown (on left top)
    @Test(priority = 1)
    @Parameters({"Email","Username", "LastName"})
    void contacts(String str1, String str2, String str3) throws InterruptedException {
        WebElement contacts = driver.findElement( By.cssSelector( "a[id='nav-primary-contacts-branch'][data-tracking='click hover']" ) );
        contacts.click();
        //        Click on contacts button
        driver.findElement( By.xpath( "(//div[contains(text(),'Contacts')])[1]" ) ).click();

        //        Click on create contact button
        WebElement createContacts = driver.findElement( By.xpath( "//span[text()='Create contact']" ) );
        createContacts.click();
//        Enter email
        WebElement email = driver.findElement( By.cssSelector( "div[class='private-form__input-wrapper'] [data-field='email']" ) );
        String mineEmail = str1;
        email.sendKeys( mineEmail );
//        Enter First name
        WebElement firstName = driver.findElement( By.xpath( "//input[@data-field='firstname']" ) );
        String firstname = str2;
        firstName.sendKeys( firstname );
//        Enter Last name
        WebElement lastName = driver.findElement( By.xpath( "//input[@data-field='lastname']" ) );
        String lastname = str3;
        lastName.sendKeys( lastname );
//        Click on Create Contact button
        driver.findElement( By.cssSelector( "button[data-selenium-test='base-dialog-confirm-btn']" ) ).click();

        //        Verify email and first name as entered
        String emailText = driver.findElement( By.xpath( "//div[@data-selenium-test='property-input-email']/span/span/span" ) ).getText();
        Assertion( mineEmail, emailText );
        String firstname01 = driver.findElement( By.xpath( "//input[@data-field='firstname']" ) ).getAttribute( "value" );
        System.out.println(firstname01);
        Assertion( firstname, firstname01 );
    }

    private void Assertion(String str1, String str2) {
        Assert.assertEquals( str1, str2 );
    }

    private void login(WebDriverWait wait) {
        By emailinput = By.id("username");
        wait.until( ExpectedConditions.visibilityOfElementLocated(emailinput));

        //        Enter the user name and password click on login button
        driver.findElement(emailinput).sendKeys("furkatkhalilov@gmail.com");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Hotspot12345");
        driver.findElement(By.id("loginBtn")).click();
    }
}
