package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void openTableTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");


    }

    @Test
    public void webRTableTest() throws InterruptedException {

        //row count
        List<WebElement> tableSize = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
        int rowCount = tableSize.size();
        System.out.println("Row Count : " + rowCount);


        //column count
        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Column count is : " + columnCount);


        //retrieve the specific row/column data
        String value = driver.findElement(By.xpath("//td[normalize-space()='$5.99']")).getText();
        System.out.println("Specified row/column : " + value);

        //retrieve all the data from the table

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j < columnCount; j++) {
                String tableDate = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print("Table Date : " + tableDate + " ");

            }
            System.out.println();
        }

        //print ID and Name only
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= 2; j++) {
                String tableDate = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print("Table Date : " + tableDate + " ");
            }
            System.out.println();
        }

        //select all the checkboxes

        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        System.out.println("page size : " + pageCount);

        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k=0; k<pageCount; k++){
            pages.get(k).click();
            Thread.sleep(1000);
            for (int i=1; i<=rowCount; i++){
               Boolean atb = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]/input")).isSelected();

               if (!atb){
                   driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]/input")).click();
                   Thread.sleep(1000);
               }

            }

        }

        //select one checkbox

        int tblRow = 1;
        driver.findElement(By.xpath("//tbody/tr["+tblRow+"]/td[4]/input")).click();


            }
        }






