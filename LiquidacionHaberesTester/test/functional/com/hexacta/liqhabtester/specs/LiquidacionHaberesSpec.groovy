package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.page.HomePage
import com.hexacta.liqhabtester.page.LoginPage
import com.hexacta.webtester.specs.ApplicationSpec

abstract class LiquidacionHaberesSpec extends ApplicationSpec {

	def getInitialPage() {
		HomePage
	}
	
	def getLoginPage() {
		LoginPage
	}
}