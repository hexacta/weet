package com.hexacta.qappwebtest.pages

import com.hexacta.qappwebtest.modules.PageMenuModule

abstract class QAppEntityPage extends QApplicationPage {
	// Page menu options
	static int HOME = 0
		
	static content = {
		pageMenu { module PageMenuModule }
	}
}