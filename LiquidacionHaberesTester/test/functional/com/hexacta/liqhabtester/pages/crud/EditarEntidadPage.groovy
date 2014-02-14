package com.hexacta.liqhabtester.pages.crud

import com.hexacta.webtester.modules.ConfirmationModalModule
import com.hexacta.webtester.pages.crud.EntityEditPage


abstract class EditarEntidadPage extends EntityEditPage {
		
	static content = {
		update {  $("input", value: "Actualizar") }
		delete {  $("button", text: containsWord("Deshabilitar")) }
		
		// deleteConfirmation { module ConfirmationModalModule, confirmText: "Delete", $("div", id: "deleteModal") }
	}
}