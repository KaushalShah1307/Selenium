import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class clicklinks {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-web-security");
		options.addArguments("--user-agent=Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3");

		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.forbes.com/");
		driver.navigate().to("http://www-staging-3.forbes.com/forbes-400/list/");
//		driver.findElement(By.cssSelector("span.load_more_label")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		List<String> hrefs = new ArrayList<String>();
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		for ( WebElement anchor : anchors ) {
		    hrefs.add(anchor.getAttribute("href"));
		}
		for ( String href : hrefs ) {
		    driver.get(href);
		    System.out.println(href);
		}
		driver.quit();

	}


}
