package com.hexacta.qapptester.specs

import spock.lang.*

import com.hexacta.qapptester.pages.HomePage
import com.hexacta.qapptester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage

class NavigationMenuSpec extends com.hexacta.weet.specs.NavigationMenuSpec {

	Map menuConfig = [
		"Configuraci\u00f3n" : ["Templates", "Procesos", "Areas", "Estados de Proyectos", "Preguntas"],
		"Auditorias" : ["Nueva auditor\u00eda", "Lista de auditor\u00edas"],
		"Proyectos" : ["Proyectos", "Instancias de Checklist"],
		"M\u00e9tricas" : ["M\u00e9tricas", "Resolver m\u00e9tricas"],
		"Administraci\u00f3n" : ["Usuarios", "Roles", "Configuraci\u00f3n"]
	]
			
	@Override
	Class<? extends WeetPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<? extends LoginPage> getLoginPage() {
		LoginPage
	}

}