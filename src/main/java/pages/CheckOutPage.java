package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

    //Billing Address
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    // Checkout Elements
    private By selectCountry = By.id("BillingNewAddress_CountryId");
    private By city = By.id("BillingNewAddress_City");
    private By address1 = By.id("BillingNewAddress_Address1");
    private By zipCode = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    // continue Buttons
    private By continueButton1 = By.name("save");
    private By shippingMethodContinue = By.xpath("//div[@id=\"shipping-method-buttons-container\"]//button");
    private By paymentMethod = By.xpath("//div[@id=\"checkout-step-payment-method\"]//button");
    private By paymentInformation = By.xpath("//div[@id=\"checkout-step-payment-info\"]//button");
    private By confirmPayment = By.xpath("//div[@id=\"confirm-order-buttons-container\"]//button");

    //FakerData
    Faker faker = new Faker();
    String cityD = faker.address().city() ;
    String address1D = faker.address().streetAddress();
    String zipCodeD = faker.address().zipCode();
    String phoneNumberD = String.valueOf(faker.phoneNumber());

    //Method
    public void sendkey(By locator,String text){driver.findElement(locator).sendKeys(text);}
    public void click(By locator){driver.findElement(locator).click();}
    // Dropdown
    public Select findDropdownElement(){
        return new Select(driver.findElement(selectCountry));
    }
    public void selectFromDropdown(String Country){
        findDropdownElement().selectByVisibleText(Country);
    }

    public void fillBillingAddress(){
        selectFromDropdown("Algeria");
        sendkey(city,cityD);
        sendkey(address1,address1D);
        sendkey(zipCode,zipCodeD);
        sendkey(phoneNumber,phoneNumberD);
        click(continueButton1);
    }

    public void selectShippingMethod(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(shippingMethodContinue)));
        click(shippingMethodContinue);
    }

    public void selectPaymentMethod(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(paymentMethod)));
        click(paymentMethod);
    }
    public void selectPaymentInformation(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(paymentInformation)));
        click(paymentInformation);
    }

    public void ConfirmPayment(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmPayment)));
        click(confirmPayment);
    }
}
