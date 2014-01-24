package com.hexacta.qappwebtest.pages

import com.hexacta.web_test_robot.AbstractPage

class LoginPage extends AbstractPage {
	static url = "login/login"
 
	static at = { title == "QA Application" }
 
    static content = {
        username  { login() }                      // Equivalent to: { $("input", name: "login") }
        password  { $("input", name: "password") } // Can't be used { password() } because a circularity call is produced
        logIn     { $("input", value: "Log in")  }
    }
}