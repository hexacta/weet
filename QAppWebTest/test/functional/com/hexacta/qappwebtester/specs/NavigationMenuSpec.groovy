package com.hexacta.qappwebtester.specs

import static com.hexacta.qappwebtester.pages.QApplicationPage.*
import spock.lang.*

import com.hexacta.qappwebtester.audits.AuditsPage
import com.hexacta.qappwebtester.configuration.ProcessPage
import com.hexacta.qappwebtester.configuration.TemplatesPage

@Ignore
class NavigationMenuSpec extends QApplicationSpec {
    def "Navigate to Templates"() {
        when: ""
		menu.expand(CONFIGURATION).item(CONF_TEMPLATES).click(TemplatesPage)
        
        then: ""
		true
		waitFor { at TemplatesPage }
    }

    def "Navigate to Processes"() {
        when: ""
		menu.expand(CONFIGURATION).item(CONF_PROCESSES).click(ProcessPage)
        
        then: ""
		waitFor { at ProcessPage }
    }

	def "Navigate to Audits"() {
		when: ""
		menu.expand(AUDITS).item(AUDIT_LIST).click(AuditsPage)
		
		then: ""
		waitFor { at AuditsPage }
	}

}