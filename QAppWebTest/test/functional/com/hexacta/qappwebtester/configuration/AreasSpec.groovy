package com.hexacta.qappwebtester.configuration

import static com.hexacta.qappwebtester.pages.crud.QAppEntityListPage.*
import static com.hexacta.qappwebtester.pages.QApplicationPage.*
import spock.lang.*

import com.hexacta.qappwebtester.specs.QApplicationCRUDSpec

//@Stepwise
class AreasSpec extends QApplicationCRUDSpec {

	static final String AREA_NAME = "webtest-area"

	static final String AREA_NAME_UPDATED = "webtest-area-updated"
	int entityId
	
	def setup() {
		given:
		menu.expand(CONFIGURATION).item(CONF_AREAS).click(AreasPage)
	}


	// @Ignore
    def "Area creation"() {
		when: "Find the entity to be inserted is not present"
		def rowCount, rowLink
		(rowCount, rowLink) = this.findRowInPages(0, AREA_NAME)
		
		then: "Check that the link for the searched value was found"
		rowLink == null
        
        when: "Navigate to new entity page and set the values for each entity property and save."
		pageMenu.item(NEW).click(AreaNewPage)
		name = AREA_NAME
		create.click(AreaShowPage)
		
		then: "Navigate to show entity page displaying the values for the new entity."
		// TODO: set entityId
		name == AREA_NAME
    }

	// @Ignore
	def "Area update"() {
        when: "Look for the inserted value in the entity list"
		// XXX: Si se ejecuta dentro del modulo esta tirando StaleElementReferenceException
		//def rowLink = table.findRowInPages("webtest-area")
		
		def rowCount, rowLink
		(rowCount, rowLink) = this.findRowInPages(0, AREA_NAME)
		
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
		name = AREA_NAME_UPDATED
		update.click(AreaShowPage)
		
		then: "Navigates back to the show enity page with the new values"
		name == AREA_NAME_UPDATED
    }

	def "Area delete"() {
		when: "Look for the inserted value in the entity list"
		// XXX: Si se ejecuta dentro del modulo esta tirando StaleElementReferenceException
		//def rowLink = table.findRowInPages("webtest-area")
		def rowCount, rowLink
		(rowCount, rowLink) = this.findRowInPages(0, AREA_NAME_UPDATED)
		
		then: "Check that the link for the searched value was found"
		rowLink != null
		
		when: "Navigate to the show entity page"
		rowLink.click(AreaShowPage)
		// TODO: check entityId

		then: "Check that its attributes are the same as the ones in the entity previously inserted."
		name == AREA_NAME_UPDATED
		
		when: "Click delete"
		delete.click(AreaShowPage)
		
		then: "Confirmation modal dialog is displayed"
		deleteConfirmation.displayed == true
		
		when: "Cancel deletion"
		deleteConfirmation.cancel.click(AreaShowPage)
		
		then: "Confirmation modal dialog is not displayed and go back to show entity page."
		deleteConfirmation.displayed == false
		
		when: "Click delete and Confirm deletion"
		delete.click(AreaShowPage)
		deleteConfirmation.confirm.click(AreasPage)
		def newRowCount
		(newRowCount, rowLink) = this.findRowInPages(0, AREA_NAME_UPDATED)
		
		then: "Navigate to entity list. Check the entity is not listed and the size decreased in one."
		rowLink == null
		rowCount == newRowCount + 1 // XXX: this works if the deleted value was in the last page
	}
}