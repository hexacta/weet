package com.hexacta.weet.modules

import com.hexacta.weet.modules.WeetModule

/**
 * Autocomplete field. 
 * <p> 
 * Following is an example of the html node that handles an instance of this class:<p>
<code> 
<div class="yui-ac">
  <input class="yui-ac-input" style="" type="text" id="revisionManager.displayName" name="revisionManager.displayName" value="" title="" autocomplete="off">
  <div class="searchcontainer yui-skin-sam yui-ac-container" id="adda118e80e924d1a4542bcdce1bbf19f" style="left: 30px; top: 2px;"><div class="yui-ac-content" style="width: 302px; height: 32px;"><div class="yui-ac-hd" style="display: none;"></div>
  <div class="yui-ac-bd">
  <ul>
  <li style="" class="yui-ac-highlight">Gerardo Massenzano</li>
  <li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li></ul></div><div class="yui-ac-ft" style="display: none;"></div></div></div>
</div>
</code> 
 * 
 * @author gmassenzano
 */
class AutocompleteModule extends WeetModule {

	String inputValueName
	 
    static content = {
		search  { $("input", name: inputValueName) }
		options { $("ul li") }
    }
	
	/**
	 * Enter the received value into the autocomplete field.
	 * 
	 * @param val
	 */
	def searchValue(String val) {
		search = val
	}
	
	/**
	 * Select the received value from the autocomplete options.
	 * 
	 * @param val
	 */
	def selectValue(String val) {
		def option = options.filter(text: val)
		if (option) {
			avoidElementNotClickable(option)
			option.click()
		} 
	}

	/**
	 * Enter the received value into the autocomplete field, and then select the displayed value from the combo.
	 * 
	 * @param val
	 */
	def setValue(val) {
		search.value(val)
		waitFor { options.present } 
		selectValue(val)
	}
	
	/**
	 * Get the value from the autocomplete field.
	 */
	def getValue() {
		search.value()
	}

}
