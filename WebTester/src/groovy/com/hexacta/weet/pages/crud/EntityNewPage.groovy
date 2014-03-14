package com.hexacta.weet.pages.crud


abstract class EntityNewPage extends EntityPage {
		
	static content = {
		create {  $("input", name: "create") }
	}
}