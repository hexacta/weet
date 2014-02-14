package com.hexacta.qappwebtester.pages.crud

import com.hexacta.webtester.modules.ConfirmationModalModule
import com.hexacta.webtester.modules.NavigationMenuModule
import com.hexacta.webtester.pages.crud.EntityShowPage

abstract class QAppEntityShowPage extends EntityShowPage {
	// Page menu options
	static int LIST = 1, NEW = 2
	
	static content = {
		pageMenu { module NavigationMenuModule, $("ul.nav")[1] }
		
		deleteConfirmation { module ConfirmationModalModule, confirmText: "Delete", $("div", id: "deleteModal") }
	}
}