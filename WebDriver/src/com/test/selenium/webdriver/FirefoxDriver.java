package com.test.selenium.webdriver;

public class FirefoxDriver implements WebDriver {

	@Override
	public void click(String locator) {

		System.out.println("Clicked on an element in FireFox : " +locator);
	}

	@Override
	public void sendkeys(String locator, String element) {

		System.out.println("Tyed in an element in FireFox : "+locator+ "Value entered is : " +element);
	}

}
