<%@page import="com.demoGadd.tusEventos.backoffice.controllers.BackEventoController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<form action="backoffice/eventos" method="post">

	<input type="hidden" name="op" value="<%=BackEventoController.OP_GUARDAR%>">
	
	<input type="hidden" name="id" value="${evento.id }">
	<input type="hidden" name="vendidas" value="${evento.vendidas }">

	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="nombre" class="col-form-label">Nombre</label>
		</div>
		<div class="col-auto">
			<input type="text" id="nombre" name="nombre" class="form-control"
				aria-describedby="nombreHelp" value="${evento.nombre }">
		</div>
		<div class="col-auto">
			<span id="nombreHelp" class="form-text"> Máximo 125
				caracteres. </span>
		</div>
	</div>
	<br>
	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="lugar" class="col-form-label">Lugar</label>
		</div>
		<div class="col-auto">
			<input type="text" id="lugar" name="lugar" class="form-control"
				aria-describedby="lugarHelp" value="${evento.lugar }">
		</div>
		<div class="col-auto">
			<span id="lugarHelp" class="form-text"> Señala recinto y
				ciudad. </span>
		</div>
	</div>

	<br>
	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="fecha" class="col-form-label">Fecha</label>
		</div>
		<div class="col-auto">
			<input type="text" id="fecha" name="fecha" class="form-control"
				aria-describedby="fechaHelp" value="${evento.fecha }">
		</div>
		<div class="col-auto">
			<span id="fechaHelp" class="form-text"> Señala así: dd/mm/aaaa
				hh:mm </span>
		</div>
	</div>
	<br>

	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="precio" class="col-form-label">Precio</label>
		</div>
		<div class="col-auto">
			<input type="number" id="precio" name="precio" class="form-control"
				aria-describedby="precioHelp" value="${evento.precio }">
		</div>
		<div class="col-auto">
			<span id="precioHelp" class="form-text"> 10.000 € Máx. </span>
		</div>
	</div>
	<br>

	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="aforo" class="col-form-label">Aforo</label>
		</div>
		<div class="col-auto">
			<input type="number" id="aforo" name="aforo" class="form-control"
				aria-describedby="aforoHelp" value="${evento.aforo }">
		</div>
		<div class="col-auto">
			<span id="aforoHelp" class="form-text"> Cambiarlo modificará
				las entradas disponibles. </span>
		</div>
	</div>
	<br>

	<div class="row g-3 align-items-center">
		<div class="col-auto">
			<label for="imagen" class="col-form-label">Imagen cartel</label>
		</div>
		<div class="col-auto">
			<input type="text" id="imagen" name="portadaImg" class="form-control"
				aria-describedby="imagenHelp" value="${evento.portadaImg }">
		</div>
		<div class="col-auto">
			<span id="imagenHelp" class="form-text"> Preferiblemente jpg.
			</span>
		</div>
	</div>
	<br>
	
	<input type="submit" class="btn btn-${(evento.id != -1)?'warning':'success'}" value="${(evento.id != -1)?'MODIFICAR':'CREAR'} ">
</form>

<h5 class="text-success">${mensaje }</h5>

<%@include file="../../includes/footer.jsp"%>