package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import testBase.BaseTest;

public class ProductTest extends BaseTest {
    @Test
    private void testChoseProduct() throws InterruptedException {
        var products = homePage.choseProduct();
        var myProduct = products.selectProduct();
        var shoppingCart = myProduct.addProductToCart();
        shoppingCart.clickContinueShopping();
        shoppingCart.updateShoppingCart();
        var estimatShopoing = shoppingCart.clickEstimateShipping();
        estimatShopoing.fillFields();
    }
    @Test
    private void tryMethod() throws InterruptedException {
        var products = homePage.choseProduct();
        var myProduct = products.selectProduct();
        var shoppingCart = myProduct.addProductToCart();
        shoppingCart.clickContinueShopping();
        shoppingCart.clickCheckout();
    }



}
