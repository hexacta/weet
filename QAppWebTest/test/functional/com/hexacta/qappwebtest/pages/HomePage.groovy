package com.hexacta.qappwebtest.pages

import com.hexacta.web_test_robot.AbstractPage

class HomePage extends QApplicationPage {
	static url = ""
	
	static at = { $().text().contains("Audits and metrics for Hexacta projects") } 
	
	static content = {
	}
}