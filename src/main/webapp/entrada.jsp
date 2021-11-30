<%@page import="com.demoGadd.tusEventos.controllers.EventoController"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2>Datos de tu compra</h2>

<div class="border shadow">

	<div class="container">
		<div class="card">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="resources/images/${evento.portadaImg }"
						class="img-fluid rounded-start" style="width: auto" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">${evento.nombre }</h5>
						<p class="card-text">${evento.lugar}</p>
						<p class="card-text">
							Fecha:
							<fmt:formatDate pattern="dd/MM/yyyy 'a las ' HH:mm"
								value="${evento.fecha}" />
						</p>
						<p class="card-text">Entradas adquiridas:
							${numEntradas}</p>
						<p class="card-text">
							Precio:
							<fmt:setLocale value="es_ES" />
							<fmt:formatNumber value="${evento.precio * numEntradas} "
								type="number" minFractionDigits="2" maxFractionDigits="2" />
							€
						</p>


						<p class="card-footer">
						<form>

							<h6>Tus datos personales</h6>
							<div class="mb-1 col-3">
								Nombre y apellidos: <input type="text"
									class="form-control form-control-sm" name="nombre" id="nombre"
									placeholder="Nombre y Apellidos" disabled value="${nombre }">
							</div>
							<div class="mb-1 col-3">
								Email: <input type="email" class="form-control form-control-sm"
									name="email" id="email" placeholder="Tu correo electrónico"
									disabled value="${email}">
							</div>
							<div class="mb-1 col-3">
								Teléfono: <input type="text"
									class="form-control form-control-sm" name="telefono"
									id="telefono" placeholder="Tu teléfono" disabled
									value="${telefono}">
							</div>
							<div class="mb-1 col-3">
								Número de entradas: <input type="number"
									class="form-control form-control-sm" name="entradas"
									id="entradas" placeholder="Cuántas entradas quieres" disabled
									value="${numEntradas}">
							</div>
						</form>


						</p>

					</div>
				</div>
			</div>
		</div>
	</div>



</div>


<%@include file="includes/footer.jsp"%>