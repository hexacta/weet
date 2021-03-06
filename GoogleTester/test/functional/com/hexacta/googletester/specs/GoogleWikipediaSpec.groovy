package com.hexacta.googletester.specs

import spock.lang.*

import com.hexacta.googletester.pages.GoogleHomePage
import com.hexacta.googletester.pages.GoogleResultsPage
import com.hexacta.googletester.pages.WikipediaPage
import com.hexacta.weet.specs.WeetSpec;

class GoogleWikipediaSpec extends WeetSpec {

	def "first result for wikipedia search should be wikipedia"() {
		given: "Voy a la p\u00e1gina de inicio de Google"
		to GoogleHomePage
 
		expect: "Se cargo la pagina buscada"
		at GoogleHomePage
 
		when: "Ingreso 'wikipedia' en el campo de busqueda"
		report "google"
		searchText("wikipedia")
 
		then: "Espero a cargarse la nueva pagina con los resultados"
		at GoogleResultsPage
 
		and: "Chequeo que el texto del 1er resultado sea 'Wikipedia'"
		resultText(0) == "Wikipedia"
 
		when: "Navego a la URL del link del 1er resultado"
		report "google results"
		toResult(0)
 
		then: "Espero a cargarse la pagina (chequeando que sea la correcta)"
		waitFor(3) { at WikipediaPage }
	}
}