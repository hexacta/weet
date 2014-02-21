package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage
import com.hexacta.webtester.pages.AbstractPage

class NavigationMenuSpec extends com.hexacta.webtester.specs.NavigationMenuSpec {

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