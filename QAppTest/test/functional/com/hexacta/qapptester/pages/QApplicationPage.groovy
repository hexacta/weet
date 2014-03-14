package com.hexacta.qapptester.pages

import com.hexacta.weet.modules.NavigationMenuModule
import com.hexacta.weet.pages.ApplicationPage

abstract class QApplicationPage extends ApplicationPage {
	// Menu options
	static int CONFIGURATION = 0, AUDITS = 1
	
	// Configuration submenu
	static int CONF_TEMPLATES = 0, CONF_PROCESSES = 1, CONF_AREAS = 2
	
	// Audits submenu
	static int AUDIT_CREATE = 0, AUDIT_LIST = 1
		
	static content = {
		menu { module NavigationMenuModule, $("ul.nav")[0] }
		
		userMenu { $("a", class:"btn dropdown-toggle").has("i") }
	}
}