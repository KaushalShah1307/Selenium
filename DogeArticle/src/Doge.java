import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Doge {

	public static void main(String[] args) {
		
		// Setup the browser driver to be used
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");

		WebDriver driver = new ChromeDriver(options);
		
		// Go to the correct domain
		driver.get("http://www.forbes.com");
		driver.navigate().to("http://www-staging-4.forbes.com/sites/robertwood/2015/01/22/10-surprising-items-irs-says-to-report-on-your-taxes/?view=doge");
	    driver.findElement(By.xpath("//div[@id='article-page']/div/header/ul/li[3]/i[2]")).click();
	    driver.findElement(By.name("q")).click();
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("apple");
	    driver.findElement(By.cssSelector("span.label.ng-binding")).sendKeys(Keys.RETURN);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String search = driver.getCurrentUrl();
		if (search!="0"){
			System.out.println("Search Functionality fails on this page!");
		}
		else{
			System.out.println("Search functionality is working fine on this page!");
		}
		
	}

}
