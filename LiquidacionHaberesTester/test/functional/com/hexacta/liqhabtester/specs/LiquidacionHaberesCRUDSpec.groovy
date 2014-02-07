package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.webtester.specs.CRUDSpec

abstract class LiquidacionHaberesCRUDSpec extends CRUDSpec {

	def getInitialPage() {
		HomePage
	}
	
	def getLoginPage() {
		LoginPage
	}
}