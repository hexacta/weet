package com.hexacta.qappwebtester.pages

import com.hexacta.weet.pages.AbstractPage


class LoginPage extends com.hexacta.weet.pages.LoginPage {
	static url = "login/login"
 
	static at = { $("h2", text: "Por Favor Ingrese sus Credenciales") }
 
}