package com.hexacta.foxtester.specs

import spock.lang.*

import com.hexacta.foxtester.pages.HomePage
import com.hexacta.foxtester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage

class LoginSpec extends com.hexacta.weet.specs.LoginSpec {

	def setupSpec() {
		username = "gmassenzano"
		password = "miclave1" // TODO: obtenerla por configuracion o ingresarla encriptada.
	}

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
		$().text().contains("The user does not have permissions. Please contact your Administrator.")
	}
	
	@Override
	void invalidUsernameExtraAssertion() {
		$().text().contains("The user does not have permissions. Please contact your Administrator.")
	}
}
