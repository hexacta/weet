package com.hexacta.weet.pages

import geb.Page

/**
 * Base class to be extended by pages that include ajax calls.
 * 
 * Tips:
 * - It is important to put divs that are not visible at the beginning of the page load as required:false in page objects. i.e:
 * 
 * 		content{
 *     		loadingDiv( required: false ){ $( '#loading' ) }
 * 		}
 * 
 * @author gmassenzano
 */
abstract class AjaxPage extends WeetPage {

	/**
	 * Luke Daley provided the implementation of a waitFor method in the <a href="http://xircles.codehaus.org/lists/user@geb.codehaus.org">geb-user mailing list</a>
	 * 
	 * Usage:
	 * 
	 * when: 'I click on search'
	 *     searchButton.click()
	 * then: 'search wait dialog appears'
	 *     waitFor{ loadingDiv.present }
	 * then: 'search wait dialog is gone'
	 *     waitFor{ !loadingDiv.present }
	 * then: 'my results are loaded'
	 *     ...
	 *     
	 * @param timeoutSecs
	 * @param intervalSecs
	 * @param condition
	 */
	def waitFor(Double timeoutSecs, Double intervalSecs, Closure condition) {
		timeoutSecs = timeoutSecs ?: 5
		intervalSecs = intervalSecs ?: 0.5
		def loops = Math.ceil(timeoutSecs / intervalSecs)
		def pass = condition()
		def i = 0
		while (!pass && i++ < loops) {
			sleep(intervalSecs * 1000)
			pass = condition()
		}
		if (i >= loops) {
			throw new AssertionError("condition did not pass in $timeoutSecs seconds")
		}
		true
	}

	/**
	 * @param timeoutSecs
	 * @param condition
	 */
	def waitFor(Double timeoutSecs, Closure condition) {
		waitFor(timeoutSecs, null, condition)
	}
	
	/**
	 * @param condition
	 */
	def waitFor(Closure condition) {
		waitFor(null, condition)
	}

}