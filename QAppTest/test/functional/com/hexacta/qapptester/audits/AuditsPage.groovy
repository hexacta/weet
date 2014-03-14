package com.hexacta.qapptester.audits

import com.hexacta.qapptester.pages.QApplicationPage

class AuditsPage extends QApplicationPage {
	static url = "audit/list"
	
	static at = { $().text().contains("Lista de Auditorías") } 
	
	static content = {
	}
}