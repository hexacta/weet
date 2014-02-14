package com.hexacta.webtester.pages.crud


abstract class EntityNewPage extends EntityPage {
		
	static content = {
		create {  $("input", name: "create") }
	}
}