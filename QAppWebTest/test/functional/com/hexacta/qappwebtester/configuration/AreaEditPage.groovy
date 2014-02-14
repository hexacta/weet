package com.hexacta.qappwebtester.configuration

import com.hexacta.qappwebtester.pages.crud.QAppEntityEditPage;

class AreaEditPage extends QAppEntityEditPage {
	static url = "area/edit"
	
	static at = { $().text().contains("Edit Area") } 
	
	static content = {
		name  {  $("input", name: "name") }
	}
}