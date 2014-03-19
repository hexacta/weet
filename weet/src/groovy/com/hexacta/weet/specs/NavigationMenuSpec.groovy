package com.hexacta.weet.specs

import spock.lang.*

/**
 * Common main navigation menu specifications.
 * 
 * @author gmassenzano
 */
abstract class NavigationMenuSpec extends ApplicationSpec {
	
	/**
	 * Returns a map with the configured menu, having:
	 * <p>
	 * Key: first level item label<br/>
	 * Value: string list of second level item labels for the corresponding first level item.
	 */
	abstract Map getMenuConfig()

	/**
	 * Tests that current navigation menu has the expected items and submenus. It check all labels are correct. 				
	 */
	def "Check valid menu options"() {
		expect:
		checkMenuOptions(menu, menuConfig)
	}

	/**
	 * 
	 * @param menu
	 * @param config
	 */
	void checkMenuOptions(def menu, def config) {
		// expect: "Check menu size (first level items)"
		assert menu.items.size() == config.size()
		
		if (config instanceof List) {
			// For each first level item
			for ( itemLabel in config ) {
				def item = menu.item(itemLabel)
				assert item != null
				assert menu.isLeaf(item)
			}
		} else {
			// For each first level item
			for ( submenuConfigMap in config ) {
				// when: "Obtain the item using the configured label"
				def item = menu.item(submenuConfigMap.key)
				
				// then: "Check it exists"
				assert item != null
				
				// when: "It is a leaf"
				if (menu.isLeaf(item)) {
					// then: "No config labels should have as children"
					assert submenuConfigMap.value?.empty
				} else {
					// when: "It is not a leaf, expand the item and get its submenu"
					def submenu = menu.expand(item)
					
					// then: "Execute recursive call with submenu and its expected config"
					checkMenuOptions(submenu, submenuConfigMap.value)
				}
			}
		}
	}

}