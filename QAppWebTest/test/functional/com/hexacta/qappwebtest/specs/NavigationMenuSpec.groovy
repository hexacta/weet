package com.hexacta.qappwebtest.specs

import static com.hexacta.qappwebtest.pages.QApplicationPage.*
import spock.lang.*

import com.hexacta.qappwebtest.pages.HomePage

class NavigationMenuSpec extends QApplicationSpec {

    def "Menu Configuration"() {
		given:
		def itemConfig = menu.item(CONFIGURATION)
		
        when: "username y clave correctos"
        itemConfig.click()
        
        then: "Redirects to home page"
		itemConfig.text().trim() == "Configuration"
    }
    
}