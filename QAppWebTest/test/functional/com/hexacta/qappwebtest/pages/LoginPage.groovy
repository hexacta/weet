package com.hexacta.qappwebtest.pages

import com.hexacta.web_test_robot.AbstractPage

class LoginPage extends AbstractPage {
	static url = "login/login"
 
	static at = { title == "QA Application" }
 
    static content = {
        username  { $("input", name: "login")    }
        password  { $("input", name: "password") }
        logIn     { $("input", value: "Log in")  }
    }
}