package com.hexacta.qapplicationwebtest.specs

import spock.lang.*

import com.hexacta.qapplicationwebtest.pages.HomePage
import com.hexacta.qapplicationwebtest.pages.LoginPage
import com.hexacta.web_test_robot.AbstractPageSpec

class LoginPageSpec extends AbstractPageSpec {

    def "Succesful login"() {
        given: "Any page"
        to HomePage
 
        expect: "Redirects to login page"
        at LoginPage
 
        when: "username y clave correctos"
        username = "admin"
        password = "admin"
        logIn.click()
        
        then: "Redirige a la paina incio"
        at HomePage
    }
    
    def "Invalid password"() {
        given: "Cualquier p�gina"
        to HomePage
     
        expect: "Redirige a la p�gina de login"
        at LoginPage
 
        when: "Password invalida"
        username = "admin"
        password = "xxxxxxxxx"
        logIn.click()
 
        then: "Permanece en la p�gina de login y muestra el mensaje de error"
        at LoginPage
		$().text().contains("El nombre de username o contrase�a no v�lidos. Verifique los datos ingresados")
     }
	
	def "Invalid username"() {
		given: "Cualquier p�gina"
		to HomePage
		
		expect: "Redirige a la p�gina de login"
		at LoginPage
 
		when: "Password invalida"
		username = "usernameInexistente"
		password = "xxxxxxxxx"
		logIn.click()
 
		then: "Permanece en la p�gina de login y muestra el mensaje de error"
		at LoginPage
		$().text().contains("El nombre de username o contrase�a no v�lidos. Verifique los datos ingresados")
	 }
}