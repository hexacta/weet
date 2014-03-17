package com.hexacta.weet.pages


/**
 * Common login page, with basic elements, such as username, password and login button. Also provides the login method so that 
 * a user of this class doesn't need to interact with those page elements.
 * 
 * @author gmassenzano
 */
abstract class LoginPage extends WeetPage {
	// static url =   ** DEFINE IT ON SUBCLASS **
 
	// static at =    ** DEFINE IT ON SUBCLASS **
 
    static content = {
        username  { login() }                      // Equivalent to: { $("input", name: "login") }
        password  { $("input", name: "password") } // Can't be used { password() } because a circularity call is produced
        loginButton { $("input", value: "Log in")  }
		
		logoutButton(required: false) { $("input", value: "Log out") }
    }
	
	/**
	 * Logs in to the user session.
	 * 
	 * @param user
	 * @param pswd
	 */
	void login(String user, String pswd) {
		username = user
		password = pswd
		loginButton.click()
	}

	/**
	 * Sometimes if the application in redirected to the login page when a user is logged in, it shows a logout button. 
	 * Then, this method logs out the session.
	 */
	void logout() {
		def button = logoutButton
		if (button?.size() == 1) {
			button.click()
		}
	}
}