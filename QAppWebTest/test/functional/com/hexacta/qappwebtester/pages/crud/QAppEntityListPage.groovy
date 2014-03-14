package com.hexacta.qappwebtester.pages.crud

import com.hexacta.weet.modules.NavigationMenuModule
import com.hexacta.weet.pages.crud.EntityListPage

abstract class QAppEntityListPage extends EntityListPage {
	// Menu options
	static int HOME = 0, NEW = 1
		
	static content = {
		pageMenu { module NavigationMenuModule, $("ul.nav")[1] }
		
		create { pageMenu.item(NEW) } 
		
		userMenu { $("a", class:"btn dropdown-toggle").has("i") }
	}
}