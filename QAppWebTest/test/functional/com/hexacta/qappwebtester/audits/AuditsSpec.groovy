package com.hexacta.qappwebtester.audits

import static com.hexacta.qappwebtester.pages.crud.QAppEntityListPage.*
import static com.hexacta.qappwebtester.pages.QApplicationPage.*
import spock.lang.*

import com.hexacta.qappwebtester.specs.QApplicationSpec

//@Stepwise
class AuditsSpec extends QApplicationSpec {

	static final String AUDIT_PROJECT = "Prueba Gerar"
	
	int entityId

	// @Ignore
    def "Audit creation"() {
		given:
		menu.expand(AUDITS).item(AUDIT_CREATE).click(AuditNewPage)
		
        when: "Navigate to new entity page and set the values for each entity property and save."
		project = AUDIT_PROJECT
		
		revisionManager.search = "Gerardo"
		revisionManager.selectValue("Gerardo Massenzano")
		
		from.value.click()
		from.prevMonth().click()
		from.selectDay(5)
		
		to.value = new Date().format('dd/MM/yyyy')
		date.value = new Date().format('dd/MM/yyyy')
		
		// waitFor { phase.displayed  }
		phase = "Desarrollo"
		
		create.click(AuditNewAnswerQuestionsPage)
		
		then: "Navigate to show entity page displaying the values for the new entity."
		groups.size() == 2
		groups[0].text().contains("Gesti�n de proyectos")
		groups[1].text().contains("Gesti�n de proyectos �giles")
		
		when:
		if (groups[0].isExpanded()) {
			groups[0].toogle
		}
		groups[1].toogle
		
		then:
		true
    }
}