package com.hexacta.weet.modules

import com.hexacta.weet.modules.WeetModule


/**
 * Confirmation pop in modal window.
 * <p> 
 * Following is an example of the html node that handles an instance of this class:<p>
 <code> 
<div class="modal hide in" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="display: block;">
   <div class="modal-body">
   		<p>Are you sure?</p>
   </div>
   <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
	    <button id="btn_deleteConfirm" class="btn btn-danger" data-dismiss="modal">Delete</button>
   </div>
</div>
</code> 
 * @author gmassenzano
 */
class ConfirmationModalModule extends WeetModule {
 
	String cancelText = "Cancel"
	String confirmText = "Confirm"
	
    static content = {
		// TODO: title { }
		
		cancelButton {
			$("button", text: cancelText)
		}
		
		confirmButton {
			$("button", text: confirmText)
		}
    }
	
	def cancel() {
		cancelButton.click()
	}
	
	def confirm(nextPage) {
		confirmButton.click(nextPage)
	}
}
