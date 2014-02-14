package com.hexacta.webtester.pages

import com.hexacta.webtester.modules.NavigationMenuModule
import com.hexacta.webtester.pages.AjaxPage

abstract class ApplicationPage extends AjaxPage {

	static content = {
		menu { module NavigationMenuModule, $("ul" , id: "menu") }
	}
}