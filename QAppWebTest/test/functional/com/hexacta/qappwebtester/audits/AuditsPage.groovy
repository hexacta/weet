package com.hexacta.qappwebtester.audits

import com.hexacta.qappwebtester.pages.QApplicationPage

class AuditsPage extends QApplicationPage {
	static url = "audit/list"
	
	static at = { $().text().contains("Lista de Auditorías") } 
	
	static content = {
	}
}