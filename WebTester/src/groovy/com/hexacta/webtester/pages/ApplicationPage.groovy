package com.hexacta.webtester.pages

import com.hexacta.webtester.modules.NavigationMenuModule
import com.hexacta.webtester.pages.AjaxPage

abstract class ApplicationPage extends AjaxPage {

	def getMenuBase() {
		$("ul" , id: "menu")
	}
	 		
	static content = {
		menu { module NavigationMenuModule, menuBase }
	}
}