package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By rememberMe = By.id("RememberMe");
    private By forgetPassword = By.linkText("Forgot password?");
    private By loginButton = By.cssSelector("div[class=\"buttons\"]>button[type=\"submit\"]");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void sendKey(By locator,String text){driver.findElement(locator).sendKeys(text);}
    public void click(By locator){driver.findElement(locator).click();}
    public  void stepsLogin(String myEmail, String myPassword){
        sendKey(email,myEmail);
        sendKey(password,myPassword);
        click(rememberMe);
        click(loginButton);
    }
    public ForgetPasswordPage clickForgetPassword(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(forgetPassword)));
        click(forgetPassword);
        return new ForgetPasswordPage(driver);
    }
}
