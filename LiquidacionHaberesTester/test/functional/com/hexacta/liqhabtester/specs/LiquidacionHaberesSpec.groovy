package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.page.HomePage
import com.hexacta.liqhabtester.page.LoginPage
import com.hexacta.webtester.AbstractPageSpec

abstract class LiquidacionHaberesSpec extends AbstractPageSpec {

	def setup() {
		given:
		waitFor { to LoginPage }
		username = "admin"
		password = "admin"
		logIn.click()
		
		then: "Redirects to home page"
		waitFor { at HomePage }
	}
}