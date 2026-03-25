import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class windowExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void windowTest() throws InterruptedException {
        //click and confirm new window open
        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window : " + oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.printf("handles size : " + handles.size());

        for (String newWindow:handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.printf("Page title is : " + driver.getTitle());
        }
        driver.close();

        driver.switchTo().window(oldWindow);

        WebElement openButton1 = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button visibilty : " + openbuttonVisibility);

       //find the number of open tabs

        WebElement mulitiWindowButton =driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        mulitiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiWindowsSize =  driver.getWindowHandles();
        int howmanyWindoes = multiWindowsSize.size();
        System.out.printf("Number of winddowws opned : " + howmanyWindoes);


        //close all windows except primary
        WebElement dontCloseMeButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
        dontCloseMeButton.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandles = driver.getWindowHandles();
        for(String allwindows:newWindowsHandles){
           if (!allwindows.equals(oldWindow)){
               driver.switchTo().window(allwindows);
               driver.close();
           }
        }

        driver.quit();


    }
}
