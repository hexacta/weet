package com.hexacta.liqhabtester.page

import com.hexacta.webtester.modules.NavigationMenuModule
import com.hexacta.webtester.pages.AbstractPage

abstract class LiquidacionHaberesPage extends AbstractPage {
	// Menu options
	static int PERSONAL = 0, NOVEDADES = 1, LIQUIDACION = 2, CONFIGURACION = 3
	
	// Configuration submenu
	static int CONF_GRADOS = 13
		
	static content = {
		menu { module NavigationMenuModule, $("ul" , id: "menu") }
	}
}