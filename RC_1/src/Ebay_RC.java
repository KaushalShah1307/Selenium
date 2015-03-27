import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;















import com.thoughtworks.selenium.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class Ebay_RC {

	public static void main(String[] args) throws InterruptedException, IOException {


		/*Selenium selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.forbes.com/");

		selenium.start();
		selenium.open("/");
		selenium.windowMaximize();
		selenium.windowFocus();

		//selenium.getTitle();

		System.out.println(selenium.getTitle());

		/* Using XPath we are assigning the username and password to the relevent fields based on thier XPath */

		/*selenium.type("//*[@id='Email']", "just4test12345@gmail.com");
		selenium.type("//*[@id='Passwd']", "qatest12");
		selenium.click("//*[@id='signIn']");
		/*String Actual = selenium.getText("//*[@id='errormsg_0_Passwd']");
		System.out.println(Actual);
		String Error = "The username o password you entered is incorrect. ?";

		Assert.assertEquals(Actual, Error);*/

		//selenium.captureScreenshot("C://users//kshah//Desktop//capture.png");

//			  System.out.println("/************************** Checking for FaceBook ***********************************/");
			  WebDriver driver = new FirefoxDriver();
//			  driver.get("http://www.forbes.com");
//			  driver.get("http://www.forbes.com/home_europe/");
//			  driver.get("http://www.forbes-falcon.com");
/*			  driver.get("http://www.forbes.com/home_europe/");
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    driver.findElement(By.linkText("Log in")).click();
			    driver.findElement(By.id("login_form_user_email")).click();
			    driver.findElement(By.id("login_form_user_email")).clear();
			    driver.findElement(By.id("login_form_user_email")).sendKeys("kshah@forbes.com");
			    driver.findElement(By.id("login_form_password")).clear();
			    driver.findElement(By.id("login_form_password")).sendKeys("forbes123");
			    driver.findElement(By.cssSelector("span.inner > span.label")).click();

			    String MemberName = "Kaushal Shah";
			    if(driver.findElement(By.cssSelector("div.currentuser")).getText().contains(MemberName)){
			    	System.out.println("Member Login is successful for : " +MemberName);
			    }else{
			    	String Errormsg = "The email/username and password you entered do not match. Please try again.";
			    	if(driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div[2]/div[2]/form/div/span[2]/ul/li")).getText().contains(Errormsg)){

			    		System.out.println("Member Login Is not Successful");
			    }
			    }
*/
			  //*********** Screen Shot Snippet **************///

/*			  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  try {
					  FileUtils.copyFile(scrFile, new File("C:\\users\\kshah\\Desktop\\new.png"));
			        } catch (IOException e) {
			            e.printStackTrace();
			        }

//			    new Select(driver.findElement(By.cssSelector("div.currentuser"))).selectByVisibleText("The email/username and password you entered do not match. Please try again.");




/*			    String Errormsg = "The email/username and password you entered do not match. Please try again.";
			    if(driver.findElement(By.cssSelector("div.main_error_msg")).getText().contains(Errormsg)) {
					   System.out.println(Errormsg +" Member Login is not successful");
					   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						  try {
							  FileUtils.copyFile(scrFile, new File("C:\\users\\kshah\\Desktop\\capture.png"));
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
					return;
					} else {
					System.out.println("Memeber Login is successful ");}*/


			  //FileUtils.copyFile(scrFile, new File("C:\\users\\kshah\\Desktop\\capture.png"));
			// Now you can do whatever you need to do with it, for example copy somewhere
			//FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
/*			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.get("http://www.forbes.com/sites/kitconews/2013/11/11/p-m-kitco-roundup-gold-modestly-lower-in-quiet-holiday-trading-bears-have-technical-edge/");
			  String Count1 = driver.findElement(By.xpath("//*[@id='gigya_share_counter_facebook']")).getText();
			  System.out.println("Initial Count is :" +Count1);
			  String master = driver.getWindowHandle();
			  driver.findElement(By.xpath("//*[@id='gigya_share_button_facebook']")).click();
			  int timeCount = 1;

			  do
			  {
			     driver.getWindowHandles();
			     Thread.sleep(200);
			     timeCount++;
			     if ( timeCount > 50 )
			     {
			         break;
			     }
			  }
			  while ( driver.getWindowHandles().size() == 1 );

			  //Assigning the handles to a set
			  Set<String> handles = driver.getWindowHandles();
			  //Switching to the popup window.
			  for ( String handle : handles )
			  {
			      if(!handle.equals(master))
			      {
			           driver.switchTo().window(handle);
			      }
			  }
			  driver.findElement(By.id("email")).clear();
			  driver.findElement(By.id("email")).sendKeys("forbesqatest@gmail.com");
			  driver.findElement(By.id("pass")).clear();
			  driver.findElement(By.id("pass")).sendKeys("forbes123");
			  driver.findElement(By.xpath("//*[@id='u_0_1']")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.findElement(By.xpath("//*[@id='u_0_1']")).click();
//			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			  driver.switchTo().window("master");
//			  driver.navigate().refresh();
			  driver.get("http://www.forbes.com/sites/kitconews/2013/11/11/p-m-kitco-roundup-gold-modestly-lower-in-quiet-holiday-trading-bears-have-technical-edge/");
			  String Count2= driver.findElement(By.xpath("//*[@id='gigya_share_counter_facebook']")).getText();
			  System.out.println("Final Count is :" +Count2);
			  if (Integer.parseInt(Count1) == Integer.parseInt(Count2)){
				  System.out.println("The Gigya Toolbaar for Facebook is not showing an increase in the shared value");
			  }
			  else {
				  System.out.println("The Gigya Toolbar for Facebook is showing the change after sharing the post");
			  }
*/
//			  System.out.println("/************************** Checking for Twitter **************************************/");
/*
			  driver.get("http://www.forbes.com");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.get("http://www.forbes.com/sites/michaelkanellos/2013/10/28/erecyclingcorps-gets-105-million-to-provide-carriers-refurbished-androids-iphones/");
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  String Count3 = driver.findElement(By.xpath("//*[@id='gigya_share_counter_twitter']")).getText();
			  System.out.println("Initial Tweet Count is :" +Count3);
			  String master1 = driver.getWindowHandle();
			  String link = "http://www.forbes.com/sites/michaelkanellos/2013/10/28/erecyclingcorps-gets-105-million-to-provide-carriers-refurbished-androids-iphones/";
			  driver.get("https://twitter.com/intent/tweet?original_referer=" + link + "&tw_p=tweetbutton&url=http%3A%2F%2Fonforb.es%2F17xAze6&via=forbes");
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  int timeCount2 = 1;

			  do
			  {
			     driver.getWindowHandles();
			     Thread.sleep(200);
			     timeCount2++;
			     if ( timeCount2 > 50 )
			     {
			         break;
			     }
			  }
			  while ( driver.getWindowHandles().size() == 1 );

			  //Assigning the handles to a set
			  Set<String> handles1 = driver.getWindowHandles();
			  //Switching to the popup window.
			  for ( String handless : handles1 )
			  {
			      if(!handless.equals(master1))
			      {
			           driver.switchTo().window(handless);
			      }
			  }
			  driver.findElement(By.id("username_or_email")).clear();
			  driver.findElement(By.id("username_or_email")).sendKeys("just4test12345@gmail.com");
			  driver.findElement(By.id("password")).clear();
			  driver.findElement(By.id("password")).sendKeys("qatest123");
			  driver.findElement(By.xpath("//input[@value='Sign in and Tweet']")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.switchTo().window(master1);
			  try {
				Thread.sleep(108000);
				} catch(InterruptedException e) {
				}
			  driver.get("http://www.forbes.com/sites/michaelkanellos/2013/10/28/erecyclingcorps-gets-105-million-to-provide-carriers-refurbished-androids-iphones/");
			  String Count4= driver.findElement(By.xpath("//*[@id='gigya_share_counter_twitter']")).getText();
			  System.out.println("Shared Tweet Count is :" +Count4);
			  if (Integer.parseInt(Count3) == Integer.parseInt(Count4)){
				  System.out.println("The Gigya Toolbaar for Twitter is not showing an increase in the shared value");
			  }
			  else {
				  System.out.println("The Gigya Toolbar for Twitter is showing the change after sharing the post");
			  }

*/
//			  System.out.println("/************************** Checking for LinkedIn **************************************/");
/*
			  driver.get("http://www.forbes.com");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.get("http://www.forbes.com/sites/halahtouryalai/2013/11/11/the-worlds-29-too-big-to-fail-banks-jpmorgan-at-the-top/");
			  String Count5 = driver.findElement(By.xpath("//*[@id='gigya_share_counter_linkedin']")).getText();
			  System.out.println("Initial Count is :" +Count5);
			  String master2 = driver.getWindowHandle();
			  driver.findElement(By.xpath("//*[@id='gigya_share_button_linkedin-reaction0-icon_img']")).click();
			  int timeCount3 = 1;

			  do
			  {
			     driver.getWindowHandles();
			     Thread.sleep(200);
			     timeCount3++;
			     if ( timeCount3 > 50 )
			     {
			         break;
			     }
			  }
			  while ( driver.getWindowHandles().size() == 1 );

			  //Assigning the handles to a set
			  Set<String> handles2 = driver.getWindowHandles();
			  //Switching to the popup window.
			  for ( String handle : handles2 )
			  {
			      if(!handle.equals(master2))
			      {
			           driver.switchTo().window(handle);
			      }
			  }
			  driver.findElement(By.linkText("Sign in")).click();
			  driver.findElement(By.id("session_key-login")).clear();
			  driver.findElement(By.id("session_key-login")).sendKeys("qaforbestest@gmail.com");
			  driver.findElement(By.id("session_password-login")).clear();
			  driver.findElement(By.id("session_password-login")).sendKeys("forbes123");
			  driver.findElement(By.xpath("//input[@id='btn-primary']")).click();
			  //Thread.sleep(108000);

			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  //driver.switchTo().window("master2");
			  driver.get("http://www.forbes.com/sites/halahtouryalai/2013/11/11/the-worlds-29-too-big-to-fail-banks-jpmorgan-at-the-top/");
			  driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			  String Count6= driver.findElement(By.xpath("//*[@id='gigya_share_counter_linkedin']")).getText();
			  System.out.println("Final Count is :" +Count6);
			  if (Integer.parseInt(Count5) == Integer.parseInt(Count6)){
				  System.out.println("The Gigya Toolbaar for LinkedIn is not showing an increase in the shared value");
			  }
			  else {
				  System.out.println("The Gigya Toolbar for LinkedIn is showing the change after sharing the post");
			  }
*/
			  //driver.get("http://graph.facebook.com/?id=http://www.forbes.com/sites/kitconews/2013/11/11/p-m-kitco-roundup-gold-modestly-lower-in-quiet-holiday-trading-bears-have-technical-edge/");
			  //String text = "shares";
			  //System.out.println(driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]")));
/*			  driver.get("http://urls.api.twitter.com/1/urls/count.json?url=http://www.forbes.com/sites/michaelkanellos/2013/10/28/erecyclingcorps-gets-105-million-to-provide-carriers-refurbished-androids-iphones/");
			  //driver.get("http://www.linkedin.com/countserv/count/share?url=http://www.forbes.com/sites/halahtouryalai/2013/11/11/the-worlds-29-too-big-to-fail-banks-jpmorgan-at-the-top/");
			  String s = driver.findElement(By.xpath("/html/body/pre")).getText();
			  System.out.println(s);
			  if(driver.getPageSource().contains("shares"))
			  {
			    System.out.println("Pass");
			  }
			else
			  {
			    System.out.println("Fail");
			  }
			  String s1 = driver.findElement(By.cssSelector("shares")).getText();
			  System.out.println(s1);

*/
			  //************************* Delete Social Account Feeds *****************************//
/*			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get("http://www.facebook.com");
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("//*[@id='email']")).clear();
			 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("forbesqatest@gmail.com");
			 driver.findElement(By.xpath("//*[@id='pass']")).clear();
			 driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("forbes123");
			 driver.findElement(By.xpath("//*[@id='u_0_e']")).click();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get("https://www.facebook.com/quality.assurance.3152");
			 driver.findElement(By.xpath("//*[@id='u_0_2k']")).click();
			 driver.findElement(By.xpath("/html/body/div/div[3]/div[4]/div/div/div/ul/li[8]/a/span")).click();
			 driver.findElement(By.xpath("/html/body/div[5]/div/div/div[7]/div/div[3]/div/label/input")).click();
			 driver.get("https://www.facebook.com/quality.assurance.3152");
			 driver.findElement(By.xpath("//*[@id='userNavigationLabel']")).click();
			 driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/ul/li[6]/div/div/ul/li[6]/form/label/input")).click();
			 //System.out.println("The FB Feed shared for the article : " + "link" + "has been deleted!!!");
			 System.out.println("Deleted!!");
*/

//			 System.out.println("//********************* Tweets Delete *********************//");
/*			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get("https://twitter.com/");
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("//*[@id='signin-email']")).clear();
			 driver.findElement(By.xpath("//*[@id='signin-email']")).sendKeys("forbesqatest@gmail.com");
			 driver.findElement(By.xpath("//*[@id='signin-password']")).clear();
			 driver.findElement(By.xpath("//*[@id='signin-password']")).sendKeys("forbes123");
			 driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/table/tbody/tr/td[2]/button")).click();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/ul/li/a")).click();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 driver.findElement(By.linkText("Delete")).click();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("/html/body/div[11]/div[2]/div[2]/div[3]/button[2]")).click();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("//*[@id='user-dropdown-toggle']")).click();
			 driver.findElement(By.xpath("//*[@id='signout-button']")).click();

*/

/*			 List<WebElement> link=driver.findElements(By.tagName("a"));

			 for(WebElement ele:link)
			 {
			      System.out.println(ele.getText());
			 }



/*			 List <WebElement> tableRow = driver.findElements(By.xpath("//*[@id='listbody']//tr"));
			 for (WebElement row : tableRow) {
				    WebElement key = row.findElement(By.xpath("./td[2]"));
				    String k = key.getText();
				    WebElement val = row.findElement(By.xpath("./td[5]"));
				    String v = val.getText();
				    System.out.println("For " +k+ " The Value is :" +v);
				    if(v != null){
				    	System.out.println("There is no NULL value for the Ticker");
				    }
				    else{
				    	System.out.println("There is a null value for : " +k);
				    }

				}

*/
			//  System.out.println("//*********** Mobile Testing ***************//");
		//WebDriver Idriver = new RemoteWebDriver(new URL("http://localhost:3001/wd/hub"), DesiredCapabilities.iphone());
		// or use the convenience class which uses localhost:3001 by default
//		WebDriver Idriver = new RemoteWebDriver (new URL("http://www.forbes.com"), DesiredCapabilities.iphone());
//		Idriver.get("http://www.forbes.com");
			driver.get("http://www.forbes.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://192.168.0.153/special-report/2014/30-under-30/finance.html");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String s = driver.findElement(By.cssSelector("div.featured_info")).getText();
			System.out.println("The Bio is: " +s);
			Pattern p = Pattern.compile("[^a-z0-9 .,;'&()-]", Pattern.CASE_INSENSITIVE);
//			Pattern p = Pattern.compile("/*!@#$%^&(){}_[]|\\?<>", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(s);
			//Matcher m = p.matcher("Hey this is special character I need to find");
			boolean b = m.find();

			if (b == true){
				   System.out.println("There is a special character in my string");
				}
				else{
				  System.out.println("No Special Character...Hurray!!");
				}

			



/*
//			String pagesrc1 = driver.findElement(By.id("bio")).getText();
			String pagesrc2 = driver.findElement(By.id("fulldesc")).getText();
//			System.out.println(pagesrc1 +" "+pagesrc2);
			System.out.println(pagesrc2);


*/







/*
			if (!driver.findElement(By.cssSelector("a#moredesc")).isDisplayed()){
				System.out.println("Hi I am not there!!");
			}

*/

/*			WebElement MoreBio = driver.findElement(By.id("moredesc"));
			if (MoreBio.isDisplayed()){
				MoreBio.click();
			}*/
//			if(driver.findElement(By.id("moredesc")).isDisplayed()){
/*			if(!driver.findElement(By.cssSelector("a#moredesc")).isDisplayed()){
				System.out.println("No More Description button available for this profile");
				//driver.findElement(By.id("moredesc")).click();
			}
			else{
				driver.findElement(By.id("moredesc")).click();
				//System.out.println("No More Description button available for this profile");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String Bio = driver.findElement(By.xpath("//*[@id='bio']")).getText();
			System.out.println("The Bio is : " +Bio);

			Pattern p = Pattern.compile("[^a-z0-9 .,;'&()-]", Pattern.CASE_INSENSITIVE);
//			Pattern p = Pattern.compile("/*!@#$%^&(){}_[]|\\?<>", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(Bio);
			//Matcher m = p.matcher("Hey this is special character I need to find");
			boolean b = m.find();

			if (b == true){
			   System.out.println("There is a special character in my string");
			}
			else{
			  System.out.println("No Special Character...Hurray!!");
			}

*/



	}

}












