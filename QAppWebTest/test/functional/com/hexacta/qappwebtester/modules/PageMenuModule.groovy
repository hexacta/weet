package com.hexacta.qappwebtester.modules

import com.hexacta.webtester.AbstractModule

/**
 * 
 * 
 * @author gmassenzano
 */
class PageMenuModule extends AbstractModule {
 
    static base = { $("ul.nav")[1] }
 
    static content = {
		item { i -> $().children("li")[i].find("a")[0] }
		itemText { i -> item(i).text().trim() }
		
		clickItem { i -> 
			item(i).click()
		}
    }
}
