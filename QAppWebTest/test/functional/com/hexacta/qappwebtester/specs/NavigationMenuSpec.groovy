package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage
import com.hexacta.webtester.pages.AbstractPage

class NavigationMenuSpec extends com.hexacta.webtester.specs.NavigationMenuSpec {

	Map menuConfig = [
		"Configuraci�n" : ["Templates", "Procesos", "Areas", "Estados de Proyectos", "Preguntas"],
		"Auditorias" : ["Nueva auditor�a", "Lista de auditor�as"],
		"Proyectos" : ["Proyectos", "Instancias de Checklist"],
		"M�tricas" : ["M�tricas", "Resolver m�tricas"],
		"Administraci�n" : ["Usuarios", "Roles", "Configuraci�n"]
	]
			
	@Override
	Class<? extends AbstractPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<? extends LoginPage> getLoginPage() {
		LoginPage
	}

}