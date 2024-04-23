package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import testBase.BaseTest;

public class FogetPasswordTest extends BaseTest {
    @Test
    public void testForgetPassword(){
        var login = homePage.clickLogin();
        var forgetPassword = login.clickForgetPassword();
        forgetPassword.stepsEmailRecovery();
        String actual = forgetPassword.validateAlert();
        String expected = "Email with instructions has been sent to you.";
        Assert.assertTrue(actual.contains(expected),"the Massege in Alert is Incorrect");
        forgetPassword.closeAndLogin();
    }
}
