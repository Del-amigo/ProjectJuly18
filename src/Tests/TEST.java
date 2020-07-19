package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 extends BaseDriver {

    private Reusable_methods methods = new Reusable_methods(wait,driver);

/*
    @BeforeMethod(groups = {"smoke_test"})
    @Parameters ({"login_email", "login_password"})
    public void Login(String login_email, String login_password) {

        methods=new Reusable_methods(wait,driver);
        methods.login001(login_email, login_password);
    }*/


    @Test(groups = {"regression"})
    @Parameters({"Email","Username", "LastName"})
    void setContact(String account_email, String account_username, String account_lastname) {

        WebElement contacts = driver.findElement( By.cssSelector( "a[id='nav-primary-contacts-branch'][data-tracking='click hover']" ) );
        contacts.click();
        //        Click on contacts button
        driver.findElement( By.xpath( "(//div[contains(text(),'Contacts')])[1]" ) ).click();

        //        Click on create contact button
        WebElement createContacts = driver.findElement( By.xpath( "//span[text()='Create contact']" ) );
        createContacts.click();
//        Enter email

        WebElement email = driver.findElement( By.cssSelector( "div[class='private-form__input-wrapper'] [data-field='email']" ) );

        email.sendKeys(account_email);

//        Enter First name
        WebElement firstName = driver.findElement( By.xpath( "//input[@data-field='firstname']" ) );

        firstName.sendKeys( account_username );
//        Enter Last name
        WebElement lastName = driver.findElement( By.xpath( "//input[@data-field='lastname']" ) );

        lastName.sendKeys( account_lastname );
//        Click on Create Contact button
        driver.findElement( By.cssSelector( "button[data-selenium-test='base-dialog-confirm-btn']" ) ).click();

        //        Verify email and first name as entered

        WebElement email_text = driver.findElement(By.xpath("//div[@data-selenium-test='property-input-email']/span/span/span"));
        methods.assertion(email_text,account_email);


        WebElement firstName_value = driver.findElement( By.xpath( "//input[@data-field='firstname']" ) );
        methods.assertion(firstName_value,account_username);

    }

    @Test(groups = {"regression1"})
    @Parameters({"Domain", "Name"})
    void setDomain(String domain, String name01) {
        WebElement contacts = driver.findElement( By.cssSelector( "a[id='nav-primary-contacts-branch'][data-tracking='click hover']" ) );
        contacts.click();
        //        Click on companies button
        driver.findElement( By.xpath( "(//div[contains(text(),'Companies')])[1]" ) ).click();

        //        Click on create companies button
        driver.findElement( By.xpath( "//span[text()='Create company']" ) ).click();

//        Enter the company domain
        WebElement domainName = driver.findElement( By.cssSelector( "input[data-field='domain']" ) );
        domainName.sendKeys( domain );

//        Enter the name
        WebElement name = driver.findElement( By.cssSelector( "input[data-field='name']" ) );

        name.clear();
        name.sendKeys( name01 );

//        Click on Create company button
        driver.findElement( By.cssSelector( "button[data-confirm-button=\"accept\"]" ) ).click();

        //        Verify company domain as entered
        WebElement domainText = driver.findElement( By.xpath( "//div[@data-test-id='domain-input']/span/span/span" ) );
        methods.assertion( domainText, domain );
    }

}
