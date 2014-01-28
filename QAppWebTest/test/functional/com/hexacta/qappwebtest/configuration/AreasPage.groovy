package com.hexacta.qappwebtest.configuration

import com.hexacta.qappwebtest.pages.QAppEntityListPage

class AreasPage extends QAppEntityListPage {
	static url = "area/list"
	
	static at = { $().text().contains("Areas List") } 
	
	static content = {
		
	}
}