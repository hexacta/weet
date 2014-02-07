package com.hexacta.webtester.pages.crud


abstract class EntityNewPage extends EntityPage {
	// Menu options
	static int LIST = 1
		
	static content = {
		create {  $("input", name: "create") }
	}
}