import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){
        //click and confirm title

        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String excpectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (excpectedTitle.equals(actualTitle)){
            System.out.println("Actual title is same as expected");
        }
        else {
            System.out.println("Actual tiyle is not expected.");
        }

        //Find the position of thr submit button

        driver.navigate().back();

        WebElement getPosition = driver.findElement(By. id("j_idt88:j_idt94"));
        Point xypoint =  getPosition.getLocation();
        int x = xypoint.getX();
        int y = xypoint.getY();
        System.out.println("X position " + x + "Y positio " + y);


        //find the save color
        WebElement buttonColor = driver.findElement(By . id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.printf("color " +color);


        //find the height and width
        WebElement sizeButton = driver.findElement(By .id("j_idt88:j_idt98"));
        Dimension size =  sizeButton.getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        System.out.println(" Button height is " + height + "Button width is " + width);

    }


}
