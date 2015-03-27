import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AndroidEmulator {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");

		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.forbes.com/");
		driver.navigate().to("http://www.forbes.com/most-popular/");
//		driver.navigate().to("http://www.forbes.com/most-popular/?view=mobile-a");
		  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		String stored_report = driver.getPageSource();
		System.out.println(stored_report);

/* 		Object response = ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerHTML;");
		String stored_report = (String) response;
		System.out.println(stored_report);
*/

		File f = new File("C:/Users/KShah/Desktop/PageSource/" + "DesktopReport" +new Date().getDate()+"_"+new Date().getHours()+"_" +new Date().getMinutes()+".html");
//		File f = new File("C:/Users/KShah/Desktop/PageSource/" + "MobileReport" +new Date().getDate()+"_"+new Date().getHours()+"_" +new Date().getMinutes()+".html");
		FileWriter writer = new FileWriter(f,true);
		writer.write(stored_report);
		System.out.println("Report Created is in Location : " + f.getAbsolutePath());
		writer.close();
		driver.close();
	}
}
