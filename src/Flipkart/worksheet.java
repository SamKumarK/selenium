package Flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class worksheet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAM\\Selenium\\chromedriver.exe");
     WebDriver driver=new ChromeDriver();
     
     
 	driver.get("https://google.com");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys("mobiles");
	driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
	
	Thread.sleep(3000);

	
	driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]")).click();
	
	JavascriptExecutor scroll=(JavascriptExecutor)driver;
	scroll.executeScript("window.scrollBy(0,250)","");
	scroll.executeScript("window.scrollBy(0,-250)","");
	
	java.util.Set<String> tabs=driver.getWindowHandles();
	String tab1=driver.getWindowHandle();
	tabs.remove(tab1);
	String tab=tabs.iterator().next();
	String tab2="";
	if(tab!=tab1)
	{
		tab2=tab;
		driver.switchTo().window(tab2);
		System.out.println(tab2);
	}
	driver.close();
	driver.switchTo().window(tab1);
	
	
}
     
     
    		 
    		 
	}


