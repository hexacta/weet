package com.hexacta.qapptester.specs

import spock.lang.*

import com.hexacta.qapptester.pages.HomePage
import com.hexacta.qapptester.pages.LoginPage
import com.hexacta.weet.pages.AbstractPage

class NavigationMenuSpec extends com.hexacta.weet.specs.NavigationMenuSpec {

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