package com.hexacta.weet.specs

import spock.lang.*

abstract class NavigationMenuSpec extends ApplicationSpec {
	
	/**
	 * Returns a map with the configured menu, having:
	 * <p>
	 * Key: first level item label<br/>
	 * Value: string list of second level item labels for the corresponding first level item.
	 */
	abstract Map getMenuConfig()
				
    def "Check valid menu options"() {
		expect: "Check menu size (first level items)"
		menu.items.size() == menuConfig.size()
		
		// For each first level item
		for ( submenuLabels in menuConfig ) {
	        when: "Obtain the item using the configured label"
			def item = menu.item(submenuLabels.key)
	        
	        then: "Check it exists"
			item != null
			
			when: "Expand the item and get its submenu"
			def submenu = menu.expand(item)
			
			then: "Check submenu size (second level items)"
			submenu.items.size() == submenuLabels.value.size()
			
			// For each second label item
			for ( itemLabel in submenuLabels.value ) {
				and: "Check a submenu item exists for the corresponding label"
				submenu.item(itemLabel) != null
			}
		}
    }
}