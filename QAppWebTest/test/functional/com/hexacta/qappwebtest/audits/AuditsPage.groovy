package com.hexacta.qappwebtest.audits

import com.hexacta.qappwebtest.pages.QApplicationPage

class AuditsPage extends QApplicationPage {
	static url = "audit/list"
	
	static at = { $().text().contains("Audits List") } 
	
	static content = {
	}
}