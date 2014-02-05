package com.hexacta.webtester.modules


/**
 * 
 * 
 * @author gmassenzano
 */
class NavigationMenuModule extends AbstractModule {
 
    static content = {
		
		item { i -> $().children("li")[i] }
		itemLink { i -> item(i).find("a")[0] }
		itemText { i -> itemLink(i).text().trim() }
		
		submenu { item -> module NavigationMenuModule, item.$("ul") }
		clickItem { i -> 
			itemLink(i).click()
			return submenu( item(i) )
		}
    }
}

/*
<li>
<div class="btn-group">
	<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
		Configuration
	</a>
	<ul class="dropdown-menu">
		<li>
			<a href="/qapplication/template/list">
				Templates
			</a>
		</li>
		<li>
			<a href="/qapplication/process/list">
				Processes
			</a>
		</li>
		<li>
			<a href="/qapplication/area/list">
				Areas
			</a>
		</li>
		<li>
			<a href="/qapplication/projectState/list">
				Projects States
			</a>
		</li>
	</ul>
</div>
</li>*/
/*
<ul id="menu">
	<li class="menu_right">
		<a href="#" class="drop">Configuración</a>
		<div class="dropdown_3columns align_right">
			<div class="col_1">
				
				<h2>Parámetros generales</h2>
				<ul class="greybox">
					
					<li><a href="/liquidacion-haberes/estadoCivil">Estados civiles</a></li>
					
					
					<li><a href="/liquidacion-haberes/nivelEscolaridad">Niveles de escolaridad</a></li>
					
					
					<li><a href="/liquidacion-haberes/parentesco">Parentescos</a></li>
					
					
					<li><a href="/liquidacion-haberes/provincia">Provincias</a></li>
					
					
					<li><a href="/liquidacion-haberes/tipoDocumento">Tipos de documento</a></li>
					
					
					<li><a href="/liquidacion-haberes/tituloUniversitario">Títulos universitarios</a></li>
					
				</ul>
				
				
				<h2>Definiciones organizacionales</h2>
				<ul class="greybox">
					
					<li><a href="/liquidacion-haberes/unidad">UTACs</a></li>
					
					
					<li><a href="/liquidacion-haberes/subunidad">Subunidades</a></li>
					
					
					<li><a href="/liquidacion-haberes/destino">Destinos</a></li>
					
					
					<li><a href="/liquidacion-haberes/mesaEntrada">Mesas de control</a></li>
					
					
					<li><a href="/liquidacion-haberes/sociedad">Sociedades</a></li>
					
				</ul>
				
			</div>
			<div id="administracion" class="col_1">
				
				<h2>Parámetros propios</h2>
				<ul class="greybox">
					
					<li><a href="/liquidacion-haberes/cargo">Cargos</a></li>
					
					
					<li><a href="/liquidacion-haberes/jerarquia">Jerarquías</a></li>
					
					
					<li><a href="/liquidacion-haberes/grado">Grados</a></li>
					
					
					<li><a href="/liquidacion-haberes/categoriaCivil">Categorías civiles</a></li>
					
					
					<li><a href="/liquidacion-haberes/especialidad">Especialidades</a></li>
					
					
					<li><a href="/liquidacion-haberes/situacionRevista">Situaciones de revista</a></li>
					
					
					<li><a href="/liquidacion-haberes/situacionRetiro">Situaciones de retiro</a></li>
					
					
					<li><a href="/liquidacion-haberes/situacionEspecial">Situaciones especiales</a></li>
					
					
					<li><a href="/liquidacion-haberes/situacionRevistaSGP">Situaciones de revista del SGP</a></li>
					
				</ul>
				
				
				<h2>Seguridad</h2>
				<ul class="greybox">
					
					<li><a href="/liquidacion-haberes/rol">Configuración de roles</a></li>
					
					
					<li><a href="/liquidacion-haberes/usuario" id="usuario">Usuarios y permisos</a></li>
					
				</ul>
				
			</div>
		</div>
	</li>
	
	<li class="menu_logout_right">
		<a href="#" class="drop_logout">▼</a>
		<div class="dropdown_6columns align_right">
			<!-- Begin 3 columns container -->
			
				
			
			<div class="col_1">
				<ul class="greybox">
					<li class="li_logout"><a href="/liquidacion-haberes/usuario/cambiarPassword/%0D%0A%09%09%09%09%091%0D%0A%09%09%09%09">Cambiar contraseña</a></li>
					<li class="li_logout"><a href="/liquidacion-haberes/authentication/logout?success_controller=authentication&amp;success_action=index&amp;error_controller=authentication&amp;error_action=index" value="Logout" class="cerrar_sesion">Cerrar sesión</a></li>
				</ul>
			</div>
		</div>
	</li>
	<li class="menu_logout">
		<a href="/liquidacion-haberes/usuario/edit/%0D%0A%09%09%09%09%091%0D%0A%09%09%09%09">
			<label>admin, admin</label>
		</a>
	</li>
	<li class="menu_logout">

			
	</li>
	<!-- End 3 columns container -->
	
	<!-- End 3 columns Item -->

</ul>
*/