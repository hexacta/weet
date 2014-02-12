package com.hexacta.liqhabtester.configuracion

import com.hexacta.webtester.pages.crud.EntityEditPage


class GradoEditPage extends EntityEditPage {
	static url = "grado/edit"
	
	static at = { title.contains("Editar grado") } 
	
	static content = {
		cargo            { $("select", name: "cargo.id") }
		cargoValue       { $("select", name: "cargo.id").find("option", selected: "selected")?.text() }
		jerarquia        { $("select", name: "jerarquia.id") }
		codigo           { $("input", name: "codigo") }
		descripcion      { $("input", name: "descripcion") }
		descripcionCorta { $("input", name: "descripcionCorta") }
	}
}