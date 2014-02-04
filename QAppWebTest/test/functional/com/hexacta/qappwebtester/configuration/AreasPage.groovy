package com.hexacta.qappwebtester.configuration

import com.hexacta.qappwebtester.pages.QAppEntityListPage

class AreasPage extends QAppEntityListPage {
	static url = "area/list"
	
	static at = { $().text().contains("Areas List") } 
	
	static content = {
		
	}
}