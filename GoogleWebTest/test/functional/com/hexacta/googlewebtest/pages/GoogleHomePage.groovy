package com.hexacta.googlewebtest.pages

import com.hexacta.googlewebtest.pages.modules.GoogleSearchModule
import com.hexacta.web_test_robot.AbstractPage

class GoogleHomePage extends AbstractPage {
	// pages can define their location, either absolutely or relative to a base
	static url = "http://google.com/ncr"
 
	// �at checkers� allow verifying that the browser is at the expected page
	static at = { title == "Google" }
 
	static content = {
		// include the previously defined module
		search { module GoogleSearchModule, buttonValue: "Google Search" }
	}
}