package com.hexacta.weet.modules

import geb.Module

/**
 * Abstract module which provides a generic behavior for any page that uses weet.
 * 
 * @author gmassenzano
 */
class WeetModule extends Module {

	void avoidElementNotClickable(element) {
		page.avoidElementNotClickable(element)
	}
	
	void mouseoverAndClick(element) {
		page.mouseoverAndClick(element)
	}
}