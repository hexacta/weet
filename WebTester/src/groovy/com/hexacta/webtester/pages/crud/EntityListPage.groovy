package com.hexacta.webtester.pages.crud

import com.hexacta.webtester.modules.PageableTableModule


abstract class EntityListPage extends EntityPage {
		
	static content = {
		table { module PageableTableModule, tableBase: $("table"), navigationBase: $("div.pagination") }
	}

}