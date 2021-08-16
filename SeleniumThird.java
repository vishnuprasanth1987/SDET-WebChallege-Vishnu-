package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumThird {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        
        //1.Use Hamburger menu in Top Right corner “All Sections”
        driver.get("https://www.channelnewsasia.com/news/international");
       
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //2,Use Hamburger menu in Top Right corner “All Sections”
        driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[12]/span")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //3.Choose “Weather” from the list of options.
        driver.findElement(By.xpath("(//a[contains(.,'Weather')])[3]")).click();
        Thread.sleep(3000);
       //4.Find the Weather for city of “SINGAPORE” and the Condition
        WebElement element= driver.findElement(By.xpath("//*[@id='weather-block']/div/div[1]/div/div[2]"));
        String Singapore_Weather = element.getText();
         System.out.println(Singapore_Weather);
         driver.close();
               
	}

}
