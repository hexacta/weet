package com.hexacta.liqhabtester.configuracion

import com.hexacta.webtester.pages.crud.EntityNewPage

class GradoNewPage extends EntityNewPage {
	static url = "grado/create"
	
	static at = { $().text().contains("Crear grado") } 
	
	static content = {
		cargo            { $("select", name: "cargo.id") }
		jerarquia        { $("select", name: "jerarquia.id") }
		codigo           { $("input", name: "codigo") }
		descripcion      { $("input", name: "descripcion") }
		descripcionCorta { $("input", name: "descripcionCorta") }
	}
}