import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class mysandbox {

	public static void main(String[] args) throws IOException, IOException {

		String path = "C:/Users/KShah/Forbes Links/ChannelSec.txt";
		// Open the file
		FileInputStream fstream = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		{
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
//		  System.out.println (strLine);
			URL url = new URL(strLine);
		    HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		    httpURLConnect.setConnectTimeout(3000);
		    httpURLConnect.connect();
		    if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
		        System.out.println(strLine+" - "+httpURLConnect.getResponseMessage()
		                + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
		     }
		    /*else{
		   	 System.out.println(strLine+" - Link is redirecting to the correct URL");
		    }*/
		}

		//Close the input stream
		br.close();

		System.out.println(" ");
		System.out.println("/********* HTTP response check is completed for the file contents!! *********/");


		}

	}


}
