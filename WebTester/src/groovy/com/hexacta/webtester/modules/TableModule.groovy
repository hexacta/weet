package com.hexacta.webtester.modules

import com.hexacta.webtester.modules.AbstractModule


/**
 * 
 * 
 * @author gmassenzano
 */
class TableModule extends AbstractModule {
 
    static content = {
    	cell { $("td", it) }
		cells { $("td") }
		rows(required: false) { $("tbody").find("tr") }
		column { 
			i -> rows.collect {
				row -> row.find("td")[i] 
			}
		}
    }

	int getRowCount() { 
		rows ? rows.size() : 0
	}
	
	def findCell(value) { 
		cells.filter(text: value.toString()) 
	}
	
	String findLastValue(int col) {
		def columns = column(col)
		def lastCol = columns.last()
		def lastValue = lastCol.text().trim()
		lastValue
	}
	
	def findRowLink(int col, String value) {
		def link = column(col).find{
			it.find("a", text: value)
		}
		link?.find("a")
	}
	
	def findRow(int col, String value) {
		def td = column(col).find{
			def text = it.text().trim()
			text == value
		}
		td?.closest("tr")
	}

}

/*
<table class="table table-striped">
	<thead>
		<tr>
			<th class="sortable sorted null"><a href="/qapplication/project/list?sort=name&amp;max=15&amp;order=asc">Name</a></th>
			<th>Project Manager</th>
			<th>Project Partner</th>
		</tr>
	</thead>
	<tbody>
		<tr class="even">
			<td><a href="/qapplication/project/show/2">ADrianTestAgil</a></td>
			<td>Adrian Martinez</td>
			<td>Fabio Gasparri</td>
		</tr>
		<tr class="odd">
			<td><a href="/qapplication/project/show/5">AdrianTestInActiveProyecto</a></td>
			<td>Adrian Martinez</td>
			<td>Adrian Martinez</td>
		</tr>
	</tbody>
</table>
*/
