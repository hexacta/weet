package com.hexacta.liqhabtester.configuracion

import com.hexacta.webtester.pages.crud.EntityNewPage

class GradoNewPage extends EntityNewPage {
	static url = "grado/create"
	
	static at = { $().text().contains("Crear grado") } 
	
	static content = {
		codigo  {  $("input", name: "codigo") }
	}
}