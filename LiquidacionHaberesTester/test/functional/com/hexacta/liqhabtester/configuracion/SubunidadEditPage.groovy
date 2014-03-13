package com.hexacta.liqhabtester.configuracion

import com.hexacta.liqhabtester.pages.crud.EditarEntidadPage


class SubunidadEditPage extends EditarEntidadPage {
	static url = "subunidad/edit"
	
	static at = { title.contains("Editar subunidad") } 
	
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