import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Sandbox {

	public static void main(String[] args) {

		WebDriver driver = new SafariDriver();
//		WebDriver driver = new ChromeDriver();
		driver.get("www-staging-3.forbes.com");
		driver.navigate().to("www-staging-3.forbes.com/taiwan-billionaires/?view=mobile-a");





	}

}
