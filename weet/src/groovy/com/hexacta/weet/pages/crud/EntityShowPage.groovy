package com.hexacta.weet.pages.crud

import com.hexacta.weet.modules.ConfirmationModalModule


abstract class EntityShowPage extends EntityPage {
	
	static content = {
		edit {  $("a", text: containsWord("Edit")) }
		delete {  $("button", text: containsWord("Delete")) }
	}
}