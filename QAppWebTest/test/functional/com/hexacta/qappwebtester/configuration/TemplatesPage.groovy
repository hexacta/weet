package com.hexacta.qappwebtester.configuration

import com.hexacta.qappwebtester.pages.QApplicationPage

class TemplatesPage extends QApplicationPage {
	static url = "template/list"
	
	static at = { $().text().contains("Templates List") } 
	
	static content = {
	}
}