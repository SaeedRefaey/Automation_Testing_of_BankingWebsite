import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase
{
    LoginPage loginpage;
    @Test (priority = 1)
    public void ValidLogin()
    {
    loginpage=new LoginPage(driver);
    loginpage.Login("mngr492746","zaqabah");
    Assert.assertTrue(driver.findElement(By.xpath("//marquee[@class='heading3']"))
            .getText().contains("Welcome To Manager's Page of Guru99 Bank"));

    }

    @Test (priority = 2)
    public void InValidUserLogin()
    {
        loginpage=new LoginPage(driver);
        loginpage.Login("mgr492746","zaqabah");
        Assert.assertTrue(driver.switchTo().alert().getText().contains("User or Password is not valid"));
        driver.switchTo().alert().accept();

    }

    @Test (priority = 3)
    public void InValidPassLogin()
    {
        loginpage=new LoginPage(driver);
        loginpage.Login("mngr492746","zaq22abah");
        Assert.assertTrue(driver.switchTo().alert().getText().contains("User or Password is not valid"));
        driver.switchTo().alert().accept();

    }
    @Test(priority = 4)
    public void InValidBoth()
    {
        loginpage=new LoginPage(driver);
        loginpage.Login("mngr555","zaq23333");
        Assert.assertTrue(driver.switchTo().alert().getText().contains("User or Password is not valid"));
        driver.switchTo().alert().accept();

    }
}
