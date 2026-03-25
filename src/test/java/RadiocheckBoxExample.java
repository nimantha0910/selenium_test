import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadiocheckBoxExample {


    WebDriver driver;

    @BeforeMethod
    public void radio_checkbox_example(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public  void radioTest(){
        //Find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeradioOption =  driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxradioOption =  driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption =  driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption =  driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeradioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.printf("Default select radio button is  :" + chromeText);
        }else if (firefoxradioOption){
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.printf("Default select radio button is  :" + firefoxText);
        } else if (safariradioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.printf("Default select radio button is  :" + safariText);

        } else if (edgeradioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.printf("Default select radio button is  :" + edgeText);

        }


        //select the age group ( only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if (!isChecked){
            //myAgeGroup.click();

            driver.findElement(By.xpath("//label[normalize-space()='1-20 Years']")).click();

        }

    }
    @Test
    public void CheckBocTest(){

        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//body/div[@class='layout-wrapper layout-wrapper-slim-sidebar slim']/div[@class='layout-main']/div[@class='layout-main-content']/form[@id='j_idt87']/div[@class='grid ui-fluid']/div[1]/div[3]/div[1]/div[1]//label"));
        for (WebElement element:checkBoxList){
            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i=1;i<=checkBoxList.size();i++){boolean checkboxStaus =
        driver.findElement(By.xpath("//body/div[@class='layout-wrapper layout-wrapper-slim-sidebar slim']/div[@class='layout-main']/div[@class='layout-main-content']/form[@id='j_idt87']/div[@class='grid ui-fluid']/div[1]/div[3]/div[1]/div[1]//input[" + i + "]")).isSelected();
            System.out.println("checkbox : " + i + "selected status is: " + checkboxStaus);}
    }


}
