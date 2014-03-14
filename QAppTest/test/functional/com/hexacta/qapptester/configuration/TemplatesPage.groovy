package com.hexacta.qapptester.configuration

import com.hexacta.qapptester.pages.QApplicationPage

class TemplatesPage extends QApplicationPage {
	static url = "template/list"
	
	static at = { $().text().contains("Templates List") } 
	
	static content = {
	}
}