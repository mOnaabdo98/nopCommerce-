package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class MyProductPage {
    private WebDriver driver;
    private By productName = By.className("product-name");
    private By numberOfProducts = By.id("product_enteredQuantity_2");
    private By addToCart = By.id("add-to-cart-button-2");
    public MyProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public ShoppingCartPage addProductToCart(){
        driver.findElement(numberOfProducts).clear();
        driver.findElement(numberOfProducts).sendKeys("2");
        driver.findElement(addToCart).click();
        return HomePage.clickShoppingCart();
    }

}
