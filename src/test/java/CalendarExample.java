import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarExample {

    WebDriver driver;

    @BeforeMethod
    public void opencalendarTestPage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");

    }

    @Test
    public  void calendarTest(){

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.sendKeys("07/02/2024");
    }
}
