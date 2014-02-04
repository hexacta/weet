package com.hexacta.qappwebtester.configuration

import com.hexacta.qappwebtester.pages.QApplicationPage

class ProcessPage extends QApplicationPage {
	static url = "process/list"
	
	static at = { $().text().contains("Processes List") } 
	
	static content = {
	}
}