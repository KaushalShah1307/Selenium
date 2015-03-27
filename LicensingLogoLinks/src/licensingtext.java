import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class licensingtext {

	public static void main(String[] args) {

		// Setup the browser driver to be used
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-web-security");

				WebDriver driver = new ChromeDriver(options);
				
				// Go to the correct domain
				driver.get("http://www.forbes.com");
				driver.navigate().to("http://www-staging.forbes.com/largest-private-companies/");
				
/*				String path = "C:/Users/KShah/Forbes Links/morningstarpeopleuris.txt";
				// Open the file
				FileInputStream fstream = new FileInputStream(path);
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

				String strLine;

				while ((strLine = br.readLine()) != null)   {

				driver.get(strLine);*/
				
//				boolean check = driver.getPageSource().contains("//rt.liftdna.com/apibidder.js"); // check parameter accepts the JS file that we are looking for within the page-source
				String searchfor = "Logo Licensing";
				boolean check = driver.getPageSource().contains(searchfor);
				System.out.println(check + " - The text exists in the page source of the link - "); // Output is returned in a boolean format
				
				

	}

}
