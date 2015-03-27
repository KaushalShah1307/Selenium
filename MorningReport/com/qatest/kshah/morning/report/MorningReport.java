package com.qatest.kshah.morning.report;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.forbes.test.selenium.seleniumDaily.PerformTest;
import com.forbes.test.selenium.seleniumDaily.SeleniumDaily;
import com.thoughtworks.selenium.SeleniumException;

public class MorningReport {
	private static final Logger logger = LoggerFactory.getLogger(MorningReport.class);

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MorningReport test = context.getBean(MorningReport.class);
		test.runTestUntilSuccess();
	}

	String errorMessage = "";
	public boolean testErrored() {
		boolean success = false;
		QAReport test = new QAReport();
		try {
			tests();
			success = true;
		} catch(UnreachableBrowserException ex) {
			logger.error(ex.getMessage(), ex);
			test.driver.quit();
			errorMessage= errorMessage + ex.getMessage();
		}catch(SeleniumException timedOut) {
			logger.error(timedOut.getMessage(), timedOut);
			test.driver.quit();
			errorMessage= errorMessage + timedOut.getMessage();
		}
		return success;
	}

	public void runTestUntilSuccess() {
		int numberOfTries = 5;
		QAReport test = new QAReport();
		while(!testErrored() && numberOfTries > 0) {
			numberOfTries--;
		}
		if (numberOfTries == 0) {
//			test.sendEmail("jjean@forbes.com","pyu@forbes.com","kshah@forbes.com", "Test did not Complete", errorMessage, "jjean@forbes.com");
		}
	}

	public void tests() {

		testit();
	}

	public void testit(){

	}

}
