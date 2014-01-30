package com.hexacta.qappwebtest.pages

import com.hexacta.qappwebtest.modules.ConfirmationModalModule

abstract class QAppEntityShowPage extends QAppEntityPage {
	// Page menu options
	static int LIST = 1, NEW = 2
	
	static content = {
		edit {  $("a", text: containsWord("Edit")) }
		delete {  $("button", text: containsWord("Delete")) }
		
		deleteConfirmation { module ConfirmationModalModule, confirmText: "Delete", $("div", id: "deleteModal") }
	}
}