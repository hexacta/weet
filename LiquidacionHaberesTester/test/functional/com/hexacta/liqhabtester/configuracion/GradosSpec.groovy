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

	def cleanupSpec() {
		// Delete the created Grado instance from database, because the application doesn't provide away to do it.
		sql.execute( "delete from grado where codigo = $CODIGO" )
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
	def "Crear Grado"() {
		when: "Find the entity to be inserted is not present"
		def rowCount, row
		(rowCount, row) = this.findRowInPages(0, "9.999")

		then: "Check that the link for the searched value was found"
		row == null

		when: "Navigate to new entity page and set the values for each entity property and save."
		create.click(GradoNewPage)
		cargo            = CARGO
		// jerarquia        = JERARQUIA
		codigo           = CODIGO
		descripcion      = DESCRIPCION
		descripcionCorta = DESC_CORTA
		create.click(GradosPage)

		int newRowCount
		(newRowCount, row) = this.findRowInPages(0, "9.999")
		
		then: "Check that the link for the searched value was found"
		row != null
		rowCount + 1 == newRowCount
		isHabilitado(row)

		when: "Navigate to the show entity page"
		row.click(GradoEditPage)
		
		then:
		// FIXME: no esta funcionando la comparacion del select por texto.
//		cargoText        == CARGO
//		jerarquia        == JERARQUIA
		codigo           == CODIGO
		descripcion      == DESCRIPCION
		descripcionCorta == DESC_CORTA
	}

	// @Ignore
	def "Actualizar Grado"() {
        when: "Look for the inserted value in the entity list"
		def rowCount, row
		(rowCount, row) = this.findRowInPages(0, "9.999")
		
		then: "Check that the link for the searched value was found"
		row != null
		
		when: "Navigate to the entity edit page"
		row.click(GradoEditPage)
		// TODO: check entityId

		then: "Check that its attributes are the same as the ones in the entity previously inserted."
		// FIXME: no esta funcionando la comparacion del select por texto.
//		cargoText        == CARGO
//		jerarquia        == JERARQUIA
		codigo           == CODIGO
		descripcion      == DESCRIPCION
		descripcionCorta == DESC_CORTA
		
		when: "Update its attributes and save"
//		cargo            = CARGO
//		jerarquia        = JERARQUIA
//		codigo           = CODIGO
		descripcion      = DESCRIPCION + "XX"
		descripcionCorta = DESC_CORTA + "Z"
		update.click(GradosPage)
		
		int newRowCount
		(newRowCount, row) = this.findRowInPages(0, "9.999")
		
		then: "Check that the link for the searched value was found"
		row != null
		rowCount == newRowCount

		when: "Navigate to the show entity page"
		row.click(GradoEditPage)
		
		then:
		// FIXME: no esta funcionando la comparacion del select por texto.
//		cargoText        == CARGO
//		jerarquia        == JERARQUIA
		codigo           == CODIGO
		descripcion      == DESCRIPCION  + "XX"
		descripcionCorta == DESC_CORTA + "Z"
    }

	def "Deshabilitar Grado"() {
		when: "Look for the inserted value in the entity list"
		def rowCount, row
		(rowCount, row) = this.findRowInPages(0, "9.999")
		
		then: "Check that the link for the searched value was found"
		row != null
		
		when: "Navigate to the entity edit page"
		row.click(GradoEditPage)

		then: "Check that its attributes are the same as the ones in the entity previously updated."
		// FIXME: no esta funcionando la comparacion del select por texto.
//		cargoText        == CARGO
//		jerarquia        == JERARQUIA
		codigo           == CODIGO
		descripcion      == DESCRIPCION  + "XX"
		descripcionCorta == DESC_CORTA + "Z"
		
		when: "Click delete"
		delete.click(GradosPage)
		
		def newRowCount
		(newRowCount, row) = this.findRowInPages(0, "9.999")
		
		then: "Navigate to entity list. Check the entity is not listed and the size decreased in one."
		row != null
		!isHabilitado(row)
		rowCount == newRowCount
	}

	// @Ignore
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