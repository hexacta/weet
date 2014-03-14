package com.hexacta.googletester.pages

import com.hexacta.googletester.pages.modules.GoogleSearchModule
import com.hexacta.weet.pages.AjaxPage

class GoogleHomePage extends AjaxPage {
	// pages can define their location, either absolutely or relative to a base
	static url = "http://google.com/ncr"
 
	// “at checkers” allow verifying that the browser is at the expected page
	static at = { title == "Google" }
 
	static content = {
		// include the previously defined module
		search { module GoogleSearchModule }
	}
	
	def searchText(String text) {
		search.text.value("wikipedia")
		search.button.click()
		sleep(1000)
	}
}