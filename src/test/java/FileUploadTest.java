import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.SizeLimitExceededException;

import static org.testng.Assert.assertEquals;

public class FileUploadTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","C:/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest(){
        WebElement uploadPicker = driver.findElement(By.id("file-upload"));
        uploadPicker.sendKeys("C:/setup.log");
        sleep();

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        sleep();
        WebElement uploadedFileName = driver.findElement(By.id("uploaded-files"));
        String fileName = uploadedFileName.getText();
        assertEquals(fileName, "setup.log");
        sleep();
    }

    public void sleep(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
