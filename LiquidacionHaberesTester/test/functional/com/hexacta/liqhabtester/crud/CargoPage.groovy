package com.hexacta.liqhabtester.crud

import com.hexacta.liqhabtester.pages.crud.CRUDPage

class CargoPage extends CRUDPage {
	static content = {
		codigo           { $("input", name: "codigo") }
		descripcion      { $("input", name: "descripcion") }
		descripcionCorta { $("input", name: "descripcionCorta") }
	}
	
	String getEntity() {
		"cargo"
	}
	
	String getPluralEntity() {
		"cargos"
	}
}