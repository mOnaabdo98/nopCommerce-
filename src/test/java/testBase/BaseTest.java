package testBase;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void navigateToHomePage(){
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshot/failed"+result.getName()+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException{
        Thread.sleep(1000);
       // driver.quit();
    }
}

