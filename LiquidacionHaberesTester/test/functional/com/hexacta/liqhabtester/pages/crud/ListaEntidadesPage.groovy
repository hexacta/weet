package com.hexacta.liqhabtester.pages.crud

import com.hexacta.webtester.pages.crud.EntityListPage

class ListaEntidadesPage extends EntityListPage {
	
	static content = {
		create { $("a", name: "create") }
	}
	
	String getNextPageText() {
		"Siguiente"
	}
	
	String getPrevPageText() {
		"Anterior"
	}


}