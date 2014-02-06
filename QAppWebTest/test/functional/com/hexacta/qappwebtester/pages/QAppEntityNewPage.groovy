package com.hexacta.qappwebtester.pages


abstract class QAppEntityNewPage extends QAppEntityPage {
	// Menu options
	static int LIST = 1
		
	static content = {
		create {  $("input", name: "create") }
	}
}