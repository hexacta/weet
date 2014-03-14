package com.hexacta.qapptester.pages


class HomePage extends QApplicationPage {
	static url = ""
	
	static at = { $("p", text: contains("Auditorías y métricas para los proyectos de Hexacta")) } 
	
	static content = {
	}
}