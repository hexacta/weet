package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage
import com.hexacta.webtester.AbstractPageSpec

abstract class QApplicationSpec extends AbstractPageSpec {

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