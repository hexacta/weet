package com.hexacta.webtester.pages.crud


abstract class EntityEditPage extends EntityPage {
	// Menu options
	static int LIST = 1, NEW = 2
		
	static content = {
		update {  $("input", value: "Update") }
		delete {  $("button", text: containsWord("Delete")) }
	}
}