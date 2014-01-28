package com.hexacta.qappwebtest.pages

import com.hexacta.qappwebtest.modules.PageMenuModule

abstract class QAppEntityEditPage extends QAppEntityPage {
	// Menu options
	static int LIST = 1, NEW = 2
		
	static content = {
		update {  $("input", value: "Update").click() }
		delete {  $("button.btn btn-danger").click() }
	}
}