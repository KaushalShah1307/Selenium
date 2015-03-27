import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrokenImages {

	public static void main(String[] args) throws ClientProtocolException, IOException {

//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new SafariDriver();
//		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");

		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.forbes.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.forbes.com/");
//		driver.navigate().to("http://www.forbes.com/sites/johnwasik/2014/02/05/figuring-your-retirement-income-in-four-steps/");
		driver.navigate().to("http://www-staging-3.forbes.com/forbes-400/list/");

//		driver.findElement(By.cssSelector("div.avatars"));

		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		for (WebElement image : imagesList)
		{
			String Link = image.getAttribute("src");
		    HttpResponse response = new DefaultHttpClient().execute(new HttpGet(image.getAttribute("src")));
		    if (response.getStatusLine().getStatusCode() != 200){
		    	 System.out.println(Link+" - Link has a broken image");
              }
             else{
            	 System.out.println(Link+" - is fine!");

		    }

		}

		driver.quit();
//		driver.close();
	}

}



