package com.hexacta.qappwebtester.specs

import static com.hexacta.qappwebtester.pages.QApplicationPage.*
import spock.lang.*

import com.hexacta.qappwebtester.audits.AuditsPage
import com.hexacta.qappwebtester.configuration.ProcessPage
import com.hexacta.qappwebtester.configuration.TemplatesPage

@Ignore
class NavigationMenuSpec extends QApplicationSpec {
/*
    def "Menu Configuration"() {
		given:
		def itemConfig = menu.item(CONFIGURATION)
		
        when: "username y clave correctos"
        itemConfig.click()
        
        then: "Redirects to home page"
		itemConfig.text().trim() == "Configuration"
    }
*/

    def "Navigate to Templates"() {
        when: ""
		def submenu = menu.clickItem(CONFIGURATION)
		submenu.clickItem(CONF_TEMPLATES, TemplatesPage)
        
        then: ""
		true
		waitFor { at TemplatesPage }
    }

    def "Navigate to Processes"() {
        when: ""
		def submenu = menu.clickItem(CONFIGURATION)
		submenu.item(CONF_PROCESSES).click(ProcessPage)
        
        then: ""
		waitFor { at ProcessPage }
    }

	def "Navigate to Audits"() {
		when: ""
		def submenu = menu.clickItem(AUDITS)
		submenu.item(AUDIT_LIST).click(AuditsPage)
		
		then: ""
		waitFor { at AuditsPage }
	}


}