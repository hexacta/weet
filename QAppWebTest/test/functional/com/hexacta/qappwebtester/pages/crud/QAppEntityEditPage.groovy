package com.hexacta.qappwebtester.pages.crud

import com.hexacta.webtester.modules.ConfirmationModalModule
import com.hexacta.webtester.pages.crud.EntityEditPage


abstract class QAppEntityEditPage extends EntityEditPage {
	// Menu options
	static int HOME = 0, LIST = 1, NEW = 2
		
	static content = {
		pageMenu { module NavigationMenuModule, $("ul.nav")[1] }
		
		deleteConfirmation { module ConfirmationModalModule, confirmText: "Delete", $("div", id: "deleteModal") }
		
		userMenu { $("a", class:"btn dropdown-toggle").has("i") }
	}
}