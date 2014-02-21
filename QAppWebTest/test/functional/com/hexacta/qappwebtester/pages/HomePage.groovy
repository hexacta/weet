package com.hexacta.qappwebtester.pages


class HomePage extends QApplicationPage {
	static url = ""
	
	static at = { $("p", text: contains("Auditorías y métricas para los proyectos de Hexacta")) } 
	
	static content = {
	}
}