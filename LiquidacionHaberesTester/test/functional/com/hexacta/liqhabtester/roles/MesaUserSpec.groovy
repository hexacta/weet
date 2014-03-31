package com.hexacta.liqhabtester.roles

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage
import com.hexacta.weet.specs.NavigationMenuSpec

class MesaUserSpec extends NavigationMenuSpec {

	Map menuConfig = [
		"Personal" : ["Consulta de empleados"],
		"Novedades" : ["Verificaci\u00f3n y aprobaci\u00f3n"],
		"Liquidaci\u00f3n" : ["Conceptos y f\u00f3rmulas"]
	]

	def setupSpec() {
		username = "jmesa"
		password = "Jmesa123"
	}
	
	@Override
	Class<? extends WeetPage> getInitialPage() {
		HomePage
	}

	@Override
	Class<? extends LoginPage> getLoginPage() {
		LoginPage
	}

}