package com.hexacta.weet.pages

import geb.Page

/**
 * 
 * @author gmassenzano
 */
class SecurityCertificateErrorPage extends WeetPage {

	static url = ""
	
	static at = { $().text().contains("There is a problem with this website's security certificate") }

	static content = {
		continueLink     { $("overridelink")  }
	}

	def continueToThisWebsite() {
		continueLink.click()
	}  
}