package com.hexacta.liqhabtester.page

import com.hexacta.webtester.pages.AbstractPage;

class LoginPage extends AbstractPage {
	static url = "login/index"
 
	static at = { $().text().contains("Bienvenido, por favor ingrese su usuario y contraseña.") }
 
    static content = {
        username  { login() }                      // Equivalent to: { $("input", name: "login") }
        password  { $("input", name: "password") } // Can't be used { password() } because a circularity call is produced
        logIn     { $("input", value: "Ingresar") }
    }
}