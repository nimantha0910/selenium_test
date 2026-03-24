import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class OpenGoogleTest {

    @Test
    public void googleTest() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.google.com/");

        Thread.sleep(2000); // wait like human

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Colombo");

        Thread.sleep(1000);
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

    }
}