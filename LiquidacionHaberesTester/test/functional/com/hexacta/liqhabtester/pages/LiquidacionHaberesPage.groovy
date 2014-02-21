package com.hexacta.liqhabtester.pages

import com.hexacta.webtester.modules.NavigationMenuModule
import com.hexacta.webtester.pages.ApplicationPage

abstract class LiquidacionHaberesPage extends ApplicationPage {
	// Menu options
	static int PERSONAL = 0, NOVEDADES = 1, LIQUIDACION = 2, CONFIGURACION = 3
	
	// Configuration submenu
	static int CONF_GRADOS = 13
		
	static content = {
		menu { module NavigationMenuModule, $("ul" , id: "menu"), itemBase: "li.menu_right" }
		
		userMenu { $("li.menu_logout_right a.drop_logout") }
	}
}