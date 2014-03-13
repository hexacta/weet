package com.hexacta.liqhabtester.crud

import com.hexacta.liqhabtester.pages.crud.CRUDPage


class SubunidadPage extends CRUDPage {
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
	
	String getEntity() {
		"subunidad"
	}
	
	String getPluralEntity() {
		"subunidades"
	}
}