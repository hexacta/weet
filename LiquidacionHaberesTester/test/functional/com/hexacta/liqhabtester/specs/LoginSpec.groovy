package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage

class LoginSpec extends com.hexacta.weet.specs.LoginSpec {

	@Override
	Class<? extends WeetPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<? extends LoginPage> getLoginPage() {
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
