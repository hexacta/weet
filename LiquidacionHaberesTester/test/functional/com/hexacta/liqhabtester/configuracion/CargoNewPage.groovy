package com.hexacta.liqhabtester.configuracion

import com.hexacta.webtester.pages.crud.EntityNewPage

class CargoNewPage extends EntityNewPage {
	static url = "cargo/create"
	
	static at = { $().text().contains("Crear cargo") } 
	
	static content = {
		codigo           { $("input", name: "codigo") }
		descripcion      { $("input", name: "descripcion") }
		descripcionCorta { $("input", name: "descripcionCorta") }
	}
}