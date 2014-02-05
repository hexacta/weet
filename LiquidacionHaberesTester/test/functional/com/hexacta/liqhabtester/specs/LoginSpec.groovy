package com.hexacta.liqhabtester.specs

import spock.lang.*

import com.hexacta.liqhabtester.page.HomePage
import com.hexacta.liqhabtester.page.LoginPage
import com.hexacta.webtester.AbstractSpec

class LoginSpec extends AbstractSpec {

    def "Login correcto"() {
        given: "Cualquier p�gina"
        go ""
 
        expect: "Redirige a la p�gina de login"
        at LoginPage
 
        when: "Usuario y clave correctos"
        username = "admin"
        password = "admin"
        logIn.click(HomePage)
        
        then: "Redirige a la paina incio"
        at HomePage
    }
    
    def "Password invalido"() {
        given: "Cualquier p�gina"
        go ""
     
        expect: "Redirige a la p�gina de login"
        at LoginPage
 
        when: "Password invalida"
        username = "admin"
        password = "xxxxxxxxx"
        logIn.click(LoginPage)
 
        then: "Permanece en la p�gina de login y muestra el mensaje de error"
        at LoginPage
		$().text().contains("El nombre de usuario o contrase�a no v�lidos. Verifique los datos ingresados")
     }
	
	def "Usuario inexistente"() {
		given: "Cualquier p�gina"
		go ""
		
		expect: "Redirige a la p�gina de login"
		at LoginPage
 
		when: "Password invalida"
		username = "UsuarioInexistente"
		password = "xxxxxxxxx"
		logIn.click(LoginPage)
 
		then: "Permanece en la p�gina de login y muestra el mensaje de error"
		at LoginPage
		$().text().contains("El nombre de usuario o contrase�a no v�lidos. Verifique los datos ingresados")
	 }
}