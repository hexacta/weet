package com.hexacta.webtester.modules

/**
 * Pageable table. 
 *
 * @author gmassenzano
 * @see TableModule
 * @see PaginationModule
 */
class PageableTableModule extends AbstractModule {
 
	def tableBase
	def navigationBase
	
    static content = {
		table { module TableModule, tableBase }
		pagination { module PaginationModule, navigationBase }
    }

	// ---------------------------------------------------------------
	// Table methods
	// ---------------------------------------------------------------
	int getPageRowCount() {
		table.rowCount
	}

	def getColumn(int i) {
		table.column(i) 
	}
	
	def findCell(String value) {
		table.findCell(value)
	}
	
	String findLastValue(int col) {
		table.findLastValue(col)
	}
	
	def findRowLink(int col, String value) {
		table.findRowLink(col, value)
	}
	
	def findRow(int col, String value) {
		table.findRow(col, value)
	}

	// ---------------------------------------------------------------
	// Navigation methods
	// ---------------------------------------------------------------
	def prevPage() {
		pagination.previous()
	}
	
	def nextPage() {
		pagination.next()
	}
	
	void toPage(int pageNumber) {
		pagination.toPage(pageNumber)
	}

	boolean isFirstPage() {
		pagination.isFirstPage()
	}

	boolean isLastPage() {
		pagination.isLastPage()
	}

}
