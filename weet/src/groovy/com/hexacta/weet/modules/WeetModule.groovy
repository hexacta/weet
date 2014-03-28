package com.hexacta.weet.modules

import geb.Module

/**
 * Abstract module which provides a generic behavior for any page that uses weet.
 * 
 * @author gmassenzano
 */
class WeetModule extends Module {

	/**
	 * If the method is not defined in super, it is delegated on the corresponding page method.
	 */
	def methodMissing(String name, args) {
		try {
			super.methodMissing(name, args)
		} catch (MissingMethodException e) {
			page."$name"(*args)
		}
	}

}