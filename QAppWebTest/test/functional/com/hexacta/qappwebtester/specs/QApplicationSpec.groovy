package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage
import com.hexacta.weet.pages.AbstractPage
import com.hexacta.weet.specs.ApplicationSpec

abstract class QApplicationSpec extends ApplicationSpec {

	@Override
	Class<? extends AbstractPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<LoginPage> getLoginPage() {
		LoginPage
	}

}