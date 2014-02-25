package com.hexacta.webtester.specs

import geb.spock.GebSpec

import org.junit.Rule
import org.junit.rules.TestName
import org.openqa.selenium.Capabilities
import org.openqa.selenium.JavascriptExecutor

import spock.lang.*

abstract class AbstractSpec extends GebSpec {

	@Rule TestName testName = new TestName()
	
	def setupSpec() {
		reportGroup reportGroupName
		cleanReportGroupDir()
		Capabilities cp = driver.capabilities
		if (cp.browserName == "internet explorer") {
			// TODO: resolver erroe para aplicacion con certificado SSL
			// go baseUrl
			// $("overridelink")?.click()
			// waitFor { to SecurityCertificateErrorPage }
			// continueToThisWebsite()
		}
	}

	def setup() {
		reportGroup reportGroupName
	}
	
	def cleanup() {
		// Generate a report of last page state before calling spec cleanup
		report "${testName.methodName}_cleanup"
	}

	/**
	 * Folder name for all the reports generated for this spec class. Redefine it conveniently.
	 */
	protected String getReportGroupName() {
		this.class.simpleName
	}
	
	/**
	 * This method solve the problem of Web driver that cannot simulate mouse movement events. 
	 * Web driver also requires all elements that you call to be visible on the page before 
	 * you can interact with them or it will throw an exception.
	 * 
	 * Usage:
	 * js(' jQuery( "myHiddenDiv" ).show(); ')
	 * js(' return jQuery( "myHiddenDiv" ).isVisible(); ')
	 *
	 * Important: The reason this method is put in my specs instead of the base page object 
	 * is because the later seems to make the calls non-blocking. I.e, if the js definition 
	 * is put in AjaxPage, waitFor{ myDiv.present } run right away instead of waiting for 
	 * js( ‘ showHiddenDiv() ‘ ) to finish.
	 * 
	 * @see http://fbflex.wordpress.com/2010/08/25/geb-and-grails-tips-tricks-and-gotchas
	 *  
	 * @param script
	 */
	def js(String script){
		(driver as JavascriptExecutor).executeScript(script)
	}
}