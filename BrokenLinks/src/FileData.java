import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FileData {

	public static void main(String[] args) throws IOException {
		
		String file_name = "C:/Users/KShah/Documents/companies.txt";
		
		try{
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			
			int i;
			for (i=0; i<aryLines.length; i++){
				//System.out.println(aryLines[i]);
				WebDriver driver = new FirefoxDriver();
				//driver.get("http://www.forbes.com/");
				
				String s = aryLines[i];
				driver.get(s);
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.navigate().to(s);
				  List<WebElement> linksList = driver.findElements(By.tagName("a"));
			      for(WebElement linkElement: linksList){
			          String link =linkElement.getAttribute("href");
			          if(link!=null){
			              if(!isLink(link)){
			                  continue;
			              }
			              verifyLinkActive(link);
			          }
			          
			          
			}
			
//			String s = aryLines[i];
		}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		

	}

	private static void verifyLinkActive(String linkUrl) {

		 try {
             URL url = new URL(linkUrl);
             HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
             httpURLConnect.setConnectTimeout(3000);
             httpURLConnect.connect();
             if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
                 System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()
                         + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
              }
             else{
            	 System.out.println(linkUrl+" - Link is not a 404!");
             }
          } catch (MalformedURLException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
		
	}

	private static boolean isLink(String link) {
		return link.contains("http://") && !link.contains("mailto");
	}

}


