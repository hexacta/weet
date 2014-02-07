package com.hexacta.webtester.specs

import spock.lang.*

//@Stepwise
abstract class CRUDSpec extends ApplicationSpec {

	def setup() {
		//given:
		//menu.expand(CONFIGURATION).item(CONF_AREAS).click(AreasPage)
	}

	// TODO: se asume la columna recibida ordenada ascendentemente
	protected findRowInPages(int col, String value) {
		int rowCount = 0, pageRowCount
		while ( (pageRowCount = table.pageRowCount()) > 0 && 
				 table.nextPage?.present &&
				 table.findLastValue(col) < value) {
				 
			rowCount += pageRowCount
			table.nextPage.click(browser.page.class)
		}
		rowCount += pageRowCount
		def rowLink = table.findRow(col, value)
		[rowCount, rowLink]
	}
}