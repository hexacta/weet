package com.hexacta.qappwebtest.configuration

import com.hexacta.qappwebtest.pages.QAppEntityNewPage

class AreaNewPage extends QAppEntityNewPage {
	static url = "area/create"
	
	static at = { $().text().contains("Create Area") } 
	
	static content = {
		name  {  $("input", name: "name") }
	}
}