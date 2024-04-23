package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By dateOfBirthDay = By.name("DateOfBirthDay");
    private By day = By.xpath("//option[text()=\"1\"]");
    private By month = By.xpath("//select[@name=\"DateOfBirthMonth\" ]//option[text()=\"July\"]");
    private By year = By.xpath("//option[text()=\"1998\"]");
    private By email = By.id("Email");
    private By companyName = By.id("Company");
    private By newsLetter = By.id("Newsletter");
    private By password = By.id("Password");
    private By comfirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    // Result page
    private By resultMessageLocate = By.className("result");
    private By continueButton = By.xpath("//div[@class=\"buttons\"]//a[text()=\"Continue\"]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void sendKey(By locator,String text){driver.findElement(locator).sendKeys(text);}
    public void registerSteps(){
        click(genderMale);
        sendKey(firstName,"Yousef");
        sendKey(lastName,"Mohamed");
        click(day);
        click(month);
        click(year);
        sendKey(email,"lucktoy92@gmail.com");
        sendKey(companyName,"JoeCompany");
        click(newsLetter);
        sendKey(password,"mnmnmnmn");
        sendKey(comfirmPassword,"mnmnmnmn");
        click(registerButton);
        //click();
    }
    public String validateRegister(){
        return driver.findElement(resultMessageLocate).getText();
    }
    public void completeRegister(){
        click(continueButton);
    }

}
