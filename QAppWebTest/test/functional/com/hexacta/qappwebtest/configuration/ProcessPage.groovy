package com.hexacta.qappwebtest.configuration

import com.hexacta.qappwebtest.pages.QApplicationPage

class ProcessPage extends QApplicationPage {
	static url = "process/list"
	
	static at = { $().text().contains("Processes List") } 
	
	static content = {
	}
}