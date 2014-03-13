package com.hexacta.liqhabtester.configuracion

import com.hexacta.liqhabtester.pages.crud.EditarEntidadPage


class CargoEditPage extends EditarEntidadPage {
	static url = "cargo/edit"
	
	static at = { title.contains("Editar cargo") } 
	
	static content = {
		codigo           { $("input", name: "codigo") }
		descripcion      { $("input", name: "descripcion") }
		descripcionCorta { $("input", name: "descripcionCorta") }
	}
}