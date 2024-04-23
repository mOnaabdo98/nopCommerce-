package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;

public class RegisterTest extends BaseTest {
    @Test
    public void testRegister(){
        var register = homePage.clickRegister();
        register.registerSteps();
        String actual = register.validateRegister();
        String expected = "Your registration completed";
        Assert.assertTrue(actual.contains(expected),"the result message of register not correct");
        register.completeRegister();
    }
}
