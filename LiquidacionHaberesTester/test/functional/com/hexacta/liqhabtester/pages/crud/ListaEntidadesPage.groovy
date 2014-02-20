package com.hexacta.liqhabtester.pages.crud

import com.hexacta.webtester.pages.crud.EntityListPage

class ListaEntidadesPage extends EntityListPage {
	
	static content = {
		create { $("a", name: "create") }
		
		userMenu { $("li.menu_logout_right a.drop_logout") }
	}

	boolean isHabilitado(row) {
		def td = row.find("td").last()
		def enable = td.find("input", class: "enableFila")
		enable.size() == 1
	}
}