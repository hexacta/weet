package com.hexacta.qapptester.pages


class HomePage extends QApplicationPage {
	static url = ""
	
	static at = { $("p", text: contains("Auditor�as y m�tricas para los proyectos de Hexacta")) } 
	
	static content = {
	}
}