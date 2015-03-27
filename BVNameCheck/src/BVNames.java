import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BVNames {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");

		WebDriver driver = new ChromeDriver(options);

		String path = "C:/Users/kshah/KShah/Forbes Links/BVTest.txt";
		// Open the file
		FileInputStream fstream = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		while ((strLine = br.readLine()) != null)   {

		driver.get(strLine);
/*		Object response = ((JavascriptExecutor) driver)
		        .executeScript("return document.documentElement.innerHTML;");
		String source = (String) response;*/
//		System.out.println(source);

//		boolean check = driver.getPageSource().contains("//rt.liftdna.com/apibidder.js"); // check parameter accepts the JS file that we are looking for within the page-source
//		boolean check = driver.getPageSource().contains("At a Glance");
		String BVName = driver.findElement(By.cssSelector("div.content-block.wide>h3>span.ng-binding.ng-scope")).getText();
		if (BVName.isEmpty()){
			System.out.println(strLine + " - Missing BV Name in front of Voice");
		}
		else{
			System.out.println("It`s fine");
		}
/*		String check1 = driver.findElement(By.cssSelector("div.ataglanz.fleft")).getText();
		if(check1.isEmpty()){
			System.out.println("This is correct");
		}
		else{
			System.out.println("This is not correct");
		}*/
//		System.out.println(check + " - The text exists in the page source of the link - " +strLine); // Output is returned in a boolean format

//		PrintStream out = new PrintStream(new FileOutputStream("C:/Users/KShah/Forbes Links/testoutputs.txt"));
//		System.setOut(out);

	}
		driver.close();


	}

}
