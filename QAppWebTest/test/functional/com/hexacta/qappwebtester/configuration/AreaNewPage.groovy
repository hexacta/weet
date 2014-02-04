package com.hexacta.qappwebtester.configuration

import com.hexacta.qappwebtester.pages.QAppEntityNewPage

class AreaNewPage extends QAppEntityNewPage {
	static url = "area/create"
	
	static at = { $().text().contains("Create Area") } 
	
	static content = {
		name  {  $("input", name: "name") }
	}
}