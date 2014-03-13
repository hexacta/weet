package com.hexacta.liqhabtester.configuracion

import com.hexacta.webtester.pages.crud.EntityNewPage

class SubunidadNewPage extends EntityNewPage {
	static url = "subunidad/create"
	
	static at = { $().text().contains("Crear subunidad") } 
	
	static content = {
		unidad           { $("select", name: "unidad.id") }
		codigo           { $("input", name: "codigo") }
		nombre           { $("input", name: "nombre") }
		descripcion      { $("input", name: "descripcion") }
		nucleo           { $("select", name: "nucleo") }
		zonaCritica      { $("select", name: "zonaCritica") }
		zonaMontana      { $("select", name: "zonaMontana") }
		zonaSCD          { $("select", name: "zonaSCD") }
		zonaPorcentaje   { $("input", name: "zonaPorcentaje") }
	}
}