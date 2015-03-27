package DCS.AutomationFramework;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.google.common.reflect.TypeToken;
//import com.google.gson.Gson;
//import com.google.gson.reflect.*;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.SeleniumServer;
public class SeleniumTrafficAnalyzer  {

	public Collection<HTMLRequestFromSelenium> seleniumRequests;
	static SeleniumServer srvr;
	static Selenium selenium1;

	//_________________________________________________________________________________________________
	public static void AnalyzeTraffic(WebDriver driver) throws Exception
	{
		try
		{
			srvr = new SeleniumServer();
			srvr.start();
			// Create a Selenium Session with captureNetworkTraffic ready
			String site = driver.getCurrentUrl()+"/";
			selenium1 = new DefaultSelenium("localhost", 4444, "*firefox", site);
			selenium1.start("captureNetworkTraffic=true");
			// open a page to get the traffic
			selenium1.open("/");
			selenium1.waitForPageToLoad("60000");
			// dump the traffic into a variable in Json format
			String trafficOutput = selenium1.captureNetworkTraffic("json");
			//System.out.println(trafficOutput);

			// parse the json using Gson
			Gson gson = new Gson();
			Type collectionOfHTMLRequestsType =
			new TypeToken<Collection<HTMLRequestFromSelenium>>(){}.getType();
			Collection<HTMLRequestFromSelenium> seleniumRequests =
			gson.fromJson(trafficOutput, collectionOfHTMLRequestsType);

			// get ready to analyse the traffic
			//TrafficAnalyser ta = new TrafficAnalyser(seleniumRequests);
			TrafficAnalyser ta = new TrafficAnalyser(seleniumRequests);
			// this is pretty much copied from Corey's python example
			int num_requests = ta.get_num_requests();
			int total_size = ta.get_content_size();
			HashMap<Integer,Integer> status_map = ta.get_http_status_codes();
			HashMap<String, Object[]> file_extension_map = ta.get_file_extension_stats();
		    System.out.println("\n\n--------------------------------");
		    System.out.println("Traffic Results for this URL: "+site);
		    System.out.println(String.format("content size: %d kb",total_size));
		    System.out.println(String.format("http requests: %d",num_requests));
		    Iterator<Integer> statusIterator = status_map.keySet().iterator() ;
		    while ( statusIterator.hasNext (  )  )
		    {
		    	int key = statusIterator.next();
		    	System.out.println(String.format("status %d: %d", key, status_map.get(key)));
		    }
		    System.out.println("\nfile extensions: (count, size)");
		    Iterator<String> extensionIterator = file_extension_map.keySet().iterator() ;
		    while ( extensionIterator.hasNext (  )  )
		    {
		    	String key = extensionIterator.next();
		    	System.out.println(String.format("%s: %d, %f", key,
				file_extension_map.get(key)[0],file_extension_map.get(key)[1]));
		    }
		    System.out.println("\nhttp timing detail: (status, method, url, size(bytes), time(ms))");
			for (Iterator iterator = seleniumRequests.iterator(); iterator.hasNext();)
			{
				HTMLRequestFromSelenium hr = (HTMLRequestFromSelenium) iterator.next();
				//totalContentSize += hr.bytes;
				if (hr.statusCode!=200 && hr.statusCode!=301 && hr.statusCode!=302 && (!hr.url.contains("favicon")))
				{
				    System.out.println(String.format("%d, %s, %s, %d, %d",
					hr.statusCode, hr.method, hr.url, hr.bytes, hr.timeInMillis));
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//selenium1.close();
			//selenium1.stop();
			srvr.stop();
		}
	}//end function AnalyzeTraffic
}
