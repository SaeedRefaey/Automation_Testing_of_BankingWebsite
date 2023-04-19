import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;


public class WelcomeTest extends TestBase{
    LoginPage loginpage;

    @Test
    public void WelcomeCheck() throws IOException {
        loginpage = new LoginPage(driver);
        loginpage.Login("mngr492746", "zaqabah");



        String pageText = driver.findElement(By.xpath("//tr[@class=\"heading3\"]")).getText();

        // Extract the dynamic text mngrXXXX on page
        String[] parts = pageText.split(TestBase.PATTERN);
        String dynamicText = parts[1];


        // Check that the dynamic text is of pattern mngrXXXX
        // First 4 characters must be "mngr"
        assertEquals(TestBase.FIRST_PATTERN,dynamicText.substring(1, 5));

        // remain stores the "XXXX" in pattern mngrXXXX
        String remain = dynamicText.substring(5);


        // Check remain string must be numbers;
        assertTrue(remain.matches(TestBase.SECOND_PATTERN));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Code to save screenshot at desired location
        FileUtils.copyFile(scrFile, new File("S:\\Downloads\\screenshot.png"));
    }
}
