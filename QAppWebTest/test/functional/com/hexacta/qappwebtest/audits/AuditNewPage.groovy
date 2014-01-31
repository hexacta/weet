package com.hexacta.qappwebtest.audits

import com.hexacta.qappwebtest.modules.AutocompleteModule
import com.hexacta.qappwebtest.modules.DatechooserModule
import com.hexacta.qappwebtest.pages.QAppEntityNewPage

class AuditNewPage extends QAppEntityNewPage {
	static url = "audit/create"
	
	static at = { $().text().contains("Create Audit") } 
	
	static content = {
		project { $("select", name: "project.id") }
		phase { $("select", name: "phase.id") }
		
		revisionManagerLabel {  $("label", text: containsWord("Revision Manager")) }
		// autocomplete field
		revisionManager { module AutocompleteModule, revisionManagerLabel.next(), inputValueName: "revisionManager.displayName" } 
		
		fromLabel  {  $("label", text: containsWord("From")) }
		from       {  module DatechooserModule, fromLabel.next() }

		toLabel  {  $("label", text: containsWord("To")) }
		to       {  module DatechooserModule, toLabel.next() }

		dateLabel  {  $("label", text: containsWord("Date")) }
		date       {  module DatechooserModule, dateLabel.next() }

	}
}