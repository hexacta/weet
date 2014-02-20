package com.hexacta.liqhabtester.pages.crud

import com.hexacta.webtester.modules.ConfirmationModalModule
import com.hexacta.webtester.pages.crud.EntityEditPage


abstract class EditarEntidadPage extends EntityEditPage {
		
	static content = {
		update {  $("input", value: "Actualizar") }
		delete(required: false) {  $("input", value: containsWord("Deshabilitar")) }
		habilitar(required: false) {  $("input", value: containsWord("Habilitar")) }
		
		userMenu { $("li.menu_logout_right a.drop_logout") }
	}
}