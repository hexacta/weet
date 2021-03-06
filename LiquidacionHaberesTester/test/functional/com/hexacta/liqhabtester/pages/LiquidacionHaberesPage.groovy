package com.hexacta.liqhabtester.pages

import com.hexacta.weet.modules.NavigationMenuModule
import com.hexacta.weet.pages.ApplicationPage

abstract class LiquidacionHaberesPage extends ApplicationPage {
	// Menu options
	static int PERSONAL = 0, NOVEDADES = 1, LIQUIDACION = 2, CONFIGURACION = 3
	
	// Configuration submenu
	static int CONF_SUBUNIDADES = 7, CONF_CARGOS = 11, CONF_GRADOS = 13
		
	static content = {
		menu { module NavigationMenuModule, $("ul" , id: "menu"), itemBase: "li.menu_right" }
		
		userMenu { $("li.menu_logout_right a.drop_logout") }
	}
}