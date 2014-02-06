package com.hexacta.qappwebtester.pages


abstract class QAppEntityEditPage extends QAppEntityPage {
	// Menu options
	static int LIST = 1, NEW = 2
		
	static content = {
		update {  $("input", value: "Update") }
		delete {  $("button", text: containsWord("Delete")) }
	}
}