import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperations {


    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void mouseOperationsTest1() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

        WebElement from= driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

       // actions.clickAndHold(from).moveToElement(to).release(to).perform();  //way 1
        actions.dragAndDrop(from,to).perform(); //way 2

        WebElement sliderPoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        System.out.println("Location slider point 1 : " + sliderPoint1.getLocation());

        actions.dragAndDropBy(sliderPoint1,50,0).perform();
        System.out.printf("New location : " + sliderPoint1.getLocation());

    }

    @Test
    public void mouseOperationTest2() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClickButton).perform();

        driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
        Alert alertPop = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println("Alert show  : " + alertPop.getText());
        alertPop.accept();
    }


}
