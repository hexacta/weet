package com.hexacta.qappwebtest.configuration

import com.hexacta.qappwebtest.pages.QAppEntityEditPage

class AreaEditPage extends QAppEntityEditPage {
	static url = "area/edit"
	
	static at = { $().text().contains("Edit Area") } 
	
	static content = {
		name  {  $("input", name: "name") }
	}
}