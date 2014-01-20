package com.hexacta.qappwebtest.pages

import com.hexacta.web_test_robot.AbstractPage

class HomePage extends AbstractPage {
	static url = ""
	
	static at = { title == "QA Application" } // TODO: preguntar por "QA Application" y "Audits and metrics for Hexacta projects"
	
	static content = {
	}
}