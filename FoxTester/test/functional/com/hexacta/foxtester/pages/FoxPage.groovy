package com.hexacta.foxtester.pages

import com.hexacta.weet.modules.NavigationMenuModule
import com.hexacta.weet.pages.ApplicationPage

abstract class FoxPage extends ApplicationPage {
		
	static content = {
		menu { module NavigationMenuModule, $("ul" , id: "nav") }
		
		userMenu { $("a.logOutIcon") }
	}
}