import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class dropdownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void leafgroungpageDropDownTest() throws InterruptedException {
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //get the number of dropdown options
        List<WebElement> listOfOptions = select.getOptions();
        int size =listOfOptions.size();
        System.out.printf("No of options : " + size);
        for (WebElement element:listOfOptions){
            System.out.println(element.getText());
        }

        //using sendkeys select dropdown value
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //selecting value in a boostrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listOfDropDownValues2 =  driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element:listOfDropDownValues2){
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")){
                element.click();
                break;
            }
        }
    }

    @Test
    public  void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role = \"listbox\"]//li//div[@class=\"wM6W7d\"]"));
        System.out.printf(String.valueOf(googleSearchList.size()));
        for (WebElement element:googleSearchList){
            System.out.printf(element.getText());
        }

        //Handle hidden auto suggestion drop down and search using DOM Debugger Trick





    }

}
