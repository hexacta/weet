package com.hexacta.liqhabtester.roles

import spock.lang.*

import com.hexacta.liqhabtester.pages.HomePage
import com.hexacta.liqhabtester.pages.LoginPage
import com.hexacta.weet.pages.WeetPage
import com.hexacta.weet.specs.NavigationMenuSpec

class AdminUserSpec extends NavigationMenuSpec {

	Map menuConfig = [
		"Personal" : ["Consulta de empleados", "Importar movimientos de RRHH"],
		"Novedades" : ["Carga y consulta de novedades", "Verificación y aprobación", "Tipos de novedades y mesas", "Configuración de novedades"],
		"Liquidación" : ["Liquidaciones", "Tipos de liquidación", "Tipos de movimiento", "Clasificadores de conceptos",
			"Períodos y fechas de cierre", "Conceptos y fórmulas", "Fórmula de máximo embargable", "Definición y carga de tablas"],
		"Configuración" : ["Estados civiles", "Niveles de escolaridad", "Parentescos", "Provincias", "Tipos de documento", "Títulos universitarios",
			 "UTACs", "Subunidades", "Destinos", "Mesas de control", "Sociedades",
			 "Cargos", "Jerarquías", "Grados", "Categorías civiles", "Especialidades", "Situaciones de revista", "Situaciones de retiro", "Situaciones especiales", "Situaciones de revista del SGP",
			 "Configuración de roles", "Usuarios y permisos"]
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