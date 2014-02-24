package com.hexacta.liqhabtester.modules

import geb.error.UndefinedPageContentException

import com.hexacta.webtester.modules.AbstractModule

/**
 * Filter panel. 
 * <p> 
 * Following is an example of the html node that handles an instance of this class:
<code> 
<div id="filterPane" class="filterpane fp-dialog fp-dialog_2" style="display: block;">
	<h2>Filtro</h2>
	<form name="filterPaneForm" id="filterPaneForm" method="post" action="/liquidacion-haberes/grado/list">
<div id="form_filter">
<!-- Do we still need this hidden prop? -->
<input type="hidden" name="filterProperties" value="">
<div cellspacing="0" cellpadding="0" class="filterPaneTable">
	<div><label>Código</label>
<br>
<select id="filter.op.codigo" name="filter.op.codigo" onchange="grailsFilterPane.filterOpChange('filter.op.codigo', 'codigo');">
<option value=""></option>
<option value="Equal">Igual a</option>
<option value="NotEqual">Distinto de</option>
</select>
	<input type="text" name="filter.codigo" value="" opname="filter.op.codigo" domain="Grado" propertyname="codigo" id="codigo" onchange="grailsFilterPane.selectDefaultOperator('filter.op.codigo')">
	<span style="display:none;" id="between-span-codigoTo">
		&nbsp;y&nbsp;
		<input type="text" name="filter.codigoTo" value="" opname="filter.op.codigo" domain="Grado" propertyname="codigo" id="codigoTo" onchange="grailsFilterPane.selectDefaultOperator('filter.op.codigo')">
	</span>
	</div>
	<div><label>Cargo (código)</label>
<br>
<select id="filter.op.cargo.codigo" name="filter.op.cargo.codigo" onchange="grailsFilterPane.filterOpChange('filter.op.cargo.codigo', 'cargo.codigo');">
<option value=""></option>
<option value="Equal">Igual a</option>
<option value="NotEqual">Distinto de</option>
</select>
	<input type="text" name="filter.cargo.codigo" value="" opname="filter.op.cargo.codigo" domain="Cargo" propertyname="codigo" id="cargo.codigo" onchange="grailsFilterPane.selectDefaultOperator('filter.op.cargo.codigo')">
	<span style="display:none;" id="between-span-cargo.codigoTo">
		&nbsp;y&nbsp;
		<input type="text" name="filter.cargo.codigoTo" value="" opname="filter.op.cargo.codigo" domain="Cargo" propertyname="codigo" id="cargo.codigoTo" onchange="grailsFilterPane.selectDefaultOperator('filter.op.cargo.codigo')">
	</span>
	</div>
</div>
	<input type="hidden" name="sort" value="">
	<input type="hidden" name="order" value="">
</div>
	<hr>
<div class="buttons">
    <span class="button">
        <input type="submit" name="_action_list" value="Filtrar" class="bt_principales_right">
    </span>
    <span class="button">
        <input type="button" value="Cancelar" class="bt_principales_left" onclick="setVisibility('fondo_popin','none'); return grailsFilterPane.hideElement('filterPane'); ">
    </span>
    <span class="button">
        <input type="button" value="Limpiar" class="bt_principales_left_limpiar" onclick="return grailsFilterPane.clearFilterPane('filterPaneForm');">
    </span>
</div>
	</form>
</div>
</code> 
 * @author gmassenzano
 */
class FilterModule extends AbstractModule {

	static base = { $("div", id:"filterPane") }
	
	enum OpType {
		EQ("Equal"), NE("NotEqual"), LT("LessThan"), LTE("LessThanEquals"), GT("GreaterThan"), GTE("GreaterThanEquals"), BT("Between")
		
		OpType(String value) { this.value = value }
		final String value
	}
	
	static content = {
		fieldOpType(required: false) { field -> $("select", name: "filter.op.$field") }
		fieldValue(required: false)  { field -> $("input", name: "filter.$field") }
		
		filterButton { $("input", name: "_action_list") }
		clearButton { $("input", value: "Limpiar") }
		cancelButton { $("input", value: "Cancelar") }
	}
	
	void addFilter(String field, OpType opType, value) {
		def select = fieldOpType(field)
		if (select.size() == 0) {
			throw new NoSuchFieldException("$field is not a valid filter field.")
		}
		select.value(opType.value)
		def input = fieldValue(field)
		input.value(value)
	}
	
	def methodMissing(String name, args) {
		try {
			super.methodMissing(name, args)
		} catch (MissingMethodException e) {
			if (args.size() != 2 && args[0] instanceof OpType) {
				throw e
			}
			addFilter(name, *args)
		}
	}
	
	def execute() {
		filterButton.click()
	}
	
	def clear() {
		clearButton.click()
	}
	
	def cancel() {
		cancelButton.click()
	}

}
