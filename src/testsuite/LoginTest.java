package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @After
    public void terminateBrowser() {
        // Close all windows
        closeBrowser();
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        String expectedMessage = "Dashboard";
        //Element to enter Username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //Element to enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        //Element to click LOGIN button
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to Login", expectedMessage, actualMessage);
    }


}
