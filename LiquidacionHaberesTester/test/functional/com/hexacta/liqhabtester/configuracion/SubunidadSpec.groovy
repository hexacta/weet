package com.hexacta.liqhabtester.configuracion

import static com.hexacta.liqhabtester.pages.LiquidacionHaberesPage.*
import spock.lang.*

import com.hexacta.liqhabtester.specs.CRUDField
import com.hexacta.liqhabtester.specs.CRUDSpec

class SubunidadSpec extends CRUDSpec {

	List<CRUDField> getCRUDFields() {
		[
			new CRUDField(field: "unidad", value: "0 - SIN UNIDAD"),
			new CRUDField(field: "codigo", value: "999"),
			new CRUDField(field: "nombre", value: "WeetNombre"),
			new CRUDField(field: "descripcion", value: "WeetDescripcion", updatedValue: "WeetDescripcion-new"),
			new CRUDField(field: "nucleo", value: "Si", updatedValue: "No"),
			new CRUDField(field: "zonaCritica", value: "No", updatedValue: "Si", inTable: false),
			new CRUDField(field: "zonaMontana", value: "No", updatedValue: "Si", inTable: false),
			new CRUDField(field: "zonaSCD", value: "No", updatedValue: "Si", inTable: false),
			new CRUDField(field: "zonaPorcentaje", value: "0,34", updatedValue: "0,78", inTable: false)
		]
	}
	
	int getMenuItemIdx() {
		CONFIGURACION
	}
	
	int getSubmenuItemIdx() {
		CONF_SUBUNIDADES
	}
	
	Class getEntityListPage() {
		SubunidadListPage
	}
	
	Class getEntityEditPage() {
		SubunidadEditPage
	}
	
	Class getEntityNewPage() {
		SubunidadNewPage
	}
	
	String getEntityIdField() {
		"codigo"
	}
	
	String getTableName() {
		"subunidad"
	}
	
	String getColumnIdName() {
		"codigo"
	}
}