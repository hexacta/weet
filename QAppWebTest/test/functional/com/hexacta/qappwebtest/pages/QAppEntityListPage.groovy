package com.hexacta.qappwebtest.pages

import com.hexacta.qappwebtest.modules.PageableTableModule

abstract class QAppEntityListPage extends QAppEntityPage {
	// Menu options
	static int NEW = 1
		
	static content = {
		table { module PageableTableModule, tableBase: $("table"), navigationBase: $("div.pagination") }
	}
}