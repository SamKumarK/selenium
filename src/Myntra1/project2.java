package Myntra1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.io.FileHandler;


public class project2 {


	static int count=0;


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAM\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.google.com");
		driver.get("https://www.myntra.com/");

		driver.navigate().to("https://www.myntra.com");
		driver.manage().window().maximize();


		driver.get("https://www.myntra.com/puma-bags?extra_search_param=isautosuggestentry%3atrue%3a%3aid%3a2297-puma-bags");

		driver.findElement(By.cssSelector("#desktop-header-cnt > div.desktop-bound > nav > div > div:nth-child(1) > div > a")).click();



		driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);

		driver.get("https://www.myntra.com/");
		Thread.sleep(3000);

		WebElement men=driver.findElement(By.xpath("//*[@id=\"desktop-headerMount\"]"));
		Actions action=new Actions(driver);
		action.moveToElement(men).perform();
		WebElement var=driver.findElement(By.cssSelector("#desktop-header-cnt > div.desktop-bound > nav > div > div:nth-child(1) > div > a"));


		WebDriverWait  wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mountRoot\"]/div/div/div/main/div[2]/div[1]/div[2]/div/div[1]")));



		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,1000)","");
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-1000)","");
		driver.findElement(By.cssSelector("#desktopSearchResults > div.search-searchProductsContainer.row-base > section > ul > li:nth-child(1) > a > div.product-imageSliderContainer > div")).click();



		java.util.Set<String> handles= driver.getWindowHandles();
		String winHandle1=driver.getWindowHandle();
		handles.remove(winHandle1);
		String winHandle=handles.iterator().next();
		String winHandle2="";
		if(winHandle!=winHandle1)
		{
			winHandle2=winHandle;
			driver.switchTo().window(winHandle2);
			System.out.println(winHandle2);
			String currentPage1=driver.getCurrentUrl();
			System.out.println(currentPage1);

		}

	}

	public static void Screen1(WebDriver driver) throws IOException 
	{
		TakesScreenshot SS=(TakesScreenshot)driver;
		File source=SS.getScreenshotAs(OutputType.FILE);

		String Filepath="./ScreenShot"+count+".png";
		FileHandler.copy(source,new File(Filepath));
		count++;

	}

}
















