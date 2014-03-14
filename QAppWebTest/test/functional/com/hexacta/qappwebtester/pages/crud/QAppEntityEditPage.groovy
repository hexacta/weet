package com.hexacta.qappwebtester.pages.crud

import com.hexacta.weet.modules.ConfirmationModalModule
import com.hexacta.weet.pages.crud.EntityEditPage


abstract class QAppEntityEditPage extends EntityEditPage {
	// Menu options
	static int HOME = 0, LIST = 1, NEW = 2
		
	static content = {
		pageMenu { module NavigationMenuModule, $("ul.nav")[1] }
		
		update {  $("input", value: "Actualizar") }
		delete {  $("button", text: containsWord("Eliminar")) }
		
		deleteConfirmation { module ConfirmationModalModule, confirmText: "Eliminar", cancelText: "Cancelar", $("div", id: "deleteModal") }
		
		userMenu { $("a", class:"btn dropdown-toggle").has("i") }
	}
}