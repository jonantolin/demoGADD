<%@page import="com.demoGadd.tusEventos.controllers.EventoController"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="border shadow">

	<div class="container">
		<div class="card bg-secondary">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="resources/images/${evento.portadaImg }"
						class="img-fluid rounded-start" style="width: auto" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Nombre: ${evento.nombre }</h5>
						<p class="card-text">Lugar: ${evento.lugar}</p>
						<p class="card-text">
							Fecha:
							<fmt:formatDate pattern="dd/MM/yyyy 'a las ' HH:mm"
								value="${evento.fecha}" />
						</p>
						<p class="card-text">
							Precio entrada:
							<fmt:setLocale value="es_ES" />
							<fmt:formatNumber value="${evento.precio} " type="number"
								minFractionDigits="2" maxFractionDigits="2" />
							€
						</p>
						<p class="card-text">Entradas disponibles:
							${evento.disponibles}</p>

						<p class="card-footer">
						<form action="eventos" method="post">
						<input type="hidden" name="op" value="<%=EventoController.OP_COMPRAR%>">
						<input type="hidden" name="id" value="${evento.id }">
						
						<h6>Escribe tus datos</h6>
							<div class="mb-1 col-3">
								<input type="text" class="form-control form-control-sm" name="nombre" id="nombre" placeholder="Nombre y Apellidos" required>		
							</div>
							<div class="mb-1 col-3">
								<input type="email" class="form-control form-control-sm" name="email" id="email" placeholder="Tu correo electrónico" required>
							</div>
							<div class="mb-1 col-3">
								<input type="text" class="form-control form-control-sm" name="telefono" id="telefono" placeholder="Tu teléfono" required>
							</div>
							<div class="mb-1 col-3">
								<input type="number" class="form-control form-control-sm" name="entradas" id="entradas" placeholder="Cuántas entradas quieres" required>
							</div>
							<button type="submit" class="btn btn-primary">Comprar</button>
						</form>
						

						</p>

					</div>
				</div>
			</div>
		</div>
	</div>



</div>

<%@include file="includes/footer.jsp"%>