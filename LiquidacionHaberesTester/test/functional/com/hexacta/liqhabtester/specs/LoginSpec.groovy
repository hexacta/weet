package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage

class LoginSpec extends com.hexacta.webtester.specs.LoginSpec {

	def getInitialPage() {
		HomePage
	}
	
	def getLoginPage() {
		LoginPage
	}
	
	@Override
	Object invalidPasswordExtraAssertion() {
		$().text().contains("El nombre de usuario o contraseña no válidos. Verifique los datos ingresados")
	}
	
	@Override
	Object invalidUsernameExtraAssertion() {
		$().text().contains("El nombre de usuario o contraseña no válidos. Verifique los datos ingresados")
	}
}
