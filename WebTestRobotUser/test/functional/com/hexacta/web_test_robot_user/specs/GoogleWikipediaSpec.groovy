package com.hexacta.web_test_robot_user.specs

import spock.lang.*

import com.hexacta.web_test_robot.AbstractPageSpec
import com.hexacta.web_test_robot_user.pages.GoogleHomePage
import com.hexacta.web_test_robot_user.pages.GoogleResultsPage
import com.hexacta.web_test_robot_user.pages.WikipediaPage

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