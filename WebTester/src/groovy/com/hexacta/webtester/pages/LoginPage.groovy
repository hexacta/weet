package com.hexacta.webtester.pages

import com.hexacta.webtester.pages.AbstractPage;

abstract class LoginPage extends AbstractPage {
	// static url =   ** DEFINE IT ON SUBCLASS **
 
	// static at =    ** DEFINE IT ON SUBCLASS **
 
    static content = {
        username  { login() }                      // Equivalent to: { $("input", name: "login") }
        password  { $("input", name: "password") } // Can't be used { password() } because a circularity call is produced
        loginButton { $("input", value: "Log in")  }
		
		logoutButton(required: false) { $("input", value: "Log out") }
    }
	
	void login(String user, String pswd) {
		username = user
		password = pswd
		loginButton.click()
	}

	void logout() {
		def button = logoutButton
		if (button?.size() == 1) {
			button.click()
		}
	}
}