package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private final WebDriver driver;
    private By parentProduct = By.xpath("//div[@data-productid=\"2\"]");
    private By firstItem = By.linkText("Digital Storm VANQUISH 3 Custom Performance PC");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void sendKey(By locator,String text){driver.findElement(locator).sendKeys(text);}
    public MyProductPage selectProduct(){
        driver.findElement(parentProduct).findElement(firstItem).click();
        return new MyProductPage(driver);
    }
}
