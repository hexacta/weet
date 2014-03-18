package com.hexacta.weet.pages

import geb.Page

import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

/**
 * Abstract page which provides a generic behavior for any page that uses weet.
 * 
 * @author gmassenzano
 */
abstract class WeetPage extends Page {
	
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
	void avoidElementNotClickable(element) {
		Capabilities cp = driver.capabilities
		if (cp.browserName == "chrome") {
			try {
				driver.executeScript("arguments[0].scrollIntoView(true);", element)
			} catch (Exception e) {
				// Nothing to do.
			}
		}
	}

	/**
	 * It does a mouseover and a click on the received element.
	 * i.e. some menus items expand with a click and other with a mouseover. This method solves both cases.
	 * 
	 * @param element
	 */
	void mouseoverAndClick(element) {
		// TODO: revisar este workaround porque en algunas corridas sigue fallando con la excepcion "Element is not clickable at point"
		Actions actions = new Actions(driver)
		WebElement webElement = element.firstElement()
		actions.moveToElement(webElement)
		element.click()
		actions.clickAndHold(webElement)
		sleep(500)
		element.jquery.mouseover()
		sleep(500)  // To avoid "Element is not clickable at point" exception
		actions.release()
	}

}