package com.hexacta.webtester.modules


/**
 * Represents a navigation menu. Each item can have nested submenus of the same type. 
 * A module or page that use this class, should include the base definition from the ul element:
 * <p> 
 * <code> menu { module NavigationMenuModule, $("ul.nav")[0] } </code>
 * <p> 
 * Following is an example of the html node that handles an instance of this class:
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
class NavigationMenuModule extends AbstractModule {
 
    static content = {
		
		/**
		 * Returns the menu item corresponding to the received index.
		 *  
		 * @param i
		 * 		0-Index of the item position
		 */
		item { i -> $().children("li")[i] }
		
		/**
		 * Returns the displayed text for the menu item corresponding to the received index.
		 *  
		 * @param i
		 * 		0-Index of the item position
		 */
		itemText { i -> itemLink(i).text().trim() }
		
		/**
		 * Expands the menu item corresponding to the received index, returning a submenu (instance of this class).
		 * 
		 * @param i
		 * 		0-Index of the item position
		 */
		expand { i -> 
			def item = item(i) 
			item.click()
			return submenu(item)
		}

		/* ------------------------------------------------------------------------------------------------------*/				
		/*                                              Private use                                              */				
		/* ------------------------------------------------------------------------------------------------------*/
						
		/**
		 * 	Private use.
		 *  Returns the submenu under the received item.
		 *  
		 * @param item
		 * 		web element returned by item property.
		 */
		submenu { item -> module NavigationMenuModule, item.$("ul") }

		/**
		 * Private use.
		 * Returns the link contained by the menu item corresponding to the received index.
		 *  
		 * @param i
		 * 		0-Index of the item position
		 */
		itemLink { i -> item(i).find("a")[0] }
    }
}
