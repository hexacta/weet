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
	void invalidPasswordExtraAssertion() {
		$().text().contains("El nombre de usuario o contrase\u00f1a no v\u00e1lidos. Verifique los datos ingresados")
	}
	
	@Override
	void invalidUsernameExtraAssertion() {
		$().text().contains("El nombre de usuario o contrase\u00f1a no v\u00e1lidos. Verifique los datos ingresados")
	}
}
