package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    static WebDriver driver;
    WebDriverWait wait;
    public By register = By.className("ico-register");
    public By login = By.className("ico-login");
    public static final By shoppingCart = By.id("topcartlink");
    public By computers = By.linkText("Computers");
    public By notebooks = By.xpath("//ul [@class=\"top-menu notmobile\"] // li[1]//li[1]//a");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public static void clickLink(By locator){
        driver.findElement(locator).click();
    }
    public RegisterPage clickRegister(){
        clickLink(register);
        return new RegisterPage(driver);
    }

    public LoginPage clickLogin(){
        clickLink(login);
        return new LoginPage(driver);
    }

    public ProductsPage choseProduct(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(computers)).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(notebooks)));
        clickLink(notebooks);
        return new ProductsPage(driver);
    }
    public static ShoppingCartPage clickShoppingCart(){
        clickLink(shoppingCart);
        return new ShoppingCartPage(driver);
    }

}
