package com.hexacta.qappwebtester.audits

import com.hexacta.qappwebtester.pages.crud.QAppEntityNewPage;

class AuditNewAnswerQuestionsPage extends QAppEntityNewPage {
	static url = "audit/answerQuestions"
	
	static at = { $().text().contains("Answer Questions") } 
	
	static content = {
		groups { moduleList QuestionsGroupModule, $("div.accordion-group") }
	}
}