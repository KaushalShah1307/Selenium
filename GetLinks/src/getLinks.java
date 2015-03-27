import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class getLinks {

	public static void main(String[] args) throws Exception {
		
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-web-security");
		
				WebDriver driver = new ChromeDriver(options);
				
				driver.get("http://www-staging-2.forbes.com/");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.navigate().to("http://www.forbes.com/video/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				List<WebElement> ele=driver.findElements(By.tagName("a"));
			     for(int i=0;i<ele.size();i++) {
			     int statusCode=0;
			     try{
			     statusCode=getResponseCode(ele.get(i).getAttribute("href"));
			     System.out.println(ele.get(i).getAttribute("href"));
			     }catch(Exception e)
			     {
			     e.printStackTrace();
			     }
			     if(statusCode==404) {
			     System.out.println("INVALIDLINKS :->  "+ele.get(i).getAttribute("href"));
			     }
			       }
			    }
				public static int getResponseCode(String urlString) throws IOException{
			    URL u = new URL(urlString);
			    HttpURLConnection h =  (HttpURLConnection)  u.openConnection();
			    h.setRequestMethod("GET");
			    h.connect();
			    return h.getResponseCode();
		    }

	}

