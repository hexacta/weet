package com.hexacta.qappwebtester.configuration

import com.hexacta.qappwebtester.pages.QAppEntityShowPage

class AreaShowPage extends QAppEntityShowPage {
	static url = "area/show"
	
	static at = { $().text().contains("Show Area") } 
	
	static content = {
		nameLabel  {  $("label", text: "Name") }
		name       {  $(nameLabel).next().find("input") }
	}
}