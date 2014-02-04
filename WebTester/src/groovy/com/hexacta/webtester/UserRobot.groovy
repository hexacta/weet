package com.hexacta.webtester

import geb.Browser

class UserRobot  {

    Browser browser
    
    private UserRobot(Browser browser) {
        this.browser = browser
    }

    def login() {
        login("admin", "admin")
    }
        
    def login(String username, String password) {
        browser.drive {
            to LoginPage
            delegate.usuario = username 
            delegate.password = password 
            logIn.click()
        }
    }   

    def logout() {
        browser.drive {
            go "authentication/logout"
        }
    }
}