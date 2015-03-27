import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.safari.SafariDriver;

import com.opera.core.systems.OperaDriver;


public class RealTimeNumbers {

	public static void main(String[] args) throws IOException {

//		WebDriver driver = new FirefoxDriver();



//		WebDriver driver = new OperaDriver();
		WebDriver driver = new SafariDriver();

/*		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();*/
		driver.get("http://www.forbes.com/");
		driver.navigate().to("http://www.forbes.com/real-time/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String test = driver.findElement(By.cssSelector("li.stream_item>div.item_wrapper>h6.postMeta>i")).getText();
		System.out.println(test);

		String s = driver.findElement(By.cssSelector("div.stream_contents>ul>li")).getAttribute("data-timestamp");
		System.out.println(s);

		java.util.Date date= new java.util.Date();
		System.out.println(new Timestamp(date.getTime()));

		// Collects no of POSTS from the page and the page source and compares to see if they are same or not
		System.out.println("//******************** POSTS ********************* //");
		String Posts = driver.findElement(By.cssSelector("dt.totalPosts>strong")).getText();
		System.out.println("The No. of Posts visible on the page : " +Posts);

		String p1 = driver.findElement(By.cssSelector("dt.totalPosts>strong")).getAttribute("data-init-value");
		System.out.println("The No. of Posts getting called from the page source : " +p1);

		if(Posts!=p1){
			System.out.println("Real Time page is showing the correct no of Posts");
		}
		else{
			System.out.println("The value for the Posts on Real Time page is not showing the right count");
		}

		// Collects no of COMMENTS from the page and the page source and compares to see if they are same or not
		System.out.println("//******************** COMMENTS ********************* //");
		String Comm = driver.findElement(By.cssSelector("dt.totalComments>strong")).getText();
		System.out.println("The No. of Comments visible on the page : " +Comm);

		String c1 = driver.findElement(By.cssSelector("dt.totalComments>strong")).getAttribute("data-init-value");
		System.out.println("The No. of Comments getting called from the page source : " +c1);

		if(Comm!=c1){
			 System.out.println("Real Time page is showing the correct no of Comments");
		}
		else{
			 System.out.println("The value for the Comments on Real Time page is not showing the right count");
		}

		// Collects no of SHARES from the page and the page source and compares to see if they are same or not
		System.out.println("//******************** SHARES ********************* //");
		String Shares = driver.findElement(By.cssSelector("dt.totalShares>strong")).getText();
		System.out.println("The No. of Shares visible on the page : " +Shares);

		String shares1 = driver.findElement(By.cssSelector("dt.totalShares>strong")).getAttribute("data-init-value");
		System.out.println("The No. of Shares getting called from the page source : " +shares1);

		if(Shares!=shares1){
			 System.out.println("Real Time page is showing the correct no of Shares");
		}
		else{
			 System.out.println("The value for the Shares on Real Time page is not showing the right count");
		}

/*		driver.get("www-staging-3.forbes.com/singapore-billionaires/?view=mobile-a");
		WebElement pages = driver.findElement(By.id("vp_pages"));
		TouchActions flick = new TouchActions(driver).flick(pages, -100, 0, 0);
		flick.perform();*/

		driver.get("http://www-staging.forbes.com/billionaires/list/");
		// get the text of the body element
		WebElement body = driver.findElement(By.tagName("body"));
		String bodyText = body.getText();

		// count occurrences of the string
		int count = 0;

		// search for the String within the text
		while (bodyText.contains("Bill Gates")){

		    // when match is found, increment the count
		    count++;

		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");

//		    Actions actions = new Actions(driver);
//		    actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

		    // continue searching from where you left off
		    bodyText = bodyText.substring(bodyText.indexOf("Bill Gates") + "Bill Gates".length());
		    System.out.println("This line on the page has the word you looking for: " +bodyText);
		}

			driver.get("http://api.forbes.com/forbesapi/content/all.json?");
			









	}


}




