package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThinkBridge_Question2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        
        
        driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
        driver.manage().window().maximize();
        Thread.sleep(5000);
          
        driver.findElement(By.xpath("//*[@id='language']")).click();
        
      
        WebElement element= driver.findElement(By.xpath("//*[@id='language']/ul"));
        String Languages = element.getText();
         System.out.println(Languages);
         Thread.sleep(5000);
         driver.findElement(By.xpath("//*[@id='ui-select-choices-row-1-0']/a/div")).click();
           driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Vishnu");
           driver.findElement(By.xpath("//*[@id='orgName']")).sendKeys("XYZ Corp");
           driver.findElement(By.xpath("//*[@id='singUpEmail']")).sendKeys("vispep@gmail.com");
           Thread.sleep(3000);
           driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/section/div[1]/form/fieldset/div[4]/label/span")).click();
           driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/section/div[1]/form/fieldset/div[5]/button")).submit();
           WebDriverWait wait=new WebDriverWait(driver,40);
           
           WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div/div[3]/div/section/div[1]/form/div")));
           boolean status = element2.isDisplayed();
           
      		// if else condition
      		if (status) {
      			System.out.println("===== Expand to read the full story is visible======");
      		} else {
      			System.out.println("===== Expand to read the full story is not visible======");
      		}

           WebElement element1= driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/section/div[1]/form/div"));
           String Email = element1.getText();
            System.out.println(Email);
         
        	} 
           }
	

           
	

	
