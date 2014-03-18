package com.hexacta.foxtester.pages


class HomePage extends FoxPage {
	static url = ""
	
	static at = { $("div.persubText", text: contains("For support or user permissions send an email to ")) } 
	
	static content = {
	}
}