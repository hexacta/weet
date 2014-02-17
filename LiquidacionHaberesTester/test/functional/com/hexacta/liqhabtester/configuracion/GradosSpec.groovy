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
		(rowCount, rowLink) = this.findRowInPages(0, "9.999")

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
		// FIXME: no esta funcionando la comparacion del select por texto.
//		cargoText        == CARGO
//		jerarquia        == JERARQUIA
		codigo           == CODIGO
		descripcion      == DESCRIPCION
		descripcionCorta == DESC_CORTA
	}

	// @Ignore
	def "Grado update"() {
        when: "Look for the inserted value in the entity list"
		// XXX: Si se ejecuta dentro del modulo esta tirando StaleElementReferenceException
		//def rowLink = table.findRowInPages("webtest-area")
		
		def rowCount, rowLink
		(rowCount, rowLink) = this.findRowInPages(0, "9.999")
		
		then: "Check that the link for the searched value was found"
		rowLink != null
		
		when: "Navigate to the show entity page"
		rowLink.click(GradoEditPage)
		// TODO: check entityId

		then: "Check that its attributes are the same as the ones in the entity previously inserted."
		// FIXME: no esta funcionando la comparacion del select por texto.
//		cargoText        == CARGO
//		jerarquia        == JERARQUIA
		codigo           == CODIGO
		descripcion      == DESCRIPCION
		descripcionCorta == DESC_CORTA
		
		when: "Update its attributes and save"
		cargo            = CARGO
		jerarquia        = JERARQUIA
		codigo           = CODIGO
		descripcion      = DESCRIPCION + "XX"
		descripcionCorta = DESC_CORTA + "Z"
		update.click(GradosPage)
		
		(rowCount, rowLink) = this.findRowInPages(0, "9.999")
		
		then: "Check that the link for the searched value was found"
		rowLink != null

		when: "Navigate to the show entity page"
		rowLink.click(GradoEditPage)
		
		then:
		// FIXME: no esta funcionando la comparacion del select por texto.
//		cargoText        == CARGO
//		jerarquia        == JERARQUIA
		codigo           == CODIGO
		descripcion      == DESCRIPCION  + "XX"
		descripcionCorta == DESC_CORTA + "Z"
		
		cleanup: "borro el usuario"
		sql.execute( "delete from grado where codigo = $CODIGO" )
    }
/*
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
	@Ignore
	def "Paginacion correcta"() {
		expect: "Pagina inicial"
		table.pageRowCount == 10
		table.currentPage == 1
		table.firstPage
		!table.lastPage
		
		when: "user navigates to 2nd page of results"
		table.toPage(2)

		then:
		// at GradosPage
		table.pageRowCount == 10
		table.currentPage == 2
		!table.firstPage
		!table.lastPage
		
		when: "user navigates to last page of results"
		table.toPage(8)

		then:
		// at GradosPage
		table.pageRowCount == 5
		table.currentPage == 8
		!table.firstPage
		table.lastPage
		
		when: "user navigates back to 1st page of results"
		table.toPage(1)

		then:
		// at GradosPage
		table.pageRowCount == 10
		table.currentPage == 1
		
		when: "user uses next button to go to 2nd page"
		table.nextPage()
		
		then:
		// at GradosPage
		table.pageRowCount == 10
		table.currentPage == 2
		
		when: "user uses previous button to go back to 1st page"
		table.prevPage()

		then:
		// at GradosPage
		table.pageRowCount == 10
		table.currentPage == 1
	}

}