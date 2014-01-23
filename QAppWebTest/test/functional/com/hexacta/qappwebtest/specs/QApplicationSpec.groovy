package com.hexacta.qappwebtest.specs

import spock.lang.*

import com.hexacta.qappwebtest.pages.HomePage
import com.hexacta.qappwebtest.pages.LoginPage
import com.hexacta.web_test_robot.AbstractPageSpec

class QApplicationSpec extends AbstractPageSpec {

	def setup() {
		given:
		to LoginPage
		username = "admin"
		password = "admin"
		logIn.click()
		
		then: "Redirects to home page"
		waitFor { at HomePage }
	}
}