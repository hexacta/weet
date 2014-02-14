package com.hexacta.webtester.pages

import geb.Page

import org.openqa.selenium.Capabilities

abstract class AbstractPage extends Page {
	
	/**
	 * Workaround to avoid "element not clickable at point" bug for chromedriver.
	 *
	 * @see https://code.google.com/p/selenium/issues/detail?id=2766#c57
	 *
	 * TODO: update click method from RemoteWebElement metaclass, and call this method.
	 *
	 * @param element
	 * 		A clickable element.
	 */
	def avoidElementNotClickable(element) {
		Capabilities cp = driver.capabilities
		if (cp.browserName == "chrome") {
			try {
				driver.executeScript("arguments[0].scrollIntoView(true);", element)
			} catch (Exception e) {
				// Nothing to do.
			}
		}
	}

}