package com.hexacta.qappwebtester.pages


class HomePage extends QApplicationPage {
	static url = ""
	
	static at = { $().text().contains("Audits and metrics for Hexacta projects") } 
	
	static content = {
	}
}