import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

        @FindBy(xpath = "//input[@name='uid']")
        WebElement Username;

        @FindBy(xpath = "//input[@name='password']")
        WebElement Password;

        @FindBy(xpath = "//input[@name='btnLogin']")
        WebElement LoginButton;


        public void Login(String User, String Pass)
        {
            Username.clear();
            Username.sendKeys(User);
            Password.clear();
            Password.sendKeys(Pass);
            LoginButton.click();
        }


    }

