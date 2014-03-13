package com.hexacta.liqhabtester.pages.crud

import com.hexacta.liqhabtester.modules.ExportModule
import com.hexacta.liqhabtester.modules.FilterModule
import com.hexacta.liqhabtester.pages.LiquidacionHaberesPage
import com.hexacta.webtester.modules.PageableTableModule


abstract class CRUDPage extends LiquidacionHaberesPage {

	CRUDAction action
	CRUDAction nextAction
	
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
		nextAction = CRUDAction.NEW
		add.click(this.class)
	}
	
	def saveEntity() {
		def button = action == CRUDAction.NEW ? create : update
		nextAction = CRUDAction.LIST
		button.click(this.class)
	}

	def disable() {
		nextAction = CRUDAction.LIST
		delete.click(this.class)
	}

	def editRow(int idx) {
		nextAction = CRUDAction.EDIT
		def row = table.row(idx)
		row.click(this.class)
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

}