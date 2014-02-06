package com.hexacta.qappwebtester.pages

import com.hexacta.webtester.modules.NavigationMenuModule

abstract class QAppEntityPage extends QApplicationPage {
	// Page menu options
	static int HOME = 0
		
	static content = {
		pageMenu { module NavigationMenuModule, $("ul.nav")[1] }
	}
}