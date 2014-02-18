package com.hexacta.webtester.modules

import com.hexacta.webtester.modules.AbstractModule


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
class TableModule extends AbstractModule {
 
    static content = {
		// generic cell accessor that takes an index
		cell { i -> $("td", i) }
		
		cells { $("td") }
		
		rows(required: false) { $("tbody tr") }
		
		row { i -> $("tbody tr", i) }
		
		column { 
			i -> rows.collect {
				row -> getCell(row, i) 
			}
		}

		// TODO: resolver dinamicamente la columna segun el titulo, para usarlo por ej:
		// table.row(0).title
		// table.row(1).author
		
//		title { cell(0).text() }
//		author { cell(1).text() }
//		format { cell(2).text() }
//		price { cell(3).text().find(/\d+(?:\.\d+)?/).toBigDecimal() }
//		releaseDate { new SimpleDateFormat("d MMM yyyy").parse(cell(4).text()) }

    }

	def getCell(row, int col) {
		row.find("td")[col]
	}

	String getCellValue(row, int col) {
		getCell(row, col).text()
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

