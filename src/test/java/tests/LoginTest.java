package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import testBase.BaseTest;

public class LoginTest extends BaseTest {
    @Test (priority = 1)
    public void testForgetPassword(){
        var login = homePage.clickLogin();
        login.stepsLogin("lucktoy92@gmail.com","jojojo");
        var forgetPassword = login.clickForgetPassword();
        forgetPassword.stepsEmailRecovery();
        String actual = forgetPassword.validateAlert();
        String expected = "Email with instructions has been sent to you.";
        Assert.assertTrue(actual.contains(expected),"the Massege in Alert in Incorrect");
    }
    @Test(priority = 2)
    public void testLogin(){
        var login = homePage.clickLogin();
        login.stepsLogin("lucktoy92@gmail.com","mnmnmnmn");
    }
    @Test(priority = 3)
    private void testChoseProduct() throws InterruptedException {
        var products = homePage.choseProduct();
        var myProduct = products.selectProduct();
        var shoppingCart = myProduct.addProductToCart();
        shoppingCart.clickContinueShopping();
        //HomePage.clickShopingCart();
    }
}
