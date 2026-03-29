import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageExample {

    WebDriver driver;

    @BeforeMethod
    public void openImagePage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void findBrokenImageTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> brokenImages = driver.findElements(By.xpath("//div[@class='example']/img"));

        //natural width = 0 --> broken image

        int i = 1;
        for (WebElement element:brokenImages){
            if (element.getAttribute("naturalWidth").equals("0")){
                System.out.println("image" +  i + " is broken");
            }else {
                System.out.println("image" + i + " is not broken");
            }
            i++;
        }

    }
}
