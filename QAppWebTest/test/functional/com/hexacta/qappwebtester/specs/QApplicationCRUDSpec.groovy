package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage
import com.hexacta.webtester.specs.CRUDSpec

abstract class QApplicationCRUDSpec extends CRUDSpec {

	def getInitialPage() {
		HomePage
	}
	
	def getLoginPage() {
		LoginPage
	}

	protected findRowInPages(int col, String value) {
		def rowCount, rowLink
		(rowCount, rowLink) = super.findRowInPages(col, value)
		rowLink = rowLink?.find("td a")?.getAt(col)
		[rowCount, rowLink]
	}

}