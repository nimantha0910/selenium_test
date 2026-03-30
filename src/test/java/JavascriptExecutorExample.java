import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptExecutorExample {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void openLinkTestPage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void jsExecutorTests() throws InterruptedException {

        jsExecutor = (JavascriptExecutor) driver;

        //get an alert box in to web page using JS
        //jsExecutor.executeScript("alert('Welcome to my page');");

        //set an input value in a text box using JavascriptExecutor

        WebElement inutNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        jsExecutor.executeScript("arguments[0].setAttribute('value', 'Learn With Nimantha');", inutNameTextBox);

        Thread.sleep(4000);

        //Highlight element
        jsExecutor.executeScript("arguments[0].style.border='3px solid red';", inutNameTextBox);

        //click element using javascriptExecutor
        WebElement maleCheckBox = driver.findElement(By.xpath("//input[@id='male']"));
        jsExecutor.executeScript("arguments[0].click();", maleCheckBox);

        Thread.sleep(4000);

        scrollPae();



    }

    //scrolling the page

    public void scrollPae(){

        jsExecutor = (JavascriptExecutor) driver;

        //scroll to some position
        jsExecutor.executeScript("window.scrollTo(0,1000);");
        jsExecutor.executeScript("window.scrollTo(0,-1000);");

        //scroll to bottom  of the page
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //scroll to top of the page
        jsExecutor.executeScript("window.scrollTo(0,0);");

        //scroll the page till element is visible
        WebElement scrollElement = driver.findElement(By.xpath("//label[normalize-space()='Gender:']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", scrollElement);
    }




}
