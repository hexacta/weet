package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.page.HomePage
import com.hexacta.liqhabtester.page.LoginPage

class LoginSpec extends com.hexacta.webtester.specs.LoginSpec {

	def getInitialPage() {
		HomePage
	}
	
	def getLoginPage() {
		LoginPage
	}
	
	@Override
	Object invalidPasswordExtraAssertion() {
		$().text().contains("El nombre de usuario o contrase�a no v�lidos. Verifique los datos ingresados")
	}
	
	@Override
	Object invalidUsernameExtraAssertion() {
		$().text().contains("El nombre de usuario o contrase�a no v�lidos. Verifique los datos ingresados")
	}
}
