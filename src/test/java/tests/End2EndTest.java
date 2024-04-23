package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;

public class End2EndTest extends BaseTest {
//Git test
    //Git Test 2
    @Test(priority = 1)
    public void testRegister(){
        var register = homePage.clickRegister();
        register.registerSteps();
        String actual = register.validateRegister();
        String expected = "Your registration completed";
        Assert.assertTrue(actual.contains(expected),"the result message of register not correct");
        register.completeRegister();
    }

    @Test(priority = 2)
    public void testForgetPassword(){
        var login = homePage.clickLogin();
        login.stepsLogin("lucktoy92@gmail.com","jojojo");
        var forgetPassword = login.clickForgetPassword();
        forgetPassword.stepsEmailRecovery();
        String actual = forgetPassword.validateAlert();
        String expected = "Email with instructions has been sent to you.";
        Assert.assertTrue(actual.contains(expected),"the Massege in Alert in Incorrect");
    }

    @Test(priority = 3)
    public void testLogin(){
        var login = homePage.clickLogin();
        login.stepsLogin("lucktoy92@gmail.com","mnmnmnmn");
    }

    @Test(priority = 4)
    private void testChoseProduct() throws InterruptedException {
        var products = homePage.choseProduct();
        var myProduct = products.selectProduct();
        var shoppingCart = myProduct.addProductToCart();
        shoppingCart.clickContinueShopping();
        //shoppingCart.updateShoppingCart();
        var estimateShipping = shoppingCart.clickEstimateShipping();
        estimateShipping.fillFields();
        Thread.sleep(2000);
    /*    var checkout = shoppingCart.clickCheckout();
        checkout.fillBillingAddress();
        checkout.selectShippingMethod();
        checkout.selectPaymentMethod();
        checkout.selectPaymentInformation();
        checkout.ConfirmPayment();
    */
    }

    private void testCheckout(){
        var shoppingCartCheckout = homePage.clickShoppingCart();
        var checkout = shoppingCartCheckout.clickCheckout();
        checkout.fillBillingAddress();
        checkout.selectShippingMethod();
        checkout.selectPaymentMethod();
        checkout.selectPaymentInformation();
        checkout.ConfirmPayment();
    }

}
