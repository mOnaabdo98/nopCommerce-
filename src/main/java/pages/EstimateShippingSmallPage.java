package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstimateShippingSmallPage {
    private WebDriver driver;
    private By zipcode = By.id("ZipPostalCode");
    private By dropdownSelectCountry = By.id("CountryId");
    private By applyButton = By.xpath("//div[@class=\"apply-shipping-button-container\"]//button");
    public EstimateShippingSmallPage(WebDriver driver) {
        this.driver = driver;
    }
    public Select findDropdownElement(){
        return new Select(driver.findElement(dropdownSelectCountry));
    }
    public void selectFromDropdown(String Country){
        findDropdownElement().selectByVisibleText(Country);
    }

    public void fillFields() throws InterruptedException {
        selectFromDropdown("Algeria");
        driver.findElement(zipcode).sendKeys("77");
        Thread.sleep(2000);
        driver.findElement(applyButton).click();
    }

}
