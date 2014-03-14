package com.hexacta.qapptester.configuration

import com.hexacta.qapptester.pages.crud.QAppEntityListPage;

class AreasPage extends QAppEntityListPage {
	static url = "area/list"
	
	static at = { $().text().contains("Lista de Areas") } 
	
	static content = {
		
	}
}