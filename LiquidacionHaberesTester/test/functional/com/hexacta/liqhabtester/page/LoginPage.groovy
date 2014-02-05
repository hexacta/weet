package com.hexacta.liqhabtester.page


class LoginPage extends com.hexacta.webtester.pages.LoginPage {
	static url = "login/index"
 
	static at = { $().text().contains("Bienvenido, por favor ingrese su usuario y contraseña.") }
 
    static content = {
        logIn     { $("input", value: "Ingresar") }
    }
}