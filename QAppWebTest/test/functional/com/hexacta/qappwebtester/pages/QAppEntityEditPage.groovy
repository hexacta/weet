package com.hexacta.qappwebtester.pages

import com.hexacta.webtester.modules.ConfirmationModalModule


abstract class QAppEntityEditPage extends QAppEntityPage {
	// Menu options
	static int LIST = 1, NEW = 2
		
	static content = {
		update {  $("input", value: "Update") }
		delete {  $("button", text: containsWord("Delete")) }
		
		deleteConfirmation { module ConfirmationModalModule, confirmText: "Delete", $("div", id: "deleteModal") }
	}
}