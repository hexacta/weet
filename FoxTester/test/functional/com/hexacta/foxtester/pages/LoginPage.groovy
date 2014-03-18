package com.hexacta.foxtester.pages


class LoginPage extends com.hexacta.weet.pages.LoginPage {
	static url = "Security/Login"
 
	static at = { $("div.loginText").text() == "Persub II" }
 
    static content = {
        username  { $("input", id: "UserName") }
        password  { $("input", id: "Password") }
        loginButton { $("input", id: "LoginButton")  }
    }
}