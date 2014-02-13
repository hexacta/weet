package com.hexacta.webtester.pages.crud

import com.hexacta.webtester.modules.PageableTableModule


abstract class EntityListPage extends EntityPage {
	// Menu options
	static int NEW = 1
		
	static content = {
		table { module PageableTableModule, tableBase: $("table"), navigationBase: $("div.pagination") }
	}

}