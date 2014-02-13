package com.hexacta.webtester.specs

import spock.lang.*

abstract class CRUDSpec extends ApplicationSpec {

	// TODO: se asume la columna recibida ordenada ascendentemente
	protected findRowInPages(int col, String value) {
		int rowCount = 0, pageRowCount
		while ( (pageRowCount = table.pageRowCount) > 0 && 
				 !table.isLastPage() &&
				 table.findLastValue(col) < value) {
				 
			rowCount += pageRowCount
			table.nextPage()
		}
		rowCount += pageRowCount
		def rowLink = table.findRow(col, value)
		[rowCount, rowLink]
	}
}