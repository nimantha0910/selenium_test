import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public  void alertTest() throws InterruptedException {
    //alert Simple
     WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
     alertBox.click();

      Alert alert =  driver.switchTo().alert();
      Thread.sleep(3000);
      alert.accept();


      WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
      confirmBox.click();

        Alert alert1 =  driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();


      //Alert prompt dialog
      WebElement promptDialog = driver.findElement(By.id("j_idt88:j_idt104"));
      promptDialog.click();

        Alert alert2 =  driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText =  alert2.getText();
        System.out.printf("Alert Text is : " +alertText);
        alert2.sendKeys("My name is nimantha");
        alert2.accept();


    }



}
