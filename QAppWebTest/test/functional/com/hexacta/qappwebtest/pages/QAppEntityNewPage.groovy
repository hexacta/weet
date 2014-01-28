package com.hexacta.qappwebtest.pages

import com.hexacta.qappwebtest.modules.PageMenuModule

abstract class QAppEntityNewPage extends QAppEntityPage {
	// Menu options
	static int LIST = 1
		
	static content = {
		create {  $("input", name: "create") }
	}
}