package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.page.HomePage
import com.hexacta.liqhabtester.page.LoginPage
import com.hexacta.web_test_robot.AbstractPageSpec

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
		$().text().contains("El nombre de usuario o contraseña no válidos. Verifique los datos ingresados")
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
		$().text().contains("El nombre de usuario o contraseña no válidos. Verifique los datos ingresados")
	 }
}