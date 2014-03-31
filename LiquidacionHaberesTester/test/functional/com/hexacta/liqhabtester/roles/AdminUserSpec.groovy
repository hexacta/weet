package com.hexacta.liqhabtester.roles

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage
import com.hexacta.weet.specs.NavigationMenuSpec

class AdminUserSpec extends NavigationMenuSpec {

	Map menuConfig = [
		"Personal" : ["Consulta de empleados", "Importar movimientos de RRHH"],
		"Novedades" : ["Carga y consulta de novedades", "Verificaci\u00f3n y aprobaci\u00f3n", "Tipos de novedades y mesas", "Configuraci\u00f3n de novedades"],
		"Liquidaci\u00f3n" : ["Liquidaciones", "Tipos de liquidaci\u00f3n", "Tipos de movimiento", "Clasificadores de conceptos",
			"Per\u00edodos y fechas de cierre", "Conceptos y f\u00f3rmulas", "F\u00f3rmula de m\u00e1ximo embargable", "Definici\u00f3n y carga de tablas"],
		"Configuraci\u00f3n" : ["Estados civiles", "Niveles de escolaridad", "Parentescos", "Provincias", "Tipos de documento", "T\u00edtulos universitarios",
			 "UTACs", "Subunidades", "Destinos", "Mesas de control", "Sociedades",
			 "Cargos", "Jerarqu\u00edas", "Grados", "Categor\u00edas civiles", "Especialidades", "Situaciones de revista", "Situaciones de retiro", "Situaciones especiales", "Situaciones de revista del SGP",
			 "Configuraci\u00f3n de roles", "Usuarios y permisos"]
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