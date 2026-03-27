import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {


    WebDriver driver;

    @BeforeMethod
    public void FrameExample(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){

        //click me(inside frame)
        driver.switchTo().frame(0);
        WebElement buttton1 = driver.findElement(By.xpath("//button[@id='Click']"));
        buttton1.click();

        String afterClickButtonText = buttton1.getText();
        System.out.println("After click button : " + afterClickButtonText);

    //click me (inside nested frame)
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        driver.switchTo().frame(0);

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();
        String buttonText = button3.getText();
        System.out.println("Button3 text : " + buttonText);


    //How mane frames in this page

        driver.switchTo().defaultContent();

        List<WebElement> getIframCount = driver.findElements(By.tagName("iframe"));
        int frameCount = getIframCount.size();

        System.out.printf("Frame count : " +frameCount);


    }
}
