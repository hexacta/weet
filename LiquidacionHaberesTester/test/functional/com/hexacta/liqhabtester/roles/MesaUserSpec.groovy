package com.hexacta.liqhabtester.roles

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.webtester.pages.AbstractPage
import com.hexacta.webtester.specs.NavigationMenuSpec

class MesaUserSpec extends NavigationMenuSpec {

	Map menuConfig = [
		"Personal" : ["Consulta de empleados"],
		"Novedades" : ["Verificación y aprobación"],
		"Liquidación" : ["Conceptos y fórmulas"]
	]

	def setupSpec() {
		username = "jmesa"
		password = "Jmesa123"
	}
	
	@Override
	Class<? extends AbstractPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<? extends LoginPage> getLoginPage() {
		LoginPage
	}

}