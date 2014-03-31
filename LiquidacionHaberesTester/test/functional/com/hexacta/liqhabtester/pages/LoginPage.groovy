package com.hexacta.liqhabtester.pages


class LoginPage extends com.hexacta.weet.pages.LoginPage {
	static url = "login/index"
 
	static at = { $().text().contains("Bienvenido, por favor ingrese su usuario y contrase\u00f1a.") }
 
    static content = {
        loginButton   { $("input", value: "Ingresar") }
    }
}