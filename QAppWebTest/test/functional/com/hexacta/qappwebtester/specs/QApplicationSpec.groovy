package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage
import com.hexacta.webtester.specs.ApplicationSpec

abstract class QApplicationSpec extends ApplicationSpec {

	def getInitialPage() {
		HomePage
	}
	
	def getLoginPage() {
		LoginPage
	}

}