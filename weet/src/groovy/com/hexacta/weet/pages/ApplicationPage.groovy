package com.hexacta.weet.pages

import com.hexacta.weet.modules.NavigationMenuModule
import com.hexacta.weet.pages.AjaxPage

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