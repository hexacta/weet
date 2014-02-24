package com.hexacta.qappwebtester.configuration

import com.hexacta.qappwebtester.pages.crud.QAppEntityShowPage;

class AreaShowPage extends QAppEntityShowPage {
	static url = "area/show"
	
	static at = { $().text().contains("Mostar Area") } // FIXME: cuando se corrija la app, cambiar el label por "Mostrar Area" 
	
	static content = {
		nameLabel  {  $("label", text: "Nombre") }
		name       {  $(nameLabel).next().find("input") }
	}
}