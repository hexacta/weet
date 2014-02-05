package com.hexacta.webtester.specs

import spock.lang.*

import com.hexacta.webtester.UserRobot

/**
 * Common spec for any web application which starts with a user session login.
 *  
 * @author gmassenzano
 */
abstract class ApplicationSpec extends AbstractSpec {

	/**
	 * Logs in before any spec method is executed.
	 */
	def setup() {
		given:
		waitFor { to loginPage }
		username = usernameValue
		password = usernameValue
		logIn.click()

		then: "Redirects to home page"
		waitFor { at initialPage }
	}

	/**
	 * Returns the class for the initial page after the login.
	 */
	abstract def getInitialPage()

	/**
	 * Returns the Login page class. It should contain 'username' and 'password' field properties, and a 'logIn' button property.	
	 */
	abstract def getLoginPage()

	/**
	 * The default username used for the session. 
	 */
	String getUsernameValue() {
		"admin"
	}

	/**
	 * The default password used for the session. 
	 */
	String getPasswordValue() {
		"admin"
	}

	def cleanup() {
		// user.logout()
	}
}