package com.hexacta.webtester.specs

import spock.lang.*

abstract class NavigationMenuSpec extends ApplicationSpec {
	
	abstract Map getMenuConfig()
				
    def "Check valid menu options"() {
		expect:
		menu.items.size() == menuConfig.size()
		
		for ( submenuLabels in menuConfig ) {
	        when: ""
			def item = menu.item(submenuLabels.key)
	        
	        then: ""
			item != null
			
			when:
			def submenu = menu.expand(item)
			
			then:
			submenu.items.size() == submenuLabels.value.size()
			for ( itemLabel in submenuLabels.value ) {
				submenu.item(itemLabel) != null
			}
		}
		
    }


}