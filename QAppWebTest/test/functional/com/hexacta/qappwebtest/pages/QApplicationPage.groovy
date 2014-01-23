package com.hexacta.qappwebtest.pages

import com.hexacta.qappwebtest.modules.NavigationMenuModule
import com.hexacta.web_test_robot.AbstractPage

class QApplicationPage extends AbstractPage {
	static int CONFIGURATION = 0
	
	static url = ""
	
	static at = { $().text().contains("Audits and metrics for Hexacta projects") } 
	
	static content = {
		menu { module NavigationMenuModule }
	}
}