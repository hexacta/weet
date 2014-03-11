package com.hexacta.liqhabtester.specs

import static com.hexacta.liqhabtester.pages.LiquidacionHaberesPage.*
import spock.lang.*

class CRUDField {
	String field
	def value
	def updatedValue = null
	boolean inTable = true
}
