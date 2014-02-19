package com.hexacta.liqhabtester.pages


class LoginPage extends com.hexacta.webtester.pages.LoginPage {
	static url = "login/index"
 
	static at = { $().text().contains("Bienvenido, por favor ingrese su usuario y contraseņa.") }
 
    static content = {
        loginButton   { $("input", value: "Ingresar") }
    }
}