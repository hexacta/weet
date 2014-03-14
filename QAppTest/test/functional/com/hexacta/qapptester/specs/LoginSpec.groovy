package com.hexacta.qapptester.specs

import spock.lang.*

import com.hexacta.qapptester.pages.HomePage
import com.hexacta.qapptester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage

class LoginSpec extends com.hexacta.weet.specs.LoginSpec {

	@Override
	Class<? extends WeetPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<LoginPage> getLoginPage() {
		LoginPage
	}
	
}