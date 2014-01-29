package com.hexacta.qappwebtest.configuration

import static com.hexacta.qappwebtest.pages.QAppEntityListPage.*
import static com.hexacta.qappwebtest.pages.QAppEntityPage.*
import static com.hexacta.qappwebtest.pages.QApplicationPage.*
import spock.lang.*

import com.hexacta.qappwebtest.specs.QApplicationSpec

//@Stepwise
class AreasSpec extends QApplicationSpec {

	static final String AREA_NAME = "webtest-area"
	int entityId
	
	def setup() {
		given:
		def submenu = menu.clickItem(CONFIGURATION)
		submenu.item(CONF_AREAS).click(AreasPage)
	}


	@Ignore
    def "Area creation"() {
        given: "From the entity list navigate to new entity page."
		pageMenu.item(NEW).click(AreaNewPage)
        
        when: "Set the values for each entity property and save."
		name = AREA_NAME
		create.click(AreaShowPage)
		
		then: "Navigate to show entity page displaying the values for the new entity."
		// TODO: set entityId
		name == AREA_NAME
    }

    def "Area update"() {
        when: "Look for the inserted value in the entity list"
		// XXX: Si se ejecuta dentro del modulo esta tirando StaleElementReferenceException
		//def rowLink = table.findRowInPages("webtest-area")
		
		def lastValue = table.findLastValue()
		while (lastValue < AREA_NAME) {
			table.nextPage.click(AreasPage)
			lastValue = table.findLastValue()
		}
		def rowLink = table.findRowLink(AREA_NAME)
		
		then: "Check that the link for the searched value was found"
		rowLink != null
		
		when: "Navigate to the show entity page"
		rowLink.click(AreaShowPage)
		// TODO: check entityId

		then: "Check that its attributes are the same as the ones in the entity previously inserted."
		name == AREA_NAME
		
		when: "Navigate to the entity edition page"
		edit.click(AreaEditPage)
		
		then: "Check that its attributes are the same as the ones in the entity previously inserted."
		name == AREA_NAME
		
		when: "Update its attributes and save"
		name = "webtest-area-updated"
		update.click(AreaShowPage)
		
		then: "Navigates back to the show enity page with the new values"
		name == "webtest-area-updated"
    }

}