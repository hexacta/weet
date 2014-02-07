package com.hexacta.webtester.modules

import com.hexacta.webtester.modules.AbstractModule


/**
 * 
 * 
 * @author gmassenzano
 */
class AutocompleteModule extends AbstractModule {

	String inputValueName
	 
    static content = {
		search       {  $("input", name: inputValueName) }
		selectValue  { val -> $("ul").find("li", text: val).click() }
		
		// XXX: combining both not working
		value        { val -> 
			$("input", name: inputValueName).value(val)
			selectValue(val)
		}
    }
	
	
}
/*
<div class="yui-ac">
  <input class="yui-ac-input" style="" type="text" id="revisionManager.displayName" name="revisionManager.displayName" value="" title="" autocomplete="off">
  <div class="searchcontainer yui-skin-sam yui-ac-container" id="adda118e80e924d1a4542bcdce1bbf19f" style="left: 30px; top: 2px;"><div class="yui-ac-content" style="width: 302px; height: 32px;"><div class="yui-ac-hd" style="display: none;"></div>
  <div class="yui-ac-bd">
  <ul>
  <li style="" class="yui-ac-highlight">Gerardo Massenzano</li>
  <li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li><li style="display: none;"></li></ul></div><div class="yui-ac-ft" style="display: none;"></div></div></div>
</div>
	*/