package com.hexacta.qappwebtester.pages

import com.hexacta.qappwebtester.modules.PageableTableModule

abstract class QAppEntityListPage extends QAppEntityPage {
	// Menu options
	static int NEW = 1
		
	static content = {
		table { module PageableTableModule, tableBase: $("table"), navigationBase: $("div.pagination") }
	}
}