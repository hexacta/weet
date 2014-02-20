package com.hexacta.qappwebtester.pages

import com.hexacta.webtester.pages.AbstractPage


class LoginPage extends com.hexacta.webtester.pages.LoginPage {
	static url = "login/login"
 
	static at = { $("h2", text: "Please enter your credentials") }
 
}