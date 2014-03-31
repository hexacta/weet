package com.hexacta.qapptester.pages


class HomePage extends QApplicationPage {
	static url = ""
	
	static at = { $("p", text: contains("Auditor\u00edas y m\u00e9tricas para los proyectos de Hexacta")) } 
	
	static content = {
	}
}