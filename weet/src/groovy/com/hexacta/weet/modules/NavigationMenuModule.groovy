package com.hexacta.weet.modules

import org.openqa.selenium.WebElement


/**
 * Represents a navigation menu. Each item can have nested submenus of the same type. 
 * <p>
 * A module or page that use this class, should include the base definition from the ul element:
 * <p> 
 * <code> menu { module NavigationMenuModule, $("ul.nav")[0] } </code>
 * <p> 
 * Following is an example of the html node that handles an instance of this class:<p>
<code> 
<ul>
	<li>
		<div class="btn-group">
			<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				Configuration
			</a>
			<ul class="dropdown-menu">
				<li>
					<a href="/qapplication/template/list">
						Templates
					</a>
				</li>
				<li>
					<a href="/qapplication/process/list">
						Processes
					</a>
				</li>
			</ul>
		</div>
	</li>
</ul>
</code> 
 * @author gmassenzano
 */
class NavigationMenuModule extends WeetModule {
 
	String itemBase
	
    static content = {
		
		/**
		 * Returns all first level menu items.
		 */
		items { $().children(itemBase != null ? itemBase : "li").not(style: contains("display: none")).not(text: "") }
		
		item { i -> items[i] }
		
		/**
		 * Returns the submenu under the received item.
		 *
		 * @param item
		 * 		web element returned by item property.
		 * 
		 * NOTE: private usage, better to use the provided methods.
		 */
		submenu { item -> module NavigationMenuModule, item.find("ul")[0].parent().children("ul") }
    }

	/**
	 * Returns the displayed text for the menu item corresponding to the received index.
	 *
	 * @param i
	 * 		0-Index of the item position
	 */
	def item(String itemText) {
		def item = items.find { item -> getLink(item).text().trim() == itemText }
		item?.size() > 0 ? item : null
	}

	/**
	 * Returns the displayed text for the menu item corresponding to the received index.
	 *
	 * @param i
	 * 		0-Index of the item position
	 */
	String getItemText(int i) {
		itemLink(i).text().trim() 
	}

	/**
	 * Returns true if the item is a leaf, thus it can't expand a submenu. 
	 */
	boolean isLeaf(item) {
		item.find("ul").size() == 0
	}
	
	/**
	 * Expands the menu item corresponding to the received index, returning a submenu (instance of this class).
	 *
	 * @param i
	 * 		0-Index of the item position
	 */
	def expand(def item) {
		mouseoverAndClick(item)
		return submenu(item)
	}

	/**
	 * Expands the menu item corresponding to the received index, returning a submenu (instance of this class).
	 *
	 * @param i
	 * 		0-Index of the item position
	 */
	def expand(int i) {
		expand(item(i))
	}
	
	/**
	 * Returns the link contained by the menu item.
	 *
	 * @param item
	 * 		The menu item element.
	 */
	private getLink(def item) { 
		item.find("a")[0] 
	}
	
	/**
	 * Returns the link contained by the menu item corresponding to the received index.
	 *
	 * @param i
	 * 		0-Index of the item position
	 */
	private getItemLink(int i) { 
		getLink(item(i)) 
	}

}
