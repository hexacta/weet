package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage

class LoginSpec extends com.hexacta.webtester.specs.LoginSpec {

	def getInitialPage() {
		HomePage
	}
	
	def getLoginPage() {
		LoginPage
	}
	
}