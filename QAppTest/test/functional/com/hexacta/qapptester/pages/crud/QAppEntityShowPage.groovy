package com.hexacta.qapptester.pages.crud

import com.hexacta.weet.modules.ConfirmationModalModule
import com.hexacta.weet.modules.NavigationMenuModule
import com.hexacta.weet.pages.crud.EntityShowPage

abstract class QAppEntityShowPage extends EntityShowPage {
	// Page menu options
	static int LIST = 1, NEW = 2
	
	static content = {
		pageMenu { module NavigationMenuModule, $("ul.nav")[1] }
		
		edit {  $("a", text: containsWord("Editar")) }
		delete {  $("button", text: containsWord("Eliminar")) }
		
		deleteConfirmation { module ConfirmationModalModule, confirmText: "Eliminar", cancelText: "Cancelar", $("div", id: "deleteModal") }
		
		userMenu { $("a", class:"btn dropdown-toggle").has("i") }
	}
}