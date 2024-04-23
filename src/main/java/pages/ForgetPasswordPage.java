package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage {
    WebDriver driver;
    public By login = By.className("ico-login");
    private By emailRecoveryField = By.id("Email");
    private By recoverButton = By.name("send-email");
    private By validateAlert = By.className("content");
    private By closeAlert = By.className("close");

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void click(By locator){driver.findElement(locator).click();}

    public void stepsEmailRecovery() {
        driver.findElement(emailRecoveryField).sendKeys("lucktoy92@gmail.com");
        click(recoverButton);
    }
    public String validateAlert(){
        return driver.findElement(validateAlert).getText();
    }
    public void closeAndLogin(){
        click(closeAlert);
        click(login);
    }

}