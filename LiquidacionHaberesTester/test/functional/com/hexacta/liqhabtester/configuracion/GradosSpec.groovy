package com.hexacta.liqhabtester.configuracion

//import static com.hexacta.qappwebtester.pages.QAppEntityListPage.*
//import static com.hexacta.qappwebtester.pages.QAppEntityPage.*
import static com.hexacta.liqhabtester.pages.LiquidacionHaberesPage.*
import spock.lang.*

import com.hexacta.liqhabtester.specs.LiquidacionHaberesCRUDSpec

//@Stepwise
class GradosSpec extends LiquidacionHaberesCRUDSpec {

	static final String CODIGO = "9999", CARGO = "1 - Militares", JERARQUIA = "Oficial Jefes", 
		DESCRIPCION = "WebTesterGrado", DESC_CORTA = "WTst" 

	int entityId
	
	def setup() {
		given:
		menu.expand(CONFIGURACION).item(CONF_GRADOS).click(GradosPage)
	}

	@Ignore
	def "Buscar codigo"() {
		when: "Find the entity to be inserted is not present"
		def row = table.findRow(0, CODIGO)
		row.click(GradoEditPage)

		then: "Check that the link for the searched value was found"
		true
	}

	// @Ignore
	// TODO: revisar el getValue de los selects
	def "Grado creation"() {
		when: "Find the entity to be inserted is not present"
		def rowCount, rowLink
		(rowCount, rowLink) = this.findRowInPages(0, CODIGO)

		then: "Check that the link for the searched value was found"
		rowLink == null

		when: "Navigate to new entity page and set the values for each entity property and save."
		create.click(GradoNewPage)
		cargo            = CARGO
		jerarquia        = JERARQUIA
		codigo           = CODIGO
		descripcion      = DESCRIPCION
		descripcionCorta = DESC_CORTA
		create.click(GradosPage)

		(rowCount, rowLink) = this.findRowInPages(0, "9.999")
		
		then: "Check that the link for the searched value was found"
		rowLink != null

		when: "Navigate to the show entity page"
		rowLink.click(GradoEditPage)
		
		then:
		def cargoElem = cargo
		def cargoValue = cargoValue
		def cargoVal = cargo.value()
		def cargoText = cargo.text()
		def selected = cargo.find("option", selected: "selected")
		def selVal = selected?.value()
		def selText = selected?.text()
		def cargoFilter = cargo.filter(":selected")
		def cargoFilterText = cargoFilter.text()  
		cv            == CARGO
		jerarquia        == JERARQUIA
		codigo           == CODIGO
		descripcion      == DESCRIPCION
		descripcionCorta == DESC_CORTA
	}
/*
	// @Ignore
	def "Area update"() {
        when: "Look for the inserted value in the entity list"
		// XXX: Si se ejecuta dentro del modulo esta tirando StaleElementReferenceException
		//def rowLink = table.findRowInPages("webtest-area")
		
		def rowCount, rowLink
		(rowCount, rowLink) = this.findRowInPages(AREA_NAME)
		
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
		(rowCount, rowLink) = this.findRowInPages(AREA_NAME_UPDATED)
		
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
		(newRowCount, rowLink) = this.findRowInPages(AREA_NAME_UPDATED)
		
		then: "Navigate to entity list. Check the entity is not listed and the size decreased in one."
		rowLink == null
		rowCount == newRowCount + 1 // XXX: this works if the deleted value was in the last page
	}

*/	
}