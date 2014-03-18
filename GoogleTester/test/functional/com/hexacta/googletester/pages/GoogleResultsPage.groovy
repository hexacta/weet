package com.hexacta.googletester.pages


class GoogleResultsPage extends GoogleHomePage {
	static at = { title.endsWith "Google Search" }
	
	static content = {
		results { $("li.g") }
		resultLink { i -> results[i].find("a.l") }
	}
	
	void toResult(int i) {
		resultLink(i).click()
	}
	
	String resultText(int i) {
		resultLink(i).text()
	}
}