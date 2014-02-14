package com.hexacta.webtester.pages.crud


abstract class EntityEditPage extends EntityPage {
		
	static content = {
		update {  $("input", value: "Update") }
		delete {  $("button", text: containsWord("Delete")) }
	}
}