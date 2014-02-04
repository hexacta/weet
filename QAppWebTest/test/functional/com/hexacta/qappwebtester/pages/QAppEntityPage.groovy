package com.hexacta.qappwebtester.pages

import com.hexacta.qappwebtester.modules.PageMenuModule

abstract class QAppEntityPage extends QApplicationPage {
	// Page menu options
	static int HOME = 0
		
	static content = {
		pageMenu { module PageMenuModule }
	}
}