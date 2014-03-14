package com.hexacta.qapptester.specs

import spock.lang.*

import com.hexacta.qapptester.pages.HomePage
import com.hexacta.qapptester.pages.LoginPage
import com.hexacta.weet.pages.AbstractPage

class NavigationMenuSpec extends com.hexacta.weet.specs.NavigationMenuSpec {

	Map menuConfig = [
		"Configuración" : ["Templates", "Procesos", "Areas", "Estados de Proyectos", "Preguntas"],
		"Auditorias" : ["Nueva auditoría", "Lista de auditorías"],
		"Proyectos" : ["Proyectos", "Instancias de Checklist"],
		"Métricas" : ["Métricas", "Resolver métricas"],
		"Administración" : ["Usuarios", "Roles", "Configuración"]
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