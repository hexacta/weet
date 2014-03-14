package com.hexacta.weet.specs

import spock.lang.*

/**
 * Common login specifications.
 * 
 * @author gmassenzano
 */
abstract class LoginSpec extends ApplicationSpec {

	def invalidPasswordExtraAssertion() { true }

	def invalidUsernameExtraAssertion() { true }
	
	def setupSpec() {
		initialLogin = false
	}

    def "Succesful login"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at loginPage
 
        when: "username y clave correctos"
        login username, password
        
        then: "Redirects to home page"
        at initialPage
    }
    
    def "Invalid password"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at loginPage
 
        when: "Invalid password"
        login username, "xxxxxxxxx"
 
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