package com.hexacta.qapptester.specs

import spock.lang.*

import com.hexacta.qapptester.pages.HomePage
import com.hexacta.qapptester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage
import com.hexacta.weet.specs.CRUDSpec

abstract class QApplicationCRUDSpec extends CRUDSpec {

	@Override
	Class<? extends WeetPage> getInitialPage() {
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