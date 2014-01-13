package com.hexacta.web_test_robot_user.pages

import com.hexacta.web_test_robot.AbstractPage
import com.hexacta.web_test_robot_user.pages.modules.GoogleSearchModule;

class GoogleHomePage extends AbstractPage {
/*    
	static url = "http://google.com"
	
	static at = {
		title == "Google"
	}

	static content = {
		text     { $("input", name: "q") }
		search   { $("button", name: "btnG") }
	}
*/
	// pages can define their location, either absolutely or relative to a base
	static url = "http://google.com/ncr"
 
	// “at checkers” allow verifying that the browser is at the expected page
	static at = { title == "Google" }
 
	static content = {
		// include the previously defined module
		search { module GoogleSearchModule, buttonValue: "Google Search" }
	}
}