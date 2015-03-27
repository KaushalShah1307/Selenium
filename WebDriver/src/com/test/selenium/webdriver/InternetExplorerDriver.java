package com.test.selenium.webdriver;

public class InternetExplorerDriver implements WebDriver {

	@Override
	public void click(String locator) {

		System.out.println("Clicked on an element in IE : " +locator);
	}

	@Override
	public void sendkeys(String locator, String element) {

		System.out.println("Tyed in an element in IE : "+locator+ "Value entered is : " +element);
	}

}
