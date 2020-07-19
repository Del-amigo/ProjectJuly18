package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Utils extends BaseDriver  {




    public void login(String login_email, String login_password) {
        By emailinput = By.id("username");
//        wait.until( ExpectedConditions.visibilityOfElementLocated(emailinput));
        driver.findElement(emailinput).sendKeys(login_email);
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys(login_password);
        driver.findElement(By.id("loginBtn")).click();
    }



}
