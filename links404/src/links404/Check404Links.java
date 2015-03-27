package links404;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Check404Links {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");

		WebDriver driver = new ChromeDriver(options);

		String path = "C:/Users/kshah/KShah/Forbes Links/Japan2015.txt";
		// Open the file
		FileInputStream fstream = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		while ((strLine = br.readLine()) != null)   {

		driver.get(strLine);
		
		if(strLine!=null){
            if(!isLink(strLine)){
                continue;
            }
            verifyLinkActive(strLine);
        }
    }
}

    public static boolean isLink(String link){
  	  //Change the Link container based on what URL you are looking for//
        return link.contains("http://") && !link.contains("mailto") && !link.contains("[URI]");
    }

     public static void verifyLinkActive(String linkUrl){
        try {
           URL url = new URL(linkUrl);
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           httpURLConnect.setConnectTimeout(3000);
           httpURLConnect.connect();
           if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()
                       + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
//           else{
//          	 System.out.println(linkUrl+" - Link is redirecting to the correct URL");
//           }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
     
	}


