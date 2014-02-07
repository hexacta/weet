package com.hexacta.webtester.pages.crud

import com.hexacta.webtester.modules.NavigationMenuModule
import com.hexacta.webtester.pages.ApplicationPage

abstract class EntityPage extends ApplicationPage {
	// Page menu options
	static int HOME = 0
		
	static content = {
		pageMenu { module NavigationMenuModule, $("ul.nav")[1] }
	}
}