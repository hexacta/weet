package com.hexacta.qappwebtester.pages

import com.hexacta.webtester.AjaxPage
import com.hexacta.webtester.modules.NavigationMenuModule;

abstract class QApplicationPage extends AjaxPage {
	// Menu options
	static int CONFIGURATION = 0, AUDITS = 1
	
	// Configuration submenu
	static int CONF_TEMPLATES = 0, CONF_PROCESSES = 1, CONF_AREAS = 2
	
	// Audits submenu
	static int AUDIT_CREATE = 0, AUDIT_LIST = 1
		
	static content = {
		menu { module NavigationMenuModule, $("ul.nav")[0] }
	}
}