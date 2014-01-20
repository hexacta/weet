package com.hexacta.googlewebtest.specs

import spock.lang.*

import com.hexacta.web_test_robot.AbstractPageSpec

class GoogleWikipediaSpec extends AbstractPageSpec {

	def "first result for wikipedia search should be wikipedia"() {
		given:
		to GoogleHomePage
 
		expect:
		at GoogleHomePage
 
		when:
		search.text.value("wikipedia")
 
		then:
		waitFor { at GoogleResultsPage }
 
		and:
		firstResultLink.text() == "Wikipedia"
 
		when:
		firstResultLink.click()
 
		then:
		waitFor { at WikipediaPage }
	}
}