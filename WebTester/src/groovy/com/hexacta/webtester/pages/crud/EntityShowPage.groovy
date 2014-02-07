package com.hexacta.webtester.pages.crud

import com.hexacta.webtester.modules.ConfirmationModalModule


abstract class EntityShowPage extends EntityPage {
	// Page menu options
	static int LIST = 1, NEW = 2
	
	static content = {
		edit {  $("a", text: containsWord("Edit")) }
		delete {  $("button", text: containsWord("Delete")) }
		
		deleteConfirmation { module ConfirmationModalModule, confirmText: "Delete", $("div", id: "deleteModal") }
	}
}