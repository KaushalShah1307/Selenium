import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PopUpWindows {

	public static void main(String[] args) {
		
		WebDriver driver= new FirefoxDriver(); 
//		ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.forbes.com/");
        driver.get("http://www.forbes.com/sites/kitconews/2013/11/11/p-m-kitco-roundup-gold-modestly-lower-in-quiet-holiday-trading-bears-have-technical-edge/");
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String Count1 = driver.findElement(By.xpath("//*[@id='gigya_share_counter_facebook']")).getText();
		System.out.println("Initial Count is :" +Count1);
		
/*        WebElement sign = driver.findElement(By.xpath("//*[@id='gigya_share_button_facebook']"));
        sign.click();

        Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
        Iterator<String> itererator = windowId.iterator();   

        String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();

        driver.switchTo().window(newAdwinID);
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.close();
        driver.findElement(By.id("email")).clear();
		  driver.findElement(By.id("email")).sendKeys("forbesqatest@gmail.com");
		  driver.findElement(By.id("pass")).clear();
		  driver.findElement(By.id("pass")).sendKeys("forbes123");
		  driver.findElement(By.xpath("//*[@id='u_0_1']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id='u_0_1']")).click();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().window(mainWinID);
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get("http://www.forbes.com/sites/kitconews/2013/11/11/p-m-kitco-roundup-gold-modestly-lower-in-quiet-holiday-trading-bears-have-technical-edge/");
        
		  String Count2= driver.findElement(By.xpath("//*[@id='gigya_share_counter_facebook']")).getText();
		  System.out.println("Final Count is :" +Count2);
		  if (Integer.parseInt(Count1) == Integer.parseInt(Count2)){
			  System.out.println("The Gigya Toolbaar for Facebook is not showing an increase in the shared value");
		  }
		  else {
			  System.out.println("The Gigya Toolbar for Facebook is showing the change after sharing the post");
		  }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.close();
        driver.quit();
*/
		String master = driver.getWindowHandle();
		  driver.findElement(By.xpath("//*[@id='gigya_share_button_facebook']")).click();
		  int timeCount = 1;

		  do
		  {
		     driver.getWindowHandles();
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		     Thread.sleep(200);
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
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
//		  driver.get("http://www.forbes.com/sites/kitconews/2013/11/11/p-m-kitco-roundup-gold-modestly-lower-in-quiet-holiday-trading-bears-have-technical-edge/");
		  String Count2= driver.findElement(By.xpath("//*[@id='gigya_share_counter_facebook']")).getText();
		  System.out.println("Final Count is :" +Count2);
		  if (Integer.parseInt(Count1) == Integer.parseInt(Count2)){
			  System.out.println("The Gigya Toolbaar for Facebook is not showing an increase in the shared value");
		  }
		  else {
			  System.out.println("The Gigya Toolbar for Facebook is showing the change after sharing the post");
		  }

      driver.close();
      driver.quit();
	}

}
