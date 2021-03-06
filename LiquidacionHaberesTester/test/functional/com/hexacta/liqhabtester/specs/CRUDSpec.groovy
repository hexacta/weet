package com.hexacta.liqhabtester.specs

import static com.hexacta.liqhabtester.pages.LiquidacionHaberesPage.*
import geb.Browser
import spock.lang.*

import com.hexacta.liqhabtester.modules.FilterModule.OpType
import com.hexacta.liqhabtester.pages.crud.CRUDPage
import com.hexacta.liqhabtester.pages.crud.CRUDPage.CRUDAction

//@Stepwise
abstract class CRUDSpec extends LiquidacionHaberesCRUDSpec {

	@Shared Map<String, CRUDField> crudFieldsMap = [:]
	
	abstract int getMenuItemIdx()
	abstract int getSubmenuItemIdx()
	abstract Class getEntityPage()
	
	abstract String getEntityIdField()
	abstract List<CRUDField> getCRUDFields()
	
	List<CRUDField> getTableFields() {
		crudFieldsMap.values().findAll { it.inTable }
	}
	
	abstract String getTableName()
	abstract String getColumnIdName()
	
	def getListPage() {
		entityPage.metaClass.getAction << {
			-> CRUDAction.LIST 
		}
		entityPage
	}
	
	def setup() {
		given:
		menu.expand(menuItemIdx).item(submenuItemIdx).click(listPage)
	}

	def cleanup() {
		if (entityPage.isInstance(page) && page.action == CRUDAction.LIST && filter.displayed) {
			filter.cancel()
		}	
		entityPage.metaClass.getAction << { -> null }
	}
	
	def setupSpec() {
		CRUDFields.each {
			crudFieldsMap.put(it.field, it) 
		}
	}
	
	def cleanupSpec() {
		// Delete the created entity instance from database, because the application doesn't provide away to do it.
		String statement = new String("delete from $tableName where $columnIdName = ${crudFieldsMap[entityIdField].value}")
		sql.execute( statement )
	}
	
	void searchEntityById(int expectedNr) {
		def value = crudFieldsMap[entityIdField].value
		
		// "Find the entity to be inserted is not present"
		openFilterPane()
		filter."$entityIdField" OpType.EQ, value
		filter.execute()

		// "No row present with searched value"
		assert table.pageRowCount == expectedNr
	}
	
	def "Create entity"() {
		when: "Find the entity to be inserted is not present"
		searchEntityById(0)
		
		and: "Navigate to new entity page and set the values for each entity property and save."
		newEntity()
		for ( crudField in crudFieldsMap.values() ) {
			page."${crudField.field}" = crudField.value 
		}
		saveEntity()

		then: "Search for the new entity"
		searchEntityById(1)
		
		and: "The row contains the same values used for the new entity"
		def row = table.row(0)
		for ( crudField in tableFields ) {
			row."${crudField.field}" == crudField.value 
		}
		
		and: "The entity is active"
		isHabilitado(row)
	}

	def "Update entity"() {
		when: "Search for the new entity"
		searchEntityById(1)

		and: "Navigate to the entity edit page"
		editRow(0)
		
		// TODO: check entityId
		then: "Check that its attributes are the same as the ones in the entity previously inserted."
		for ( crudField in crudFieldsMap.values() ) {
			// FIXME: no esta funcionando la comparacion del select por texto.
			if (!crudField.field in ['cargo', 'jerarquia']) {
				page."${crudField.field}" == crudField.value
			} 
		}
		
		when: "Update its attributes and save"
		for ( crudField in crudFieldsMap.values() ) {
			page."${crudField.field}" = crudField.updatedValue ?: crudField.value 
		}
		saveEntity()
		
		and: "Search for the edited entity"
		searchEntityById(1)
		
		then: "The row contains the same values used for updating the entity"
		def row = table.row(0)
		for ( crudField in tableFields ) {
			row."${crudField.field}" == crudField.updatedValue ?: crudField.value 
		}

		and: "The entity is active"
		isHabilitado(row)
    }

	def "Disable entity"() {
		when: "Search for the new entity"
		searchEntityById(1)
		def row = table.row(0)
		
		then: "Check it is active"
		isHabilitado(row)

		when: "Navigate to the entity edit page"
		editRow(0)
		disable()
		
		and: "Search for the entity set inactive"
		searchEntityById(1)

		then: "Check it is inactive"
		!isHabilitado(table.row(0))
	}

}