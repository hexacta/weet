package com.hexacta.liqhabtester.page

import com.hexacta.webtester.AbstractPage

class HomePage extends LiquidacionHaberesPage {
	static url = ""
	
	static at = { $("img", src: contains("home_gna.png")) } 
	
	static content = {
	}
}