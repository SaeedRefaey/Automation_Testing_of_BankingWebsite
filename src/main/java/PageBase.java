import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageBase {
    protected WebDriver driver;

    //Create Constructor
    public PageBase(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public static void main(String[] args) {

    }
}
