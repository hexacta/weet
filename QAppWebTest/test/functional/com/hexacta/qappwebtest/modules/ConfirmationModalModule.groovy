package com.hexacta.qappwebtest.modules

import com.hexacta.web_test_robot.AbstractModule

/**
 * 
 * 
 * @author gmassenzano
 */
class ConfirmationModalModule extends AbstractModule {
 
	String confirmText
    static content = {
		// TODO: text { }
		
		cancel {
			$("button", text: "Cancel")
		}
		
		confirm {
			$("button", text: confirmText)
		}
    }
}

/*
<div class="modal hide in" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="display: block;">
   <div class="modal-body">
   		<p>Are you sure?</p>
   </div>
   <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
	    <button id="btn_deleteConfirm" class="btn btn-danger" data-dismiss="modal">Delete</button>
   </div>
</div>
*/
