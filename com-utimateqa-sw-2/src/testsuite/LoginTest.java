package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click(); // click on the ‘Sign In’ link
        // * Verify the text ‘Welcome Back!’
        String expectedText = "Weelcome Back";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']//h2[text()=' Welcome Back!']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage(){

        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click(); // click on the ‘Sign In’ link
        driver.findElement(By.id("user[email]")).sendKeys("gdhf3464");  //  * Enter invalid username
        driver.findElement(By.id("user[password]")).sendKeys("21544dhf"); //  * Enter invalid password
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click(); // click on the ‘Log In’ button

        // Verify error message
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals(actualText,expectedText);

       driver.quit();
    }
}
