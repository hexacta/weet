package com.hexacta.webtester.modules

import geb.Module

/**
 * Represents a reusable fragment that can be used across pages that can be parameterized
 * 
 * @author gmassenzano
 */
class AbstractModule extends Module {

	def avoidElementNotClickable(element) {
		page.avoidElementNotClickable(element)
	} 
}