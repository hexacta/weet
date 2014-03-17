package com.hexacta.weet.specs

import spock.lang.*

/**
 * TODO
 * 
 * @author gmassenzano
 */
abstract class CRUDSpec extends ApplicationSpec {

	// TODO: se asume la columna recibida ordenada ascendentemente
	// XXX: Si se ejecuta dentro del modulo esta tirando StaleElementReferenceException
	protected findRowInPages(int col, String value) {
		int rowCount = 0, pageRowCount
		while ( (pageRowCount = table.pageRowCount) > 0 && 
				 !table.isLastPage() &&
				 table.findLastValue(col) < value) {
				 
			rowCount += pageRowCount
			table.nextPage()
		}
		rowCount += pageRowCount
		def row = table.findRow(col, value)
		[rowCount, row]
	}
}