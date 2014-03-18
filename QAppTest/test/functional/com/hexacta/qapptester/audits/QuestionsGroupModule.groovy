package com.hexacta.qapptester.audits

import com.hexacta.weet.modules.WeetModule

/**
 * Questions group.
 * <p> 
 * Following is an example of the html node that handles an instance of this class:<p>
 <code> 
<div class="accordion-group">
	<div class="accordion-heading">
		<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#processGestióndeproyectos"> Gestión de proyectos
		</a>
	</div>
	<div id="processGestióndeproyectos" class="accordion-body in collapse" style="height: auto;">
		<div class="accordion-inner">
			<table class="table table-striped">
				<tbody>
					<tr>
						<td>
						<div>
							<div class="pull-left">
								¿Se cerro el proyecto en la wiki?
							</div>
							<select class="pull-right" name="answer_2" onchange="showFindings(this, '2')" id="answer_2">
								<option value="OK">Ok</option>
								<option value="NOK">Not Ok</option>
							</select>
						</div>
						<div class="clearfix"></div>
							<div class="form-horizontal">
								<div class="control-group">
									<label class="control-label" for="comments_2"> Comments
											<span id="comments_2_required" class="hidden required-indicator">*</span>
									</label>
									<div class="controls">
										<textarea id="comments_2" class="questionTextarea" name="comments_2" rows="2"></textarea>
									</div>
								</div>

								<div id="findings_2" class="hidden">
									<div class="control-group required">
										<label class="control-label" for="finding_2"> Findings
											<span class="required-indicator">*</span>
										</label>
										<div class="controls">
											<textarea id="finding_2" class="questionTextarea" name="finding_2" rows="2"></textarea>
										</div>
									</div>
									<div class="control-group required">
										<label class="control-label" for="action_2"> Action
											<span class="required-indicator">*</span>
										</label>
										<div class="controls">
											<textarea id="action_2" class="questionTextarea" name="action_2" rows="2"></textarea>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</code> 
 * 
 * @author gmassenzano
 */
class QuestionsGroupModule extends WeetModule {
 
	static content = {
		name { $("a.accordion-toggle") }
		main { $("div.accordion-inner") }
    }
	
	boolean isExpanded() {
		main.displayed
	}
	
	void toogle() {
		name.click()
	}
	
	String getTitle() {
		name.text().trim()
	}
}
