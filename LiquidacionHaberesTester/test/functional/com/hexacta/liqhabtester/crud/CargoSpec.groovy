package com.hexacta.liqhabtester.crud

import static com.hexacta.liqhabtester.pages.LiquidacionHaberesPage.*
import spock.lang.*

import com.hexacta.liqhabtester.specs.CRUDField
import com.hexacta.liqhabtester.specs.CRUDSpec

class CargoSpec extends CRUDSpec {

	List<CRUDField> getCRUDFields() {
		[
			new CRUDField(field: "codigo", value: "999"),
			new CRUDField(field: "descripcion", value: "WeetCargo", updatedValue: "WeetCargo-new"),
			new CRUDField(field: "descripcionCorta", value: "Weet", updatedValue: "WeetNew")
		]
	}
	
	int getMenuItemIdx() {
		CONFIGURACION
	}
	
	int getSubmenuItemIdx() {
		CONF_CARGOS
	}
	
	Class getEntityPage() {
		CargoPage
	}
	
	String getEntityIdField() {
		"codigo"
	}
	
	String getTableName() {
		"cargo"
	}
	
	String getColumnIdName() {
		"codigo"
	}
}