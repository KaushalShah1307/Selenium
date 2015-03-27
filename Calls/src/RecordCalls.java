import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.server.ProxyHandler;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;


public class RecordCalls {

	public static void main(String[] args) throws Exception {


		SeleniumServer srvr = new SeleniumServer();
		srvr.start();

		String site = "http://www.forbes.com/real-time/";

		DefaultSelenium selenium = new DefaultSelenium("localhost", 4444, "/// Initiate browser here ///", site);
		  selenium.start("captureNetworkTraffic=true");
//		  selenium.getText("sc-forbes.forbes.com");

		  selenium.open(site);

		  String trafficOutput = selenium.captureNetworkTraffic("xml");
//		  selenium.getText("sc-forbes.forbes.com");

		  System.out.println(trafficOutput);


	}

}
