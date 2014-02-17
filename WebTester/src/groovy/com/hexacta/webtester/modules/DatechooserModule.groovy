package com.hexacta.webtester.modules

import com.hexacta.webtester.modules.AbstractModule

/**
 * Datechooser
 * <p> 
 * Following is an example of the html node that handles an instance of this class:
<code> 
<div class="controls">
	<input class="" style="" type="text" name="ic2ea648e5c3c095a2c33a0f382064c14" id="ic2ea648e5c3c095a2c33a0f382064c14" value="">
	<div id="c22747c2dec9fdc88b81a6bcf6b4af971" class="datechooser yui-skin-sam yui-calcontainer single" style="display: block; left: 700px; top: 384px;">
		<table cellspacing="0" class="yui-calendar y2014" id="calic2ea648e5c3c095a2c33a0f382064c14">
			<thead>
				<tr>
				<th colspan="7" class="calhead">
				<div class="calheader">
					<a class="calnavleft" href="#">Previous Month (December 2013)</a>
					January 2014
					<a class="calnavright" href="#">Next Month (February 2014)</a>
				</div>
				</th>
				</tr>
				<tr class="calweekdayrow">
				<th class="calweekdaycell">Su</th>
				<th class="calweekdaycell">Mo</th>
				<th class="calweekdaycell">Tu</th>
				<th class="calweekdaycell">We</th>
				<th class="calweekdaycell">Th</th>
				<th class="calweekdaycell">Fr</th>
				<th class="calweekdaycell">Sa</th>
				</tr>
			</thead>
			<tbody class="m1 calbody">
				<tr class="w1">
				<td class="calcell oom calcelltop calcellleft" id="calic2ea648e5c3c095a2c33a0f382064c14_cell0">29</td>
				<td class="calcell oom calcelltop" id="calic2ea648e5c3c095a2c33a0f382064c14_cell1">30</td>
				<td class="calcell oom calcelltop" id="calic2ea648e5c3c095a2c33a0f382064c14_cell2">31</td>
				<td class="calcell wd3 d1 selectable calcelltop" id="calic2ea648e5c3c095a2c33a0f382064c14_cell3"><a href="#" class="selector">1</a></td>
				<td class="calcell wd4 d2 selectable calcelltop" id="calic2ea648e5c3c095a2c33a0f382064c14_cell4"><a href="#" class="selector">2</a></td>
				<td class="calcell wd5 d3 selectable calcelltop" id="calic2ea648e5c3c095a2c33a0f382064c14_cell5"><a href="#" class="selector">3</a></td>
				<td class="calcell wd6 d4 selectable calcelltop calcellright" id="calic2ea648e5c3c095a2c33a0f382064c14_cell6"><a href="#" class="selector">4</a></td>
				</tr>
				<tr class="w2">
				<td class="calcell wd0 d5 selectable calcellleft" id="calic2ea648e5c3c095a2c33a0f382064c14_cell7"><a href="#" class="selector">5</a></td>
				<td class="calcell wd1 d6 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell8"><a href="#" class="selector">6</a></td>
				<td class="calcell wd2 d7 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell9"><a href="#" class="selector">7</a></td>
				<td class="calcell wd3 d8 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell10"><a href="#" class="selector">8</a></td>
				<td class="calcell wd4 d9 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell11"><a href="#" class="selector">9</a></td>
				<td class="calcell wd5 d10 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell12"><a href="#" class="selector">10</a></td>
				<td class="calcell wd6 d11 selectable calcellright" id="calic2ea648e5c3c095a2c33a0f382064c14_cell13"><a href="#" class="selector">11</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">	var dateChooser = new DateChooser();
		dateChooser.setDisplayContainer("c22747c2dec9fdc88b81a6bcf6b4af971");
		dateChooser.setInputId("ic2ea648e5c3c095a2c33a0f382064c14");
		dateChooser.setStructId("fromDate");
		dateChooser.setFormat("dd/MM/yyyy");
		dateChooser.setLocale("en");
		dateChooser.init();
	</script>
	<input type="hidden" name="fromDate" id="fromDate" value="date.struct">
	<input type="hidden" name="fromDate_day" id="fromDate_day" value="">
	<input type="hidden" name="fromDate_month" id="fromDate_month" value="">
	<input type="hidden" name="fromDate_year" id="fromDate_year" value="">
</div>
</code> 
 * @author gmassenzano
 */
class DatechooserModule extends AbstractModule {
 
    static content = {
		value { $("input", type: "text") }
		
		// PRIVATE
		links { $("a") }
		days { module TableModule, $("table") }
    }
	
	def showCalendar() {
		avoidElementNotClickable(value)
		value.click()
	}
	
	def selectDay(nr) {
		def link = days.findCell(nr)?.find("a")
		avoidElementNotClickable(link)
		link.click() 
	}

	def prevMonth() {
		def link = links.filter(text: startsWith("Previous Month"))
		avoidElementNotClickable(link)
		link.click() 
	}
	
	def nextMonth() {
		def link = links.filter(text: startsWith("Next Month"))
		avoidElementNotClickable(link)
		link.click() 
	}

}
