package com.hexacta.googlewebtester.specs

import spock.lang.*

import com.hexacta.googlewebtester.pages.GoogleHomePage
import com.hexacta.googlewebtester.pages.GoogleResultsPage
import com.hexacta.googlewebtester.pages.WikipediaPage
import com.hexacta.webtester.specs.AbstractSpec;

class GoogleWikipediaSpec extends AbstractSpec {

	def "first result for wikipedia search should be wikipedia"() {
		given: "Voy a la página de inicio de Google"
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
		go(0)
 
		then: "Espero a cargarse la pagina (chequeando que sea la correcta)"
		waitFor(3) { at WikipediaPage }
	}
}