package com.hexacta.liqhabtester.crud

import com.hexacta.liqhabtester.pages.crud.CRUDPage


class GradoPage extends CRUDPage {
	static content = {
		cargo            { $("select", name: "cargo.id") }
		jerarquia        { $("select", name: "jerarquia.id") }
		codigo           { $("input", name: "codigo") }
		descripcion      { $("input", name: "descripcion") }
		descripcionCorta { $("input", name: "descripcionCorta") }
	}
	
	String getEntity() {
		"grado"
	}
	
	String getPluralEntity() {
		"grados"
	}
}