package com.hexacta.qappwebtester.pages.crud

import com.hexacta.webtester.modules.NavigationMenuModule
import com.hexacta.webtester.pages.crud.EntityNewPage


abstract class QAppEntityNewPage extends EntityNewPage {
	// Menu options
	static int HOME = 0, LIST = 1
		
	static content = {
		pageMenu { module NavigationMenuModule, $("ul.nav")[1] }
		
		userMenu { $("a", class:"btn dropdown-toggle").has("i") }
	}
}