import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadExample {


    WebDriver driver;

    @BeforeMethod
    public void openFileTestsTest() throws InterruptedException {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test
    public  void fileDownloadTest() throws InterruptedException {

        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton =  driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\hp\\Downloads");
        File[] totalFiles =  file.listFiles();
        for (File findFile:totalFiles){
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is Downloaded");
                break;
            }
        }

    }


    @Test
    public void fileUploadTest() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement uploadBtn =  driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

        //windows control begin here

        StringSelection selection = new StringSelection("C:\\Users\\hp\\Downloads\\TestLeaf Logo.png");
        //coping the path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }


}
