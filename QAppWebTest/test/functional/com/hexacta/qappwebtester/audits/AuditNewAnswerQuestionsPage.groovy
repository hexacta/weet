package com.hexacta.qappwebtester.audits

import com.hexacta.qappwebtester.pages.crud.QAppEntityNewPage;

class AuditNewAnswerQuestionsPage extends QAppEntityNewPage {
	static url = "audit/answerQuestions"
	
	static at = { $().text().contains("Responder Preguntas") } 
	
	static content = {
		groups { moduleList QuestionsGroupModule, $("div.accordion-group") }
	}
}