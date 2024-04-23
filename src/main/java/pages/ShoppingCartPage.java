package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    private WebDriver driver;
    private By continueShoppingButton = By.name("continueshopping");
    private By books = By.xpath("//ul [@class = \"top-menu notmobile\"]//li[5]");
    private By addToCart = By.xpath("//div[@data-productid=\"38\"]//button[text()=\"Add to cart\"]");
    private By firstItemRemove = By.xpath("//table[@class=\"cart\"]//tbody//tr[1]//td[@class=\"remove-from-cart\"]//button");
    private By secondItemQuantity = By.xpath("//table[@class=\"cart\"]//tbody//tr[2]//td[@class=\"quantity\"]//input");
    private By updateCartButton = By.id("updatecart");
    private By estimateShippingButton = By.id("open-estimate-shipping-popup");
    private By agreeCheckBox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");
    public ShoppingCartPage(WebDriver driver) {
        this.driver=driver;
    }
    public void click(By locator){driver.findElement(locator).click();}
    public void clickContinueShopping() throws InterruptedException {
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(8));
        click(continueShoppingButton);
        click(books);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(HomePage.shoppingCart)));
        click(addToCart);
        HomePage.clickShoppingCart();
    }
    public void updateShoppingCart(){
        // remove first item and add another piece from the second item
        // 1- update
        driver.findElement(secondItemQuantity).clear();
        driver.findElement(secondItemQuantity).sendKeys("3");
        click(updateCartButton);
        // 2- remove
        click(firstItemRemove);
    }
    public EstimateShippingSmallPage clickEstimateShipping(){
        click(estimateShippingButton);
        return new EstimateShippingSmallPage(driver);
    }
    public CheckOutPage clickCheckout(){
        click(agreeCheckBox);
        click(checkoutButton);
        return new CheckOutPage(driver);
    }

}
