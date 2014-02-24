package com.hexacta.qappwebtester.configuration

import com.hexacta.qappwebtester.pages.crud.QAppEntityNewPage;

class AreaNewPage extends QAppEntityNewPage {
	static url = "area/create"
	
	static at = { $().text().contains("Crear Area") } 
	
	static content = {
		name  {  $("input", name: "name") }
	}
}