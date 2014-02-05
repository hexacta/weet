package com.hexacta.webtester.specs

import spock.lang.*

import com.hexacta.webtester.pages.LoginPage

abstract class LoginSpec extends AbstractSpec {

	abstract def getInitialPage()

	abstract def getLoginPage()
	
	def invalidPasswordExtraAssertion() { true }

	def invalidUsernameExtraAssertion() { true }
	
    def "Succesful login"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at loginPage
 
        when: "username y clave correctos"
        username = "admin"
        password = "admin"
        logIn.click()
        
        then: "Redirects to home page"
        at initialPage
    }
    
    def "Invalid password"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at loginPage
 
        when: "Invalid password"
        username = "admin"
        password = "xxxxxxxxx"
        logIn.click()
 
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
		username = "invalidusername"
		password = "xxxxxxxxx"
		logIn.click()
 
        then: "Stay at login page"
        at loginPage
		invalidUsernameExtraAssertion()
	 }
}