import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void textBoxtests(){
        //Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Nimantha Manage");

        //Append country
        WebElement country = driver.findElement(By. id("j_idt88:j_idt91"));
        country.sendKeys("Sri Lanka");

        //Verify text box is disabled
        boolean isEnabled =  driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.printf("Is text box is enabled ? " + isEnabled);

        //clear the typed text
         WebElement clearText = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        clearText.clear();

        //retreive the typed text
         WebElement retreiveText = driver.findElement(By. id("j_idt88:j_idt97"));
         String value = retreiveText.getAttribute("value");
        System.out.printf("Value :" + value);

        //Enter tab move to next
        driver.findElement(By. id("j_idt88:j_idt99")).sendKeys("nimanthamanage1111@gmail.com" + Keys.TAB + "Confirmed control moved to next element");











    }


}



