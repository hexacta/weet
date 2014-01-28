package com.hexacta.qappwebtest.pages

import com.hexacta.qappwebtest.modules.PageMenuModule

abstract class QAppEntityShowPage extends QAppEntityPage {
	// Page menu options
	static int LIST = 1, NEW = 2
	
	static content = {
		edit {  $("a", text: contains("Edit")).click() }
		delete {  $("button", text: contains("Delete")).click() }
	}
}