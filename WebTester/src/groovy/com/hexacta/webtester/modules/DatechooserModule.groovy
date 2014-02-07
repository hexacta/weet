package com.hexacta.webtester.modules

import com.hexacta.webtester.modules.AbstractModule


/**
 * 
 * 
 * @author gmassenzano
 */
class DatechooserModule extends AbstractModule {
 
    static content = {
		value     {  $("input", type: "text") }
		prevMonth { $("a", text: startsWith("Previous Month")) }
		nextMonth { $("a", text: startsWith("Next Month")) }
		days { module TableModule, $("table") }
		
		selectDay { nr -> days.findCell(nr)?.find("a").click() }
		
    }
	
	
}
/*
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
<tr class="w3">
<td class="calcell wd0 d12 selectable calcellleft" id="calic2ea648e5c3c095a2c33a0f382064c14_cell14"><a href="#" class="selector">12</a></td>
<td class="calcell wd1 d13 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell15"><a href="#" class="selector">13</a></td>
<td class="calcell wd2 d14 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell16"><a href="#" class="selector">14</a></td>
<td class="calcell wd3 d15 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell17"><a href="#" class="selector">15</a></td>
<td class="calcell wd4 d16 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell18"><a href="#" class="selector">16</a></td>
<td class="calcell wd5 d17 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell19"><a href="#" class="selector">17</a></td>
<td class="calcell wd6 d18 selectable calcellright" id="calic2ea648e5c3c095a2c33a0f382064c14_cell20"><a href="#" class="selector">18</a></td>
</tr>
<tr class="w4">
<td class="calcell wd0 d19 selectable calcellleft" id="calic2ea648e5c3c095a2c33a0f382064c14_cell21"><a href="#" class="selector">19</a></td>
<td class="calcell wd1 d20 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell22"><a href="#" class="selector">20</a></td>
<td class="calcell wd2 d21 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell23"><a href="#" class="selector">21</a></td>
<td class="calcell wd3 d22 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell24"><a href="#" class="selector">22</a></td>
<td class="calcell wd4 d23 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell25"><a href="#" class="selector">23</a></td>
<td class="calcell wd5 d24 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell26"><a href="#" class="selector">24</a></td>
<td class="calcell wd6 d25 selectable calcellright" id="calic2ea648e5c3c095a2c33a0f382064c14_cell27"><a href="#" class="selector">25</a></td>
</tr>
<tr class="w5">
<td class="calcell wd0 d26 selectable calcellleft" id="calic2ea648e5c3c095a2c33a0f382064c14_cell28"><a href="#" class="selector">26</a></td>
<td class="calcell wd1 d27 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell29"><a href="#" class="selector">27</a></td>
<td class="calcell wd2 d28 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell30"><a href="#" class="selector">28</a></td>
<td class="calcell wd3 d29 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell31"><a href="#" class="selector">29</a></td>
<td class="calcell wd4 d30 selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell32"><a href="#" class="selector">30</a></td>
<td class="calcell wd5 d31 today selectable" id="calic2ea648e5c3c095a2c33a0f382064c14_cell33"><a href="#" class="selector">31</a></td>
<td class="calcell oom calcellright" id="calic2ea648e5c3c095a2c33a0f382064c14_cell34">1</td>
</tr>
<tr class="w6">
<td class="calcell oom calcellleft calcellbottom" id="calic2ea648e5c3c095a2c33a0f382064c14_cell35">2</td>
<td class="calcell oom calcellbottom" id="calic2ea648e5c3c095a2c33a0f382064c14_cell36">3</td>
<td class="calcell oom calcellbottom" id="calic2ea648e5c3c095a2c33a0f382064c14_cell37">4</td>
<td class="calcell oom calcellbottom" id="calic2ea648e5c3c095a2c33a0f382064c14_cell38">5</td>
<td class="calcell oom calcellbottom" id="calic2ea648e5c3c095a2c33a0f382064c14_cell39">6</td>
<td class="calcell oom calcellbottom" id="calic2ea648e5c3c095a2c33a0f382064c14_cell40">7</td>
<td class="calcell oom calcellright calcellbottom" id="calic2ea648e5c3c095a2c33a0f382064c14_cell41">8</td>
</tr>
</tbody>
</table></div>
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
	*/