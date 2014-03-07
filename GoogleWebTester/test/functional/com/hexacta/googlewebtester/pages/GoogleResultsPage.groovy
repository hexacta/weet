package com.hexacta.googlewebtester.pages


class GoogleResultsPage extends GoogleHomePage {
	static at = { title.endsWith "Google Search" }
	
	static content = {
		results { $("li.g") }
		resultLink { i -> results[i].find("a.l") }
	}
	
	def go(int i) {
		resultLink(i).click()
	}
	
	def resultText(int i) {
		resultLink(i).text()
	}
}