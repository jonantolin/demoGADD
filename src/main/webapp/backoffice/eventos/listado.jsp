<%@page
	import="com.demoGadd.tusEventos.backoffice.controllers.BackEventoController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Listado eventos</h1>

<div class="border shadow">
	<span class="text-info">${mensaje }</span>
	<div class="container my-1">
		<div class="row row-cols-1 row-cols-md-11 g-4">
			<c:forEach var="evento" items="${listaEventos }">

				<div class="card">
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
								<p class="card-text">Entradas vendidas: ${evento.vendidas}</p>
								<p class="card-text">
									Recaudación:
									<fmt:formatNumber value="${evento.vendidas * evento.precio}"
										type="number" minFractionDigits="2" maxFractionDigits="2" />
									€
								</p>
								<div class="card-footer">
									<a class="btn btn-warning"
										href="backoffice/eventos?op=<%=BackEventoController.OP_EDITAR %>&id=${evento.id } ">Editar</a>
									<a class="btn btn-danger"
										href="backoffice/eventos?op=<%=BackEventoController.OP_ELIMINAR %>&id=${evento.id }">Eliminar</a>

								</div>
							</div>
						</div>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>

</div>


<%@include file="../../includes/footer.jsp"%>