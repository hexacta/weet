package com.hexacta.liqhabtester.roles

import static com.hexacta.liqhabtester.pages.LiquidacionHaberesPage.*
import spock.lang.*

import com.hexacta.liqhabtester.specs.LiquidacionHaberesSpec

class NavigationMenuSpec extends LiquidacionHaberesSpec {
    def "Check valid menu options"() {
        when: ""
		def item = menu.item("Personal")
        
        then: ""
		item != null
		
		when:
		def submenu = menu.expand(item)
		
		then:
		submenu.size() == 1
		submenu.items.size() == 2
		submenu.item("Consulta de empleados") != null
		submenu.item("Importar movimientos de RRHH") != null
    }


}