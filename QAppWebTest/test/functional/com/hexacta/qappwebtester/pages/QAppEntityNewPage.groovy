package com.hexacta.qappwebtester.pages

import com.hexacta.qappwebtester.modules.PageMenuModule

abstract class QAppEntityNewPage extends QAppEntityPage {
	// Menu options
	static int LIST = 1
		
	static content = {
		create {  $("input", name: "create") }
	}
}