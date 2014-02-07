package com.hexacta.qappwebtester.pages

import com.hexacta.webtester.pages.crud.EntityListPage

abstract class QAppEntityListPage extends EntityListPage {
	// Menu options
	static int NEW = 1
		
	static content = {
		create { pageMenu.item(NEW) } 
	}
}