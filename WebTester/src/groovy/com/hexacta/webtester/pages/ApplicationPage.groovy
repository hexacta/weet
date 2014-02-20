package com.hexacta.webtester.pages

import com.hexacta.webtester.modules.NavigationMenuModule
import com.hexacta.webtester.pages.AjaxPage

abstract class ApplicationPage extends AjaxPage {

	// Redefine any element if it is needed
	static content = {
		menu { module NavigationMenuModule, $("ul" , id: "menu") }
		
		userMenu { $("a", href: contains("logout")) }
	}
	
	void logout() {
		def userMenu = userMenu
		mouseoverAndClick(userMenu)
		userMenu.next().find("a", href: contains("logout")).click()
	}
}