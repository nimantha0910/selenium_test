import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class actionKeyboardExample {

    WebDriver driver;

    @BeforeMethod
    public void keyboardOperationsTest(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void keyBoardActionsTest1() throws InterruptedException {

        driver.get("https://www.google.com/");
        WebElement googleSearch = driver.findElement(By.name("q"));
        googleSearch.sendKeys("Welcome");

        Actions actions = new Actions(driver);
        //select the text
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//
//        Thread.sleep(5000);
//
//        actions.keyDown(Keys.SHIFT).sendKeys("Capital Letter").keyUp(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.CONTROL).sendKeys("x").perform();

        actions.keyDown(googleSearch, Keys.SHIFT).sendKeys("hello world").perform();
    }

    @Test
    public void KeyBoardActionsTest2(){

        driver.get("https://www.leafground.com/list.xhtml");

        List<WebElement> selectable =  driver.findElements(By.xpath("//ul[@aria-label='From']//li"));
        int size = selectable.size();
        System.out.printf("li count : " + size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(selectable.get(0)).click(selectable.get(1)).click(selectable.get(2)).perform();
    }
}
