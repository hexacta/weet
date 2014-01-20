package com.hexacta.googlewebtest.pages

import com.hexacta.web_test_robot.AbstractPage

class GoogleResultsPage extends AbstractPage {
	static at = { title.endsWith "Google Search" }
	
	static content = {
		// reuse our previously defined module
		search { module GoogleSearchModule, buttonValue: "Search" }

		// content definitions can compose and build from other definitions
		results { $("li.g") }
		result { i -> results[i] }
		resultLink { i -> result(i).find("a.l") }
		firstResultLink { resultLink(0) }
	}
}