package com.hexacta.webtester.modules

import geb.Module

/**
 * Represents a reusable fragment that can be used across pages that can be parameterized
 * 
 * @author gmassenzano
 */
class AbstractModule extends Module {

	void avoidElementNotClickable(element) {
		page.avoidElementNotClickable(element)
	}
	
	void mouseoverAndClick(element) {
		page.mouseoverAndClick(element)
	}
}