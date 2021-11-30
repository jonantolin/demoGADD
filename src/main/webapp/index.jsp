<%@page import="com.demoGadd.tusEventos.controllers.EventoController"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1>Eventos - Compra entradas</h1>

<div class="border shadow">

	<div class="container my-1">
		<div class="row row-cols-1 row-cols-md-3 g-4">
			<c:forEach var="evento" items="${listaEventos }">

				<div class="col bg-dark">
					<div class="card bg-secondary">

						<img src="resources/images/${evento.portadaImg }"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">${evento.nombre }</h5>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">${evento.lugar }</li>
							<li class="list-group-item"><fmt:formatDate
									pattern="dd-MM-yyyy 'a las ' HH:mm" value="${evento.fecha}" /></li>
							<li class="list-group-item">Aforo: ${evento.aforo } personas</li>
						</ul>
						<div class="card-body">
							<a
								href="eventos?op=<%=EventoController.OP_DETALLE %>&id=${evento.id}"
								class="btn btn-primary">Asistir</a>
						</div>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>

</div>

<%@include file="includes/footer.jsp"%>