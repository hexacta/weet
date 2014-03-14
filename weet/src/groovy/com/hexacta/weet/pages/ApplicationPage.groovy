package com.hexacta.weet.pages

import com.hexacta.weet.modules.NavigationMenuModule
import com.hexacta.weet.pages.AjaxPage

/**
 * Generic application page, which contains common features such as a navigation menu and a user menu.
 * 
 * @author gmassenzano
 */
abstract class ApplicationPage extends AjaxPage {

	// Redefine any element if it is needed
	static content = {
		menu { module NavigationMenuModule, $("ul" , id: "menu") }
		
		userMenu { $("a", href: contains("logout")) }
	}
	
	/**
	 * Logout the user session.
	 */
	void logout() {
		def userMenu = userMenu
		mouseoverAndClick(userMenu)
		userMenu.next().find("a", href: contains("logout")).click()
	}
}