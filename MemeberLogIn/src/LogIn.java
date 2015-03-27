import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.testing.Assert;

import java.util.regex.Pattern;


public class LogIn {

		@Before
		public void setUp() throws Exception {
			Selenium LogIn = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.forbes.com/");
			LogIn.start();
		}

		//@Test
		public void testUntitled() throws Exception {
			LogIn.open("/fdc/welcome_mjx.shtml");
			LogIn.click("link=Continue to Site »");
			LogIn.click("link=Log in");
			LogIn.click("id=login_form_user_email");
			LogIn.waitForPopUp("", "30000");
			LogIn.click("id=login_form_user_email");
			LogIn.type("id=login_form_user_email", "kshah@forbes.com");
			LogIn.click("css=span.inner > span.label");
		}

		@After
		public void tearDown() throws Exception {
			LogIn.stop();
		}

		private static void stop() {
			// TODO Auto-generated method stub

		}

		private static void type(String string, String string2) {
			// TODO Auto-generated method stub

		}

		private static void waitForPopUp(String string, String string2) {
			// TODO Auto-generated method stub

		}

		private static void click(String string) {


		}

		private static void open(String string) {
			// TODO Auto-generated method stub

		}



	}

