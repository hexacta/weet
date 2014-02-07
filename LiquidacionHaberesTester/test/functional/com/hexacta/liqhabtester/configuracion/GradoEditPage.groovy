package com.hexacta.liqhabtester.configuracion

import com.hexacta.webtester.pages.crud.EntityEditPage


class GradoEditPage extends EntityEditPage {
	static url = "grado/edit"
	
	static at = { title.contains("Editar grado") } 
	
	static content = {
		codigo  {  $("input", name: "codigo") }
	}
}