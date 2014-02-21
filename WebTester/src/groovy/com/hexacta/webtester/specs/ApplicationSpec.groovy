package com.hexacta.webtester.specs

import spock.lang.*

import com.hexacta.webtester.pages.AbstractPage
import com.hexacta.webtester.pages.LoginPage

/**
 * Common spec for any web application which starts with a user session login.
 *  
 * @author gmassenzano
 */
abstract class ApplicationSpec extends AbstractSpec {

	boolean initialLogin = true
	@Shared String username = "admin"
	@Shared String password = "admin"
	
	/**
	 * Logs in before any spec method is executed.
	 */
	def setup() {
		waitFor { to loginPage }
		if (initialLogin) {
			given:
			login username, password
	
			then: "Redirects to an initial page"
			waitFor { at initialPage }
		}
	}

	def cleanup() {
		logout()
	}

	/**
	 * Returns the class for the initial page after the login.
	 */
	abstract Class<? extends AbstractPage> getInitialPage()

	/**
	 * Returns the Login page class. It should contain 'username' and 'password' field properties, and a 'logIn' button property.	
	 */
	abstract Class<? extends LoginPage> getLoginPage()

	/**
	 * The default username used for the session. 
	 */
//	String getUsernameValue() {
//		"admin"
//	}

	/**
	 * The default password used for the session. 
	 */
//	String getPasswordValue() {
//		"admin"
//	}

}