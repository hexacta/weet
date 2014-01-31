package com.hexacta.qappwebtest.audits

import static com.hexacta.qappwebtest.pages.QAppEntityListPage.*
import static com.hexacta.qappwebtest.pages.QAppEntityPage.*
import static com.hexacta.qappwebtest.pages.QApplicationPage.*
import spock.lang.*

import com.hexacta.qappwebtest.specs.QApplicationSpec

//@Stepwise
class AuditsSpec extends QApplicationSpec {

	static final String AUDIT_PROJECT = "Prueba Gerar"
	
	int entityId

	// @Ignore
    def "Audit creation"() {
		given:
		def submenu = menu.clickItem(AUDITS)
		submenu.item(AUDIT_CREATE).click(AuditNewPage)
		
        when: "Navigate to new entity page and set the values for each entity property and save."
		project = AUDIT_PROJECT
		waitFor { phase.displayed  }
		phase = "Desarrollo"
		revisionManager.search = "Gerardo"
		revisionManager.selectValue("Gerardo Massenzano")
		
		from.value.click()
		from.prevMonth().click()
		from.selectDay(5)
		
		to.value = new Date().format('dd/MM/yyyy')
		date.value = new Date().format('dd/MM/yyyy')
		create.click()
		
		then: "Navigate to show entity page displaying the values for the new entity."
		true
    }
}