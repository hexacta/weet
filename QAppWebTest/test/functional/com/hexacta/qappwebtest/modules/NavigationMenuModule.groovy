package com.hexacta.qappwebtest.modules

import com.hexacta.web_test_robot.AbstractModule

/**
 * 
 * 
 * @author gmassenzano
 */
class NavigationMenuModule extends AbstractModule {
 
    static base = { $("ul.nav")[0] }
 
    static content = {
		item { i -> $().children("li")[i].find("a")[0] }
		itemText { i -> item(i).text().trim() }
		
		submenu { menu -> module NavigationSubmenuModule, menu }
		clickItem { i -> 
			item(i).click()
			return submenu( $().children("li")[i] )
		}
    }
}
/*<li>
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
		<li>
			<a href="/qapplication/area/list">
				Areas
			</a>
		</li>
		<li>
			<a href="/qapplication/projectState/list">
				Projects States
			</a>
		</li>
	</ul>
</div>
</li>*/