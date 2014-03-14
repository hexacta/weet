package com.hexacta.qapptester.configuration

import com.hexacta.qapptester.pages.crud.QAppEntityEditPage;

class AreaEditPage extends QAppEntityEditPage {
	static url = "area/edit"
	
	static at = { $().text().contains("Editar Area") } 
	
	static content = {
		name  {  $("input", name: "name") }
	}
}