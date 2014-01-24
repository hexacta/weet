package com.hexacta.qappwebtest.configuration

import com.hexacta.qappwebtest.pages.QApplicationPage

class TemplatesPage extends QApplicationPage {
	static url = "template/list"
	
	static at = { $().text().contains("Templates List") } 
	
	static content = {
	}
}