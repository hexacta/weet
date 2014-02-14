package com.hexacta.webtester.pages.crud

import com.hexacta.webtester.modules.ConfirmationModalModule


abstract class EntityShowPage extends EntityPage {
	
	static content = {
		edit {  $("a", text: containsWord("Edit")) }
		delete {  $("button", text: containsWord("Delete")) }
	}
}