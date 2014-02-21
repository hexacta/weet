package com.hexacta.liqhabtester.roles

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.webtester.pages.AbstractPage
import com.hexacta.webtester.specs.NavigationMenuSpec

class AdminUserSpec extends NavigationMenuSpec {

	Map menuConfig = [
		"Personal" : ["Consulta de empleados", "Importar movimientos de RRHH"],
		"Novedades" : ["Carga y consulta de novedades", "Verificaci�n y aprobaci�n", "Tipos de novedades y mesas", "Configuraci�n de novedades"],
		"Liquidaci�n" : ["Ejecuci�n y consulta", "Liquidaciones",
			"Tipos de liquidaci�n", "Tipos de movimiento", "Clasificadores de conceptos",
			"Per�odos y fechas de cierre", "Conceptos y f�rmulas", "F�rmula de m�ximo embargable", "Definici�n y carga de tablas"],
		"Configuraci�n" : ["Estados civiles", "Niveles de escolaridad", "Parentescos", "Provincias", "Tipos de documento", "T�tulos universitarios",
			 "UTACs", "Subunidades", "Destinos", "Mesas de control", "Sociedades",
			 "Cargos", "Jerarqu�as", "Grados", "Categor�as civiles", "Especialidades", "Situaciones de revista", "Situaciones de retiro", "Situaciones especiales", "Situaciones de revista del SGP",
			 "Configuraci�n de roles", "Usuarios y permisos"]
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