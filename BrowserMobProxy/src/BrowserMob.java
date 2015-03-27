import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.browsermob.core.har.Har;
import org.browsermob.proxy.ProxyServer;
import org.browsermob.proxy.jetty.http.EOFException;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserMob {

	public static void main(String[] args) throws Exception, EOFException, IOException{

		String strFilePath = "C:/Users/KShah/Development/HAR/HARfiles.har";

		// start the proxy
	    ProxyServer server = new ProxyServer(4444);
	    server.start();
	    //captures the mouse movements and navigations
	    server.setCaptureHeaders(true);
        server.setCaptureContent(true);

	    // get the Selenium proxy object
	    Proxy proxy = server.seleniumProxy();

	    // configure it as a desired capability
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.PROXY, proxy);

	    // start the browser up
//	    WebDriver driver = new FirefoxDriver(capabilities);
//	    WebDriver driver = new SafariDriver(capabilities);
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver(capabilities);


	    // create a new HAR with the label "apple.com"
	    server.newHar("assertselenium.com");

	    // open yahoo.com
	    driver.get("http://www.google.com");

//	    driver.get("http://www.forbes.com/real-time/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    // get the HAR data
        Har har = server.getHar();
        FileOutputStream fos = new FileOutputStream(strFilePath);
        har.writeTo(fos);
        server.stop();
		driver.quit();

	}


	}


