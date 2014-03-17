package com.hexacta.weet.pages

import geb.Page

/**
 * It represents a https error page.
 * FIXME: Review it, currently is not working.
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