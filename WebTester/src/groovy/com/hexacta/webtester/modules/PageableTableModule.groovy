package com.hexacta.webtester.modules

import com.hexacta.webtester.modules.AbstractModule


/**
 * 
 * 
 * @author gmassenzano
 */
class PageableTableModule extends AbstractModule {
 
	def tableBase
	def navigationBase
	
	String nextPageText
	String prevPageText
	
    static content = {
		table { module TableModule, tableBase }
		cell { $("td", it) }
		column { i -> table.column(i) }
		findLastValue { col -> table.findLastValue(col) }
		findRowLink(required: false) { value -> table.findRowLink(value) }
		findRow(required: false) { col, value -> table.findRow(col, value) }
		pageRowCount { table.rowCount() }
		
		pagination { navigationBase }
		nextPage(required: false) { pagination().find("a", text: nextPageText) } 
		prevPage(required: false) { pagination().find("a", text: prevPageText) }
		
		findRowInPages { value ->
			def lastValue = table.findLastValue()
			while (lastValue < value) {
				nextPage().click(page.class)
				lastValue = table.findLastValue()
			}
			findRowLink(value)
		}
		
    }
}

/*
		<div class="pagination">
			<ul>
				<li><span class="currentStep">1</span>
				<a href="/qapplication/area/list?offset=15&amp;max=15&amp;sort=name" class="step">2</a>
				<a href="/qapplication/area/list?offset=30&amp;max=15&amp;sort=name" class="step">3</a>
				<a href="/qapplication/area/list?offset=15&amp;max=15&amp;sort=name" class="nextLink">Next</a>
				</li>
			</ul>
		</div>
*/