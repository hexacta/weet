package com.hexacta.weet.modules

import com.hexacta.weet.utils.StringUtils

/**
 * Table.
 * <p> 
 * Following is an example of the html node that handles an instance of this class:<p>
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
class TableModule extends WeetModule {

	/**
	 * It is instantiated internally, no with this module instantiation. 
	 */
	List<String> headersText
	
    static content = {
		headers { $("tr th") }
		cells { $("td") }
		rows(required: false) { moduleList TableRowModule, $("table tr").tail(), headerNames: headersText }
		column { 
			i -> rows.collect {
				row -> row.cell(i) 
			}
		}
    }

	/**
	 * Returns a list with the table headers. Each header is previously transformed, extracting accents, concatenating words
	 * if it contains more than one, using camel case format, and lowering case to first letter.
	 */
	List<String> getHeadersText() { 
		if (!headersText) {
			headersText = headers.collect { StringUtils.toNormalizedCamelCase(it.text()) }
		}
		headersText
	}
	
	/**
	 * Returns the number of rows.
	 */
	int getRowCount() { 
		rows ? rows.size() : 0
	}
	
	/**
	 * Returns the cell that contains the received value.
	 * 
	 * @param value
	 */
	def findCell(value) { 
		cells.filter(text: value.toString()) 
	}
	
	/**
	 * Returns the value corresponding to the cell of the received column index for last row.
	 *  
	 * @param col
	 */
	String findLastValue(int col) {
		def row = rows.last()
		row.getValue(col)
	}

	/**
	 * Returns the row which contains the received value for the cell of the corresponding column index.
	 * 	
	 * @param col
	 * @param value
	 */
	def findRow(int col, String value) {
		rows.find { row ->
			row.getValue(col) == value
		}
	}

}

