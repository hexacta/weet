package com.hexacta.weet.specs

import spock.lang.*

import com.hexacta.weet.pages.WeetPage
import com.hexacta.weet.pages.LoginPage

/**
 * Common spec for any web application which starts with a user session login.
 *  
 * @author gmassenzano
 */
abstract class ApplicationSpec extends WeetSpec {

	@Shared boolean initialLogin = true
	@Shared String username = "admin"
	@Shared String password = "admin"
	
	/**
	 * Login before any spec method is executed.
	 */
	def setup() {
		waitFor { to loginPage }
		if (initialLogin) {
			given: "Session login"
			login username, password
	
			then: "Redirects to an initial page"
			waitFor { at initialPage }
		}
	}

	/**
	 * Logout after the spec method finish.
	 */
	def cleanup() {
		if (initialLogin) {
			logout()
		}
	}

	/**
	 * Returns the class for the initial page after the login.
	 */
	abstract Class<? extends WeetPage> getInitialPage()

	/**
	 * Returns the Login page class. It should contain 'username' and 'password' field properties, and a 'logIn' button property.	
	 */
	abstract Class<? extends LoginPage> getLoginPage()

}