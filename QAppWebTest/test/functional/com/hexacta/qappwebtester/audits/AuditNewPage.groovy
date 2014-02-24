package com.hexacta.qappwebtester.audits

import com.hexacta.qappwebtester.pages.crud.QAppEntityNewPage;
import com.hexacta.webtester.modules.AutocompleteModule
import com.hexacta.webtester.modules.DatechooserModule

class AuditNewPage extends QAppEntityNewPage {
	static url = "audit/create"
	
	static at = { $().text().contains("Crear Auditoría") } 
	
	static content = {
		project { $("select", name: "project.id") }
		phase { $("select", name: "phase.id") }
		
		revisionManagerLabel {  $("label", text: containsWord("Responsable de Revisión")) }
		// autocomplete field
		revisionManager { module AutocompleteModule, revisionManagerLabel.next(), inputValueName: "revisionManager.displayName" } 
		
		fromLabel  {  $("label", text: containsWord("Desde")) }
		from       {  module DatechooserModule, fromLabel.next() }

		toLabel  {  $("label", text: containsWord("Hasta")) }
		to       {  module DatechooserModule, toLabel.next() }

		dateLabel  {  $("label", text: containsWord("Fecha")) }
		date       {  module DatechooserModule, dateLabel.next() }

	}
}