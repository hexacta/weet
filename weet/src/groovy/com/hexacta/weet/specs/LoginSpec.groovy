package com.hexacta.weet.specs

import spock.lang.*

import com.hexacta.weet.pages.LoginPage

abstract class LoginSpec extends AbstractSpec {

	abstract def getInitialPage()

	abstract def getLoginPage()
	
	def invalidPasswordExtraAssertion() { true }

	def invalidUsernameExtraAssertion() { true }
	
	/**
	 * The default username used for the successful login.
	 */
	String getUsernameValue() {
		"admin"
	}

	/**
	 * The default password used for the successful login.
	 */
	String getPasswordValue() {
		"admin"
	}

    def "Succesful login"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at loginPage
 
        when: "username y clave correctos"
        login usernameValue, passwordValue
        
        then: "Redirects to home page"
        at initialPage
    }
    
    def "Invalid password"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at loginPage
 
        when: "Invalid password"
        login usernameValue, "xxxxxxxxx"
 
        then: "Stay at login page"
        at loginPage
		invalidPasswordExtraAssertion()
     }
	
	def "Invalid username"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at loginPage
		
		when: "Invalid username"
        login "invalidusername", "xxxxxxxxx"
 
        then: "Stay at login page"
        at loginPage
		invalidUsernameExtraAssertion()
	 }
}