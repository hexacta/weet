package com.hexacta.liqhabtester.configuracion

import com.hexacta.liqhabtester.pages.crud.CRUDPage

class CargosPage extends CRUDPage {
	// static url = "cargo/list"
	
	//static at = { title == "Listado de " + this."entidadPlural" } 
	
	String getEntity() {
		"cargo"
	}
	
	String getPluralEntity() {
		"cargos"
	}

	static content = {
		
	}
}