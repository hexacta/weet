package com.hexacta.weet.modules

import geb.error.UnresolvablePropertyException


/**
 * Table.
 * <p> 
 * Following is an example of the html node that handles an instance of this class:
 <code> 
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
			<td><a href="/qapplication/project/show/2">AdrianTestAgil</a></td>
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
</code> 
 * @author gmassenzano
 */
class TableRowModule extends WeetModule {
 
	List headerNames
	
    static content = {
		// generic cell accessor that takes an index
		cell { i -> $("td", i) }
    }

	int getHeaderIndex(String name) {
		headerNames.indexOf(name) 
	}

	def getValue(String header) {
		int idx = getHeaderIndex(header)
		if (idx == -1) {
			throw new NoSuchFieldException("$header is not a valid header name.")
		}
		cell(idx).text()
	}

	def getValue(int col) {
		cell(col).text()
	}

	def propertyMissing(String name) {
		try {
			super.propertyMissing(name)
		} catch (UnresolvablePropertyException e) {
			getValue(name)
		}
	}
}

