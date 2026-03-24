import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTest(){
        //take me to dashboard
        WebElement homeLink =  driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //Find my destination
        WebElement wheretoGo =driver.findElement(By.partialLinkText("Find the URL "));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to" + path);


        //Am I broken
        WebElement brokenLink= driver.findElement(By. linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.printf("The Link is Broken");
        }
        else {
            System.out.printf("Not Broken");
        }
        driver.navigate().back();


        //Duplicate Link
        WebElement homeLink1 =  driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //count the links
        List<WebElement> countfullpageLink =  driver.findElements(By. tagName("a"));
        int pageLinkCount =countfullpageLink.size();
        System.out.printf("Counts of full page Links : " + pageLinkCount);


        //count layout links
        WebElement layouElement= driver.findElement(By. className("layout-main-content"));
        List<WebElement> countoflayoutLinks = layouElement.findElements(By.tagName("a"));
        System.out.printf("Count of layout links : " + countoflayoutLinks.size());



    }
}
