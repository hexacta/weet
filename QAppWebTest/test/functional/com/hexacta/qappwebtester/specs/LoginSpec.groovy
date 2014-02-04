package com.hexacta.qappwebtester.specs

import spock.lang.*

import com.hexacta.qappwebtester.pages.HomePage
import com.hexacta.qappwebtester.pages.LoginPage
import com.hexacta.webtester.AbstractPageSpec

class LoginSpec extends AbstractPageSpec {

    def "Succesful login"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at LoginPage
 
        when: "username y clave correctos"
        username = "admin"
        password = "admin"
        logIn.click()
        
        then: "Redirects to home page"
        at HomePage
    }
    
    def "Invalid password"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at LoginPage
 
        when: "Invalid password"
        username = "admin"
        password = "xxxxxxxxx"
        logIn.click()
 
        then: "Stay at login page"
        at LoginPage
     }
	
	def "Invalid username"() {
        given: "Any page"
        go ""
 
        expect: "Redirects to login page"
        at LoginPage
		
		when: "Invalid username"
		username = "invalidusername"
		password = "xxxxxxxxx"
		logIn.click()
 
        then: "Stay at login page"
        at LoginPage
	 }
}