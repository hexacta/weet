package com.hexacta.googlewebtester.specs

import spock.lang.*

import com.hexacta.googlewebtester.pages.GoogleHomePage
import com.hexacta.googlewebtester.pages.GoogleResultsPage
import com.hexacta.googlewebtester.pages.WikipediaPage
import com.hexacta.webtester.specs.AbstractSpec;

class GoogleWikipediaSpec extends AbstractSpec {

	def "first result for wikipedia search should be wikipedia"() {
		given:
		to GoogleHomePage
 
		expect:
		at GoogleHomePage
 
		when:
		report "google"
		search.text.value("wikipedia")
 
		then:
		waitFor { at GoogleResultsPage }
 
		and:
		firstResultLink.text() == "Wikipedia"
 
		when:
		report "google results"
		firstResultLink.click()
 
		then:
		waitFor { at WikipediaPage }
	}
}