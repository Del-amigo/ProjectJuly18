package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Reusable_methods extends BaseDriver  {
    private WebDriverWait wait;
    private WebDriver driver;


    public Reusable_methods(WebDriverWait wait, WebDriver driver) {

        this.wait = wait;
        this.driver = driver;

    }

    public void login001(String login_email, String login_password) {
        By emailinput = By.id("username");
        wait.until( ExpectedConditions.visibilityOfElementLocated(emailinput));
        driver.findElement(emailinput).sendKeys(login_email);
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys(login_password);
        driver.findElement(By.id("loginBtn")).click();
        By check_login = By.cssSelector("a[id='nav-primary-contacts-branch'][data-tracking='click hover']" );
        wait.until(ExpectedConditions.visibilityOfElementLocated(check_login));
    }

    public void assertion(WebElement element, String str) {

        String actual = element.getText();

        if (element.getText().isEmpty()) {
            actual = element.getAttribute("value");

        }

        Assert.assertEquals(actual,str);

    }

    public void logout(){

        By avatar = By.cssSelector("img[src='https://api.hubspot.com/userpreferences/v1/avatar/737e61b4fbb95693441db7939817cb0d/100 ']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(avatar));

        driver.findElement(avatar).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));

        WebElement signout = driver.findElement(By.linkText("Sign out"));
        signout.click();

        driver.quit();
    }

}
