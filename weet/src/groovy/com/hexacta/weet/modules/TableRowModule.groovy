package com.hexacta.weet.modules

import geb.error.UnresolvablePropertyException


/**
 * Table row.
 * <p> 
 * Following is an example of the html node that handles an instance of this class:<p>
 <code> 
	<tr class="even">
		<td><a href="/qapplication/project/show/2">AdrianTestAgil</a></td>
		<td>Adrian Martinez</td>
		<td>Fabio Gasparri</td>
	</tr>
</code> 
 * @author gmassenzano
 */
class TableRowModule extends WeetModule {
 
	/**
	 * Header names that corresponds to this row. It should be instantiated with this module.
	 * A cell value will be able to be accessed through the corresponding header. 
	 */
	List<String> headerNames
	
    static content = {
		// generic cell accessor that takes an index
		cell { i -> $("td", i) }
    }

	/**
	 * It finds the index of a header from the received name.
	 * 
	 * @param name
	 */
	int getHeaderIndex(String name) {
		headerNames.indexOf(name) 
	}

	/**
	 * It returns the cell value that corresponds to the received header.
	 * 
	 * @param header
	 */
	def getValue(String header) {
		int idx = getHeaderIndex(header)
		if (idx == -1) {
			throw new NoSuchFieldException("$header is not a valid header name.")
		}
		cell(idx).text()
	}

	/**
	 * It returns the cell value that corresponds to column index.
	 * 
	 * @param col
	 */
	def getValue(int col) {
		cell(col).text().trim()
	}

	/**
	 * This method is overridden to provide a way to access to a row value, using the header name as a property.
	 */
	def propertyMissing(String name) {
		try {
			super.propertyMissing(name)
		} catch (UnresolvablePropertyException e) {
			getValue(name)
		}
	}
}

