package com.hexacta.qappwebtest.audits

import com.hexacta.qappwebtest.pages.QAppEntityNewPage

class AuditNewAnswerQuestionsPage extends QAppEntityNewPage {
	static url = "audit/answerQuestions"
	
	static at = { $().text().contains("Answer Questions") } 
	
	static content = {
		groups { moduleList QuestionsGroupModule, $("div.accordion-group") }
	}
}