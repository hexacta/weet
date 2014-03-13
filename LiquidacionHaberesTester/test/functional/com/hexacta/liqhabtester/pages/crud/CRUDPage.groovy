package com.hexacta.liqhabtester.pages.crud

import com.hexacta.liqhabtester.modules.ExportModule
import com.hexacta.liqhabtester.modules.FilterModule
import com.hexacta.liqhabtester.pages.LiquidacionHaberesPage
import com.hexacta.webtester.modules.PageableTableModule


abstract class CRUDPage extends LiquidacionHaberesPage {

	// CRUDAction action
	// CRUDAction nextAction
	
	static url = { crudUrl }
	
	static at = { title == crudTitle }

	static content = {
		// List action content
		add       (required: false /*action == CRUDAction.LIST*/) { $("a", name: "create") }
		filterLink(required: false /*action == CRUDAction.LIST*/) { $("a", text: "Filtrar") }
		filter    (required: false /*action == CRUDAction.LIST*/) { module FilterModule }
		export    (required: false /*action == CRUDAction.LIST*/) { module ExportModule }
		table     (required: false /*action == CRUDAction.LIST*/) { module PageableTableModule, tableBase: $("table"), navigationBase: $("div.pagination") }

		// New action content
		create(required: false /*action == CRUDAction.NEW*/) {  $("input", name: "create") }
		
		// Edit action content
		update(required: false /*action == CRUDAction.EDIT*/) {  $("input", value: "Actualizar") }
		delete(required: false) {  $("input", value: containsWord("Deshabilitar")) }
		habilitar(required: false) {  $("input", value: containsWord("Habilitar")) }
	}
	
	enum CRUDAction { NEW, EDIT, LIST }
	
	def getCrudUrl() {
		"$entity/$action2"
	}
	
	def newEntity() {
		add.click(newPage)
	}
	
	def saveEntity() {
		def button = action == CRUDAction.NEW ? create : update
		button.click(listPage)
	}

	def disable() {
		delete.click(listPage)
	}

	def editRow(int idx) {
		def row = table.row(idx)
		row.click(editPage)
	}

	abstract String getEntity()
	abstract String getPluralEntity()
	
	String getAction2() {
		action.name.toLowerCase()
	}
	
	String getCrudTitle() {
		switch (action) {
			case CRUDAction.LIST:
				"Listado de $pluralEntity"
				break
			case CRUDAction.NEW:
				"Crear $entity"
				break
			case CRUDAction.EDIT:
				"Editar $entity"
				break
		}
		
	}
	
	boolean isHabilitado(row) {
		def td = row.find("td").last()
		def enable = td.find("input", class: "enableFila")
		enable.size() == 1
	}
	
	void openFilterPane() {
		filterLink.click()
	}

	def getListPage() {
		this.class.metaClass.getAction << {
			-> CRUDAction.LIST
		}
		this.class
	}

	def getEditPage() {
		this.class.metaClass.getAction << {
			-> CRUDAction.EDIT
		}
		this.class
	}
	
	def getNewPage() {
		this.class.metaClass.getAction << {
			-> CRUDAction.NEW
		}
		this.class
	}
	
//	def getNewPage2() {
//		def methods = [ action:{  -> CRUDAction.NEW } ]
//		def newPage = ProxyGenerator.INSTANCE.instantiateAggregateFromBaseClass(methods, this.class)
//		def newPageClass = newPage.class
//		newPageClass
//	}
}