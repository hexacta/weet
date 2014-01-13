package com.hexacta.web_test_robot

import geb.spock.GebSpec

import org.openqa.selenium.JavascriptExecutor

import spock.lang.*

class AbstractPageSpec extends GebSpec {

	@Shared UserRobot user

	def setupSpec() {
		user = new UserRobot(getBrowser())
	}

	def cleanup() {
		user.logout()
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