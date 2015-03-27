package com.qatest.kshah.morning.report;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.forbes.test.selenium.seleniumDaily.PerformTest;
import com.thoughtworks.selenium.Selenium;

public class QAReport {

	public static void main(String[] args) {
		private static final Logger logger = LoggerFactory.getLogger(PerformTest.class);

		WebDriver driver = null;

		Selenium selenium = null;

		@Test
		public void initDriver() {
			try {

				driver = new FirefoxDriver();

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				selenium = new WebDriverBackedSelenium(driver, "http://www.forbes.com");

//				function = new Functions();

			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		}

		public void initDriverChrome() {
			try {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

				driver = new ChromeDriver();

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				selenium = new WebDriverBackedSelenium(driver, "http://www.forbes.com");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		}

		public void initDriverChromeLog() {
			try {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

				 ChromeOptions options = new ChromeOptions();
				 options.addArguments("--enable-logging","--INFO=1");
				 // For use with ChromeDriver:
				 driver = new ChromeDriver(options);

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				selenium = new WebDriverBackedSelenium(driver, "http://www.forbes.com");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		}

		public void initDriverIE() {
			try {

				System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer (2).exe");

				driver = new InternetExplorerDriver();

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				selenium = new WebDriverBackedSelenium(driver, "http://www.forbes.com");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		}

		public void outputLog() {
			try {
				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd...HH.mm.ss");
				Date date = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				String sdf = dateFormat.format(date);
				System.out.println(sdf);
				String year = "" +cal.get(Calendar.YEAR);
				String month = "" +(cal.get(Calendar.MONTH)+1);
				System.out.println(year);
				System.out.println(month);
				if(month.length()<2) {
					month = "0"+month;
				}
				String day = "" +cal.get(Calendar.DAY_OF_MONTH);
				if(day.length()<2){
					day = "0"+day;
				}
				System.out.println(year+month+day);

				boolean success = (new File(path+"/Test_Results/"+year+"/"+month+"/"+day)).mkdirs();

				System.out.println(path+"/Test_Results/"+year+"/"+month+"/"+day);
				if (!success) {
				    System.out.println("Folder already There");
				} else {
					System.out.println("Success");
				}

				PrintStream out = new PrintStream(new FileOutputStream(path+"/Test_Results/"+year+"/"+month+"/"+day+"/output_log_"+sdf+".txt"));
				System.setOut(out);
				System.setErr(out);
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}

			String testName;
			int error;
			List<String> errorList = new ArrayList<String>();
			List<String> errorListCompiled = new ArrayList<String>();
			List<String> resultList = new ArrayList<String>();
			Set<String> sitesVisited = new HashSet<String>();
			String path = System.getProperty("user.home")+"/Selenium";
			String resultString = "[ERROR COMPILATION]: ";

			int JQueryCounter= 0;

			@Test
			public void test(boolean condition, String messageSuccess, String messageFailure) {
				if (condition) {
					logger.debug("SUCCESS: " +messageSuccess);
				} else {
					String msg = driver.getCurrentUrl()+": FAILURE: " +messageFailure;
					if (testName !=null && msg!= null) {
						logger.debug(msg);
			//			errorArray[Error] = messageFailure;
						errorList.add("	"+testName + ":"+ msg);
						errorListCompiled.add(testName+ ":"+ msg);
						resultString = resultString + testName+ ":"+ msg+" , ";
						error++;
					}
					else {
						System.out.println("NAME THE TEST");
					}
				}

				System.out.println(resultString);

	}

}
