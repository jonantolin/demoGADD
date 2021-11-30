<nav class="navbar navbar-expand-lg navbar-light bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">TusEventos</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="eventos">Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="eventos">Eventos</a>
        </li>
        <li class="nav-item">
        	<c:if test="${usuario == null }">
          <a class="nav-link" href="login.jsp" tabindex="-1" aria-disabled="true">Login</a>
          </c:if>
          <c:if test="${usuario != null }">
          <span class="fw-bold">Estás logueado como: ${usuario.nombre }</span>
          <a class="btn btn-info" href="backoffice/index.jsp" tabindex="-1" aria-disabled="true">Panel admin</a>
          </c:if>
        </li>
      </ul>
    </div>
  </div>
</nav>