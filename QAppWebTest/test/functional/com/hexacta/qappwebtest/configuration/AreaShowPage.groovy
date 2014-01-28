package com.hexacta.qappwebtest.configuration

import com.hexacta.qappwebtest.pages.QAppEntityShowPage

class AreaShowPage extends QAppEntityShowPage {
	static url = "area/show"
	
	static at = { $().text().contains("Show Area") } 
	
	static content = {
		nameLabel  {  $("label", text: "Name") }
		name       {  $(nameLabel).next().find("input") }
	}
}