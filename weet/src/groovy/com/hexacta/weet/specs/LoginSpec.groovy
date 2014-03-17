package com.hexacta.weet.specs

import spock.lang.*

/**
 * Common login specifications.
 * 
 * @author gmassenzano
 */
abstract class LoginSpec extends ApplicationSpec {

	/**
	 * It does the extra assertion for the invalid password spec.
	 */
	void invalidPasswordExtraAssertion() { true }

	/**
	 * It does the extra assertion for the invalid username spec.
	 */
	void invalidUsernameExtraAssertion() { true }
	
	/**
	 * It is overridden to avoid the initial login inherited from ApplicationSpec.
	 */
	def setupSpec() {
		initialLogin = false
	}

	/**
	 * Tests that after going to any page, the application redirects to the login page. 
	 * Then when it enters a valid username and password, it logs in and redirect to the initial page.
	 */
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
    
	/**
	 * Tests that after going to any page, the application redirects to the login page. 
	 * Then when it enters a valid username and invalid password, it doesn't log in and stay at login page.
	 * Then it does extra assertions.
	 */
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
	
	/**
	 * Tests that after going to any page, the application redirects to the login page. 
	 * Then when it enters an valid username, it doesn't log in and stay at login page.
	 * Then it does extra assertions.
	 */
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