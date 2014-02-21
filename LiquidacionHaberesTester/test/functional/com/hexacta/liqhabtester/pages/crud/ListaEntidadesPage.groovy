package com.hexacta.liqhabtester.pages.crud

import geb.download.helper.SelfSignedCertificateHelper

import javax.net.ssl.HttpsURLConnection

import com.hexacta.liqhabtester.modules.ExportModule
import com.hexacta.webtester.pages.crud.EntityListPage

class ListaEntidadesPage extends EntityListPage {
	
	static content = {
		create { $("a", name: "create") }
		
		export { module ExportModule }
		
		userMenu { $("li.menu_logout_right a.drop_logout") }
	}

	boolean isHabilitado(row) {
		def td = row.find("td").last()
		def enable = td.find("input", class: "enableFila")
		enable.size() == 1
	}
	
//	def download(link) {
//		downloadText { HttpURLConnection connection ->
//			if (connection instanceof HttpsURLConnection) {
//				def helper = new SelfSignedCertificateHelper(getClass().getResource('/keystore.jks'), 'changeit')
//				helper.acceptCertificatesFor(connection as HttpsURLConnection)
//			}
//		}
//	}
}