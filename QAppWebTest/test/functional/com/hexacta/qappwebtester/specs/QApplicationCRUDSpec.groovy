package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage
import com.hexacta.webtester.pages.AbstractPage
import com.hexacta.webtester.specs.CRUDSpec

abstract class QApplicationCRUDSpec extends CRUDSpec {

	@Override
	Class<? extends AbstractPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<? extends LoginPage> getLoginPage() {
		LoginPage
	}

	protected findRowInPages(int col, String value) {
		def rowCount, rowLink
		(rowCount, rowLink) = super.findRowInPages(col, value)
		rowLink = rowLink?.find("td a")?.getAt(col)
		[rowCount, rowLink]
	}

}