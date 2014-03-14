package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.weet.pages.AbstractPage
import com.hexacta.weet.specs.ApplicationSpec

abstract class LiquidacionHaberesSpec extends ApplicationSpec {

	@Override
	Class<? extends AbstractPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<? extends LoginPage> getLoginPage() {
		LoginPage
	}
}