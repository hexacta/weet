package com.hexacta.liqhabtester.crud

import static com.hexacta.liqhabtester.pages.LiquidacionHaberesPage.*
import spock.lang.*

import com.hexacta.liqhabtester.specs.CRUDField
import com.hexacta.liqhabtester.specs.CRUDSpec

class GradoSpec extends CRUDSpec {

	List<CRUDField> getCRUDFields() {
		[
			new CRUDField(field: "codigo", value: "999"),
			new CRUDField(field: "cargo", value: "1 - Militares"),
			new CRUDField(field: "descripcion", value: "WeetGrado", updatedValue: "WeetGrado-new"),
			new CRUDField(field: "descripcionCorta", value: "Weet", updatedValue: "WeetNew")
		]
	}
	
	int getMenuItemIdx() {
		CONFIGURACION
	}
	
	int getSubmenuItemIdx() {
		CONF_GRADOS
	}
	
	Class getEntityPage() {
		GradoPage
	}
	
	String getEntityIdField() {
		"codigo"
	}
	
	String getTableName() {
		"grado"
	}
	
	String getColumnIdName() {
		"codigo"
	}
}