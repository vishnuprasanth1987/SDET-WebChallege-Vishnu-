package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFirst {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        
        //1.Navigate to https://www.channelnewsasia.com/
        driver.get("https://www.channelnewsasia.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
       //2.Validate the headline new item Title
        String Actual = driver.getTitle();
        String Expected = "CNA: Breaking News, Singapore News, World and Asia";

        if (Actual.equals(Expected)) {
                   System.out.println("Test Passed!");
        } else {
                   System.out.println("Test Failed");
        }
       //3.Click on the Headline Item title and navigate to the actual story
       driver.findElement(By.xpath("//*[@id='block-mc-cna-theme-mainpagecontent']/article/div/div[1]/div[2]/section/div/div[1]/div[1]")).click();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       
       //4.Once in the Headline full news item detail page, verify if we are on the expected news item
       System.out.println("Page title is : " + driver.getTitle());
       Thread.sleep(10000);
       
        //5.Scroll to the bottom of the screen and wait for AJAX to load more news items.
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,10000)");
        Thread.sleep(5000);
       
        WebDriverWait wait=new WebDriverWait(driver,40);
         
     WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='block-mc-cna-theme-mainpagecontent']/article[2]/div[2]/div/a")));
     boolean status = element.isDisplayed();
     
		// if else condition
		if (status) {
			System.out.println("===== Expand to read the full story is visible======");
		} else {
			System.out.println("===== Expand to read the full story is not visible======");
		}
		Thread.sleep(5000);
		//6.Once two news items have been loaded , click on the Second news item.
        element.click();
        Thread.sleep(5000);
        System.out.println("===== Expand to read the full story is clicked and expanded======");
        //7.Click on “Read Full Story” of the second news item and verify that the Title matches the same
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Page title is : " + driver.getTitle());
        driver.close();
      
      
}
}