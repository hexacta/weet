package com.hexacta.liqhabtester.configuracion

import static com.hexacta.liqhabtester.pages.LiquidacionHaberesPage.*
import geb.download.DownloadException
import spock.lang.*

import com.hexacta.liqhabtester.modules.FilterModule.OpType;
import com.hexacta.liqhabtester.specs.LiquidacionHaberesCRUDSpec

//@Stepwise
class GradosSpec extends LiquidacionHaberesCRUDSpec {

	static final String CODIGO = "999", CARGO = "1 - Militares", JERARQUIA = "Oficial Jefes", 
		DESCRIPCION = "WeetGrado", DESC_CORTA = "WTst" 

	int entityId
	
	def setup() {
		given:
		menu.expand(CONFIGURACION).item(CONF_GRADOS).click(GradosPage)
	}

	def cleanup() {
		if (page instanceof GradosPage && filter.displayed) {
			filter.cancel()
		}	
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

	void searchEntityById(String field, String value, int expectedNr) {
		// "Find the entity to be inserted is not present"
		openFilterPane()
		filter."$field" OpType.EQ, value
		filter.execute()

		// "No row present with searched value"
		assert table.pageRowCount == expectedNr
	}
	
	def "Crear Grado"() {
		when: "Find the entity to be inserted is not present"
		searchEntityById("codigo", CODIGO, 0)
		
		and: "Navigate to new entity page and set the values for each entity property and save."
		create.click(GradoNewPage)
		cargo            = CARGO
		// jerarquia        = JERARQUIA
		codigo           = CODIGO
		descripcion      = DESCRIPCION
		descripcionCorta = DESC_CORTA
		create.click(GradosPage)

		then: "Search for the new entity"
		searchEntityById("codigo", CODIGO, 1)
		
		and: "The row contains the same values used for the new entity"
		def row = table.row(0)
		row.with {
			cargo            == CARGO
			jerarquia        == ""
			codigo           == CODIGO
			descripcion      == DESCRIPCION
			descripcionCorta == DESC_CORTA
		}
		
		and: "The entity is active"
		isHabilitado(row)
	}

	// @Ignore
	def "Actualizar Grado"() {
		when: "Search for the new entity"
		searchEntityById("codigo", CODIGO, 1)

		and: "Navigate to the entity edit page"
		table.row(0).click(GradoEditPage)
		
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
		
		and: "Search for the edited entity"
		searchEntityById("codigo", CODIGO, 1)
		
		then: "The row contains the same values used for updating the entity"
		def row = table.row(0)
		row.with {
			cargo            == CARGO
			jerarquia        == ""
			codigo           == CODIGO
			descripcion      == DESCRIPCION + "XX"
			descripcionCorta == DESC_CORTA + "Z"
		}

		and: "The entity is active"
		isHabilitado(row)
    }

	def "Deshabilitar Grado"() {
		when: "Search for the new entity"
		searchEntityById("codigo", CODIGO, 1)
		def row = table.row(0)
		
		then: "Check it is active"
		isHabilitado(row)

		when: "Navigate to the entity edit page"
		row.click(GradoEditPage)
		delete.click(GradosPage)
		
		and: "Search for the entity set inactive"
		searchEntityById("codigo", CODIGO, 1)

		then: "Check it is inactive"
		!isHabilitado(table.row(0))
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

	def "Filtrar Grado"() {
		expect:
		!filter.displayed
		
		when:
		openFilterPane()
		
		then:
		filter.displayed
		
		when:
		filter.codigo OpType.EQ, 1
		filter.execute()
		
		then:
		table.pageRowCount == 1
		
		when:
		openFilterPane()
		filter.clear()
		filter.pepe OpType.EQ, 1

		then:
		NoSuchFieldException ex = thrown()
		// Alternative syntax: def ex = thrown(InvalidDeviceException)
		ex.message == 'pepe is not a valid filter field.'
	}

	@FailsWith(DownloadException)
	// FIXME: java.security.cert.CertificateException: No name matching hxgna01 found
	def "Export excel"() {
		when:
		def bytes = downloadBytes(export.excel.@href)
		
		then:
		true
	}
}