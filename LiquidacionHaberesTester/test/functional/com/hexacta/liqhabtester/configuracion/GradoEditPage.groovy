package com.hexacta.liqhabtester.configuracion

import com.hexacta.liqhabtester.pages.crud.EditarEntidadPage


class GradoEditPage extends EditarEntidadPage {
	static url = "grado/edit"
	
	static at = { title.contains("Editar grado") } 
	
	static content = {
		cargo            { $("select", name: "cargo.id") }
		jerarquia        { $("select", name: "jerarquia.id") }
		codigo           { $("input", name: "codigo") }
		descripcion      { $("input", name: "descripcion") }
		descripcionCorta { $("input", name: "descripcionCorta") }
	}
}