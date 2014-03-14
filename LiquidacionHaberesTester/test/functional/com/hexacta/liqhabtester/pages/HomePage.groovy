package com.hexacta.liqhabtester.pages

import com.hexacta.weet.pages.AbstractPage;

class HomePage extends LiquidacionHaberesPage {
	static url = ""
	
	static at = { $("img", src: contains("home_gna.png")) } 
	
	static content = {
	}
}