package com.hexacta.qapptester.configuration

import com.hexacta.qapptester.pages.crud.QAppEntityNewPage;

class AreaNewPage extends QAppEntityNewPage {
	static url = "area/create"
	
	static at = { $().text().contains("Crear Area") } 
	
	static content = {
		name  {  $("input", name: "name") }
	}
}