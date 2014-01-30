package com.hexacta.qappwebtest.modules

import com.hexacta.web_test_robot.AbstractModule

/**
 * 
 * 
 * @author gmassenzano
 */
class TableModule extends AbstractModule {
 
    static content = {
		cell { $("td", it) }
		rows(required: false) { $("tbody").find("tr") }
		rowCount { rows ? rows.size() : 0} 
		column { 
			i -> rows.collect {
				row -> row.find("td")[i] 
			}
		}
		
		findLastValue {
			def columns = column(0)
			def lastCol = columns.last()
			def lastValue = lastCol.find("a").text()
			lastValue
		}
		
		findRowLink(required: false) { value ->
			def link = column(0).find{
				it.find("a", text: value)
			}
			link?.find("a")
		}
		
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
