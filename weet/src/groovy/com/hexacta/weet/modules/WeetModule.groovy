package com.hexacta.weet.modules

import geb.Module

/**
 * Abstract module which provides a generic behavior for any page that uses weet.
 * 
 * @author gmassenzano
 */
class WeetModule extends Module {

	/**
	 * Delegates on the corresponding page method.
	 * 
	 * @param element
	 * @see WeetPage.avoidElementNotClickable(element)
	 */
	void avoidElementNotClickable(element) {
		page.avoidElementNotClickable(element)
	}
	
	/**
	 * Delegates on the corresponding page method.
	 * 
	 * @param element
	 * @see WeetPage.mouseoverAndClick(element)
	 */
	void mouseoverAndClick(element) {
		page.mouseoverAndClick(element)
	}
}