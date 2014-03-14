package com.hexacta.liqhabtester.modules

import com.hexacta.weet.modules.WeetModule

/**
 * Export panel. 
 * <p> 
 * Following is an example of the html node that handles an instance of this class:
<code> 
<div id="export_abm" params="" class="export">
  <span class="menuButton">
    <a class="excel" href="/liquidacion-haberes/grado/list?format=excel&amp;extension=xls">Exportar a Excel</a>
  </span>
  <span class="menuButton">
    <a class="pdf" href="/liquidacion-haberes/grado/list?format=pdf&amp;extension=pdf">Exportar a PDF</a>
  </span>
</div>
</code> 
 * @author gmassenzano
 */
class ExportModule extends WeetModule {

	static base = { $("div", id:"export_abm") }
	
	static content = {
		excel { $("a.excel") }
		pdf   { $("a.pdf") }
	}
}
