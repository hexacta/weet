package com.hexacta.qapptester.configuration

import com.hexacta.qapptester.pages.QApplicationPage

class ProcessPage extends QApplicationPage {
	static url = "process/list"
	
	static at = { $().text().contains("Processes List") } 
	
	static content = {
	}
}