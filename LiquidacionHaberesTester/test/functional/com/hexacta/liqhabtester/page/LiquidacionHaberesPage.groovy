package com.hexacta.liqhabtester.page

import com.hexacta.webtester.pages.AbstractPage;

abstract class LiquidacionHaberesPage extends AbstractPage {
	// Menu options
	static int CONFIGURATION = 0, AUDITS = 1
	
	// Configuration submenu
	static int CONF_TEMPLATES = 0, CONF_PROCESSES = 1, CONF_AREAS = 2
	
	// Audits submenu
	static int AUDIT_CREATE = 0, AUDIT_LIST = 1
		
	static content = {
		// menu { module NavigationMenuModule }
	}
}